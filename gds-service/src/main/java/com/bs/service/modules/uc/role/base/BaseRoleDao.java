package com.bs.service.modules.uc.role.base;

import java.util.List;
import com.bs.service.modules.uc.role.RoleDO;

public interface BaseRoleDao{
	/**
	 * 保存数据
	 * @param roleDO
	 */
	public Integer save(RoleDO roleDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param roleDO
	 */
	public Integer updateById(RoleDO roleDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param roleDO
	 */
	public Integer updateCriteria(RoleDO roleDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param roleDO
	 */
	public Integer removeCriteria(RoleDO roleDO) throws Exception;

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
	 * @param roleDO
	 * @return List
	 */
	public List<RoleDO> listCriteria(RoleDO roleDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(RoleDO roleDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<RoleDO> listByInIds(RoleDO roleDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<RoleDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public RoleDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param roleDO
	 * @return
	 */
	public RoleDO getOneCriteria(RoleDO roleDO) throws Exception;

	/**
	 * 统计记录数
	 * @param roleDO
	 */
	public Long count(RoleDO roleDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param roleDO
	 * @return list
	 */
	public List<RoleDO> listPaginated(RoleDO roleDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param roleDO
	 * @return list
	 */
	public List<RoleDO> listPaginatedManual(RoleDO roleDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param roleDO
	 */
	public Long countPaginatedManual(RoleDO roleDO) throws Exception;
}
