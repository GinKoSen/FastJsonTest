package test;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">GinKo.Wang</a>
 * @date 2015年9月7日 下午12:09:57
 *
 */
public class Test {

	public static void main(String[] args) {
		String content = "{\"name\":\"FastJson\",data:{\"x\":23,\"y\":26}}";
		testWithNoFeature(content);
		testWithFeature(content);
		System.err.println(Arrays.toString(new boolean[2]));
	}

	private static void testWithNoFeature(String content) {
		MyEntry<Data> entry = JSON.parseObject(content, new TypeReference<MyEntry<Data>>() {

		});
		System.out.println(entry);
	}

	private static void testWithFeature(String content) {
		MyEntry<Data> entry = JSON.parseObject(content, new TypeReference<MyEntry<Data>>() {

		}, Feature.DisableCircularReferenceDetect);
		System.out.println(entry);
	}

}
