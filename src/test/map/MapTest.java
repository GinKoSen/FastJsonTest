package test.map;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.ValueFilter;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("A", "A1");
		map.put("B", null);
		map.put("C", "C1");
		map.put("D", "D1");
		map.put("E", "E1");
		System.err.println(JSON.toJSONString(map, new ValueFilter() {
			@Override
			public Object process(Object object, String param, Object paramObject) {
				if (Map.class.isAssignableFrom(object.getClass())) {
					if (paramObject == null) {
						return "";
					}
				}
				return paramObject;
			}

		}));
	}
}
