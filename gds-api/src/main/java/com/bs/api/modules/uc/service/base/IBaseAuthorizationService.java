package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.AuthorizationDTO;

public interface IBaseAuthorizationService<T> extends IService<AuthorizationDTO>{

	/**
	 * 保存
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<AuthorizationDTO> save(AuthorizationDTO authorizationDTO);

	/**
	 * 根据id修改
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<AuthorizationDTO> updateById(AuthorizationDTO authorizationDTO);
	
	/**
	 * 动态条件删除
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<AuthorizationDTO> removeCriteria(AuthorizationDTO authorizationDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<AuthorizationDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<AuthorizationDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param authorizationDTO
	 * @return list
	 */
	public ResultData<List<AuthorizationDTO>> listCriteria(AuthorizationDTO authorizationDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<AuthorizationDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(AuthorizationDTO authorizationDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<AuthorizationDTO>> listByInIds(AuthorizationDTO authorizationDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<AuthorizationDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<AuthorizationDTO> getOneCriteria(AuthorizationDTO authorizationDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param authorizationDTO
	 * @return
	 */
	public ResultData<List<AuthorizationDTO>> paginated(AuthorizationDTO authorizationDTO);

}
