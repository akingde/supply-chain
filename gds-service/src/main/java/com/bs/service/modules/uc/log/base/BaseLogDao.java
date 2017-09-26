package com.bs.service.modules.uc.log.base;

import java.util.List;
import com.bs.service.modules.uc.log.LogDO;

public interface BaseLogDao{
	/**
	 * 保存数据
	 * @param logDO
	 */
	public Integer save(LogDO logDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param logDO
	 */
	public Integer updateById(LogDO logDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param logDO
	 */
	public Integer updateCriteria(LogDO logDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param logDO
	 */
	public Integer removeCriteria(LogDO logDO) throws Exception;

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
	 * @param logDO
	 * @return List
	 */
	public List<LogDO> listCriteria(LogDO logDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(LogDO logDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<LogDO> listByInIds(LogDO logDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<LogDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public LogDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param logDO
	 * @return
	 */
	public LogDO getOneCriteria(LogDO logDO) throws Exception;

	/**
	 * 统计记录数
	 * @param logDO
	 */
	public Long count(LogDO logDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param logDO
	 * @return list
	 */
	public List<LogDO> listPaginated(LogDO logDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param logDO
	 * @return list
	 */
	public List<LogDO> listPaginatedManual(LogDO logDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param logDO
	 */
	public Long countPaginatedManual(LogDO logDO) throws Exception;
}
