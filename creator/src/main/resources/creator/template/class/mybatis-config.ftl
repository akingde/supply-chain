<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>  
	<settings>
		<setting name="cacheEnabled" value="true" />
		<setting name="lazyLoadingEnabled" value="true" />
		<setting name="multipleResultSetsEnabled" value="true" />
		<setting name="useColumnLabel" value="true" />
		<setting name="useGeneratedKeys" value="false" />
		<setting name="defaultExecutorType" value="SIMPLE" />
		<setting name="defaultStatementTimeout" value="25000" />
	</settings>
	<typeAliases>
		<typeAlias alias="paramMap" type="java.util.HashMap"/>
		<typeAlias alias="resultMap" type="java.util.HashMap"/>
<#list tables as table>
		<#assign idx="${table.code?index_of('_')}"/>
		<#assign len="${table.code?length}"/>
		<#assign module="${table.code?substring(0,idx?number)?lower_case}"/>
		<#assign entityNameLower="${table.code?substring(idx?number+1,len?number)?lower_case}"/>
		<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
		<typeAlias alias="${entityName?uncap_first}" type="com.bs.service.modules.${module}.${entityNameLower}.${entityName}DO"/>
</#list>
	</typeAliases>
	<mappers> 
		<#list tables as table>
		<#assign idx="${table.code?index_of('_')}"/>
		<#assign len="${table.code?length}"/>
		<#assign module="${table.code?substring(0,idx?number)?lower_case}"/>
		<#assign entityNameLower="${table.code?substring(idx?number+1,len?number)?lower_case}"/>
		<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
		<mapper resource="com/bs/service/modules/${module}/${entityNameLower}/base/base-${entityNameLower}-sql-mapper.xml" />
		<mapper resource="com/bs/service/modules/${module}/${entityNameLower}/custom-${entityNameLower}-sql-mapper.xml" />
		</#list>
    </mappers>
</configuration>  

