package listb;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class JsonTest {

	private String json;

	public JsonTest() {

	}

	@Before
	public void before() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(JsonTest.class.getResource("./result.json").openStream(), "UTF-8"));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		json = buffer.toString();
	}

	@Test
	public void test() {
		ResponsesMessage message = JSON.parseObject(json, ResponsesMessage.class);
		System.out.format("CODE:%s#DESC:%s#DATA-SIZE:%s\r\n", message.flag, message.desc, +message.data.size());
		message.data.forEach(item -> {
			System.err.println(item);
		});
	}

}
