package enums;

/**
 *
 * @author ginko.wang
 * @date 2016年5月26日 下午3:33:56
 */
public enum EnumA implements IEnum {
	A("a", 1),
	B("b", 2),
	C("c", 3);

	private String key;
	private int value;

	private EnumA(String key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String key() {
		return key;
	}

	@Override
	public int value() {
		return value;
	}

	public static void main(String[] args) {
		System.err.println(EnumA.valueOf("A"));
	}

}
