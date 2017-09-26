package com.bs.service.modules.uc.organization;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.uc.service.IOrganizationService;
import com.bs.api.modules.uc.dto.OrganizationDTO;
import com.bs.service.modules.uc.organization.OrganizationDO;
import com.bs.service.modules.uc.organization.base.BaseOrganizationApi;

@Service(version = "1.0.0")
public class OrganizationApi extends BaseOrganizationApi<OrganizationDTO> implements IOrganizationService{
	
	@Override
	public String bizValid(String method, OrganizationDO organizationDO) {
		return null;
	}
}
