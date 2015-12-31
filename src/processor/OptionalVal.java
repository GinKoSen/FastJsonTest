package processor;

import java.util.List;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2015年12月31日 上午11:49:37
 *
 */
public class OptionalVal {
	private Object data;
	private Class<?> type;

	public OptionalVal(Object data, Class<?> type) {
		super();
		this.data = data;
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public Class<?> getType() {
		return type;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> data() {
		if (!List.class.isAssignableFrom(type)) {
			throw new ClassCastException("Cannot cast " + type.getName() + " to " + List.class.getName());
		}
		return (List<T>) data;
	}

	@SuppressWarnings("unchecked")
	public <T> T data(Class<T> clazz) {
		if (!clazz.isAssignableFrom(type)) {
			throw new ClassCastException("Cannot cast " + type.getName() + " to " + clazz.getName());
		}
		return (T) data;
	}

}
