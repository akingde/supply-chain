package com.bs.service.modules.${modules}.${entityPath}.base;

import java.util.List;
import com.bs.service.modules.${modules}.${entityPath}.${entity}DO;

public interface Base${entity}Dao{
<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>
	/**
	 * 保存数据
	 * @param ${entity?uncap_first}DO
	 */
	public Integer save(${entity}DO ${entity?uncap_first}DO) throws Exception;
	
	<#if idIsExist == 'true'>
	/**
	 * 数据库修改
	 * @param ${entity?uncap_first}DO
	 */
	public Integer updateById(${entity}DO ${entity?uncap_first}DO) throws Exception;
	</#if>
	
	/**
	 * 动态条件修改
	 * @param ${entity?uncap_first}DO
	 */
	public Integer updateCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param ${entity?uncap_first}DO
	 */
	public Integer removeCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception;

	<#if idIsExist == 'true'>
	/**
	 * 根据主键ID删除数据
	 * @param id
	 */
	public Integer removeById(Long id) throws Exception;
	</#if>
	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param ${entity?uncap_first}DO
	 * @return List
	 */
	public List<${entity}DO> listCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<${entity}DO> listByInIds(${entity}DO ${entity?uncap_first}DO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<${entity}DO> listAll() throws Exception;

	<#if idIsExist == 'true'>
	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public ${entity}DO getOneById(Long id) throws Exception;
	</#if>
	
	/**
	 * 查询单条记录
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public ${entity}DO getOneCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception;

	/**
	 * 统计记录数
	 * @param ${entity?uncap_first}DO
	 */
	public Long count(${entity}DO ${entity?uncap_first}DO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param ${entity?uncap_first}DO
	 * @return list
	 */
	public List<${entity}DO> listPaginated(${entity}DO ${entity?uncap_first}DO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param ${entity?uncap_first}DO
	 * @return list
	 */
	public List<${entity}DO> listPaginatedManual(${entity}DO ${entity?uncap_first}DO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param ${entity?uncap_first}DO
	 */
	public Long countPaginatedManual(${entity}DO ${entity?uncap_first}DO) throws Exception;
}
