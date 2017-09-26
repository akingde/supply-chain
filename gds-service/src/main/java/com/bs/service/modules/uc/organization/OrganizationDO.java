package com.bs.service.modules.uc.organization;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.uc.organization.base.BaseOrganizationPO;
import com.bs.service.modules.uc.user.UserDO;	
import java.util.ArrayList;

public class OrganizationDO extends BaseOrganizationPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.organization.id}",groups = {Id.class}) 
	private Long id;

	
	/**用户信息表**/
	private ArrayList<UserDO> userDOList;

	public OrganizationDO() {
	}
	
	public ArrayList<UserDO> getUserDOList () {
		return userDOList;
	}

	public void setUserDOList(ArrayList<UserDO> userDOList) {
		this.userDOList = userDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
