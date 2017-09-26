package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.AreaDTO;

public interface IBaseAreaService<T> extends IService<AreaDTO>{

	/**
	 * 保存
	 * @param areaDTO
	 * @return
	 */
	public ResultData<AreaDTO> save(AreaDTO areaDTO);

	/**
	 * 根据id修改
	 * @param areaDTO
	 * @return
	 */
	public ResultData<AreaDTO> updateById(AreaDTO areaDTO);
	
	/**
	 * 动态条件删除
	 * @param areaDTO
	 * @return
	 */
	public ResultData<AreaDTO> removeCriteria(AreaDTO areaDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<AreaDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param areaDTO
	 * @return
	 */
	public ResultData<AreaDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param areaDTO
	 * @return list
	 */
	public ResultData<List<AreaDTO>> listCriteria(AreaDTO areaDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<AreaDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(AreaDTO areaDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<AreaDTO>> listByInIds(AreaDTO areaDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<AreaDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param areaDTO
	 * @return
	 */
	public ResultData<AreaDTO> getOneCriteria(AreaDTO areaDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param areaDTO
	 * @return
	 */
	public ResultData<List<AreaDTO>> paginated(AreaDTO areaDTO);

}
