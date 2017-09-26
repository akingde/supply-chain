package com.bs.service.modules.uc.role;

import com.alibaba.dubbo.config.annotation.Service;
import com.bs.api.modules.uc.dto.RoleDTO;
import com.bs.api.modules.uc.service.IRoleService;
import com.bs.service.modules.uc.role.base.BaseRoleApi;

@Service(version = "1.0.0")
public class RoleApi extends BaseRoleApi<RoleDTO> implements IRoleService{
	
	@Override
	public String bizValid(String method, RoleDO roleDO) {
		return null;
	}
}
