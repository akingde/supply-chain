<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dubbo="http://code.alibabatech.com/schema/dubbo" xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://code.alibabatech.com/schema/dubbo
		http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
	<dubbo:application name="<#noparse>${dubbo.application.name}</#noparse>"/>
	<dubbo:registry address="<#noparse>${dubbo.registry.address}</#noparse>"/>
	<dubbo:protocol name="<#noparse>${dubbo.protocol.name}</#noparse>" port="<#noparse>${dubbo.port}</#noparse>"/>
	<#list tables as table>
		<#assign idx="${table.code?index_of('_')}"/>
		<#assign len="${table.code?length}"/>
		<#assign module="${table.code?substring(0,idx?number)?lower_case}"/>
		<#assign entityNameLower="${table.code?substring(idx?number+1,len?number)?lower_case}"/>
		<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
	<dubbo:service interface="com.bs.api.modules.${module}.service.I${entityName}Service" ref="${entityName?uncap_first}Api"/>
	</#list>
</beans>