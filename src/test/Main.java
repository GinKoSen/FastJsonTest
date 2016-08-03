package test;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2016年8月3日 上午10:50:29
 *
 */
public class Main {
	public static void main(String[] args) {
		Person person = new Person();
		person.setName("yoyo");
		person.setAge(18);
		System.err.println(JSON.toJSONString(person));
	}
}
