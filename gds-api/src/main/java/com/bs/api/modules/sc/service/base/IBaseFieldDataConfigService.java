package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.FieldDataConfigDTO;

public interface IBaseFieldDataConfigService<T> extends IService<FieldDataConfigDTO>{

	/**
	 * 保存
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> save(FieldDataConfigDTO fieldDataConfigDTO);

	/**
	 * 根据id修改
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> updateById(FieldDataConfigDTO fieldDataConfigDTO);
	
	/**
	 * 动态条件删除
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> removeCriteria(FieldDataConfigDTO fieldDataConfigDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param fieldDataConfigDTO
	 * @return list
	 */
	public ResultData<List<FieldDataConfigDTO>> listCriteria(FieldDataConfigDTO fieldDataConfigDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<FieldDataConfigDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(FieldDataConfigDTO fieldDataConfigDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<FieldDataConfigDTO>> listByInIds(FieldDataConfigDTO fieldDataConfigDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<FieldDataConfigDTO> getOneCriteria(FieldDataConfigDTO fieldDataConfigDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param fieldDataConfigDTO
	 * @return
	 */
	public ResultData<List<FieldDataConfigDTO>> paginated(FieldDataConfigDTO fieldDataConfigDTO);

}
