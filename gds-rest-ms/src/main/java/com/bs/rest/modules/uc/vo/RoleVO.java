package com.bs.rest.modules.uc.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class RoleVO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**角色ID-**/
	@NotNull(message = "{NotNull.role.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**角色名称-**/
	private String name;
	/**角色类型-1：平台方角色 2：公寓方角色**/
	private Integer roleType;
	/**角色状态-角色状态： 0：禁用 1：开启**/
	private Integer roleStatus;
	/**数据版本-**/
	private Long version;
	/**创建时间-**/
	private String createTime;
	/**更新时间-**/
	private String modifyTime;
	/**备注-**/
	private String comment;


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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
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
