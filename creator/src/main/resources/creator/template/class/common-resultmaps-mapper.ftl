<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.bs.plugins.custom.${daoImportPackage}">
<#list tables as table>
	<#assign idx="${table.code?index_of('_')}"/>
	<#assign len="${table.code?length}"/>
	<#assign prefix="${table.code?substring(0,idx?number)?lower_case}"/>
	<#assign entityNameLower="${table.code?substring(idx?number+1,len?number)?lower_case}"/>
	<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
	<parameterMap id="${entityName?uncap_first}" type="${entityName?uncap_first}" />
	<resultMap id="${entityName?uncap_first}" type="${entityName?uncap_first}">
	<#assign idIsExist="false"/>
	<#list table.columns as column>
	<#assign property="result"/>
	<#if column.code?lower_case=='id' >
		<#assign property="id"/>
		<#assign idIsExist="true"/>
	</#if>
	<#if column.dataType?contains('bigint')>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Long" />
	<#elseif column.dataType?contains('smallint')>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#elseif column.dataType?contains('double')>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Double" />
	<#elseif column.dataType?contains('decimal')>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.math.BigDecimal" />
	<#elseif column.dataType?contains('int')>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#else>
		<${property} property="${column.code?uncap_first}" column="${entityName?uncap_first}_${column.code?uncap_first}" javaType="java.lang.String" />
	</#if>
	</#list>
	<#assign isChildReference="false"/>
	<#assign isParentReference="false"/>
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#assign isChildReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<association property="${pcode?substring(idx?number+1,len?number)?uncap_first}" resultMap="${pcode?substring(idx?number+1,len?number)?uncap_first}Result"/>
	</#list>
	</#if>
	</#list>
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#assign isParentReference="true"/>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<collection property="${pcode?substring(idx?number+1,len?number)?uncap_first}" ofType="${pcode?substring(idx?number+1,len?number)?uncap_first}"/>
	</#list>
	</#if>
	</#list>
	</resultMap>
	</#list>
</mapper>