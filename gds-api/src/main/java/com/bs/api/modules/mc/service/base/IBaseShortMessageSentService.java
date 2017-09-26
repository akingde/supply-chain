package com.bs.api.modules.mc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.mc.dto.ShortMessageSentDTO;

public interface IBaseShortMessageSentService<T> extends IService<ShortMessageSentDTO>{

	/**
	 * 保存
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> save(ShortMessageSentDTO shortMessageSentDTO);

	/**
	 * 根据id修改
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> updateById(ShortMessageSentDTO shortMessageSentDTO);
	
	/**
	 * 动态条件删除
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> removeCriteria(ShortMessageSentDTO shortMessageSentDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param shortMessageSentDTO
	 * @return list
	 */
	public ResultData<List<ShortMessageSentDTO>> listCriteria(ShortMessageSentDTO shortMessageSentDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageSentDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(ShortMessageSentDTO shortMessageSentDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageSentDTO>> listByInIds(ShortMessageSentDTO shortMessageSentDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<ShortMessageSentDTO> getOneCriteria(ShortMessageSentDTO shortMessageSentDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param shortMessageSentDTO
	 * @return
	 */
	public ResultData<List<ShortMessageSentDTO>> paginated(ShortMessageSentDTO shortMessageSentDTO);

}
