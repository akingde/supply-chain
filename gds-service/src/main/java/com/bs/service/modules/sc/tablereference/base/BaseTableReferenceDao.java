package com.bs.service.modules.sc.tablereference.base;

import java.util.List;
import com.bs.service.modules.sc.tablereference.TableReferenceDO;

public interface BaseTableReferenceDao{
	/**
	 * 保存数据
	 * @param tableReferenceDO
	 */
	public Integer save(TableReferenceDO tableReferenceDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param tableReferenceDO
	 */
	public Integer updateById(TableReferenceDO tableReferenceDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param tableReferenceDO
	 */
	public Integer updateCriteria(TableReferenceDO tableReferenceDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param tableReferenceDO
	 */
	public Integer removeCriteria(TableReferenceDO tableReferenceDO) throws Exception;

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
	 * @param tableReferenceDO
	 * @return List
	 */
	public List<TableReferenceDO> listCriteria(TableReferenceDO tableReferenceDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(TableReferenceDO tableReferenceDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<TableReferenceDO> listByInIds(TableReferenceDO tableReferenceDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<TableReferenceDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public TableReferenceDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param tableReferenceDO
	 * @return
	 */
	public TableReferenceDO getOneCriteria(TableReferenceDO tableReferenceDO) throws Exception;

	/**
	 * 统计记录数
	 * @param tableReferenceDO
	 */
	public Long count(TableReferenceDO tableReferenceDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param tableReferenceDO
	 * @return list
	 */
	public List<TableReferenceDO> listPaginated(TableReferenceDO tableReferenceDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param tableReferenceDO
	 * @return list
	 */
	public List<TableReferenceDO> listPaginatedManual(TableReferenceDO tableReferenceDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param tableReferenceDO
	 */
	public Long countPaginatedManual(TableReferenceDO tableReferenceDO) throws Exception;
}
