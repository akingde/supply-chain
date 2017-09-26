package com.bs.service.modules.${module}.${entityPath};

<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>
<#if idIsExist == 'true'>
import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;
</#if>

import com.bs.service.modules.${module}.${entityPath}.base.Base${entity}PO;
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
<#assign refmodule="${pcode?substring(0,idx?number)?lower_case}"/>
<#assign refentity="${pcode?substring(idx?number+1,len?number)}"/>
import com.bs.service.modules.${refmodule}.${refentity?lower_case}.${refentity}DO;
</#list>
</#if>
</#list>
<#global isArrayList="false"/>
<#list references as reference>
<#if table.code == reference.parentTable.code>
<#list reference.joins as join>
<#assign pcode="${join.childTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
<#assign refmodule="${pcode?substring(0,idx?number)?lower_case}"/>
<#assign refentity="${pcode?substring(idx?number+1,len?number)}"/>
<#global isArrayList="true"/>
import com.bs.service.modules.${refmodule}.${refentity?lower_case}.${refentity}DO;	
</#list>
</#if>
</#list>
<#if isArrayList == 'true'>
import java.util.ArrayList;
</#if>

public class ${entity}DO extends Base${entity}PO {

	private static final long serialVersionUID = 1L;
	
	<#if idIsExist == 'true'>
	@NotNull(message = "{NotNull.${entity?uncap_first}.id}",groups = {Id.class}) 
	private Long id;
	</#if>
<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	
	/**<@compress single_line=true>${join.parentTableColumn.table.comment}</@compress>**/
	private ${pcode?substring(idx?number+1,len?number)}DO ${pcode?substring(idx?number+1,len?number)?uncap_first}DO;
	</#list>
	</#if>
</#list>

<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	
	/**<@compress single_line=true>${join.childTableColumn.table.comment}</@compress>**/
	private ArrayList<${pcode?substring(idx?number+1,len?number)}DO> ${pcode?substring(idx?number+1,len?number)?uncap_first}DOList;
	</#list>
	</#if>
</#list>

	public ${entity}DO() {
	}
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>

	public ${pcode?substring(idx?number+1,len?number)}DO get${pcode?substring(idx?number+1,len?number)}DO () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first}DO;
	}

	public void set${pcode?substring(idx?number+1,len?number)}DO(${pcode?substring(idx?number+1,len?number)}DO ${pcode?substring(idx?number+1,len?number)?uncap_first}DO) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first}DO = ${pcode?substring(idx?number+1,len?number)?uncap_first}DO;
	}
</#list>
</#if>
</#list>
<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
	
	public ArrayList<${pcode?substring(idx?number+1,len?number)}DO> get${pcode?substring(idx?number+1,len?number)}DOList () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first}DOList;
	}

	public void set${pcode?substring(idx?number+1,len?number)}DOList(ArrayList<${pcode?substring(idx?number+1,len?number)}DO> ${pcode?substring(idx?number+1,len?number)?uncap_first}DOList) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first}DOList = ${pcode?substring(idx?number+1,len?number)?uncap_first}DOList;
	}	
	</#list>
	</#if>
</#list>

	<#if idIsExist == 'true'>
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	</#if>
}
