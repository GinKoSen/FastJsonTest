package enums;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午3:32:02
 */
public class TestEnmu {
	static {
		SerializeConfig.getGlobalInstance().put(EnumA.class, EnumSerializer.instance);
	}

	public static void main(String[] args) {
		BA ba = new BA();
		ba.color = EnumA.A;
		System.err.println(JSON.toJSONString(ba));
	}
}
