package com.bs.api.modules.sc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.sc.dto.ViewConfigDTO;

public interface IBaseViewConfigService<T> extends IService<ViewConfigDTO>{

	/**
	 * 保存
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<ViewConfigDTO> save(ViewConfigDTO viewConfigDTO);

	/**
	 * 根据id修改
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<ViewConfigDTO> updateById(ViewConfigDTO viewConfigDTO);
	
	/**
	 * 动态条件删除
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<ViewConfigDTO> removeCriteria(ViewConfigDTO viewConfigDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<ViewConfigDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param viewConfigDTO
	 * @return list
	 */
	public ResultData<List<ViewConfigDTO>> listCriteria(ViewConfigDTO viewConfigDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<ViewConfigDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(ViewConfigDTO viewConfigDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<ViewConfigDTO>> listByInIds(ViewConfigDTO viewConfigDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<ViewConfigDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<ViewConfigDTO> getOneCriteria(ViewConfigDTO viewConfigDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param viewConfigDTO
	 * @return
	 */
	public ResultData<List<ViewConfigDTO>> paginated(ViewConfigDTO viewConfigDTO);

}
