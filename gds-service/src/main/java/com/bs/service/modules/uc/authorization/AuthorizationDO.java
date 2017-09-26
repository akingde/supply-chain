package com.bs.service.modules.uc.authorization;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.uc.authorization.base.BaseAuthorizationPO;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;	
import java.util.ArrayList;

public class AuthorizationDO extends BaseAuthorizationPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.authorization.id}",groups = {Id.class}) 
	private Long id;
	
	/**视图配置信息存储表**/
	private ViewConfigDO viewConfigDO;

	
	/**用户角色关系映射表**/
	private ArrayList<RoleAuthRelationDO> roleAuthRelationDOList;

	public AuthorizationDO() {
	}

	public ViewConfigDO getViewConfigDO () {
		return viewConfigDO;
	}

	public void setViewConfigDO(ViewConfigDO viewConfigDO) {
		this.viewConfigDO = viewConfigDO;
	}
	
	public ArrayList<RoleAuthRelationDO> getRoleAuthRelationDOList () {
		return roleAuthRelationDOList;
	}

	public void setRoleAuthRelationDOList(ArrayList<RoleAuthRelationDO> roleAuthRelationDOList) {
		this.roleAuthRelationDOList = roleAuthRelationDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
