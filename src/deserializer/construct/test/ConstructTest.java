package deserializer.construct.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import deserializer.construct.deserializer.GenericModelDeserializer;
import deserializer.construct.vo.Construct;

/**
 * @author ginko.wang
 * @date 2016-08-15 18:10
 */
public class ConstructTest {

	@Test
	public void test() {
		String json = "{\"a\":1}";
		GenericModelDeserializer.put(Construct.class);
		Construct co = JSON.parseObject(json, Construct.class);
		System.err.println(co.getA());
	}

}
