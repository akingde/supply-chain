package com.bs.service.modules.sc.viewfieldconfig.base;

import java.util.List;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;

public interface BaseViewFieldConfigDao{
	/**
	 * 保存数据
	 * @param viewFieldConfigDO
	 */
	public Integer save(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param viewFieldConfigDO
	 */
	public Integer updateById(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param viewFieldConfigDO
	 */
	public Integer updateCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param viewFieldConfigDO
	 */
	public Integer removeCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception;

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
	 * @param viewFieldConfigDO
	 * @return List
	 */
	public List<ViewFieldConfigDO> listCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<ViewFieldConfigDO> listByInIds(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<ViewFieldConfigDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ViewFieldConfigDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param viewFieldConfigDO
	 * @return
	 */
	public ViewFieldConfigDO getOneCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception;

	/**
	 * 统计记录数
	 * @param viewFieldConfigDO
	 */
	public Long count(ViewFieldConfigDO viewFieldConfigDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param viewFieldConfigDO
	 * @return list
	 */
	public List<ViewFieldConfigDO> listPaginated(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param viewFieldConfigDO
	 * @return list
	 */
	public List<ViewFieldConfigDO> listPaginatedManual(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param viewFieldConfigDO
	 */
	public Long countPaginatedManual(ViewFieldConfigDO viewFieldConfigDO) throws Exception;
}
