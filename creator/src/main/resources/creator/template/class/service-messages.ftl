
<#list columns as cols>
NotNull.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
NotEmpty.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}不能为空！
Pattern.${entity?uncap_first}.${cols.code?uncap_first}=${cols.name}格式不正确！

</#list>


#系统提示信息，统一在dubbo对外暴露的业务接口实现逻辑中实现
${entity?uncap_first}Api.save.10000000=信息保存成功！
${entity?uncap_first}Api.save.10000001=输入参数格式错误！
${entity?uncap_first}Api.save.10000002=[自定义提示信息！]
${entity?uncap_first}Api.save.10000003=[自定义提示信息！]
${entity?uncap_first}Api.save.10000004=[自定义提示信息！]
${entity?uncap_first}Api.save.10000005=[自定义提示信息！]
${entity?uncap_first}Api.save.10000998=数据保存失败！

${entity?uncap_first}Api.updateById.10000000=数据修改成功！
${entity?uncap_first}Api.updateById.10000001=输入参数格式错误！
${entity?uncap_first}Api.updateById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000005=[自定义提示信息！]
${entity?uncap_first}Api.updateById.10000998=数据获取失败！

${entity?uncap_first}Api.removeCriteria.10000000=数据删除成功！
${entity?uncap_first}Api.removeCriteria.10000001=输入参数格式错误！
${entity?uncap_first}Api.removeCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000005=[自定义提示信息！]
${entity?uncap_first}Api.removeCriteria.10000998=数据删除失败！

${entity?uncap_first}Api.removeById.10000000=数据删除成功！
${entity?uncap_first}Api.removeById.10000001=输入参数格式错误！
${entity?uncap_first}Api.removeById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000005=[自定义提示信息！]
${entity?uncap_first}Api.removeById.10000998=数据删除失败！

${entity?uncap_first}Api.removeAll.10000000=数据删除成功！
${entity?uncap_first}Api.removeAll.10000001=输入参数格式错误
${entity?uncap_first}Api.removeAll.10000002=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000003=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000004=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000005=[自定义提示信息！]
${entity?uncap_first}Api.removeAll.10000998=数据删除失败！

${entity?uncap_first}Api.listCriteria.10000000=列表数据获取成功！
${entity?uncap_first}Api.listCriteria.10000001=输入参数格式错误！
${entity?uncap_first}Api.listCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listCriteria.10000005=数据获取失败！

${entity?uncap_first}Api.listAll.10000000=所有数据获取成功！
${entity?uncap_first}Api.listAll.10000001=输入参数格式错误！
${entity?uncap_first}Api.listAll.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listAll.10000005=数据获取失败！

${entity?uncap_first}Api.listIdsCriteria.10000000=数据获取成功！
${entity?uncap_first}Api.listIdsCriteria.10000001=输入参数格式错误！
${entity?uncap_first}Api.listIdsCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listIdsCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listIdsCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listIdsCriteria.10000005=数据获取失败！

${entity?uncap_first}Api.listByInIds.10000000=数据获取成功！
${entity?uncap_first}Api.listByInIds.10000001=输入参数格式错误！
${entity?uncap_first}Api.listByInIds.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listByInIds.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listByInIds.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listByInIds.10000005=数据获取失败！

${entity?uncap_first}Api.getOneById.10000000=数据获取成功！
${entity?uncap_first}Api.getOneById.10000001=输入参数格式错误！
${entity?uncap_first}Api.getOneById.10000002=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000003=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000004=[自定义提示信息！]
${entity?uncap_first}Api.getOneById.10000005=数据获取失败！

${entity?uncap_first}Api.getOneCriteria.10000000=数据获取成功！
${entity?uncap_first}Api.getOneCriteria.10000001=输入参数格式错误！
${entity?uncap_first}Api.getOneCriteria.10000002=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000003=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000004=[自定义提示信息！]
${entity?uncap_first}Api.getOneCriteria.10000005=数据获取失败！

${entity?uncap_first}Api.count.10000000=获取总数量数据成功！
${entity?uncap_first}Api.count.10000001=输入参数格式错误！
${entity?uncap_first}Api.count.10000002=[自定义提示信息！]
${entity?uncap_first}Api.count.10000003=[自定义提示信息！]
${entity?uncap_first}Api.count.10000004=[自定义提示信息！]
${entity?uncap_first}Api.count.10000005=数据获取失败！

${entity?uncap_first}Api.listPaginated.10000000=自动分页数据获取成功！
${entity?uncap_first}Api.listPaginated.10000001=输入参数格式错误！
${entity?uncap_first}Api.listPaginated.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listPaginated.10000005=数据获取失败！

${entity?uncap_first}Api.listPaginatedManual.10000000=手动分页数据获取成功！
${entity?uncap_first}Api.listPaginatedManual.10000001=输入参数格式错误！
${entity?uncap_first}Api.listPaginatedManual.10000002=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000003=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000004=[自定义提示信息！]
${entity?uncap_first}Api.listPaginatedManual.10000005=数据获取失败！