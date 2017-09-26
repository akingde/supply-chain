package com.bs.service.modules.sc.table.base;

import java.util.List;
import com.bs.service.modules.sc.table.TableDO;

public interface BaseTableDao{
	/**
	 * 保存数据
	 * @param tableDO
	 */
	public Integer save(TableDO tableDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param tableDO
	 */
	public Integer updateById(TableDO tableDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param tableDO
	 */
	public Integer updateCriteria(TableDO tableDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param tableDO
	 */
	public Integer removeCriteria(TableDO tableDO) throws Exception;

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
	 * @param tableDO
	 * @return List
	 */
	public List<TableDO> listCriteria(TableDO tableDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(TableDO tableDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<TableDO> listByInIds(TableDO tableDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<TableDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public TableDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param tableDO
	 * @return
	 */
	public TableDO getOneCriteria(TableDO tableDO) throws Exception;

	/**
	 * 统计记录数
	 * @param tableDO
	 */
	public Long count(TableDO tableDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param tableDO
	 * @return list
	 */
	public List<TableDO> listPaginated(TableDO tableDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param tableDO
	 * @return list
	 */
	public List<TableDO> listPaginatedManual(TableDO tableDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param tableDO
	 */
	public Long countPaginatedManual(TableDO tableDO) throws Exception;
}
