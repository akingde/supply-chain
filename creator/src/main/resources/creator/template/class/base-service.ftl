package com.bs.service.modules.${module}.${entityPath}.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.${module}.${entityPath}.${entity}DO;
import com.bs.service.modules.${module}.${entityPath}.I${entity}Dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class Base${entity}Service<T extends ${entity}DO> extends BaseService implements InitializingBean{
<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>

	@Autowired
	protected RedisService<${entity}DO> redisService;
	
	@Autowired
	protected I${entity}Dao ${entity?uncap_first}Dao;

	/**
	 * 保存
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public Integer save(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.save(${entity?uncap_first}DO);
	}

	<#if idIsExist == 'true'>
	/**
	 * 根据id修改
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public Integer updateById(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.updateById(${entity?uncap_first}DO);
	}
	</#if>
	
	/**
	 * 动态条件修改数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public Integer updateCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.updateCriteria(${entity?uncap_first}DO);
	}
	
	/**
	 * 动态条件删除
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public Integer removeCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.removeCriteria(${entity?uncap_first}DO);
	}
	
	<#if idIsExist == 'true'>
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return ${entity?uncap_first}Dao.removeById(id);
	}
	</#if>

	/**
	 * 删除所有数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public void removeAll() throws Exception {
		${entity?uncap_first}Dao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public List<${entity}DO> listCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.listCriteria(${entity?uncap_first}DO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public List<Long> listIdsCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.listIdsCriteria(${entity?uncap_first}DO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public List<${entity}DO> listByInIds(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.listByInIds(${entity?uncap_first}DO);
	}

	/**
	 * 查询所有数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public List<${entity}DO> listAll() throws Exception {
		return ${entity?uncap_first}Dao.listAll();
	}
	
	<#if idIsExist == 'true'>
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ${entity}DO getOneById(Long id) throws Exception {
		return ${entity?uncap_first}Dao.getOneById(id);
	}
	</#if>

	/**
	 * 动态条件，获取单条数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public ${entity}DO getOneCriteria(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.getOneCriteria(${entity?uncap_first}DO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public Long count(${entity}DO ${entity?uncap_first}DO) throws Exception {
		return ${entity?uncap_first}Dao.count(${entity?uncap_first}DO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  ${entity?uncap_first}DO
	 * @return
	 */
	public PageInfo<${entity}DO> listPaginated(${entity}DO ${entity?uncap_first}DO) throws Exception {
		int page = ${entity?uncap_first}DO.getPage() == 0?1 : ${entity?uncap_first}DO.getPage();
		int rows = ${entity?uncap_first}DO.getRows() == 0?10 : ${entity?uncap_first}DO.getRows();
		PageHelper.startPage(page, rows);
		List<${entity}DO> list = ${entity?uncap_first}Dao.listPaginated( ${entity?uncap_first}DO);
		PageInfo<${entity}DO> pageInfo = new PageInfo<${entity}DO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param ${entity?uncap_first}DO
	 * @return
	 */
	public PageInfo<${entity}DO> listPaginatedManual(${entity}DO  ${entity?uncap_first}DO) throws Exception {
		List<${entity}DO> list = ${entity?uncap_first}Dao.listPaginatedManual( ${entity?uncap_first}DO);
		Long countRecords = ${entity?uncap_first}Dao.countPaginatedManual( ${entity?uncap_first}DO);
		int page = ${entity?uncap_first}DO.getPage() == 0?1: ${entity?uncap_first}DO.getPage();
		int rows = ${entity?uncap_first}DO.getRows() == 0?10: ${entity?uncap_first}DO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<${entity}DO> pageInfo = new PageInfo<${entity}DO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
