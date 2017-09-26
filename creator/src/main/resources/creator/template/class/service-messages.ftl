
<#list columns as cols>
NotNull.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
NotEmpty.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
Pattern.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}格式不正确！

</#list>


#系统提示信息，统一在dubbo对外暴露的业务接口实现逻辑中实现
${entity?uncap_first}Api.save.10000002=[自定义提示信息！]
${entity?uncap_first}Api.save.10000003=[自定义提示信息！]
${entity?uncap_first}Api.save.10000004=[自定义提示信息！]
${entity?uncap_first}Api.save.10000005=[自定义提示信息！]

${entity?uncap_first}Api.updateById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000005=[自定义提示信息！]

${entity?uncap_first}Api.removeCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000005=[自定义提示信息！]

${entity?uncap_first}Api.removeById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000005=[自定义提示信息！]

${entity?uncap_first}Api.removeAll.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000005=[自定义提示信息！]

${entity?uncap_first}Api.listCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000005=[自定义提示信息！]

${entity?uncap_first}Api.listAll.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000005=[自定义提示信息！]

${entity?uncap_first}Api.getOneById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000005=[自定义提示信息！]

${entity?uncap_first}Api.getOneCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000005=[自定义提示信息！]

${entity?uncap_first}Api.count.10000002=[自定义提示信息！]
${entity?uncap_first}Api.count.10000003=[自定义提示信息！]
${entity?uncap_first}Api.count.10000004=[自定义提示信息！]
${entity?uncap_first}Api.count.10000005=[自定义提示信息！]

${entity?uncap_first}Api.listPaginated.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000005=[自定义提示信息！]

${entity?uncap_first}Api.listPaginatedManual.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000005=[自定义提示信息！]