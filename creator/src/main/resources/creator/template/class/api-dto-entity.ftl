package com.bs.api.modules.${module}.dto;

import java.io.Serializable;

public class ${entity}DTO implements Serializable {

	private static final long serialVersionUID = 1L;
	<#list columns as cols>
	<#assign dataType="String" />
	<#if cols.dataType?contains('bigint')>
	<#assign dataType="Long" />
	<#elseif cols.dataType?contains('integer')>
	<#assign dataType="Long" />
	<#elseif cols.dataType?contains('tinyint')>
	<#assign dataType="Integer" />
	<#elseif cols.dataType?contains('smallint')>
	<#assign dataType="Integer" />
	<#elseif cols.dataType?contains('double')>
	<#assign dataType="Double" />
	<#elseif cols.dataType?contains('decimal')>
	<#assign dataType="BigDecimal" />
	<#elseif cols.dataType?contains('int')>
	<#assign dataType="Integer" />
	<#else>
	<#assign dataType="String" />
	</#if>
	
	/**${cols.name}-<@compress single_line=true>${cols.comment}</@compress>**/
	private ${dataType} ${cols.code?uncap_first};
	</#list>
	
	public ${entity}DTO() {
	
	}
	
<#list columns as cols>
<#assign dataType="String" />
<#if cols.dataType?contains('bigint')>
<#assign dataType="Long" />
<#elseif cols.dataType?contains('integer')>
<#assign dataType="Long" />
<#elseif cols.dataType?contains('tinyint')>
<#assign dataType="Integer" />
<#elseif cols.dataType?contains('smallint')>
<#assign dataType="Integer" />
<#elseif cols.dataType?contains('double')>
<#assign dataType="Double" />
<#elseif cols.dataType?contains('decimal')>
<#assign dataType="BigDecimal" />
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
}
