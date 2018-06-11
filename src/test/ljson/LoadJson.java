package test.ljson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.alibaba.fastjson.JSONPath;

import util.IOUtil;
import util.JsonUtil;

public class LoadJson {
	public static void main(String[] args) throws IOException {
		InputStream in = LoadJson.class.getResourceAsStream("./json.json");
		String json = IOUtil.getContent(in);
		long l1 = System.currentTimeMillis();
		String valueInfoJson = JSONPath.read(json, "$.form_component_values.form_component_value_vo").toString();
		List<ValueInfo> list = JsonUtil.fromJsonList(valueInfoJson, ValueInfo.class);
		Optional<ValueInfo> optional = list.stream().filter(new Predicate<ValueInfo>() {
			@Override
			public boolean test(ValueInfo t) {
				return "出差".equals(t.name);
			}
		}).findFirst();
		if (!optional.isPresent()) {
			return;
		}
		ValueInfo info = optional.get();
		List<Value> values = JsonUtil.fromJsonList(info.value, Value.class);
		Optional<Value> optionalValue = values.stream().filter(new Predicate<Value>() {
			@Override
			public boolean test(Value t) {
				return "行程".equals(t.label);
			}
		}).findFirst();
		if (!optionalValue.isPresent()) {
			return;
		}
		String valueJson = optionalValue.get().value;
		List<RowValue> rowValues = JsonUtil.fromJsonList(valueJson, RowValue.class);
		List<Value> timeValues = new ArrayList<>();
		rowValues.forEach(item -> {
			if (item.rowValue == null) {
				return;
			}
			item.rowValue.stream().filter(new Predicate<Value>() {
				@Override
				public boolean test(Value t) {
					return "开始时间".equals(t.label) || "结束时间".equals(t.label);
				}
			}).forEach(vitem -> {
				timeValues.add(vitem);
			});
		});
		long l2 = System.currentTimeMillis();
		System.err.println("used time (" + (l2 - l1) + ")ms");
		System.err.println(timeValues);
	}

	public static class ValueInfo {
		public String name;
		public String value;
	}

	public static class RowValue {
		public List<Value> rowValue;
	}

	public static class Value {
		public String label;
		public String value;
		public String key;
		public String extendValue;

		@Override
		public String toString() {
			return "[label=" + label + ", value=" + value + ", key=" + key + ", extendValue=" + extendValue + "]";
		}

	}
}