package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.TableReferenceDTO;

public interface IBaseTableReferenceService<T> extends IService<TableReferenceDTO>{

	/**
	 * 保存
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<TableReferenceDTO> save(TableReferenceDTO tableReferenceDTO);

	/**
	 * 根据id修改
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<TableReferenceDTO> updateById(TableReferenceDTO tableReferenceDTO);
	
	/**
	 * 动态条件删除
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<TableReferenceDTO> removeCriteria(TableReferenceDTO tableReferenceDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<TableReferenceDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param tableReferenceDTO
	 * @return list
	 */
	public ResultData<List<TableReferenceDTO>> listCriteria(TableReferenceDTO tableReferenceDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<TableReferenceDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(TableReferenceDTO tableReferenceDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<TableReferenceDTO>> listByInIds(TableReferenceDTO tableReferenceDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<TableReferenceDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<TableReferenceDTO> getOneCriteria(TableReferenceDTO tableReferenceDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param tableReferenceDTO
	 * @return
	 */
	public ResultData<List<TableReferenceDTO>> paginated(TableReferenceDTO tableReferenceDTO);

}
