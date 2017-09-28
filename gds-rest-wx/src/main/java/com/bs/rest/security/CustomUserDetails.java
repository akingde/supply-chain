package com.bs.rest.security;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User{

	private static final long serialVersionUID = 1L;
	
	/**用户ID-用户随机编号：系统生成**/
	private Long id;
	
	/**机构Id-**/
	private Long orgId;
	
	/**数据访问-创建者：记录用户的创建人员的名称。**/
	private String orgIds;
	
	/**用户登录帐号-用户登录ID：用户登录系统的标识，一般是英文字符或者数字。**/
	private String account;

	/**机构名称-**/
	private Integer orgType;
	
	/**机构名称-**/
	private String orgName;
	
	/**机构代码-**/
	private String orgCode;
	
	/**用户类型-1：平台方用户 2：公寓方用户**/
	private Integer userType;
	
	/**是否为超管-1：超级管理员 0：普通管理员**/
	private Integer isAdmin;
	
	/**是否为管理岗-0：否 1：是**/
	private Integer isPosition;
	
	/**用户姓名-用户名称：登录系统的用户的姓名。**/
	private String name;
	
	/**用户移动电话-用户移动电话：用户移动电话号码。**/
	private String mobilePhone;
	
	/**用户邮件-用户邮件：用户的邮箱地址。**/
	private String email;
	
	/**用户办公电话-用户办公电话：用户办公电话号码。**/
	private String officePhone;
	
	/**用户性别-用户性别 1:男性 2:女性 3:其他**/
	private Integer gender;
	
	/**用户生日-**/
	private String birthday;
	
	/**个性签名-**/
	private String signature;
	
	/**用户状态-1.启用 0.禁用**/
	private Integer userStatus;
	
	/**
	 * 登录的时候可以一次性获取的其他业务数据
	 */
	private Map<String,Object> dataMap;
	
	public CustomUserDetails(String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, true, true, true, true, authorities);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getIsPosition() {
		return isPosition;
	}

	public void setIsPosition(Integer isPosition) {
		this.isPosition = isPosition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

}
