package com.bs.service.modules.sc.dictionarycategory.base;

import java.util.List;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;

public interface BaseDictionaryCategoryDao{
	/**
	 * 保存数据
	 * @param dictionaryCategoryDO
	 */
	public Integer save(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param dictionaryCategoryDO
	 */
	public Integer updateById(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param dictionaryCategoryDO
	 */
	public Integer updateCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param dictionaryCategoryDO
	 */
	public Integer removeCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;

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
	 * @param dictionaryCategoryDO
	 * @return List
	 */
	public List<DictionaryCategoryDO> listCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<DictionaryCategoryDO> listByInIds(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<DictionaryCategoryDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public DictionaryCategoryDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public DictionaryCategoryDO getOneCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;

	/**
	 * 统计记录数
	 * @param dictionaryCategoryDO
	 */
	public Long count(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param dictionaryCategoryDO
	 * @return list
	 */
	public List<DictionaryCategoryDO> listPaginated(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param dictionaryCategoryDO
	 * @return list
	 */
	public List<DictionaryCategoryDO> listPaginatedManual(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param dictionaryCategoryDO
	 */
	public Long countPaginatedManual(DictionaryCategoryDO dictionaryCategoryDO) throws Exception;
}
