package com.bs.service.modules.sc.area.base;

import java.util.List;
import com.bs.service.modules.sc.area.AreaDO;

public interface BaseAreaDao{
	/**
	 * 保存数据
	 * @param areaDO
	 */
	public Integer save(AreaDO areaDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param areaDO
	 */
	public Integer updateById(AreaDO areaDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param areaDO
	 */
	public Integer updateCriteria(AreaDO areaDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param areaDO
	 */
	public Integer removeCriteria(AreaDO areaDO) throws Exception;

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
	 * @param areaDO
	 * @return List
	 */
	public List<AreaDO> listCriteria(AreaDO areaDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(AreaDO areaDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<AreaDO> listByInIds(AreaDO areaDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<AreaDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public AreaDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param areaDO
	 * @return
	 */
	public AreaDO getOneCriteria(AreaDO areaDO) throws Exception;

	/**
	 * 统计记录数
	 * @param areaDO
	 */
	public Long count(AreaDO areaDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param areaDO
	 * @return list
	 */
	public List<AreaDO> listPaginated(AreaDO areaDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param areaDO
	 * @return list
	 */
	public List<AreaDO> listPaginatedManual(AreaDO areaDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param areaDO
	 */
	public Long countPaginatedManual(AreaDO areaDO) throws Exception;
}
