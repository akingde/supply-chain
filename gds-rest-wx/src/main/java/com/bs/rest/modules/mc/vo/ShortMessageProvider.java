package com.bs.rest.modules.mc.vo;

import java.io.Serializable;


public class ShortMessageProvider implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	protected Long id;
	
	/**SP名称-**/
	protected String name;
	
	/**SP代码-**/
	protected String code;
	
	/**SP短信通道账号-**/
	protected String account;
	
	/**SP短信通道密码-**/
	protected String password;
	
	/**SP通道组Id-**/
	protected String tunnelCode;
	
	/**发送短信地址-**/
	protected String sendUrl;
	
	/**获取状态报告地址-**/
	protected String fetchPath;
	
	/**短信签名-**/
	protected String sign;
	
	/**短信格式类型-**/
	protected String formatType;
	
	/**是否使用-1：已使用 0：未使用**/
	protected Byte isUse;
	
	/**数据版本-**/
	protected Long version;
	
	/**创建时间-创建时间：角色的创建时间，为以后进行跟踪查询。**/
	protected String createTime;
	
	/**修改时间-**/
	protected String modifyTime;
	
	/**备注-机构描述：机构相关信息的说明或者描述。**/
	protected String comment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTunnelCode() {
		return tunnelCode;
	}

	public void setTunnelCode(String tunnelCode) {
		this.tunnelCode = tunnelCode;
	}

	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getFetchPath() {
		return fetchPath;
	}

	public void setFetchPath(String fetchPath) {
		this.fetchPath = fetchPath;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public Byte getIsUse() {
		return isUse;
	}

	public void setIsUse(Byte isUse) {
		this.isUse = isUse;
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
