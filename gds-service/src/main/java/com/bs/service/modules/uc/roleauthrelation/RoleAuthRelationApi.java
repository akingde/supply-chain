package com.bs.service.modules.uc.roleauthrelation;

import com.alibaba.dubbo.config.annotation.Service;
import com.bs.api.modules.uc.dto.RoleAuthRelationDTO;
import com.bs.api.modules.uc.service.IRoleAuthRelationService;
import com.bs.service.modules.uc.roleauthrelation.base.BaseRoleAuthRelationApi;

@Service(version = "1.0.0")
public class RoleAuthRelationApi extends BaseRoleAuthRelationApi<RoleAuthRelationDTO> implements IRoleAuthRelationService{
	
	@Override
	public String bizValid(String method, RoleAuthRelationDO roleAuthRelationDO) {
		return null;
	}
}
