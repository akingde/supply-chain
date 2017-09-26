<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dubbo="http://code.alibabatech.com/schema/dubbo" xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://code.alibabatech.com/schema/dubbo
        http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
	<dubbo:application name="<#noparse>${dubbo.application.name}</#noparse>" />
	<dubbo:registry protocol="<#noparse>${dubbo.registry.protocol}</#noparse>" address="<#noparse>${dubbo.registry.address}</#noparse>" />
	<#list tables as table>
		<#assign idx="${table.code?index_of('_')}"/>
		<#assign len="${table.code?length}"/>
		<#assign module="${table.code?substring(0,idx?number)?lower_case}"/>
		<#assign entityNameLower="${table.code?substring(idx?number+1,len?number)?lower_case}"/>
		<#assign entityName="${table.code?substring(idx?number+1,len?number)}"/>
	<dubbo:reference id="${entityName?uncap_first}Api" interface="com.bs.api.modules.${module}.service.I${entityName}Service" timeout="<#noparse>${dubbo.timeout}</#noparse>" retries="<#noparse>${dubbo.retries}</#noparse>" />
	</#list>
</beans>