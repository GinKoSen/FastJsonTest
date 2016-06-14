package listb;

public class ResponseData extends ServiceTypeEntity {
	// public int id;
	// public boolean isDelflag;
	// public Date createtime;
	// public Date updatetime;
	// public String imagekey;
	// public String imagelibrarykey;
	// public boolean isNew;

	public String coverimagename;
	public String title;
	public int price;
	public ServiceTypeEntity serviceTypeEntity;
	public String payMethodId;
	public String abstracts;
	public String description;
	public int user_id;
	public String region_id;

	@Override
	public String toString() {
		return "ResponseData [id=" + id + ", serviceTypeEntity=" + serviceTypeEntity + "]";
	}

}
