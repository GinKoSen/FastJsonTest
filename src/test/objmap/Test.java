package test.objmap;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 
 * @author GinKo
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2016年9月30日 下午4:34:00
 *
 */
public class Test {
	public static void main(String[] args) {
		Map<A, B> map = new HashMap<>();
		A a = new A();
		a.a = 1;
		a.ba = true;
		B b = new B();
		b.b = 2;
		b.c = "bc";
		map.put(a, b);
		String json = JSON.toJSONString(map);
		System.err.println(json);
		Map<A, B> mapf = JSON.parseObject(json, new TypeReference<Map<A, B>>() {

		});
		System.err.println(mapf.keySet());
		System.err.println(mapf.values());
	}
}
