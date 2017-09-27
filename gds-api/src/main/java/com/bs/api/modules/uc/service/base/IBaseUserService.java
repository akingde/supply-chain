package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.UserDTO;

public interface IBaseUserService<T> extends IService<UserDTO>{

	/**
	 * 保存
	 * @param userDTO
	 * @return
	 */
	public ResultData<UserDTO> save(UserDTO userDTO);

	/**
	 * 根据id修改
	 * @param userDTO
	 * @return
	 */
	public ResultData<UserDTO> updateById(UserDTO userDTO);
	
	/**
	 * 动态条件删除
	 * @param userDTO
	 * @return
	 */
	public ResultData<UserDTO> removeCriteria(UserDTO userDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param userDTO
	 * @return
	 */
	public ResultData<UserDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param userDTO
	 * @return list
	 */
	public ResultData<List<UserDTO>> listCriteria(UserDTO userDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<UserDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(UserDTO userDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<UserDTO>> listByInIds(UserDTO userDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<UserDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param userDTO
	 * @return
	 */
	public ResultData<UserDTO> getOneCriteria(UserDTO userDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param userDTO
	 * @return
	 */
	public ResultData<List<UserDTO>> paginated(UserDTO userDTO);

}
