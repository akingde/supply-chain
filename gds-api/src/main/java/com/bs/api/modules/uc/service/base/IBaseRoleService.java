package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.RoleDTO;

public interface IBaseRoleService<T> extends IService<RoleDTO>{

	/**
	 * 保存
	 * @param roleDTO
	 * @return
	 */
	public ResultData<RoleDTO> save(RoleDTO roleDTO);

	/**
	 * 根据id修改
	 * @param roleDTO
	 * @return
	 */
	public ResultData<RoleDTO> updateById(RoleDTO roleDTO);
	
	/**
	 * 动态条件删除
	 * @param roleDTO
	 * @return
	 */
	public ResultData<RoleDTO> removeCriteria(RoleDTO roleDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param roleDTO
	 * @return
	 */
	public ResultData<RoleDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param roleDTO
	 * @return list
	 */
	public ResultData<List<RoleDTO>> listCriteria(RoleDTO roleDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<RoleDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(RoleDTO roleDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<RoleDTO>> listByInIds(RoleDTO roleDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<RoleDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param roleDTO
	 * @return
	 */
	public ResultData<RoleDTO> getOneCriteria(RoleDTO roleDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param roleDTO
	 * @return
	 */
	public ResultData<List<RoleDTO>> paginated(RoleDTO roleDTO);

}
