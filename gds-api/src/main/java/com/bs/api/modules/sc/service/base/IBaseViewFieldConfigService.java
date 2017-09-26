package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.ViewFieldConfigDTO;

public interface IBaseViewFieldConfigService<T> extends IService<ViewFieldConfigDTO>{

	/**
	 * 保存
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> save(ViewFieldConfigDTO viewFieldConfigDTO);

	/**
	 * 根据id修改
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> updateById(ViewFieldConfigDTO viewFieldConfigDTO);
	
	/**
	 * 动态条件删除
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> removeCriteria(ViewFieldConfigDTO viewFieldConfigDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param viewFieldConfigDTO
	 * @return list
	 */
	public ResultData<List<ViewFieldConfigDTO>> listCriteria(ViewFieldConfigDTO viewFieldConfigDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<ViewFieldConfigDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(ViewFieldConfigDTO viewFieldConfigDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<ViewFieldConfigDTO>> listByInIds(ViewFieldConfigDTO viewFieldConfigDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<ViewFieldConfigDTO> getOneCriteria(ViewFieldConfigDTO viewFieldConfigDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param viewFieldConfigDTO
	 * @return
	 */
	public ResultData<List<ViewFieldConfigDTO>> paginated(ViewFieldConfigDTO viewFieldConfigDTO);

}
