package deserializer.construct.vo;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

import deserializer.Inject;
import deserializer.construct.Dao;
import deserializer.construct.GenericModel;

/**
 * @author ginko.wang
 * @date 2016-08-15 18:07
 */
public class Construct extends GenericModel {
	private Dao dao;
	@JSONField(name="a")
	private int a;

	@Inject
	@JSONCreator
	public Construct(Dao dao) {
		this.dao = dao;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
