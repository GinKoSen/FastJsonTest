package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2016年2月1日 上午11:53:41
 *
 */
public class TestListList {

	public static void main(String[] args) {
		testCase1();
		testCase2();
	}

	/**
	 * 方案1：直接转译。
	 */
	private static void testCase1() {
		System.err.println("==============testCase1==================");
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 2, 3, 4, 5));
		list.add(Arrays.asList(6, 7, 8, 9, 10));
		String json = JSON.toJSONString(list);
		System.err.println(json);
		List<List> jb = JSON.parseArray(json, List.class);
		for (List<?> list2 : jb) {
			for (Object object : list2) {
				System.err.println(object.getClass().getName() + " = " + object);
			}
		}
	}

	/**
	 * 方案2：list中包含对象，通过转换获取的List<List<Bean>>中的bean对象不可直接使用，fastjson无法获知bean对象的类型
	 */
	private static void testCase2() {
		System.err.println("==============testCase2==================");
		List<List<BA>> list = new ArrayList<>();
		List<BA> ba1 = new ArrayList<>();
		ba1.add(new BA(1, "1"));
		ba1.add(new BA(2, "2"));
		ba1.add(new BA(3, "3"));
		ba1.add(new BA(4, "4"));
		ba1.add(new BA(5, "5"));
		List<BA> ba2 = new ArrayList<>();
		ba2.add(new BA(6, "6"));
		ba2.add(new BA(7, "7"));
		ba2.add(new BA(8, "8"));
		ba2.add(new BA(9, "9"));
		ba2.add(new BA(10, "10"));
		list.add(ba1);
		list.add(ba2);
		String json = JSON.toJSONString(list);
		System.err.println(json);
		List<List> jb = JSON.parseArray(json, List.class);
		for (List<?> list2 : jb) {
			for (Object object : list2) {
				System.err.println(object.getClass() + " = " + object);
			}
		}
		System.err.println("————————对象级转换————————");
		for (List<?> list2 : jb) {
			for (Object object : list2) {
				BA ba = JSON.parseObject(JSONObject.toJSONString(object), BA.class);
				System.err.println(ba.getClass().getName() + " = " + ba);
			}
		}
		System.err.println("————————通用方法转换————————");
		List<List<BA>> data = fromListList(json, BA.class);
		for (List<BA> list2 : data) {
			for (BA ba : list2) {
				System.err.println(ba.getClass().getName()+" = " + ba);
			}
		}
		
	}

	public static <T> List<List<T>> fromListList(String input, Class<T> clazz) {
		if (input == null || input.trim().length() == 0) {
			return new ArrayList<>();
		}
		List<List<T>> list = new ArrayList<>();
		List<List> listObject = JSON.parseArray(input, List.class);
		listObject.forEach((item)->{
			list.add(JSON.parseArray(JSON.toJSONString(item), clazz));
		});
		return list;
	}

}
