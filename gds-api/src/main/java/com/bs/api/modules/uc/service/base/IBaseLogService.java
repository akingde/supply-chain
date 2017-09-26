package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.LogDTO;

public interface IBaseLogService<T> extends IService<LogDTO>{

	/**
	 * 保存
	 * @param logDTO
	 * @return
	 */
	public ResultData<LogDTO> save(LogDTO logDTO);

	/**
	 * 根据id修改
	 * @param logDTO
	 * @return
	 */
	public ResultData<LogDTO> updateById(LogDTO logDTO);
	
	/**
	 * 动态条件删除
	 * @param logDTO
	 * @return
	 */
	public ResultData<LogDTO> removeCriteria(LogDTO logDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<LogDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param logDTO
	 * @return
	 */
	public ResultData<LogDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param logDTO
	 * @return list
	 */
	public ResultData<List<LogDTO>> listCriteria(LogDTO logDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<LogDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(LogDTO logDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<LogDTO>> listByInIds(LogDTO logDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<LogDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param logDTO
	 * @return
	 */
	public ResultData<LogDTO> getOneCriteria(LogDTO logDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param logDTO
	 * @return
	 */
	public ResultData<List<LogDTO>> paginated(LogDTO logDTO);

}
