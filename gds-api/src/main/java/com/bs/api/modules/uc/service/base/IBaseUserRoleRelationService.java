package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.UserRoleRelationDTO;

public interface IBaseUserRoleRelationService<T> extends IService<UserRoleRelationDTO>{

	/**
	 * 保存
	 * @param userRoleRelationDTO
	 * @return
	 */
	public ResultData<UserRoleRelationDTO> save(UserRoleRelationDTO userRoleRelationDTO);

	
	/**
	 * 动态条件删除
	 * @param userRoleRelationDTO
	 * @return
	 */
	public ResultData<UserRoleRelationDTO> removeCriteria(UserRoleRelationDTO userRoleRelationDTO);
	

	/**
	 * 删除所有数据
	 * @param userRoleRelationDTO
	 * @return
	 */
	public ResultData<UserRoleRelationDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param userRoleRelationDTO
	 * @return list
	 */
	public ResultData<List<UserRoleRelationDTO>> listCriteria(UserRoleRelationDTO userRoleRelationDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<UserRoleRelationDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(UserRoleRelationDTO userRoleRelationDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<UserRoleRelationDTO>> listByInIds(UserRoleRelationDTO userRoleRelationDTO);
	

	/**
	 * 动态条件，获取单条数据
	 * @param userRoleRelationDTO
	 * @return
	 */
	public ResultData<UserRoleRelationDTO> getOneCriteria(UserRoleRelationDTO userRoleRelationDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param userRoleRelationDTO
	 * @return
	 */
	public ResultData<List<UserRoleRelationDTO>> paginated(UserRoleRelationDTO userRoleRelationDTO);

}
