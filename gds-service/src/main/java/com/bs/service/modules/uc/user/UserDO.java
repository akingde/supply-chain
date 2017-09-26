package com.bs.service.modules.uc.user;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.uc.user.base.BaseUserPO;
import com.bs.service.modules.uc.organization.OrganizationDO;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;	
import java.util.ArrayList;

public class UserDO extends BaseUserPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.user.id}",groups = {Id.class}) 
	private Long id;
	
	/**机构信息表**/
	private OrganizationDO organizationDO;

	
	/**用户角色关系映射表**/
	private ArrayList<UserRoleRelationDO> userRoleRelationDOList;

	public UserDO() {
	}

	public OrganizationDO getOrganizationDO () {
		return organizationDO;
	}

	public void setOrganizationDO(OrganizationDO organizationDO) {
		this.organizationDO = organizationDO;
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
