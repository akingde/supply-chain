<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.bs.plugins.custom.${daoImportPackage}">
<#list tables as table>
	<#assign idx="${table.code?index_of('_')}"/>
	<#assign len="${table.code?length}"/>
	<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
	<!-- **************************${entityName?uncap_first} begin************************************* -->
	<sql id="${entityName?uncap_first}_select">
		select
	</sql>
	<sql id="${entityName?uncap_first}_select_count">
		select count(*)
	</sql>
	<sql id="${entityName?uncap_first}_select_distinct">
		select distinct
	</sql>
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
	<sql id="${entityName?uncap_first}_form">
		from ${table.code} ${entityName?uncap_first}
	</sql>
	<sql id="${entityName?uncap_first}_inner_all">
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
		<#assign ctCode="${reference.childTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#assign childTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
		<#list reference.joins as join>
		left join ${ctCode} ${childTableCode} on ${childTableCode}.${join.childTableColumn.code}=${entityName?uncap_first}.${join.parentTableColumn.code}
		</#list>
	</#if>
	</#list>
	</sql>
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
		<#assign ctCode="${reference.childTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#assign childTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
	<sql id="${entityName?uncap_first}_inner_${childTableCode}">
		<#list reference.joins as join>
		left join ${ctCode} ${childTableCode} on ${childTableCode}.${join.childTableColumn.code}=${entityName?uncap_first}.${join.parentTableColumn.code}
		</#list>
	</sql>
		</#if>
	</#list>
	<sql id="${entityName?uncap_first}_left_all">
	<#list references as reference>
	<#if table.code == reference.childTable.code>
		<#assign ctCode="${reference.parentTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#assign parentTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
		<#list reference.joins as join>
		left join ${ctCode} ${parentTableCode} on ${entityName?uncap_first}.${join.childTableColumn.code}=${parentTableCode}.${join.parentTableColumn.code}
		</#list>
	</#if>
	</#list>
	</sql>
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#assign ctCode="${reference.parentTable.code}"/>
	<#assign ctIndex="${ctCode?index_of('_')}"/>
	<#assign ctLength="${ctCode?length}"/>
	<#assign parentTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
	<sql id="${entityName?uncap_first}_left_${parentTableCode}">
	<#list reference.joins as join>
		inner join ${ctCode} ${parentTableCode} on ${entityName?uncap_first}.${join.childTableColumn.code}=${parentTableCode}.${join.parentTableColumn.code}
	</#list>
	</sql>
	</#if>
	</#list>
	<sql id="${entityName?uncap_first}_where">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${entityName?uncap_first}.${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</where>
	</sql>
	<sql id="${entityName?uncap_first}_where_id">
		<#list table.columns as column >
		<#if column.dataType?contains('bigint')>
		<#if column.code == 'Id'>
		where ${entityName?uncap_first}.id=<#noparse>${id}</#noparse>
		</#if>
		</#if>
		</#list>
	</sql>
	<sql id="${entityName?uncap_first}_where_reference_id">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
			<#if column.dataType?contains('bigint')>
			<#if column.code != 'Id'>
			<#if column.code?contains('Id')>
				<if test="${column.code?uncap_first} != null">and ${entityName?uncap_first}.${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#if>
			</#if>
			</#list>
			</trim>
		</where>
	</sql>
	<sql id="${entityName?uncap_first}_order">
		<if test="orderDesc != null and orderAsc != null">
			order by
			<trim prefixOverrides=",">
				<foreach collection="orderDesc" index="index" item="item"> 
            		${entityName?uncap_first}.<#noparse>${item}</#noparse> desc,
        		</foreach>
				<foreach collection="orderAsc" index="index" item="item"> 
            		${entityName?uncap_first}.<#noparse>${item}</#noparse> asc,
        		</foreach>
			</trim>
		</if>  
	</sql>
	<sql id="${entityName?uncap_first}_group">
		<if test="group != null">
			group by
			<trim prefixOverrides=",">
				<foreach collection="group" index="index" item="item"> 
            	${entityName?uncap_first}.<#noparse>${item}</#noparse>,
        		</foreach>
			</trim>
		</if>
	</sql>
	<sql id="${entityName?uncap_first}_limit">
		limit <#noparse>${start}</#noparse>,<#noparse>${offset}</#noparse>
	</sql>
	<sql id="${entityName?uncap_first}_update">
		update ${table.code}
	</sql>
	<sql id="${entityName?uncap_first}_update_set">
		<set>
			<trim prefixOverrides=",">
			<#list table.columns as column >
			<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">,${column.code}=<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			<#elseif column.dataType?contains('datetime')>
				<#if column.code == 'ModifyTime' || column.code == 'ModifyDate'>
                ,${column.code}=now()
				<#else>
               	<if test="${column.code?uncap_first} != null  and ${column.code?uncap_first} != ''">,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
				</#if>
			<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}=<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
			</#list>
			</trim>
		</set>
	</sql>
	<sql id="${entityName?uncap_first}_update_set_null">
		<set>
			<trim prefixOverrides=",">
			<#list table.columns as column >
				<#if column.code != 'Id'>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}=NULL</if>
				</#if>	
			</#list>
			</trim>
		</set>
	</sql>
	<sql id="${entityName?uncap_first}_insert">
		insert into ${table.code}
			<trim prefix="(" prefixOverrides="," suffix=")">
	<#list table.columns as column >
		<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">,${column.code}</if>
		<#elseif column.dataType?contains('datetime')>
		<#if column.code == 'CreateTime' || column.code == 'CreateDate'>
            	,${column.code}
		<#else>
        		<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}</if>
		</#if>
		<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.code}</if>
		</#if>
		</#list>		
			</trim>
		values
			<trim prefix="(" prefixOverrides="," suffix=")">
		<#list table.columns as column >
		<#if column.dataType?contains('bigint')>
				<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('smallint')>
				<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('double')>
				<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('decimal')>
				<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('int')>
				<if test="${column.code?uncap_first} != null">,<#noparse>${</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		<#elseif column.dataType?contains('datetime')>
			<#if column.code == 'CreateTime' || column.code == 'CreateDate'>
            	,now()
			<#else>
            	<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
			</#if>
		<#else>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,<#noparse>#{</#noparse>${column.code?uncap_first}<#noparse>}</#noparse></if>
		</#if>
		</#list>			
			</trim>
	</sql>
	<sql id="${entityName?uncap_first}_delete">
		delete from ${table.code}
	</sql>
	<!-- *****************************${entityName?uncap_first} end********************************** -->

</#list>
</mapper>