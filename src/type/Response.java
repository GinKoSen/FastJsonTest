package type;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">GinKo.Wang</a>
 * @date 2016年4月20日 上午10:40:55
 *
 */
public class Response<T> {
	public int code;
	public String message;
	public T data;
}
