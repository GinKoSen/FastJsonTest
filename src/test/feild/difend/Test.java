package test.feild.difend;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class Test {
	public static class Aba {
		@JSONField(name = "A")
		public String a;
		@JSONField(name = "B")
		public String aB;

		@Override
		public String toString() {
			return "Aba[a:" + a + ",aB:" + aB + "]";
		}
	}

	public static void main(String[] args) {
		Aba aba = new Aba();
		aba.a = "a";
		aba.aB = "ab";
		String json = JSON.toJSONString(aba);
		Aba pAba = JSON.parseObject(json, Aba.class);
		System.err.println(json);
		System.err.println(pAba);
	}
}
