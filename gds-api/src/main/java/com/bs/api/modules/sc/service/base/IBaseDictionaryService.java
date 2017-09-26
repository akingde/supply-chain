package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.DictionaryDTO;

public interface IBaseDictionaryService<T> extends IService<DictionaryDTO>{

	/**
	 * 保存
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<DictionaryDTO> save(DictionaryDTO dictionaryDTO);

	/**
	 * 根据id修改
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<DictionaryDTO> updateById(DictionaryDTO dictionaryDTO);
	
	/**
	 * 动态条件删除
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<DictionaryDTO> removeCriteria(DictionaryDTO dictionaryDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<DictionaryDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<DictionaryDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param dictionaryDTO
	 * @return list
	 */
	public ResultData<List<DictionaryDTO>> listCriteria(DictionaryDTO dictionaryDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<DictionaryDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(DictionaryDTO dictionaryDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<DictionaryDTO>> listByInIds(DictionaryDTO dictionaryDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<DictionaryDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<DictionaryDTO> getOneCriteria(DictionaryDTO dictionaryDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param dictionaryDTO
	 * @return
	 */
	public ResultData<List<DictionaryDTO>> paginated(DictionaryDTO dictionaryDTO);

}
