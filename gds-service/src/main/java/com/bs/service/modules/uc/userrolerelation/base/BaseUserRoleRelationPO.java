package com.bs.service.modules.uc.userrolerelation.base;

import com.bs.service.core.entity.Entity;

public abstract class BaseUserRoleRelationPO extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**用户ID-用户随机编号：系统生成**/
	private Long userId;
	
	/**角色ID-**/
	private Long roleId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
