package enums;

import java.lang.reflect.Type;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午4:28:57
 */
public class EnumDeserializer implements ObjectDeserializer {

	public EnumDeserializer() {
	}

	@Override
	public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
		return null;
	}

	@Override
	public int getFastMatchToken() {
		// TODO Auto-generated method stub
		return 0;
	}

}
