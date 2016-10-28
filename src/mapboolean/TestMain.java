package mapboolean;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TestMain {
	public static void main(String[] args) {
		String json = "{" + "\"intValue\": 1234567890," + "\"doubleValue\": 1234567890.0987654321," + "\"maps\": ["
				+ "{" + "\"allFalse\": [" + "false," + "false," + "false" + "]," + "\"allTrue\": [" + "true," + "true,"
				+ "true" + "]" + "}" + "]" + "}";
		MyPoJo mypojo = JSON.parseObject(json, MyPoJo.class);
		System.err.println(mypojo.intValue);
		System.err.println(mypojo.doubleValue);
		System.err.println(mypojo.maps);
		System.err.println(mypojo.maps.get(0).get("allFalse"));
		System.err.println(mypojo.maps.get(0).get("allTrue"));
		System.err.println(mypojo.maps.get(0).get("allFalse").get(0));
		System.err.println(mypojo.maps.get(0).get("allFalse").get(1));
		System.err.println(mypojo.maps.get(0).get("allFalse").get(2));
		System.err.println(mypojo.maps.get(0).get("allTrue"));
		System.err.println(mypojo.maps.get(0).get("allTrue").get(0));
		System.err.println(mypojo.maps.get(0).get("allTrue").get(1));
		System.err.println(mypojo.maps.get(0).get("allTrue").get(2));
	}

	public static class MyPoJo {
		public int intValue;
		public double doubleValue;
		public List<Map<String, List<Boolean>>> maps;
	}
}
