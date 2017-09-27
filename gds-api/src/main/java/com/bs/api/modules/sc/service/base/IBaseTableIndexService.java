package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.TableIndexDTO;

public interface IBaseTableIndexService<T> extends IService<TableIndexDTO>{

	/**
	 * 保存
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<TableIndexDTO> save(TableIndexDTO tableIndexDTO);

	/**
	 * 根据id修改
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<TableIndexDTO> updateById(TableIndexDTO tableIndexDTO);
	
	/**
	 * 动态条件删除
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<TableIndexDTO> removeCriteria(TableIndexDTO tableIndexDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<TableIndexDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param tableIndexDTO
	 * @return list
	 */
	public ResultData<List<TableIndexDTO>> listCriteria(TableIndexDTO tableIndexDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<TableIndexDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(TableIndexDTO tableIndexDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<TableIndexDTO>> listByInIds(TableIndexDTO tableIndexDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<TableIndexDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<TableIndexDTO> getOneCriteria(TableIndexDTO tableIndexDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param tableIndexDTO
	 * @return
	 */
	public ResultData<List<TableIndexDTO>> paginated(TableIndexDTO tableIndexDTO);

}
