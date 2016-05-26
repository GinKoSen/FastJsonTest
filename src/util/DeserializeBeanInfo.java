package util;

import java.lang.reflect.Type;

import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午6:17:42
 */
public class DeserializeBeanInfo {
	public JavaBeanInfo beanInfo;

	private DeserializeBeanInfo(Class<?> clazz, Type type) {
		this.beanInfo = JavaBeanInfo.build(clazz, type);
	}

	public FieldInfo getField(String propertyName) {
		for (FieldInfo item : beanInfo.fields) {
			if (item.name.equals(propertyName)) {
				return item;
			}
		}
		return null;
	}

	public static DeserializeBeanInfo build(Class<?> clazz, Type type) {
		return new DeserializeBeanInfo(clazz, type);
	}

}
