package com.bs.service.modules.sc.fielddatacategory.base;

import java.util.List;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;

public interface BaseFieldDataCategoryDao{
	/**
	 * 保存数据
	 * @param fieldDataCategoryDO
	 */
	public Integer save(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param fieldDataCategoryDO
	 */
	public Integer updateById(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param fieldDataCategoryDO
	 */
	public Integer updateCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param fieldDataCategoryDO
	 */
	public Integer removeCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;

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
	 * @param fieldDataCategoryDO
	 * @return List
	 */
	public List<FieldDataCategoryDO> listCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<FieldDataCategoryDO> listByInIds(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<FieldDataCategoryDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public FieldDataCategoryDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public FieldDataCategoryDO getOneCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;

	/**
	 * 统计记录数
	 * @param fieldDataCategoryDO
	 */
	public Long count(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param fieldDataCategoryDO
	 * @return list
	 */
	public List<FieldDataCategoryDO> listPaginated(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param fieldDataCategoryDO
	 * @return list
	 */
	public List<FieldDataCategoryDO> listPaginatedManual(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param fieldDataCategoryDO
	 */
	public Long countPaginatedManual(FieldDataCategoryDO fieldDataCategoryDO) throws Exception;
}
