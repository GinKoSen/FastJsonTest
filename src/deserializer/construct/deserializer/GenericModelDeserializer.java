package deserializer.construct.deserializer;

import java.lang.reflect.Type;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;

import deserializer.construct.GenericModel;

/**
 * @author ginko.wang
 * @date 2016-08-15 18:07
 */
public class GenericModelDeserializer extends JavaBeanDeserializer {

	public GenericModelDeserializer(ParserConfig config, Class<?> clazz) {
		super(config, clazz);
	}

	@Override
	public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
		T t = super.deserialze(parser, type, fieldName);
		return t;
	}

	public static void put(Class<? extends GenericModel> clazz) {
		ParserConfig config = ParserConfig.getGlobalInstance();
		config.putDeserializer(clazz, new GenericModelDeserializer(config, clazz));
	}

}
