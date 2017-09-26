package com.bs.service.modules.uc.user.base;

import java.util.List;
import com.bs.service.modules.uc.user.UserDO;

public interface BaseUserDao{
	/**
	 * 保存数据
	 * @param userDO
	 */
	public Integer save(UserDO userDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param userDO
	 */
	public Integer updateById(UserDO userDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param userDO
	 */
	public Integer updateCriteria(UserDO userDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param userDO
	 */
	public Integer removeCriteria(UserDO userDO) throws Exception;

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
	 * @param userDO
	 * @return List
	 */
	public List<UserDO> listCriteria(UserDO userDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(UserDO userDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<UserDO> listByInIds(UserDO userDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<UserDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public UserDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param userDO
	 * @return
	 */
	public UserDO getOneCriteria(UserDO userDO) throws Exception;

	/**
	 * 统计记录数
	 * @param userDO
	 */
	public Long count(UserDO userDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param userDO
	 * @return list
	 */
	public List<UserDO> listPaginated(UserDO userDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param userDO
	 * @return list
	 */
	public List<UserDO> listPaginatedManual(UserDO userDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param userDO
	 */
	public Long countPaginatedManual(UserDO userDO) throws Exception;
}
