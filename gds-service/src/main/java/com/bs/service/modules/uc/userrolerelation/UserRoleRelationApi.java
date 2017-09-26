package com.bs.service.modules.uc.userrolerelation;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.uc.service.IUserRoleRelationService;
import com.bs.api.modules.uc.dto.UserRoleRelationDTO;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;
import com.bs.service.modules.uc.userrolerelation.base.BaseUserRoleRelationApi;

@Service(version = "1.0.0")
public class UserRoleRelationApi extends BaseUserRoleRelationApi<UserRoleRelationDTO> implements IUserRoleRelationService{
	
	@Override
	public String bizValid(String method, UserRoleRelationDO userRoleRelationDO) {
		return null;
	}
}
