package com.bs.service.modules.uc.organization;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.uc.organization.base.BaseOrganizationService;
import com.bs.service.modules.uc.organization.OrganizationDO;

@Service
@Transactional(readOnly = true)
public class OrganizationService extends BaseOrganizationService<OrganizationDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
