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
	<sql id="${entityName?uncap_first}_select_fields">
		<#list table.columns as column>
		<#if column_has_next>
		${entityName?uncap_first}.${column.code} ${entityName?uncap_first}_${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
		${entityName?uncap_first}.${column.code} ${entityName?uncap_first}_${column.code?uncap_first}
		</#if>
		</#list>
	</sql>
</#list>
</mapper>