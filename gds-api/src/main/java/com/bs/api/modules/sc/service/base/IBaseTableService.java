package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.TableDTO;

public interface IBaseTableService<T> extends IService<TableDTO>{

	/**
	 * 保存
	 * @param tableDTO
	 * @return
	 */
	public ResultData<TableDTO> save(TableDTO tableDTO);

	/**
	 * 根据id修改
	 * @param tableDTO
	 * @return
	 */
	public ResultData<TableDTO> updateById(TableDTO tableDTO);
	
	/**
	 * 动态条件删除
	 * @param tableDTO
	 * @return
	 */
	public ResultData<TableDTO> removeCriteria(TableDTO tableDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param tableDTO
	 * @return
	 */
	public ResultData<TableDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param tableDTO
	 * @return list
	 */
	public ResultData<List<TableDTO>> listCriteria(TableDTO tableDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<TableDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(TableDTO tableDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<TableDTO>> listByInIds(TableDTO tableDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<TableDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param tableDTO
	 * @return
	 */
	public ResultData<TableDTO> getOneCriteria(TableDTO tableDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param tableDTO
	 * @return
	 */
	public ResultData<List<TableDTO>> paginated(TableDTO tableDTO);

}
