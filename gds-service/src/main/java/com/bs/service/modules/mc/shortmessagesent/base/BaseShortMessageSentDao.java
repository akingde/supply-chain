package com.bs.service.modules.mc.shortmessagesent.base;

import java.util.List;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;

public interface BaseShortMessageSentDao{
	/**
	 * 保存数据
	 * @param shortMessageSentDO
	 */
	public Integer save(ShortMessageSentDO shortMessageSentDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param shortMessageSentDO
	 */
	public Integer updateById(ShortMessageSentDO shortMessageSentDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param shortMessageSentDO
	 */
	public Integer updateCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param shortMessageSentDO
	 */
	public Integer removeCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception;

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
	 * @param shortMessageSentDO
	 * @return List
	 */
	public List<ShortMessageSentDO> listCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<ShortMessageSentDO> listByInIds(ShortMessageSentDO shortMessageSentDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<ShortMessageSentDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ShortMessageSentDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param shortMessageSentDO
	 * @return
	 */
	public ShortMessageSentDO getOneCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception;

	/**
	 * 统计记录数
	 * @param shortMessageSentDO
	 */
	public Long count(ShortMessageSentDO shortMessageSentDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param shortMessageSentDO
	 * @return list
	 */
	public List<ShortMessageSentDO> listPaginated(ShortMessageSentDO shortMessageSentDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param shortMessageSentDO
	 * @return list
	 */
	public List<ShortMessageSentDO> listPaginatedManual(ShortMessageSentDO shortMessageSentDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param shortMessageSentDO
	 */
	public Long countPaginatedManual(ShortMessageSentDO shortMessageSentDO) throws Exception;
}
