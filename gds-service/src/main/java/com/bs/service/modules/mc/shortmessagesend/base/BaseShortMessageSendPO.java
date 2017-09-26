package com.bs.service.modules.mc.shortmessagesend.base;

import com.bs.service.core.entity.Entity;

public abstract class BaseShortMessageSendPO extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	
	/**SP代码2-**/
	private String code;
	
	/**客户ID-**/
	private Long memberId;
	
	/**发送手机号-**/
	private String mobilePhone;
	
	/**内容-**/
	private String content;
	
	/**业务类型代码-SM1001：验证码短信 SM1002：批量文件发送 SM1003：选择数据发送 SM1004：单挑手动发送 SM1005：业务触发发送**/
	private String businessCode;
	
	/**业务类型说明-SM1001：验证码短信**/
	private String businessDesc;
	
	/**SP代码-**/
	private String spCode;
	
	/**是否重发-0：否 1：是**/
	private Integer isRetry;
	
	/**重发次数-默认为0，每重发一次，该值+1，直到最大重发次数**/
	private Integer retryCount;
	
	/**短信序列号-**/
	private String messageSerial;
	
	/**发送状态-0：等待发送 1：已经发送**/
	private Integer sendStatus;
	
	/**状态报告-**/
	private Integer statusReport;
	
	/**状态说明-**/
	private String statements;
	
	/**短信类型-15 短短信 32 长短信**/
	private Integer messageType;
	
	/**发送方式-1：立即发送 2：指定时间**/
	private Integer sendType;
	
	/**发送开始小时-**/
	private Integer sendBeginHour;
	
	/**发送结束小时-**/
	private Integer sendEndHour;
	
	/**短信拆分总数-长短信被拆分的条数**/
	private Integer totalCount;
	
	/**发送时间-**/
	private String sendTime;
	
	/**超时时长-设置超时 （单位/毫秒）**/
	private Long timeout;
	
	/**开始时间-计算超时的开始时间**/
	private Long originTime;
	
	/**数据版本-**/
	private Long version;
	
	/**创建时间-创建时间：角色的创建时间，为以后进行跟踪查询。**/
	private String createTime;
	
	/**修改时间-**/
	private String modifyTime;
	
	/**备注-机构描述：机构相关信息的说明或者描述。**/
	private String comment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public Integer getIsRetry() {
		return isRetry;
	}

	public void setIsRetry(Integer isRetry) {
		this.isRetry = isRetry;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public String getMessageSerial() {
		return messageSerial;
	}

	public void setMessageSerial(String messageSerial) {
		this.messageSerial = messageSerial;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getStatusReport() {
		return statusReport;
	}

	public void setStatusReport(Integer statusReport) {
		this.statusReport = statusReport;
	}

	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		this.statements = statements;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Integer getSendBeginHour() {
		return sendBeginHour;
	}

	public void setSendBeginHour(Integer sendBeginHour) {
		this.sendBeginHour = sendBeginHour;
	}

	public Integer getSendEndHour() {
		return sendEndHour;
	}

	public void setSendEndHour(Integer sendEndHour) {
		this.sendEndHour = sendEndHour;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Long getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Long originTime) {
		this.originTime = originTime;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
