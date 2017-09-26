package com.bs.service.modules.${module}.${entityPath}.base;
<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.${module}.dto.${entity}DTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.${module}.${entityPath}.${entity}Service;
import com.bs.service.modules.${module}.${entityPath}.${entity}DO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
<#if idIsExist == 'true'>
import com.bs.service.core.group.Id;
</#if>

import com.github.pagehelper.PageInfo;

public abstract class Base${entity}Api<T> extends BaseService{
	
	@Autowired
	protected RedisService<${entity}DO> redisService;
	
	@Autowired
	protected ${entity}Service ${entity?uncap_first}Service;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,${entity}DO ${entity?uncap_first}DO);

	public ResultData<${entity}DTO> save(${entity}DTO ${entity?uncap_first}DTO){
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			//bean 拷贝
			BeanUtils.copyProperties(${entity?uncap_first}DTO,${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = ${entity?uncap_first}Service.save(${entity?uncap_first}DO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	<#if idIsExist == 'true'>
	public ResultData<${entity}DTO> updateById(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = ${entity?uncap_first}Service.updateById(${entity?uncap_first}DO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	</#if>
	
	public ResultData<${entity}DTO> updateCriteria(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = ${entity?uncap_first}Service.updateCriteria(${entity?uncap_first}DO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<${entity}DTO> removeCriteria(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = ${entity?uncap_first}Service.removeCriteria(${entity?uncap_first}DO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	
	<#if idIsExist == 'true'>
	public ResultData<${entity}DTO> removeById(Long id) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			//验证输入参数
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			${entity?uncap_first}DO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = ${entity?uncap_first}Service.removeById(id);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	</#if>

	public ResultData<${entity}DTO> removeAll() {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity?uncap_first}Service.removeAll();
			//设置返回码和提示信息
			String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<${entity}DTO>> listCriteria(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<List<${entity}DTO>> resultData = new ResultData<List<${entity}DTO>>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<${entity}DO> resultList = ${entity?uncap_first}Service.listCriteria(${entity?uncap_first}DO);
			if (resultList != null) {
				List<${entity}DTO> list${entity}DTO = new ArrayList<${entity}DTO>(resultList.size());
				for (${entity}DO ${entity?uncap_first}DOTemp:resultList) {
					${entity}DTO ${entity?uncap_first}DTOTemp = new ${entity}DTO();
					BeanUtils.copyProperties(${entity?uncap_first}DOTemp,${entity?uncap_first}DTOTemp);
					list${entity}DTO.add(${entity?uncap_first}DTOTemp);
				}
				resultData.setData(list${entity}DTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<List<${entity}DTO>> listAll() {
		ResultData<List<${entity}DTO>> resultData = new ResultData<List<${entity}DTO>>();
		try {
			List<${entity}DO> resultList = ${entity?uncap_first}Service.listAll();
			if (resultList != null) {
				List<${entity}DTO> list${entity}DTO = new ArrayList<${entity}DTO>(resultList.size());
				for (${entity}DO ${entity?uncap_first}DOTemp:resultList) {
					${entity}DTO ${entity?uncap_first}DTOTemp = new ${entity}DTO();
					BeanUtils.copyProperties(${entity?uncap_first}DOTemp,${entity?uncap_first}DTOTemp);
					list${entity}DTO.add(${entity?uncap_first}DTOTemp);
				}
				resultData.setData(list${entity}DTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<Long>> listIdsCriteria(${entity}DTO ${entity?uncap_first}DTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = ${entity?uncap_first}Service.listIdsCriteria(${entity?uncap_first}DO);
			if (resultList != null) {
				resultData.setData(resultList);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<${entity}DTO>> listByInIds(${entity}DTO ${entity?uncap_first}DTO){
		ResultData<List<${entity}DTO>> resultData = new ResultData<List<${entity}DTO>>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<${entity}DO> resultList = ${entity?uncap_first}Service.listByInIds(${entity?uncap_first}DO);
			if (resultList != null) {
				List<${entity}DTO> list${entity}DTO = new ArrayList<${entity}DTO>(resultList.size());
				for (${entity}DO ${entity?uncap_first}DOTemp:resultList) {
					${entity}DTO ${entity?uncap_first}DTOTemp = new ${entity}DTO();
					BeanUtils.copyProperties(${entity?uncap_first}DOTemp,${entity?uncap_first}DTOTemp);
					list${entity}DTO.add(${entity?uncap_first}DTOTemp);
				}
				resultData.setData(list${entity}DTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;	
	}
	
	<#if idIsExist == 'true'>
	public ResultData<${entity}DTO> getOneById(Long id) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			//验证输入参数
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			${entity?uncap_first}DO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			${entity}DO result${entity}DO = ${entity?uncap_first}Service.getOneById(id);
			if (result${entity}DO != null) {
				${entity}DTO result${entity}DTO = new ${entity}DTO();
				BeanUtils.copyProperties(result${entity}DO, result${entity}DTO);
				resultData.setData(result${entity}DTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	</#if>

	public ResultData<${entity}DTO> getOneCriteria(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<${entity}DTO> resultData = new ResultData<${entity}DTO>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			${entity}DO result${entity}DO = ${entity?uncap_first}Service.getOneCriteria(${entity?uncap_first}DO);
			if (result${entity}DO != null) {
				${entity}DTO result${entity}DTO = new ${entity}DTO();
				BeanUtils.copyProperties(result${entity}DO, result${entity}DTO);
				resultData.setData(result${entity}DTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<List<${entity}DTO>> paginated(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<List<${entity}DTO>> resultData = new ResultData<List<${entity}DTO>>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<${entity}DO> pageInfo = ${entity?uncap_first}Service.listPaginated(${entity?uncap_first}DO);
			if (pageInfo != null) {
				List<${entity}DO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<${entity}DTO> list${entity}DTO = new ArrayList<${entity}DTO>(resultList.size());
    				for (${entity}DO ${entity?uncap_first}DOTemp:resultList) {
    					${entity}DTO ${entity?uncap_first}DTOTemp = new ${entity}DTO();
    					BeanUtils.copyProperties(${entity?uncap_first}DOTemp,${entity?uncap_first}DTOTemp);
    					list${entity}DTO.add(${entity?uncap_first}DTOTemp);
    				}
    				resultData.setData(list${entity}DTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<${entity}DTO>> paginatedManual(${entity}DTO ${entity?uncap_first}DTO) {
		ResultData<List<${entity}DTO>> resultData = new ResultData<List<${entity}DTO>>();
		try {
			${entity}DO ${entity?uncap_first}DO = new ${entity}DO();
			BeanUtils.copyProperties(${entity?uncap_first}DTO, ${entity?uncap_first}DO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(${entity?uncap_first}DO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", ${entity?uncap_first}DO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<${entity}DO> pageInfo = ${entity?uncap_first}Service.listPaginatedManual(${entity?uncap_first}DO);
			if (pageInfo != null) {
				List<${entity}DO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<${entity}DTO> list${entity}DTO = new ArrayList<${entity}DTO>(resultList.size());
    				for (${entity}DO ${entity?uncap_first}DOTemp:resultList) {
    					${entity}DTO ${entity?uncap_first}DTOTemp = new ${entity}DTO();
    					BeanUtils.copyProperties(${entity?uncap_first}DOTemp,${entity?uncap_first}DTOTemp);
    					list${entity}DTO.add(${entity?uncap_first}DTOTemp);
    				}
    				resultData.setData(list${entity}DTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_SUCCESS_KEY, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(ResultCode.RCODE_EXECUTE_FAIL_KEY, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
}
