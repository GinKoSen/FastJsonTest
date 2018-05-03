package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MainA {

	public static class A {
		// public List<List<String>> tag;
		public String[] tag;
	}

	public static void main(String[] args) {
		A a = new A();
		System.err.println(JSON.toJSONString(a, SerializerFeature.WriteNullListAsEmpty));
		String json = "{\"tag\":\"\"}";
		A ca= JSON.parseObject(json, A.class);
		System.err.println(ca.tag);
	}
}
