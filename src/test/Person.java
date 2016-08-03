package test;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2016年8月3日 上午10:48:16
 *
 */
public class Person {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@JSONField(serialize = false)
	public boolean isMale() {
		return Math.random() * 2 > 0;
	}
}
