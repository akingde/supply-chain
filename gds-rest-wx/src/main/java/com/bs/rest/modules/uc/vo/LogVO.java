package com.bs.rest.modules.uc.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class LogVO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**日志ID-操作日志主键ID：操作日志记录表主键。**/
	@NotNull(message = "{NotNull.log.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**机构Id-**/
	private Long orgId;
	/**机构名称-**/
	private String orgName;
	/**用户ID-**/
	private Long userId;
	/**操作用户名称-**/
	private String userName;
	/**操作时间-操作时间：日志记录的详细时间。**/
	private String operateTime;
	/**操作类别-1：创建操作 2：修改操作 3：删除操作 4：其他操作**/
	private Integer operateType;
	/**操作内容-操作内容：系统用户操作的具体功能步骤的记录。**/
	private String content;
	/**访问IP-访问IP：系统用户远端访问的IP地址。**/
	private String accessIp;
	/**数据版本-**/
	private Long version;
	/**创建时间-**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**备注-机构描述：机构相关信息的说明或者描述。**/
	private String comment;


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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAccessIp() {
		return accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
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
