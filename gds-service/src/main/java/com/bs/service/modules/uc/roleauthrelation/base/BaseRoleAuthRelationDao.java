package com.bs.service.modules.uc.roleauthrelation.base;

import java.util.List;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;

public interface BaseRoleAuthRelationDao{
	/**
	 * 保存数据
	 * @param roleAuthRelationDO
	 */
	public Integer save(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
	
	
	/**
	 * 动态条件修改
	 * @param roleAuthRelationDO
	 */
	public Integer updateCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param roleAuthRelationDO
	 */
	public Integer removeCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception;

	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param roleAuthRelationDO
	 * @return List
	 */
	public List<RoleAuthRelationDO> listCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<RoleAuthRelationDO> listByInIds(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<RoleAuthRelationDO> listAll() throws Exception;

	
	/**
	 * 查询单条记录
	 * @param roleAuthRelationDO
	 * @return
	 */
	public RoleAuthRelationDO getOneCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception;

	/**
	 * 统计记录数
	 * @param roleAuthRelationDO
	 */
	public Long count(RoleAuthRelationDO roleAuthRelationDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param roleAuthRelationDO
	 * @return list
	 */
	public List<RoleAuthRelationDO> listPaginated(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param roleAuthRelationDO
	 * @return list
	 */
	public List<RoleAuthRelationDO> listPaginatedManual(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param roleAuthRelationDO
	 */
	public Long countPaginatedManual(RoleAuthRelationDO roleAuthRelationDO) throws Exception;
}
