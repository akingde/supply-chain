package com.bs.service.modules.uc.roleauthrelation;


import com.bs.service.modules.uc.roleauthrelation.base.BaseRoleAuthRelationPO;
import com.bs.service.modules.uc.role.RoleDO;
import com.bs.service.modules.uc.authorization.AuthorizationDO;

public class RoleAuthRelationDO extends BaseRoleAuthRelationPO {

	private static final long serialVersionUID = 1L;
	
	
	/**角色信息表**/
	private RoleDO roleDO;
	
	/**权限管理信息存储表**/
	private AuthorizationDO authorizationDO;


	public RoleAuthRelationDO() {
	}

	public RoleDO getRoleDO () {
		return roleDO;
	}

	public void setRoleDO(RoleDO roleDO) {
		this.roleDO = roleDO;
	}

	public AuthorizationDO getAuthorizationDO () {
		return authorizationDO;
	}

	public void setAuthorizationDO(AuthorizationDO authorizationDO) {
		this.authorizationDO = authorizationDO;
	}

}
