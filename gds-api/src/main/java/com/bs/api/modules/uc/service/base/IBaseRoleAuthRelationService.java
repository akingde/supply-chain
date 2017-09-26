package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.RoleAuthRelationDTO;

public interface IBaseRoleAuthRelationService<T> extends IService<RoleAuthRelationDTO>{

	/**
	 * 保存
	 * @param roleAuthRelationDTO
	 * @return
	 */
	public ResultData<RoleAuthRelationDTO> save(RoleAuthRelationDTO roleAuthRelationDTO);

	
	/**
	 * 动态条件删除
	 * @param roleAuthRelationDTO
	 * @return
	 */
	public ResultData<RoleAuthRelationDTO> removeCriteria(RoleAuthRelationDTO roleAuthRelationDTO);
	

	/**
	 * 删除所有数据
	 * @param roleAuthRelationDTO
	 * @return
	 */
	public ResultData<RoleAuthRelationDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param roleAuthRelationDTO
	 * @return list
	 */
	public ResultData<List<RoleAuthRelationDTO>> listCriteria(RoleAuthRelationDTO roleAuthRelationDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<RoleAuthRelationDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(RoleAuthRelationDTO roleAuthRelationDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<RoleAuthRelationDTO>> listByInIds(RoleAuthRelationDTO roleAuthRelationDTO);
	

	/**
	 * 动态条件，获取单条数据
	 * @param roleAuthRelationDTO
	 * @return
	 */
	public ResultData<RoleAuthRelationDTO> getOneCriteria(RoleAuthRelationDTO roleAuthRelationDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param roleAuthRelationDTO
	 * @return
	 */
	public ResultData<List<RoleAuthRelationDTO>> paginated(RoleAuthRelationDTO roleAuthRelationDTO);

}
