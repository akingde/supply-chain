package com.bs.service.modules.uc.role;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.uc.role.base.BaseRoleService;
import com.bs.service.modules.uc.role.RoleDO;

@Service
@Transactional(readOnly = true)
public class RoleService extends BaseRoleService<RoleDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
