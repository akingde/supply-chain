package com.bs.api.modules.mc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.mc.dto.ShortMessageProviderDTO;

public interface IBaseShortMessageProviderService<T> extends IService<ShortMessageProviderDTO>{

	/**
	 * 保存
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> save(ShortMessageProviderDTO shortMessageProviderDTO);

	/**
	 * 根据id修改
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> updateById(ShortMessageProviderDTO shortMessageProviderDTO);
	
	/**
	 * 动态条件删除
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> removeCriteria(ShortMessageProviderDTO shortMessageProviderDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param shortMessageProviderDTO
	 * @return list
	 */
	public ResultData<List<ShortMessageProviderDTO>> listCriteria(ShortMessageProviderDTO shortMessageProviderDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageProviderDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(ShortMessageProviderDTO shortMessageProviderDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<ShortMessageProviderDTO>> listByInIds(ShortMessageProviderDTO shortMessageProviderDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<ShortMessageProviderDTO> getOneCriteria(ShortMessageProviderDTO shortMessageProviderDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param shortMessageProviderDTO
	 * @return
	 */
	public ResultData<List<ShortMessageProviderDTO>> paginated(ShortMessageProviderDTO shortMessageProviderDTO);

}
