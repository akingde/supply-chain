package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.TableColumnDTO;

public interface IBaseTableColumnService<T> extends IService<TableColumnDTO>{

	/**
	 * 保存
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<TableColumnDTO> save(TableColumnDTO tableColumnDTO);

	/**
	 * 根据id修改
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<TableColumnDTO> updateById(TableColumnDTO tableColumnDTO);
	
	/**
	 * 动态条件删除
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<TableColumnDTO> removeCriteria(TableColumnDTO tableColumnDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<TableColumnDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param tableColumnDTO
	 * @return list
	 */
	public ResultData<List<TableColumnDTO>> listCriteria(TableColumnDTO tableColumnDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<TableColumnDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(TableColumnDTO tableColumnDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<TableColumnDTO>> listByInIds(TableColumnDTO tableColumnDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<TableColumnDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<TableColumnDTO> getOneCriteria(TableColumnDTO tableColumnDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param tableColumnDTO
	 * @return
	 */
	public ResultData<List<TableColumnDTO>> paginated(TableColumnDTO tableColumnDTO);

}
