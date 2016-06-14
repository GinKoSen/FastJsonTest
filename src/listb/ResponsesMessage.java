package listb;

import java.util.ArrayList;
import java.util.List;

public class ResponsesMessage {

	public String flag;
	public String desc;
	public List<ResponseData> data;

	public ResponsesMessage() {
		this.data = new ArrayList<>();
	}
}
