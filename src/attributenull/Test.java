package attributenull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 *
 * @author ginko.wang
 * @date 2016年5月13日 上午11:41:46
 */
public class Test {
	public static void main(String[] args) {
		A a = new A();
		System.err.println(JSON.toJSONString(a, SerializerFeature.WriteNullStringAsEmpty));
	}
}
