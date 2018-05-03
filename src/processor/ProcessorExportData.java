package processor;

import java.util.List;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2015年12月30日 下午9:38:02
 *
 */
public class ProcessorExportData {

	public String type;
	/**
	 * TODO 方案1：类字段不映射data属性，通过fastjson的额外类生成。提供自动转换过程封装，隐藏转换过程
	 */
	public OptionalVal optionalVal;
	/**
	 * TODO 方案2：类字段映射data属性，调用者需要自行负责转换过程
	 */
	public Object data;

	/**
	 * 方案2：自行转换
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> data() {
		if (!List.class.isAssignableFrom(data.getClass())) {
			throw new ClassCastException("Cannot cast " + data.getClass().getName() + " to " + List.class.getName());
		}
		return (List<T>) data;
	}

	/**
	 * 方案2：自行转换
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T data(Class<T> clazz) {
		if (!clazz.isAssignableFrom(data.getClass())) {
			throw new ClassCastException("Cannot cast " + data.getClass().getName() + " to " + clazz.getName());
		}
		return (T) data;
	}

}
