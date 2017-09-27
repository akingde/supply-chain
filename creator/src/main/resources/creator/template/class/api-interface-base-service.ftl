package com.bs.api.modules.${module}.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.${module}.dto.${entity}DTO;

public interface IBase${entity}Service<T> extends IService<${entity}DTO>{
<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>

	/**
	 * 保存
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<${entity}DTO> save(${entity}DTO ${entity?uncap_first}DTO);

	<#if idIsExist == 'true'>
	/**
	 * 根据id修改
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<${entity}DTO> updateById(${entity}DTO ${entity?uncap_first}DTO);
	</#if>
	
	/**
	 * 动态条件删除
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<${entity}DTO> removeCriteria(${entity}DTO ${entity?uncap_first}DTO);
	
	<#if idIsExist == 'true'>
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);
	</#if>

	/**
	 * 删除所有数据
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<${entity}DTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param ${entity?uncap_first}DTO
	 * @return list
	 */
	public ResultData<List<${entity}DTO>> listCriteria(${entity}DTO ${entity?uncap_first}DTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<${entity}DTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(${entity}DTO ${entity?uncap_first}DTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<${entity}DTO>> listByInIds(${entity}DTO ${entity?uncap_first}DTO);
	
	<#if idIsExist == 'true'>
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<${entity}DTO> getOneById(Long id);
	</#if>

	/**
	 * 动态条件，获取单条数据
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<${entity}DTO> getOneCriteria(${entity}DTO ${entity?uncap_first}DTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param ${entity?uncap_first}DTO
	 * @return
	 */
	public ResultData<List<${entity}DTO>> paginated(${entity}DTO ${entity?uncap_first}DTO);

}
