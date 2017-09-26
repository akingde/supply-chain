package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.DictionaryCategoryDTO;

public interface IBaseDictionaryCategoryService<T> extends IService<DictionaryCategoryDTO>{

	/**
	 * 保存
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> save(DictionaryCategoryDTO dictionaryCategoryDTO);

	/**
	 * 根据id修改
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> updateById(DictionaryCategoryDTO dictionaryCategoryDTO);
	
	/**
	 * 动态条件删除
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> removeCriteria(DictionaryCategoryDTO dictionaryCategoryDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param dictionaryCategoryDTO
	 * @return list
	 */
	public ResultData<List<DictionaryCategoryDTO>> listCriteria(DictionaryCategoryDTO dictionaryCategoryDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<DictionaryCategoryDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(DictionaryCategoryDTO dictionaryCategoryDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<DictionaryCategoryDTO>> listByInIds(DictionaryCategoryDTO dictionaryCategoryDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<DictionaryCategoryDTO> getOneCriteria(DictionaryCategoryDTO dictionaryCategoryDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param dictionaryCategoryDTO
	 * @return
	 */
	public ResultData<List<DictionaryCategoryDTO>> paginated(DictionaryCategoryDTO dictionaryCategoryDTO);

}
