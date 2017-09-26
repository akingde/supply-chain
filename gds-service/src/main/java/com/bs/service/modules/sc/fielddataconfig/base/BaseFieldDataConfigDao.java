package com.bs.service.modules.sc.fielddataconfig.base;

import java.util.List;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;

public interface BaseFieldDataConfigDao{
	/**
	 * 保存数据
	 * @param fieldDataConfigDO
	 */
	public Integer save(FieldDataConfigDO fieldDataConfigDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param fieldDataConfigDO
	 */
	public Integer updateById(FieldDataConfigDO fieldDataConfigDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param fieldDataConfigDO
	 */
	public Integer updateCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param fieldDataConfigDO
	 */
	public Integer removeCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception;

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
	 * @param fieldDataConfigDO
	 * @return List
	 */
	public List<FieldDataConfigDO> listCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<FieldDataConfigDO> listByInIds(FieldDataConfigDO fieldDataConfigDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<FieldDataConfigDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public FieldDataConfigDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param fieldDataConfigDO
	 * @return
	 */
	public FieldDataConfigDO getOneCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception;

	/**
	 * 统计记录数
	 * @param fieldDataConfigDO
	 */
	public Long count(FieldDataConfigDO fieldDataConfigDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param fieldDataConfigDO
	 * @return list
	 */
	public List<FieldDataConfigDO> listPaginated(FieldDataConfigDO fieldDataConfigDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param fieldDataConfigDO
	 * @return list
	 */
	public List<FieldDataConfigDO> listPaginatedManual(FieldDataConfigDO fieldDataConfigDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param fieldDataConfigDO
	 */
	public Long countPaginatedManual(FieldDataConfigDO fieldDataConfigDO) throws Exception;
}
