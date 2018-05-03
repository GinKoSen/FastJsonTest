package resp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Description 应答头
 * @Project InterfaceTest
 * @ClassName RespHeader.java
 * @Author guoyulin gyl_develop@163.com
 * @CreationDate 2016年1月7日 上午10:26:47
 * @Version V1.0
 * @Copyright
 * @ModificationHistory
 */
public class HeaderResp {

	/*
	 * 接口业务代码 1 EMI1000 未定义 HTTP 2 EMI1001 订购流量包 HTTP EC EC请求MDOS 3 EMI1002 订购流量包结果查询 HTTP EC EC请求MDOS 4 EMI1003
	 * 订购流量包结果反馈接口 HTTP MSA MDOS请求EC
	 */
	private String _BCode;// 消息标志_接口业务代码,5-7位,见本文档中的接口业务代码表；
	private String _Ack;// 1-请求，2-应答
	private String _SqId;// 流水号_系统时间戳,格式为: yyyyMMddHHmmss +XXXXXXXX（八位序列码），如：20141209161512345678
	private String _RtState;// 返回状态_0-成功 1-失败
	private String _RtErrCode;// 返回错误编码_见文档错误编码表
	private String _RtMsg;// 返回结果消息描述_接口实现安全机制。
	private String _Cnxt;// 报文体_具体业务数据，以JSON表达，请求方需要对此部分采用DES加密,具体加密方法参加接口实现安全机制。

	@JSONField(serialize = false)
	private String sourceRtMsg;
	@JSONField(serialize = false)
	private String sourceCnxt;// 解密_Cnxt，设置_Cnxt属性时会把解密后的字符串赋值给sourceCnxt
	@JSONField(serialize = false)
	private boolean isValidated = false;

	public String get_BCode() {
		return _BCode;
	}

	@JSONField(name = "BCode")
	public void set_BCode(String _BCode) {
		this._BCode = _BCode;
	}

	public String get_Ack() {
		return _Ack;
	}

	@JSONField(name = "Ack")
	public void set_Ack(String _Ack) {
		this._Ack = _Ack;
	}

	public String get_SqId() {
		return _SqId;
	}

	@JSONField(name = "SqId")
	public void set_SqId(String _SqId) {
		this._SqId = _SqId;
	}

	public String get_RtState() {
		return _RtState;
	}

	@JSONField(name = "RtState")
	public void set_RtState(String _RtState) {
		this._RtState = _RtState;
	}

	public String get_RtErrCode() {
		return _RtErrCode;
	}

	@JSONField(name = "RtErrCode")
	public void set_RtErrCode(String _RtErrCode) {
		this._RtErrCode = _RtErrCode;
	}

	public String get_RtMsg() {
		return _RtMsg;
	}

	@JSONField(name = "RtMsg")
	public void set_RtMsg(String _RtMsg) {
		this._RtMsg = _RtMsg;

		// 解码
		// this.sourceRtMsg = EncodeOrDecoder.decodeString(_RtMsg);
	}

	public String get_Cnxt() {
		return _Cnxt;
	}

	@JSONField(name = "Cnxt")
	public void set_Cnxt(String _Cnxt) {
		this._Cnxt = _Cnxt;
		// 解密
		try {
			if (_Cnxt == null || _Cnxt.length() == 0) {
				this.isValidated = true;// 当_Cnxt为空时也设置为通过验证
			} else {
				// this.sourceCnxt = EncryptOrDecrypt.decryptString(_Cnxt, MDOSUtil.getProperties("mdos.KEY"));
				this.isValidated = true;// 设置通过验证
			}
		} catch (Exception e) {
			this.isValidated = false;
			// loger.error("验证失败");
		}
	}

	public String getSourceCnxt() {
		return sourceCnxt;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public String getSourceRtMsg() {
		return sourceRtMsg;
	}

}
