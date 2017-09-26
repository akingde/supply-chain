package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.FieldDataCategoryDTO;

public interface IBaseFieldDataCategoryService<T> extends IService<FieldDataCategoryDTO>{

	/**
	 * 保存
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> save(FieldDataCategoryDTO fieldDataCategoryDTO);

	/**
	 * 根据id修改
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> updateById(FieldDataCategoryDTO fieldDataCategoryDTO);
	
	/**
	 * 动态条件删除
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> removeCriteria(FieldDataCategoryDTO fieldDataCategoryDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param fieldDataCategoryDTO
	 * @return list
	 */
	public ResultData<List<FieldDataCategoryDTO>> listCriteria(FieldDataCategoryDTO fieldDataCategoryDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<FieldDataCategoryDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(FieldDataCategoryDTO fieldDataCategoryDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<FieldDataCategoryDTO>> listByInIds(FieldDataCategoryDTO fieldDataCategoryDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<FieldDataCategoryDTO> getOneCriteria(FieldDataCategoryDTO fieldDataCategoryDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param fieldDataCategoryDTO
	 * @return
	 */
	public ResultData<List<FieldDataCategoryDTO>> paginated(FieldDataCategoryDTO fieldDataCategoryDTO);

}
