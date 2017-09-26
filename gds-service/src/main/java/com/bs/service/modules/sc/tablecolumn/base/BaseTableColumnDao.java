package com.bs.service.modules.sc.tablecolumn.base;

import java.util.List;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;

public interface BaseTableColumnDao{
	/**
	 * 保存数据
	 * @param tableColumnDO
	 */
	public Integer save(TableColumnDO tableColumnDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param tableColumnDO
	 */
	public Integer updateById(TableColumnDO tableColumnDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param tableColumnDO
	 */
	public Integer updateCriteria(TableColumnDO tableColumnDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param tableColumnDO
	 */
	public Integer removeCriteria(TableColumnDO tableColumnDO) throws Exception;

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
	 * @param tableColumnDO
	 * @return List
	 */
	public List<TableColumnDO> listCriteria(TableColumnDO tableColumnDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(TableColumnDO tableColumnDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<TableColumnDO> listByInIds(TableColumnDO tableColumnDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<TableColumnDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public TableColumnDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param tableColumnDO
	 * @return
	 */
	public TableColumnDO getOneCriteria(TableColumnDO tableColumnDO) throws Exception;

	/**
	 * 统计记录数
	 * @param tableColumnDO
	 */
	public Long count(TableColumnDO tableColumnDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param tableColumnDO
	 * @return list
	 */
	public List<TableColumnDO> listPaginated(TableColumnDO tableColumnDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param tableColumnDO
	 * @return list
	 */
	public List<TableColumnDO> listPaginatedManual(TableColumnDO tableColumnDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param tableColumnDO
	 */
	public Long countPaginatedManual(TableColumnDO tableColumnDO) throws Exception;
}
