package com.bs.service.modules.sc.viewconfig;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.viewconfig.base.BaseViewConfigPO;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;	
import com.bs.service.modules.uc.authorization.AuthorizationDO;	
import java.util.ArrayList;

public class ViewConfigDO extends BaseViewConfigPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.viewConfig.id}",groups = {Id.class}) 
	private Long id;

	
	/**视图字段配置信息存储表**/
	private ArrayList<ViewFieldConfigDO> viewFieldConfigDOList;
	
	/**权限管理信息存储表**/
	private ArrayList<AuthorizationDO> authorizationDOList;

	public ViewConfigDO() {
	}
	
	public ArrayList<ViewFieldConfigDO> getViewFieldConfigDOList () {
		return viewFieldConfigDOList;
	}

	public void setViewFieldConfigDOList(ArrayList<ViewFieldConfigDO> viewFieldConfigDOList) {
		this.viewFieldConfigDOList = viewFieldConfigDOList;
	}	
	
	public ArrayList<AuthorizationDO> getAuthorizationDOList () {
		return authorizationDOList;
	}

	public void setAuthorizationDOList(ArrayList<AuthorizationDO> authorizationDOList) {
		this.authorizationDOList = authorizationDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
