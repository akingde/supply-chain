package com.bs.service.modules.mc.shortmessagesend.base;

import java.util.List;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;

public interface BaseShortMessageSendDao{
	/**
	 * 保存数据
	 * @param shortMessageSendDO
	 */
	public Integer save(ShortMessageSendDO shortMessageSendDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param shortMessageSendDO
	 */
	public Integer updateById(ShortMessageSendDO shortMessageSendDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param shortMessageSendDO
	 */
	public Integer updateCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param shortMessageSendDO
	 */
	public Integer removeCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception;

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
	 * @param shortMessageSendDO
	 * @return List
	 */
	public List<ShortMessageSendDO> listCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<ShortMessageSendDO> listByInIds(ShortMessageSendDO shortMessageSendDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<ShortMessageSendDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ShortMessageSendDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param shortMessageSendDO
	 * @return
	 */
	public ShortMessageSendDO getOneCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception;

	/**
	 * 统计记录数
	 * @param shortMessageSendDO
	 */
	public Long count(ShortMessageSendDO shortMessageSendDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param shortMessageSendDO
	 * @return list
	 */
	public List<ShortMessageSendDO> listPaginated(ShortMessageSendDO shortMessageSendDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param shortMessageSendDO
	 * @return list
	 */
	public List<ShortMessageSendDO> listPaginatedManual(ShortMessageSendDO shortMessageSendDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param shortMessageSendDO
	 */
	public Long countPaginatedManual(ShortMessageSendDO shortMessageSendDO) throws Exception;
}
