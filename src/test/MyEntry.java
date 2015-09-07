package test;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">GinKo.Wang</a>
 * @date 2015年9月7日 下午12:10:55
 *
 */
public class MyEntry<T> {

	public String name;

	public T data;

	@Override
	public String toString() {
		return "[name=" + name + ", data=" + data + "]";
	}
}
