package com.bs.service.modules.mc.shortmessageprovider.base;

import java.util.List;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;

public interface BaseShortMessageProviderDao{
	/**
	 * 保存数据
	 * @param shortMessageProviderDO
	 */
	public Integer save(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param shortMessageProviderDO
	 */
	public Integer updateById(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param shortMessageProviderDO
	 */
	public Integer updateCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param shortMessageProviderDO
	 */
	public Integer removeCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception;

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
	 * @param shortMessageProviderDO
	 * @return List
	 */
	public List<ShortMessageProviderDO> listCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<ShortMessageProviderDO> listByInIds(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<ShortMessageProviderDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ShortMessageProviderDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param shortMessageProviderDO
	 * @return
	 */
	public ShortMessageProviderDO getOneCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception;

	/**
	 * 统计记录数
	 * @param shortMessageProviderDO
	 */
	public Long count(ShortMessageProviderDO shortMessageProviderDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param shortMessageProviderDO
	 * @return list
	 */
	public List<ShortMessageProviderDO> listPaginated(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param shortMessageProviderDO
	 * @return list
	 */
	public List<ShortMessageProviderDO> listPaginatedManual(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param shortMessageProviderDO
	 */
	public Long countPaginatedManual(ShortMessageProviderDO shortMessageProviderDO) throws Exception;
}
