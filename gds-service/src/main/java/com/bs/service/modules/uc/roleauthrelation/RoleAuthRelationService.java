package com.bs.service.modules.uc.roleauthrelation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.uc.roleauthrelation.base.BaseRoleAuthRelationService;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;

@Service
@Transactional(readOnly = true)
public class RoleAuthRelationService extends BaseRoleAuthRelationService<RoleAuthRelationDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
