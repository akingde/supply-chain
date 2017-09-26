package com.bs.service.modules.sc.tableindex.base;

import java.util.List;
import com.bs.service.modules.sc.tableindex.TableIndexDO;

public interface BaseTableIndexDao{
	/**
	 * 保存数据
	 * @param tableIndexDO
	 */
	public Integer save(TableIndexDO tableIndexDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param tableIndexDO
	 */
	public Integer updateById(TableIndexDO tableIndexDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param tableIndexDO
	 */
	public Integer updateCriteria(TableIndexDO tableIndexDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param tableIndexDO
	 */
	public Integer removeCriteria(TableIndexDO tableIndexDO) throws Exception;

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
	 * @param tableIndexDO
	 * @return List
	 */
	public List<TableIndexDO> listCriteria(TableIndexDO tableIndexDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(TableIndexDO tableIndexDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<TableIndexDO> listByInIds(TableIndexDO tableIndexDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<TableIndexDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public TableIndexDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param tableIndexDO
	 * @return
	 */
	public TableIndexDO getOneCriteria(TableIndexDO tableIndexDO) throws Exception;

	/**
	 * 统计记录数
	 * @param tableIndexDO
	 */
	public Long count(TableIndexDO tableIndexDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param tableIndexDO
	 * @return list
	 */
	public List<TableIndexDO> listPaginated(TableIndexDO tableIndexDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param tableIndexDO
	 * @return list
	 */
	public List<TableIndexDO> listPaginatedManual(TableIndexDO tableIndexDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param tableIndexDO
	 */
	public Long countPaginatedManual(TableIndexDO tableIndexDO) throws Exception;
}
