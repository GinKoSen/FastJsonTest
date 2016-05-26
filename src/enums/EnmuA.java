package enums;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午3:33:56
 */
public enum EnmuA implements IEnum {
	A("a"), B("b"), C("c"), D("d"), E("e"), F("f");
	private String value;

	private EnmuA(String value) {
	}

	public String getValue() {
		return value;
	}
}
