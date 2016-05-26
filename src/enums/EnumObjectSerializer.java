package enums;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午4:28:57
 */
public class EnumObjectSerializer implements ObjectSerializer {

	public static EnumObjectSerializer instance = new EnumObjectSerializer();

	@Override
	public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
			throws IOException {
		if (object == null) {
			serializer.writeNull();
			return;
		}
		if (!(object instanceof EnumA)) {
			serializer.writeWithFieldName(object, fieldName);
			return;
		}
		IEnum iEnum = (IEnum) object;
		Map<String, Object> map = new HashMap<>();
		map.put(iEnum.key(), iEnum.value());
		serializer.writeWithFieldName(map, fieldName);
	}

}
