package test.feild.number;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author GinKo
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2016年9月26日 下午4:28:23
 *
 */
public class Test {

	public static class Icon {
		@JSONField(name = "240")
		public String p240;
		@JSONField(name = "640")
		public String p640;
		public String origin;
		public String format;
	}

	public static void main(String[] args) {
		String json = "{240:\"http://static.social.umeng.com/icon_e12e64ff0a1bcc785a279add401b69ed@240w_50Q.jpeg\",640:\"http://static.social.umeng.com/icon_e12e64ff0a1bcc785a279add401b69ed@640w_90Q.jpeg\",origin: \"http://static.social.umeng.com/icon_e12e64ff0a1bcc785a279add401b69ed\",format: \"jpeg\"}";
		JSONObject object = JSON.parseObject(json);
		json = JSON.toJSONString(object);
		Icon icon = JSON.parseObject(json, Icon.class);
		System.err.println(icon.p240);
		System.err.println(icon.p640);
		System.err.println(icon.origin);
		System.err.println(icon.format);
	}
}
