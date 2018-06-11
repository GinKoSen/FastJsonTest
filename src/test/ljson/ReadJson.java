package test.ljson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;

import com.alibaba.fastjson.JSONPath;

import util.IOUtil;
import util.JsonUtil;

public class ReadJson {
	public static void main(String[] args) throws IOException {
		InputStream in = ReadJson.class.getResourceAsStream("./json.json");
		String json = IOUtil.getContent(in);
		long l1 = System.currentTimeMillis();
		String valueInfoJson = JSONPath.read(json, "$.form_component_values.form_component_value_vo").toString();
		List<ValueInfo> list = JsonUtil.fromJsonList(valueInfoJson, ValueInfo.class);
		ValueInfo info = IterableUtils.find(list, new Predicate<ValueInfo>() {
			@Override
			public boolean evaluate(ValueInfo object) {
				return "出差".equals(object.name);
			}
		});
		if (info == null) {
			return;
		}
		List<Value> values = JsonUtil.fromJsonList(info.value, Value.class);
		CollectionUtils.filter(values, new Predicate<Value>() {
			@Override
			public boolean evaluate(Value object) {
				return "行程".equals(object.label);
			}
		});
		if (CollectionUtils.isEmpty(values)) {
			return;
		}
		String valueJson = null;
		List<RowValue> rowValues = null;
		List<Value> timeValues = new ArrayList<>();
		for (Value value : values) {
			valueJson = value.value;
			try {
				rowValues = JsonUtil.fromJsonList(valueJson, RowValue.class);
			} catch (Exception e) {

			}
			if (rowValues == null || CollectionUtils.isEmpty(rowValues)) {
				continue;
			}
			for (RowValue rowValue : rowValues) {
				if (rowValue.rowValue == null) {
					continue;
				}
				CollectionUtils.filter(rowValue.rowValue, new Predicate<Value>() {
					@Override
					public boolean evaluate(Value object) {
						return "开始时间".equals(object.label) || "结束时间".equals(object.label);
					}
				});
				timeValues.addAll(rowValue.rowValue);
			}
		}
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