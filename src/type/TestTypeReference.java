package type;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">GinKo.Wang</a>
 * @date 2016年4月20日 上午10:33:49
 *
 */
public class TestTypeReference {

	@Test
	public void test() {
		One one = new One();
		one.one = 1;
		one.oneName = "one";
		Two two = new Two();
		two.two = 2;
		two.twoName = "two";
		Response<One> rone = new Response<>();
		rone.code = 200;
		rone.message = "ok";
		rone.data = one;
		Response<Two> rtwo = new Response<>();
		rtwo.code = 404;
		rtwo.message = "not found";
		rtwo.data = two;
		String jsonOne = JSON.toJSONString(rone);
		String jsonTwo = JSON.toJSONString(rtwo);
		System.err.format("One : %s\r\n", jsonOne);
		System.err.format("Two : %s\r\n", jsonTwo);
		Response<One> resOne = JSON.parseObject(jsonOne, new TypeReference<Response<One>>(){});
		Response<Two> resTwo = JSON.parseObject(jsonTwo, new TypeReference<Response<Two>>(){});
		System.err.format("One : %s\t%s\t\t%s,%s\r\n", resOne.code,resOne.message,resOne.data.one,resOne.data.oneName);
		System.err.format("Two : %s\t%s\t%s,%s\r\n", resTwo.code,resTwo.message,resTwo.data.two,resTwo.data.twoName);
	}
}
