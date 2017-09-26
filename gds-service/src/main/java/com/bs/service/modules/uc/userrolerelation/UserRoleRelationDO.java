package com.bs.service.modules.uc.userrolerelation;


import com.bs.service.modules.uc.userrolerelation.base.BaseUserRoleRelationPO;
import com.bs.service.modules.uc.role.RoleDO;
import com.bs.service.modules.uc.user.UserDO;

public class UserRoleRelationDO extends BaseUserRoleRelationPO {

	private static final long serialVersionUID = 1L;
	
	
	/**角色信息表**/
	private RoleDO roleDO;
	
	/**用户信息表**/
	private UserDO userDO;


	public UserRoleRelationDO() {
	}

	public RoleDO getRoleDO () {
		return roleDO;
	}

	public void setRoleDO(RoleDO roleDO) {
		this.roleDO = roleDO;
	}

	public UserDO getUserDO () {
		return userDO;
	}

	public void setUserDO(UserDO userDO) {
		this.userDO = userDO;
	}

}
