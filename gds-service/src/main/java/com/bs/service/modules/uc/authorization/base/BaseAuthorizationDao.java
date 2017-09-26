package com.bs.service.modules.uc.authorization.base;

import java.util.List;
import com.bs.service.modules.uc.authorization.AuthorizationDO;

public interface BaseAuthorizationDao{
	/**
	 * 保存数据
	 * @param authorizationDO
	 */
	public Integer save(AuthorizationDO authorizationDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param authorizationDO
	 */
	public Integer updateById(AuthorizationDO authorizationDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param authorizationDO
	 */
	public Integer updateCriteria(AuthorizationDO authorizationDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param authorizationDO
	 */
	public Integer removeCriteria(AuthorizationDO authorizationDO) throws Exception;

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
	 * @param authorizationDO
	 * @return List
	 */
	public List<AuthorizationDO> listCriteria(AuthorizationDO authorizationDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(AuthorizationDO authorizationDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<AuthorizationDO> listByInIds(AuthorizationDO authorizationDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<AuthorizationDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public AuthorizationDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param authorizationDO
	 * @return
	 */
	public AuthorizationDO getOneCriteria(AuthorizationDO authorizationDO) throws Exception;

	/**
	 * 统计记录数
	 * @param authorizationDO
	 */
	public Long count(AuthorizationDO authorizationDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param authorizationDO
	 * @return list
	 */
	public List<AuthorizationDO> listPaginated(AuthorizationDO authorizationDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param authorizationDO
	 * @return list
	 */
	public List<AuthorizationDO> listPaginatedManual(AuthorizationDO authorizationDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param authorizationDO
	 */
	public Long countPaginatedManual(AuthorizationDO authorizationDO) throws Exception;
}
