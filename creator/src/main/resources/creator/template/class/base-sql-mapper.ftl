<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="com.bs.service.modules.${module}.${entityPath}.I${entity}Dao">

	<cache type="com.bs.service.core.mybatis.MybatisRedisCache">
        <property name="eviction" value="LRU" />
        <property name="flushInterval" value="6000000" />
        <property name="size" value="1024" />
        <property name="readOnly" value="false" />
    </cache>

<#list tables as table>
	<#assign idx="${table.code?index_of('_')}"/>
	<#assign len="${table.code?length}"/>
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
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Long" />
	<#elseif column.dataType?contains('float')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Float" />
	<#elseif column.dataType?contains('smallint')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#elseif column.dataType?contains('double')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Double" />
	<#elseif column.dataType?contains('decimal')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.math.BigDecimal" />
	<#elseif column.dataType?contains('integer')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Long" />
	<#elseif column.dataType?contains('tinyint')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#elseif column.dataType?contains('int')>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.Integer" />
	<#else>
		<${property} property="${column.code?uncap_first}" column="${column.code?uncap_first}" javaType="java.lang.String" />
	</#if>
	</#list>
	</resultMap>
	<resultMap id="${entityName?uncap_first}Ref" type="${entityName?uncap_first}" extends="${entityName?uncap_first}">
	<#list references as reference>
	<#if table.code == reference.childTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.parentTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<association property="${pcode?substring(idx?number+1,len?number)?uncap_first}" resultMap="${pcode?substring(idx?number+1,len?number)?uncap_first}"/>
	</#list>
	</#if>
	</#list>
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
	<#list reference.joins as join>
	<#assign pcode="${join.childTableColumn.table.code}"/>
	<#assign idx="${pcode?index_of('_')}"/>
	<#assign len="${pcode?length}"/>
		<collection property="${pcode?substring(idx?number+1,len?number)?uncap_first}s" resultMap="${pcode?substring(idx?number+1,len?number)?uncap_first}"/>
	</#list>
	</#if>
	</#list>
	</resultMap>	
	
	<sql id="${entityName?uncap_first}_select">
		select
	</sql>
	<sql id="${entityName?uncap_first}_select_count">
		select count(*)
	</sql>
	
	<sql id="${entityName?uncap_first}_select_id">
		select _${entityName?uncap_first}.id
	</sql>
	
	<sql id="${entityName?uncap_first}_select_distinct">
		select distinct
	</sql>
	
	<sql id="${entityName?uncap_first}_select_fields">
		<#list table.columns as column>
		<#if column_has_next>
		_${entityName?uncap_first}.${column.originalCode} ${column.code?uncap_first},
		</#if>
		<#if !column_has_next>
		_${entityName?uncap_first}.${column.originalCode} ${column.code?uncap_first}
		</#if>
		</#list>
	</sql>
	<sql id="${entityName?uncap_first}_form">
		from ${table.code} _${entityName?uncap_first}
	</sql>
	
	<sql id="${entityName?uncap_first}_page_form_where">
		from ${table.code} _${entityName?uncap_first},(
			select id from ${table.code}
			<where>
				<trim prefixOverrides="and">
				<#list table.columns as column >
					<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and _${entityName?uncap_first}.${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
				</#list>
				</trim>
			</where>
			<if test="dorder != null or aorder != null">
			order by
			<trim prefixOverrides=",">
				<if test="dorder != null">
				<foreach collection="dorder" index="index" item="item" separator=","> 
            		<#noparse>${item}</#noparse> desc
        		</foreach>
        		</if>  
        		<if test="aorder != null">
				<foreach collection="aorder" index="index" item="item" separator=","> 
            		<#noparse>${item}</#noparse> asc
        		</foreach>
        		</if>  
			</trim>
			</if>  
			limit <#noparse>${start}</#noparse>,<#noparse>${offset}</#noparse>
		) _${entityName?uncap_first}_page where _${entityName?uncap_first}.id=_${entityName?uncap_first}_page.id
	</sql>
	
	<sql id="${entityName?uncap_first}_inner_all">
	<#list references as reference>
	<#if table.code == reference.childTable.code>
		<#assign ctCode="${reference.parentTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#assign parentTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
		<#list reference.joins as join>
		inner join ${ctCode} _${parentTableCode} on _${parentTableCode}.${join.parentTableColumn.originalCode}=_${entityName?uncap_first}.${join.childTableColumn.originalCode}
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
	<sql id="${entityName?uncap_first}_inner_${parentTableCode}">
		<#list reference.joins as join>
		inner join ${ctCode} _${parentTableCode} on _${parentTableCode}.${join.parentTableColumn.originalCode}=_${entityName?uncap_first}.${join.childTableColumn.originalCode}
		</#list>
	</sql>
		</#if>
	</#list>
	<sql id="${entityName?uncap_first}_left_all">
	<#list references as reference>
	<#if table.code == reference.parentTable.code>
		<#assign ctCode="${reference.childTable.code}"/>
		<#assign ctIndex="${ctCode?index_of('_')}"/>
		<#assign ctLength="${ctCode?length}"/>
		<#assign childTableCode="${ctCode?substring(ctIndex?number+1,ctLength?number)?uncap_first}"/>
		<#list reference.joins as join>
		left join ${ctCode} _${childTableCode} on _${childTableCode}.${join.childTableColumn.originalCode}=_${entityName?uncap_first}.${join.parentTableColumn.originalCode}
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
	<sql id="${entityName?uncap_first}_left_${childTableCode}">
	<#list reference.joins as join>
		left join ${ctCode} _${childTableCode} on _${childTableCode}.${join.childTableColumn.originalCode}=_${entityName?uncap_first}.${join.parentTableColumn.originalCode}
	</#list>
	</sql>
	</#if>
	</#list>
	<sql id="${entityName?uncap_first}_where">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and _${entityName?uncap_first}.${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
			</#list>
			</trim>
		</where>
	</sql>
	
	<sql id="${entityName?uncap_first}_where_fields">
	<#list table.columns as column >
		<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and _${entityName?uncap_first}.${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
	</#list>
	</sql>
	<sql id="${entityName?uncap_first}_update_where">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
			</#list>
			</trim>
		</where>
	</sql>
	<sql id="${entityName?uncap_first}_update_where_fields">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">and ${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
			</#list>
			</trim>
		</where>
	</sql>
	<sql id="${entityName?uncap_first}_where_id">
		<#list table.columns as column >
		<#if column.dataType?contains('bigint')>
		<#if column.code?lower_case == 'id'>
		where _${entityName?uncap_first}.id=<#noparse>#{</#noparse>id,jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse>
		</#if>
		</#if>
		</#list>
	</sql>
	<sql id="${entityName?uncap_first}_update_where_id">
		<#list table.columns as column >
		<#if column.dataType?contains('bigint')>
		<#if column.code?lower_case == 'id'>
		where id=<#noparse>#{</#noparse>id,jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse>
		</#if>
		</#if>
		</#list>
	</sql>
	<sql id="${entityName?uncap_first}_where_reference_id">
		<where>
			<trim prefixOverrides="and">
			<#list table.columns as column >
			<#if column.dataType?contains('bigint')>
			<#if column.code?lower_case != 'id'>
			<#if column.code?lower_case?contains('id')>
				<if test="${column.code?uncap_first} != null">and _${entityName?uncap_first}.${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
			</#if>
			</#if>
			</#if>
			</#list>
			</trim>
		</where>
	</sql>
	<sql id="${entityName?uncap_first}_where_ids">
		<if test="ids != null">
			where _${entityName?uncap_first}.id in
			<trim prefixOverrides=",">
				<foreach collection="ids" index="index" item="item" open="(" separator="," close=")"> 
            	<#noparse>${item}</#noparse>
        		</foreach>
			</trim>
		</if>
	</sql>
	<sql id="${entityName?uncap_first}_order">
		<if test="dorder != null or aorder != null">
			order by
			<trim prefixOverrides=",">
				<if test="dorder != null">
				<foreach collection="dorder" index="index" item="item" separator=","> 
            		<#noparse>${item}</#noparse> desc
        		</foreach>
        		</if>  
        		<if test="aorder != null">
				<foreach collection="aorder" index="index" item="item" separator=","> 
            		<#noparse>${item}</#noparse> asc
        		</foreach>
        		</if>  
			</trim>
		</if>  
	</sql>
	<sql id="${entityName?uncap_first}_group">
		<if test="sgroup != null">
			group by
			<trim prefixOverrides=",">
				<foreach collection="sgroup" index="index" item="item" separator=","> 
            	<#noparse>${item}</#noparse>
        		</foreach>
			</trim>
		</if>
	</sql>
	<sql id="${entityName?uncap_first}_limit">
		limit <#noparse>${start}</#noparse>,<#noparse>${offset}</#noparse>
	</sql>
	<sql id="${entityName?uncap_first}_update">
		update ${table.code} _${entityName?uncap_first}
	</sql>
	<sql id="${entityName?uncap_first}_update_set">
		<set>
			<trim prefixOverrides=",">
			<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.originalCode}=<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
			</#list>
			</trim>
		</set>
	</sql>
	<sql id="${entityName?uncap_first}_update_set_null">
		<set>
			<trim prefixOverrides=",">
			<#list table.columns as column >
				<#if column.code != 'id'>
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.originalCode}=NULL</if>
				</#if>	
			</#list>
			</trim>
		</set>
	</sql>
	<sql id="${entityName?uncap_first}_insert">
		insert into ${table.code}
			<trim prefix="(" prefixOverrides="," suffix=")">
		<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,${column.originalCode}</if>
		</#list>		
			</trim>
		values
			<trim prefix="(" prefixOverrides="," suffix=")">
		<#list table.columns as column >
				<if test="${column.code?uncap_first} != null and ${column.code?uncap_first} != ''">,<#noparse>#{</#noparse>${column.code?uncap_first},jdbcType=${column.dataType?upper_case}<#noparse>}</#noparse></if>
		</#list>			
			</trim>
	</sql>
	<sql id="${entityName?uncap_first}_delete">
		delete from ${table.code}
	</sql>

</#list>

<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>	
<#assign idx="${table.code?index_of('_')}"/>
<#assign len="${table.code?length}"/>
<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
<#assign tableAliasCode="${entityName?uncap_first}"/>
	<insert id="save" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_insert"/>
		<selectKey keyProperty="generatedKey" resultType="Long">
			select LAST_INSERT_ID() as generatedKey   
		</selectKey>
	</insert>
	
	<#if idIsExist=='true' >
	<update id="updateById" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_update"/>
		<include refid="${tableAliasCode}_update_set"/>
		<include refid="${tableAliasCode}_update_where_id"/>
	</update>
	</#if>
	
	<update id="updateCriteria" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_update"/>
		<include refid="${tableAliasCode}_update_set"/>
		<include refid="${tableAliasCode}_update_where"/>
	</update>

	<delete id="removeCriteria" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_delete"/>
		<include refid="${tableAliasCode}_where"/>
	</delete>
	
	<#if idIsExist=='true' >
	<delete id="removeById" parameterType="java.lang.Long">
		<include refid="${tableAliasCode}_delete"/>
		<include refid="${tableAliasCode}_where_id"/>
	</delete>
	</#if>
	
	<delete id="removeAll" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_delete"/>
	</delete>

	<select id="listIdsCriteria" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_id"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
	</select>
	
	<select id="listByInIds" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where_ids"/>
	</select>
	
	<select id="listCriteria" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
		<include refid="${tableAliasCode}_order"/>
		<include refid="${tableAliasCode}_group"/>
	</select>
	
	<select id="listAll" resultMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
	</select>
	
	<#if idIsExist == 'true' >
	<select id="getOneById" resultMap="${tableAliasCode}" parameterType="java.lang.Long" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where_id"/>
	</select>		
	</#if>
	
	<select id="getOneCriteria" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
	</select>	

	<select id="listPaginated" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
		<include refid="${tableAliasCode}_order"/>
		<include refid="${tableAliasCode}_group"/>
	</select>
	
	<select id="count" resultType="long" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_select_count"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
	</select>
	
	<select id="listPaginatedManual" resultMap="${tableAliasCode}" parameterMap="${tableAliasCode}" useCache="true">
		<include refid="${tableAliasCode}_select"/>
		<include refid="${tableAliasCode}_select_fields"/>
		<include refid="${tableAliasCode}_page_form_where"/>
	</select>
	
	<select id="countPaginatedManual" resultType="long" parameterMap="${tableAliasCode}">
		<include refid="${tableAliasCode}_select_count"/>
		<include refid="${tableAliasCode}_form"/>
		<include refid="${tableAliasCode}_where"/>
	</select>

</mapper>