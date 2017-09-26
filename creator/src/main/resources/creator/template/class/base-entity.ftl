package com.bs.plugins.custom.${entityPackage};

import com.bs.service.core.entity.Entity;
<#list columns as cols>
<#if cols.dataType?contains('decimal')>
import java.math.BigDecimal;
<#break>
</#if>
</#list>
<#global isAssociation="false"/>
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
<#global isAssociation="true"/>
import com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)};
</#list>
</#if>
</#list>
<#global isCollection="false"/>
<#list references as reference>
<#if table.code == reference.parentTable.code>
<#list reference.joins as join>
<#assign pcode="${join.childTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
<#global isCollection="true"/>
import com.bs.plugins.custom.${pcode?substring(0,idx?number)?lower_case}.${pcode?substring(idx?number + 1,len?number)?lower_case}.entity.${pcode?substring(idx?number+1,len?number)};	
</#list>
</#if>
</#list>
<#if isCollection == 'true'>
import java.util.List;
</#if>
import java.util.HashMap;
import java.util.Map;

public class Base${entity} extends Entity {

	private static final long serialVersionUID = 1L;
	public static final String TABLE_CODE = "${table.code}";
	public static Map<String,String> FIELDS = new HashMap<String,String>();
	static{
		<#list columns as cols>
		<#assign dataType="String" />
		<#if cols.dataType?contains('bigint')>
		<#assign dataType="Long" />
		<#elseif cols.dataType?contains('integer')>
		<#assign dataType="Long" />
		<#elseif cols.dataType?contains('smallint')>
		<#assign dataType="Integer" />
		<#elseif cols.dataType?contains('double')>
		<#assign dataType="Double" />
		<#elseif cols.dataType?contains('decimal')>
		<#assign dataType="BigDecimal" />
		<#elseif cols.dataType?contains('tinyint')>
		<#assign dataType="Integer" />
		<#elseif cols.dataType?contains('int')>
		<#assign dataType="Integer" />
		<#else>
		<#assign dataType="String" />
		</#if>
		FIELDS.put("${cols.code?uncap_first}","${cols.name}");
		</#list>
	}
	<#list columns as cols>
	<#assign dataType="String" />
	<#if cols.dataType?contains('bigint')>
	<#assign dataType="Long" />
	<#elseif cols.dataType?contains('integer')>
	<#assign dataType="Long" />
	<#elseif cols.dataType?contains('smallint')>
	<#assign dataType="Integer" />
	<#elseif cols.dataType?contains('double')>
	<#assign dataType="Double" />
	<#elseif cols.dataType?contains('decimal')>
	<#assign dataType="BigDecimal" />
	<#elseif cols.dataType?contains('tinyint')>
	<#assign dataType="Integer" />	
	<#elseif cols.dataType?contains('int')>
	<#assign dataType="Integer" />
	<#else>
	<#assign dataType="String" />
	</#if>
	/**${cols.name}-<@compress single_line=true>${cols.comment}</@compress>**/
	private ${dataType} ${cols.code?uncap_first};
	</#list>
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
	/**<@compress single_line=true>${join.parentTableColumn.table.comment}</@compress>**/
	private ${pcode?substring(idx?number+1,len?number)} ${pcode?substring(idx?number+1,len?number)?uncap_first};
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
	private List<${pcode?substring(idx?number+1,len?number)}> ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	</#list>
	</#if>
</#list>
	/**排序-降续**/
	private String dorder [];
	/**排序-生续**/
	private String aorder [];
	/**分组查询**/
	private String sgroup [];
	
	public Base${entity}() {
	}

<#list columns as cols>
<#assign dataType="String" />
<#if cols.dataType?contains('bigint')>
<#assign dataType="Long" />
<#elseif cols.dataType?contains('integer')>
<#assign dataType="Long" />
<#elseif cols.dataType?contains('smallint')>
<#assign dataType="Integer" />
<#elseif cols.dataType?contains('double')>
<#assign dataType="Double" />
<#elseif cols.dataType?contains('decimal')>
<#assign dataType="BigDecimal" />
<#elseif cols.dataType?contains('tinyint')>
<#assign dataType="Integer" />
<#elseif cols.dataType?contains('int')>
<#assign dataType="Integer" />
<#else>
<#assign dataType="String" />
</#if>
	public ${dataType} get${cols.code}() {
		return ${cols.code?uncap_first};
	}

	public void set${cols.code}(${dataType} ${cols.code?uncap_first}) {
		this.${cols.code?uncap_first} = ${cols.code?uncap_first};
	}
</#list>
	
<#list references as reference>
<#if table.code == reference.childTable.code>
<#list reference.joins as join>
<#assign pcode="${join.parentTableColumn.table.code}"/>
<#assign idx="${pcode?index_of('_')}"/>
<#assign len="${pcode?length}"/>
	public ${pcode?substring(idx?number+1,len?number)} get${pcode?substring(idx?number+1,len?number)} () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first};
	}

	public void set${pcode?substring(idx?number+1,len?number)}(${pcode?substring(idx?number+1,len?number)} ${pcode?substring(idx?number+1,len?number)?uncap_first}) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first} = ${pcode?substring(idx?number+1,len?number)?uncap_first};
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
	public List<${pcode?substring(idx?number+1,len?number)}> get${pcode?substring(idx?number+1,len?number)}s () {
		return ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	}

	public void set${pcode?substring(idx?number+1,len?number)}s(List<${pcode?substring(idx?number+1,len?number)}> ${pcode?substring(idx?number+1,len?number)?uncap_first}s) {
		this.${pcode?substring(idx?number+1,len?number)?uncap_first}s = ${pcode?substring(idx?number+1,len?number)?uncap_first}s;
	}
	</#list>
	</#if>
</#list>

	public String[] getDorder(){
		return dorder;
	}

	public void setDorder(String[] dorder){
		this.dorder = dorder;
	}

	public String[] getAorder(){
		return aorder;
	}

	public void setAorder(String[] aorder){
		this.aorder = aorder;
	}

	public String[] getSgroup(){
		return sgroup;
	}

	public void setSgroup(String[] sgroup){
		this.sgroup = sgroup;
	}	
}
