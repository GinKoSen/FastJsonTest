package resp;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">GinKo.Wang</a>
 * @date 2016年1月16日 下午4:31:42
 *
 */
public class HeaderRespTest {
	
	public static void main(String[] args) {
		String json = "{\"BCode\":\"EMI1000\",\"Ack\":\"2\",\"SqId\":\"ec2016011615450610380851\",\"RtState\":\"1\",\"RtErrCode\":\"1100\",\"RtMsg\":\"RUPnvJbnoIHkuI3mraPnoa4=\",\"Cnxt\":\"\"}";
		HeaderResp resp = JSON.parseObject(json, HeaderResp.class);
		System.out.println("BCode" + "=" + resp.get_BCode());
		System.out.println("Ack" + "=" + resp.get_Ack());
		System.out.println("SqId" + "=" + resp.get_SqId());
		System.out.println("RtState" + "=" + resp.get_RtState());
		System.out.println("RtErrCode" + "=" + resp.get_RtErrCode());
		System.out.println("RtMsg" + "=" + resp.get_RtMsg());
		System.out.println("Cnxt" + "=" + resp.get_Cnxt());
		System.out.println("SourceCnxt" + "=" + resp.getSourceCnxt());
		System.out.println("SourceRtMsg" + "=" + resp.getSourceRtMsg());
//		System.out.println("MDOSConstants._RtErrCodeDesc=" + MDOSConstants._RtErrCode.get(resp.get_RtErrCode()));
		System.out.println("是否通过验证=" + resp.isValidated());
		System.err.println(JSON.toJSONString(resp));
	}
	
}
