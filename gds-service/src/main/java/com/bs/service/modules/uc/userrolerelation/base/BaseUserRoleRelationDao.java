package com.bs.service.modules.uc.userrolerelation.base;

import java.util.List;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;

public interface BaseUserRoleRelationDao{
	/**
	 * 保存数据
	 * @param userRoleRelationDO
	 */
	public Integer save(UserRoleRelationDO userRoleRelationDO) throws Exception;
	
	
	/**
	 * 动态条件修改
	 * @param userRoleRelationDO
	 */
	public Integer updateCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param userRoleRelationDO
	 */
	public Integer removeCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception;

	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param userRoleRelationDO
	 * @return List
	 */
	public List<UserRoleRelationDO> listCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<UserRoleRelationDO> listByInIds(UserRoleRelationDO userRoleRelationDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<UserRoleRelationDO> listAll() throws Exception;

	
	/**
	 * 查询单条记录
	 * @param userRoleRelationDO
	 * @return
	 */
	public UserRoleRelationDO getOneCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception;

	/**
	 * 统计记录数
	 * @param userRoleRelationDO
	 */
	public Long count(UserRoleRelationDO userRoleRelationDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param userRoleRelationDO
	 * @return list
	 */
	public List<UserRoleRelationDO> listPaginated(UserRoleRelationDO userRoleRelationDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param userRoleRelationDO
	 * @return list
	 */
	public List<UserRoleRelationDO> listPaginatedManual(UserRoleRelationDO userRoleRelationDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param userRoleRelationDO
	 */
	public Long countPaginatedManual(UserRoleRelationDO userRoleRelationDO) throws Exception;
}
