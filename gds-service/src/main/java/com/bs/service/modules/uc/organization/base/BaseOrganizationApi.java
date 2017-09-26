package com.bs.service.modules.uc.organization.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.OrganizationDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.organization.OrganizationService;
import com.bs.service.modules.uc.organization.OrganizationDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseOrganizationApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<OrganizationDO> redisService;
	
	@Autowired
	protected OrganizationService organizationService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,OrganizationDO organizationDO);

	public ResultData<OrganizationDTO> save(OrganizationDTO organizationDTO){
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			//bean 拷贝
			BeanUtils.copyProperties(organizationDTO,organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = organizationService.save(organizationDO);
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

	public ResultData<OrganizationDTO> updateById(OrganizationDTO organizationDTO) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = organizationService.updateById(organizationDO);
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
	
	public ResultData<OrganizationDTO> updateCriteria(OrganizationDTO organizationDTO) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = organizationService.updateCriteria(organizationDO);
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
	
	public ResultData<OrganizationDTO> removeCriteria(OrganizationDTO organizationDTO) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = organizationService.removeCriteria(organizationDO);
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

	
	public ResultData<OrganizationDTO> removeById(Long id) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			//验证输入参数
			OrganizationDO organizationDO = new OrganizationDO();
			organizationDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = organizationService.removeById(id);
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

	public ResultData<OrganizationDTO> removeAll() {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			organizationService.removeAll();
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
	
	public ResultData<List<OrganizationDTO>> listCriteria(OrganizationDTO organizationDTO) {
		ResultData<List<OrganizationDTO>> resultData = new ResultData<List<OrganizationDTO>>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<OrganizationDO> resultList = organizationService.listCriteria(organizationDO);
			if (resultList != null) {
				List<OrganizationDTO> listOrganizationDTO = new ArrayList<OrganizationDTO>(resultList.size());
				for (OrganizationDO organizationDOTemp:resultList) {
					OrganizationDTO organizationDTOTemp = new OrganizationDTO();
					BeanUtils.copyProperties(organizationDOTemp,organizationDTOTemp);
					listOrganizationDTO.add(organizationDTOTemp);
				}
				resultData.setData(listOrganizationDTO);
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

	public ResultData<List<OrganizationDTO>> listAll() {
		ResultData<List<OrganizationDTO>> resultData = new ResultData<List<OrganizationDTO>>();
		try {
			List<OrganizationDO> resultList = organizationService.listAll();
			if (resultList != null) {
				List<OrganizationDTO> listOrganizationDTO = new ArrayList<OrganizationDTO>(resultList.size());
				for (OrganizationDO organizationDOTemp:resultList) {
					OrganizationDTO organizationDTOTemp = new OrganizationDTO();
					BeanUtils.copyProperties(organizationDOTemp,organizationDTOTemp);
					listOrganizationDTO.add(organizationDTOTemp);
				}
				resultData.setData(listOrganizationDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(OrganizationDTO organizationDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = organizationService.listIdsCriteria(organizationDO);
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
	
	public ResultData<List<OrganizationDTO>> listByInIds(OrganizationDTO organizationDTO){
		ResultData<List<OrganizationDTO>> resultData = new ResultData<List<OrganizationDTO>>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<OrganizationDO> resultList = organizationService.listByInIds(organizationDO);
			if (resultList != null) {
				List<OrganizationDTO> listOrganizationDTO = new ArrayList<OrganizationDTO>(resultList.size());
				for (OrganizationDO organizationDOTemp:resultList) {
					OrganizationDTO organizationDTOTemp = new OrganizationDTO();
					BeanUtils.copyProperties(organizationDOTemp,organizationDTOTemp);
					listOrganizationDTO.add(organizationDTOTemp);
				}
				resultData.setData(listOrganizationDTO);
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
	
	public ResultData<OrganizationDTO> getOneById(Long id) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			//验证输入参数
			OrganizationDO organizationDO = new OrganizationDO();
			organizationDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			OrganizationDO resultOrganizationDO = organizationService.getOneById(id);
			if (resultOrganizationDO != null) {
				OrganizationDTO resultOrganizationDTO = new OrganizationDTO();
				BeanUtils.copyProperties(resultOrganizationDO, resultOrganizationDTO);
				resultData.setData(resultOrganizationDTO);
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

	public ResultData<OrganizationDTO> getOneCriteria(OrganizationDTO organizationDTO) {
		ResultData<OrganizationDTO> resultData = new ResultData<OrganizationDTO>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			OrganizationDO resultOrganizationDO = organizationService.getOneCriteria(organizationDO);
			if (resultOrganizationDO != null) {
				OrganizationDTO resultOrganizationDTO = new OrganizationDTO();
				BeanUtils.copyProperties(resultOrganizationDO, resultOrganizationDTO);
				resultData.setData(resultOrganizationDTO);
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

	public ResultData<List<OrganizationDTO>> paginated(OrganizationDTO organizationDTO) {
		ResultData<List<OrganizationDTO>> resultData = new ResultData<List<OrganizationDTO>>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<OrganizationDO> pageInfo = organizationService.listPaginated(organizationDO);
			if (pageInfo != null) {
				List<OrganizationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<OrganizationDTO> listOrganizationDTO = new ArrayList<OrganizationDTO>(resultList.size());
    				for (OrganizationDO organizationDOTemp:resultList) {
    					OrganizationDTO organizationDTOTemp = new OrganizationDTO();
    					BeanUtils.copyProperties(organizationDOTemp,organizationDTOTemp);
    					listOrganizationDTO.add(organizationDTOTemp);
    				}
    				resultData.setData(listOrganizationDTO);
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
	
	public ResultData<List<OrganizationDTO>> paginatedManual(OrganizationDTO organizationDTO) {
		ResultData<List<OrganizationDTO>> resultData = new ResultData<List<OrganizationDTO>>();
		try {
			OrganizationDO organizationDO = new OrganizationDO();
			BeanUtils.copyProperties(organizationDTO, organizationDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(organizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", organizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<OrganizationDO> pageInfo = organizationService.listPaginatedManual(organizationDO);
			if (pageInfo != null) {
				List<OrganizationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<OrganizationDTO> listOrganizationDTO = new ArrayList<OrganizationDTO>(resultList.size());
    				for (OrganizationDO organizationDOTemp:resultList) {
    					OrganizationDTO organizationDTOTemp = new OrganizationDTO();
    					BeanUtils.copyProperties(organizationDOTemp,organizationDTOTemp);
    					listOrganizationDTO.add(organizationDTOTemp);
    				}
    				resultData.setData(listOrganizationDTO);
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
