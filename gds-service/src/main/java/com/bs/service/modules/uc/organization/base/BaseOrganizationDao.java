package com.bs.service.modules.uc.organization.base;

import java.util.List;
import com.bs.service.modules.uc.organization.OrganizationDO;

public interface BaseOrganizationDao{
	/**
	 * 保存数据
	 * @param organizationDO
	 */
	public Integer save(OrganizationDO organizationDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param organizationDO
	 */
	public Integer updateById(OrganizationDO organizationDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param organizationDO
	 */
	public Integer updateCriteria(OrganizationDO organizationDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param organizationDO
	 */
	public Integer removeCriteria(OrganizationDO organizationDO) throws Exception;

	/**
	 * 根据主键ID删除数据
	 * @param id
	 */
	public Integer removeById(Long id) throws Exception;
	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param organizationDO
	 * @return List
	 */
	public List<OrganizationDO> listCriteria(OrganizationDO organizationDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(OrganizationDO organizationDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<OrganizationDO> listByInIds(OrganizationDO organizationDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<OrganizationDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public OrganizationDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param organizationDO
	 * @return
	 */
	public OrganizationDO getOneCriteria(OrganizationDO organizationDO) throws Exception;

	/**
	 * 统计记录数
	 * @param organizationDO
	 */
	public Long count(OrganizationDO organizationDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param organizationDO
	 * @return list
	 */
	public List<OrganizationDO> listPaginated(OrganizationDO organizationDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param organizationDO
	 * @return list
	 */
	public List<OrganizationDO> listPaginatedManual(OrganizationDO organizationDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param organizationDO
	 */
	public Long countPaginatedManual(OrganizationDO organizationDO) throws Exception;
}
