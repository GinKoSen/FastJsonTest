package thread.jdk6;

/**
 *
 * @author ginko.wang
 * @date 2016年6月19日 下午4:59:36
 */
public interface Callback<T> {
	void process(T t);

	void error(T t);

	void complete(T t);
}
