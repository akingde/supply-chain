package com.bs.service.modules.sc.dictionary.base;

import java.util.List;
import com.bs.service.modules.sc.dictionary.DictionaryDO;

public interface BaseDictionaryDao{
	/**
	 * 保存数据
	 * @param dictionaryDO
	 */
	public Integer save(DictionaryDO dictionaryDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param dictionaryDO
	 */
	public Integer updateById(DictionaryDO dictionaryDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param dictionaryDO
	 */
	public Integer updateCriteria(DictionaryDO dictionaryDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param dictionaryDO
	 */
	public Integer removeCriteria(DictionaryDO dictionaryDO) throws Exception;

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
	 * @param dictionaryDO
	 * @return List
	 */
	public List<DictionaryDO> listCriteria(DictionaryDO dictionaryDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(DictionaryDO dictionaryDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<DictionaryDO> listByInIds(DictionaryDO dictionaryDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<DictionaryDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public DictionaryDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param dictionaryDO
	 * @return
	 */
	public DictionaryDO getOneCriteria(DictionaryDO dictionaryDO) throws Exception;

	/**
	 * 统计记录数
	 * @param dictionaryDO
	 */
	public Long count(DictionaryDO dictionaryDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param dictionaryDO
	 * @return list
	 */
	public List<DictionaryDO> listPaginated(DictionaryDO dictionaryDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param dictionaryDO
	 * @return list
	 */
	public List<DictionaryDO> listPaginatedManual(DictionaryDO dictionaryDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param dictionaryDO
	 */
	public Long countPaginatedManual(DictionaryDO dictionaryDO) throws Exception;
}
