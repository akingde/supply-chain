package com.bs.service.modules.uc.userrolerelation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.uc.userrolerelation.base.BaseUserRoleRelationService;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;

@Service
@Transactional(readOnly = true)
public class UserRoleRelationService extends BaseUserRoleRelationService<UserRoleRelationDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
