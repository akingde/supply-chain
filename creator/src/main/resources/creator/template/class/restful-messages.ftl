
<#list columns as cols>
NotNull.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
NotEmpty.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
Pattern.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}格式不正确！

</#list>

#系统提示信息，统一在接口控制器中调用
${entity?uncap_first}Controller.save.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.save.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.save.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.save.10000005=[自定义提示信息！]
${entity?uncap_first}Controller.save.10000998=[自定义提示信息！]

${entity?uncap_first}Controller.update.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.update.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.update.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.update.10000005=[自定义提示信息！]
${entity?uncap_first}Controller.update.10000998=[自定义提示信息！]

${entity?uncap_first}Controller.remove.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.remove.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.remove.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.remove.10000005=[自定义提示信息！]
${entity?uncap_first}Controller.remove.10000998=[自定义提示信息！]

${entity?uncap_first}Controller.single.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.single.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.single.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.single.10000005=[自定义提示信息！]

${entity?uncap_first}Controller.list.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.list.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.list.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.list.10000005=[自定义提示信息！]

${entity?uncap_first}Controller.paginate.10000002=[自定义提示信息！]
${entity?uncap_first}Controller.paginate.10000003=[自定义提示信息！]
${entity?uncap_first}Controller.paginate.10000004=[自定义提示信息！]
${entity?uncap_first}Controller.paginate.10000005=[自定义提示信息！]
