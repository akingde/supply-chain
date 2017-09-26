package com.bs.service.modules.sc.viewconfig.base;

import java.util.List;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;

public interface BaseViewConfigDao{
	/**
	 * 保存数据
	 * @param viewConfigDO
	 */
	public Integer save(ViewConfigDO viewConfigDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param viewConfigDO
	 */
	public Integer updateById(ViewConfigDO viewConfigDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param viewConfigDO
	 */
	public Integer updateCriteria(ViewConfigDO viewConfigDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param viewConfigDO
	 */
	public Integer removeCriteria(ViewConfigDO viewConfigDO) throws Exception;

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
	 * @param viewConfigDO
	 * @return List
	 */
	public List<ViewConfigDO> listCriteria(ViewConfigDO viewConfigDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(ViewConfigDO viewConfigDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<ViewConfigDO> listByInIds(ViewConfigDO viewConfigDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<ViewConfigDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ViewConfigDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param viewConfigDO
	 * @return
	 */
	public ViewConfigDO getOneCriteria(ViewConfigDO viewConfigDO) throws Exception;

	/**
	 * 统计记录数
	 * @param viewConfigDO
	 */
	public Long count(ViewConfigDO viewConfigDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param viewConfigDO
	 * @return list
	 */
	public List<ViewConfigDO> listPaginated(ViewConfigDO viewConfigDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param viewConfigDO
	 * @return list
	 */
	public List<ViewConfigDO> listPaginatedManual(ViewConfigDO viewConfigDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param viewConfigDO
	 */
	public Long countPaginatedManual(ViewConfigDO viewConfigDO) throws Exception;
}
