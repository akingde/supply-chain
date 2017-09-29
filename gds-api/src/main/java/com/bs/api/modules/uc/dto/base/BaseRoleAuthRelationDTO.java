package com.bs.api.modules.uc.dto.base;

import com.bs.api.core.entity.Entity;

public abstract class BaseRoleAuthRelationDTO extends Entity {

	private static final long serialVersionUID = 1L;

	
	/**角色ID-**/
	private Long roleId;
	
	/**权限ID-系统权限代码，编码为数字，具有一定的规律。格式如下：1，11，111，112，12，121，122，13，131，132……**/
	private Long authId;
	
	public BaseRoleAuthRelationDTO() {
	
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}
}
