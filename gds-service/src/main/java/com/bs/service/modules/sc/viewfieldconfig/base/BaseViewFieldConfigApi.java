package com.bs.service.modules.sc.viewfieldconfig.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.ViewFieldConfigDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigService;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseViewFieldConfigApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<ViewFieldConfigDO> redisService;
	
	@Autowired
	protected ViewFieldConfigService viewFieldConfigService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,ViewFieldConfigDO viewFieldConfigDO);

	public ResultData<ViewFieldConfigDTO> save(ViewFieldConfigDTO viewFieldConfigDTO){
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			//bean 拷贝
			BeanUtils.copyProperties(viewFieldConfigDTO,viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewFieldConfigService.save(viewFieldConfigDO);
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

	public ResultData<ViewFieldConfigDTO> updateById(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewFieldConfigService.updateById(viewFieldConfigDO);
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
	
	public ResultData<ViewFieldConfigDTO> updateCriteria(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewFieldConfigService.updateCriteria(viewFieldConfigDO);
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
	
	public ResultData<ViewFieldConfigDTO> removeCriteria(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewFieldConfigService.removeCriteria(viewFieldConfigDO);
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

	
	public ResultData<ViewFieldConfigDTO> removeById(Long id) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			//验证输入参数
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			viewFieldConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewFieldConfigService.removeById(id);
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

	public ResultData<ViewFieldConfigDTO> removeAll() {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			viewFieldConfigService.removeAll();
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
	
	public ResultData<List<ViewFieldConfigDTO>> listCriteria(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<List<ViewFieldConfigDTO>> resultData = new ResultData<List<ViewFieldConfigDTO>>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<ViewFieldConfigDO> resultList = viewFieldConfigService.listCriteria(viewFieldConfigDO);
			if (resultList != null) {
				List<ViewFieldConfigDTO> listViewFieldConfigDTO = new ArrayList<ViewFieldConfigDTO>(resultList.size());
				for (ViewFieldConfigDO viewFieldConfigDOTemp:resultList) {
					ViewFieldConfigDTO viewFieldConfigDTOTemp = new ViewFieldConfigDTO();
					BeanUtils.copyProperties(viewFieldConfigDOTemp,viewFieldConfigDTOTemp);
					listViewFieldConfigDTO.add(viewFieldConfigDTOTemp);
				}
				resultData.setData(listViewFieldConfigDTO);
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

	public ResultData<List<ViewFieldConfigDTO>> listAll() {
		ResultData<List<ViewFieldConfigDTO>> resultData = new ResultData<List<ViewFieldConfigDTO>>();
		try {
			List<ViewFieldConfigDO> resultList = viewFieldConfigService.listAll();
			if (resultList != null) {
				List<ViewFieldConfigDTO> listViewFieldConfigDTO = new ArrayList<ViewFieldConfigDTO>(resultList.size());
				for (ViewFieldConfigDO viewFieldConfigDOTemp:resultList) {
					ViewFieldConfigDTO viewFieldConfigDTOTemp = new ViewFieldConfigDTO();
					BeanUtils.copyProperties(viewFieldConfigDOTemp,viewFieldConfigDTOTemp);
					listViewFieldConfigDTO.add(viewFieldConfigDTOTemp);
				}
				resultData.setData(listViewFieldConfigDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(ViewFieldConfigDTO viewFieldConfigDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = viewFieldConfigService.listIdsCriteria(viewFieldConfigDO);
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
	
	public ResultData<List<ViewFieldConfigDTO>> listByInIds(ViewFieldConfigDTO viewFieldConfigDTO){
		ResultData<List<ViewFieldConfigDTO>> resultData = new ResultData<List<ViewFieldConfigDTO>>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<ViewFieldConfigDO> resultList = viewFieldConfigService.listByInIds(viewFieldConfigDO);
			if (resultList != null) {
				List<ViewFieldConfigDTO> listViewFieldConfigDTO = new ArrayList<ViewFieldConfigDTO>(resultList.size());
				for (ViewFieldConfigDO viewFieldConfigDOTemp:resultList) {
					ViewFieldConfigDTO viewFieldConfigDTOTemp = new ViewFieldConfigDTO();
					BeanUtils.copyProperties(viewFieldConfigDOTemp,viewFieldConfigDTOTemp);
					listViewFieldConfigDTO.add(viewFieldConfigDTOTemp);
				}
				resultData.setData(listViewFieldConfigDTO);
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
	
	public ResultData<ViewFieldConfigDTO> getOneById(Long id) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			//验证输入参数
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			viewFieldConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ViewFieldConfigDO resultViewFieldConfigDO = viewFieldConfigService.getOneById(id);
			if (resultViewFieldConfigDO != null) {
				ViewFieldConfigDTO resultViewFieldConfigDTO = new ViewFieldConfigDTO();
				BeanUtils.copyProperties(resultViewFieldConfigDO, resultViewFieldConfigDTO);
				resultData.setData(resultViewFieldConfigDTO);
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

	public ResultData<ViewFieldConfigDTO> getOneCriteria(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<ViewFieldConfigDTO> resultData = new ResultData<ViewFieldConfigDTO>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ViewFieldConfigDO resultViewFieldConfigDO = viewFieldConfigService.getOneCriteria(viewFieldConfigDO);
			if (resultViewFieldConfigDO != null) {
				ViewFieldConfigDTO resultViewFieldConfigDTO = new ViewFieldConfigDTO();
				BeanUtils.copyProperties(resultViewFieldConfigDO, resultViewFieldConfigDTO);
				resultData.setData(resultViewFieldConfigDTO);
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

	public ResultData<List<ViewFieldConfigDTO>> paginated(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<List<ViewFieldConfigDTO>> resultData = new ResultData<List<ViewFieldConfigDTO>>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ViewFieldConfigDO> pageInfo = viewFieldConfigService.listPaginated(viewFieldConfigDO);
			if (pageInfo != null) {
				List<ViewFieldConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ViewFieldConfigDTO> listViewFieldConfigDTO = new ArrayList<ViewFieldConfigDTO>(resultList.size());
    				for (ViewFieldConfigDO viewFieldConfigDOTemp:resultList) {
    					ViewFieldConfigDTO viewFieldConfigDTOTemp = new ViewFieldConfigDTO();
    					BeanUtils.copyProperties(viewFieldConfigDOTemp,viewFieldConfigDTOTemp);
    					listViewFieldConfigDTO.add(viewFieldConfigDTOTemp);
    				}
    				resultData.setData(listViewFieldConfigDTO);
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
	
	public ResultData<List<ViewFieldConfigDTO>> paginatedManual(ViewFieldConfigDTO viewFieldConfigDTO) {
		ResultData<List<ViewFieldConfigDTO>> resultData = new ResultData<List<ViewFieldConfigDTO>>();
		try {
			ViewFieldConfigDO viewFieldConfigDO = new ViewFieldConfigDO();
			BeanUtils.copyProperties(viewFieldConfigDTO, viewFieldConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(viewFieldConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", viewFieldConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ViewFieldConfigDO> pageInfo = viewFieldConfigService.listPaginatedManual(viewFieldConfigDO);
			if (pageInfo != null) {
				List<ViewFieldConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ViewFieldConfigDTO> listViewFieldConfigDTO = new ArrayList<ViewFieldConfigDTO>(resultList.size());
    				for (ViewFieldConfigDO viewFieldConfigDOTemp:resultList) {
    					ViewFieldConfigDTO viewFieldConfigDTOTemp = new ViewFieldConfigDTO();
    					BeanUtils.copyProperties(viewFieldConfigDOTemp,viewFieldConfigDTOTemp);
    					listViewFieldConfigDTO.add(viewFieldConfigDTOTemp);
    				}
    				resultData.setData(listViewFieldConfigDTO);
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
