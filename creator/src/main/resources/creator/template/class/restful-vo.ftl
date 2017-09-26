package com.bs.rest.modules.${module}.vo;

import java.io.Serializable;
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

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;
</#if>
<#list columns as cols>
<#if cols.dataType?contains('decimal')>
import java.math.BigDecimal;
<#break>
</#if>
</#list>

public class ${entity}VO implements Serializable{

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
	<#if cols.code?lower_case == 'id' >
	/**${cols.name}-<@compress single_line=true>${cols.comment}</@compress>**/
	@NotNull(message = "{NotNull.${entity?uncap_first}.id}",groups = {Second.class,Fourth.class})
	private ${dataType} ${cols.code?uncap_first};
	</#if>
	<#if cols.code?lower_case != 'id' >
	/**${cols.name}-<@compress single_line=true>${cols.comment}</@compress>**/
	private ${dataType} ${cols.code?uncap_first};
	</#if>
	</#list>

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
