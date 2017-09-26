package com.bs.service.modules.uc.organization;

import org.apache.ibatis.annotations.Mapper;

import com.bs.service.modules.uc.organization.base.BaseOrganizationDao;

@Mapper
public interface IOrganizationDao extends BaseOrganizationDao{
	
	/**
	 * 根据code代码查询机构信息
	 * @param organizationDO
	 * @return
	 */
	public OrganizationDO getOneByCode(String code);
}
