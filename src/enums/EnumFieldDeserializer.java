package enums;

import java.lang.reflect.Type;
import java.util.Map;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.util.FieldInfo;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午4:28:57
 */
public class EnumFieldDeserializer extends FieldDeserializer {

	public EnumFieldDeserializer(Class<?> clazz, FieldInfo fieldInfo) {
		super(clazz, fieldInfo);
	}

	@Override
	public void parseField(DefaultJSONParser parser, Object object, Type objectType, Map<String, Object> fieldValues) {

	}

}
