package listb;

import java.util.Date;

public class ServiceTypeEntity {
	public int id;
	public boolean isDelflag;
	public Date createtime;
	public Date updatetime;
	public String imagekey;
	public String name;
	public int level;
	public int parent_id;
	public String imagepath;
	public boolean isNew;

	@Override
	public String toString() {
		return "ServiceTypeEntity [id=" + id + "name=" + name + ", level=" + level + "]";
	}

}
