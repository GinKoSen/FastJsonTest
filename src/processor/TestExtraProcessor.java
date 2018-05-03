//package processor;
//
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
//
///**
// * 
// * @author GinKo.Wang
// * @mail <a href="mailto:yingosen@gmail.com">yingosen@gmail.com</a>
// * @date 2015年12月30日 下午9:23:04
// *
// */
//public class TestExtraProcessor {
//
//	public static void main(String[] args) {
//		String json = "{" +
//				"\"contents\":"
//				+ "[" +
//				"{" +
//				"\"type\":\"image\"," +
//				"\"data\":[" +
//				"{" +
//				"\"attachment\":\"picurl\"," +
//				"\"width\":600," +
//				"\"height\":398" +
//				"}," +
//				"{" +
//				"\"attachment\":\"picurl\"," +
//				"\"width\":600," +
//				"\"height\":398" +
//				"}" +
//				"]" +
//				"}," +
//				"{" +
//				"\"type\":\"text\"," +
//				"\"data\":\"聊过往，聊里、花草里、阳光里。\"" +
//				"}" +
//				"]" +
//				"}";
//		// TODO 注意这里的ExtraProcessor实例在fastjson中的说明
//		ProcessorExport export = JSON.parseObject(json, ProcessorExport.class, new ExtraProcessor() {
//
//			@Override
//			public void processExtra(Object object, String key, Object value) {
//				if (object.getClass().isAssignableFrom(ProcessorExportData.class)) {
//					ProcessorExportData data = (ProcessorExportData) object;
//					data.optionalVal = new OptionalVal(value, value.getClass());
//				}
//			}
//		});
//		// 方案1：转换后获取数据过程
//		// for (ProcessorExportData info : export.contents) {
//		// OptionalVal optional = info.optionalVal;
//		// if (List.class.isAssignableFrom(optional.getType())) {
//		// List<ProcessorExportDataInfo> datas = optional.data();
//		// System.err.println(datas + "," + datas.size());
//		// } else {
//		// String data = optional.data(String.class);
//		// System.err.println(data);
//		// }
//		// }
//		// TODO 方案2：调用者自行转换
//		for (ProcessorExportData info : export.contents) {
//			Object object = info.data;
//			if (List.class.isAssignableFrom(object.getClass())) {
//				List<ProcessorExportDataInfo> datas = info.data();
//				System.err.println(datas + "," + datas.size());
//			} else {
//				String data = info.data(String.class);
//				System.err.println(data);
//			}
//		}
//	}
//}
