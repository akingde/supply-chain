package com.bs.service.modules.uc.role;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.uc.role.base.BaseRolePO;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;	
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;	
import java.util.ArrayList;

public class RoleDO extends BaseRolePO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.role.id}",groups = {Id.class}) 
	private Long id;

	
	/**用户角色关系映射表**/
	private ArrayList<RoleAuthRelationDO> roleAuthRelationDOList;
	
	/**用户角色关系映射表**/
	private ArrayList<UserRoleRelationDO> userRoleRelationDOList;

	public RoleDO() {
	}
	
	public ArrayList<RoleAuthRelationDO> getRoleAuthRelationDOList () {
		return roleAuthRelationDOList;
	}

	public void setRoleAuthRelationDOList(ArrayList<RoleAuthRelationDO> roleAuthRelationDOList) {
		this.roleAuthRelationDOList = roleAuthRelationDOList;
	}	
	
	public ArrayList<UserRoleRelationDO> getUserRoleRelationDOList () {
		return userRoleRelationDOList;
	}

	public void setUserRoleRelationDOList(ArrayList<UserRoleRelationDO> userRoleRelationDOList) {
		this.userRoleRelationDOList = userRoleRelationDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
