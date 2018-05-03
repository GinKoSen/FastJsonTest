package processor;

/**
 * 
 * @author GinKo.Wang
 * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
 * @date 2015年12月30日 下午9:38:02
 *
 */
public class ProcessorExportDataInfo {

	public String attachment;
	public int width;
	public int height;

	@Override
	public String toString() {
		return "[attachment=" + attachment + ", width=" + width + ", height=" + height + "]";
	}

}
