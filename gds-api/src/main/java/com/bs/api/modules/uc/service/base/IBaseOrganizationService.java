package com.bs.api.modules.uc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.uc.dto.OrganizationDTO;

public interface IBaseOrganizationService<T> extends IService<OrganizationDTO>{

	/**
	 * 保存
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<OrganizationDTO> save(OrganizationDTO organizationDTO);

	/**
	 * 根据id修改
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<OrganizationDTO> updateById(OrganizationDTO organizationDTO);
	
	/**
	 * 动态条件删除
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<OrganizationDTO> removeCriteria(OrganizationDTO organizationDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<OrganizationDTO> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<OrganizationDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param organizationDTO
	 * @return list
	 */
	public ResultData<List<OrganizationDTO>> listCriteria(OrganizationDTO organizationDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<OrganizationDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(OrganizationDTO organizationDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<OrganizationDTO>> listByInIds(OrganizationDTO organizationDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<OrganizationDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<OrganizationDTO> getOneCriteria(OrganizationDTO organizationDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param organizationDTO
	 * @return
	 */
	public ResultData<List<OrganizationDTO>> paginated(OrganizationDTO organizationDTO);

}
