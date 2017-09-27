package com.bs.api.modules.mc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.mc.dto.ShortMessageSendDTO;

public interface IBaseShortMessageSendService<T> extends IService<ShortMessageSendDTO>{

	/**
	 * 保存
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> save(ShortMessageSendDTO shortMessageSendDTO);

	/**
	 * 根据id修改
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> updateById(ShortMessageSendDTO shortMessageSendDTO);
	
	/**
	 * 动态条件删除
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> removeCriteria(ShortMessageSendDTO shortMessageSendDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param shortMessageSendDTO
	 * @return list
	 */
	public ResultData<List<ShortMessageSendDTO>> listCriteria(ShortMessageSendDTO shortMessageSendDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageSendDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(ShortMessageSendDTO shortMessageSendDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageSendDTO>> listByInIds(ShortMessageSendDTO shortMessageSendDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<ShortMessageSendDTO> getOneCriteria(ShortMessageSendDTO shortMessageSendDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param shortMessageSendDTO
	 * @return
	 */
	public ResultData<List<ShortMessageSendDTO>> paginated(ShortMessageSendDTO shortMessageSendDTO);

}
