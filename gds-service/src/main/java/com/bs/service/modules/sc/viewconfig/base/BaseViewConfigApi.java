package com.bs.service.modules.sc.viewconfig.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.ViewConfigDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.viewconfig.ViewConfigService;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseViewConfigApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<ViewConfigDO> redisService;
	
	@Autowired
	protected ViewConfigService viewConfigService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,ViewConfigDO viewConfigDO);

	public ResultData<ViewConfigDTO> save(ViewConfigDTO viewConfigDTO){
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			//bean 拷贝
			BeanUtils.copyProperties(viewConfigDTO,viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewConfigService.save(viewConfigDO);
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

	public ResultData<ViewConfigDTO> updateById(ViewConfigDTO viewConfigDTO) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewConfigService.updateById(viewConfigDO);
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
	
	public ResultData<ViewConfigDTO> updateCriteria(ViewConfigDTO viewConfigDTO) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewConfigService.updateCriteria(viewConfigDO);
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
	
	public ResultData<ViewConfigDTO> removeCriteria(ViewConfigDTO viewConfigDTO) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewConfigService.removeCriteria(viewConfigDO);
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

	
	public ResultData<ViewConfigDTO> removeById(Long id) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			//验证输入参数
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			viewConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = viewConfigService.removeById(id);
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

	public ResultData<ViewConfigDTO> removeAll() {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			viewConfigService.removeAll();
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
	
	public ResultData<List<ViewConfigDTO>> listCriteria(ViewConfigDTO viewConfigDTO) {
		ResultData<List<ViewConfigDTO>> resultData = new ResultData<List<ViewConfigDTO>>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<ViewConfigDO> resultList = viewConfigService.listCriteria(viewConfigDO);
			if (resultList != null) {
				List<ViewConfigDTO> listViewConfigDTO = new ArrayList<ViewConfigDTO>(resultList.size());
				for (ViewConfigDO viewConfigDOTemp:resultList) {
					ViewConfigDTO viewConfigDTOTemp = new ViewConfigDTO();
					BeanUtils.copyProperties(viewConfigDOTemp,viewConfigDTOTemp);
					listViewConfigDTO.add(viewConfigDTOTemp);
				}
				resultData.setData(listViewConfigDTO);
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

	public ResultData<List<ViewConfigDTO>> listAll() {
		ResultData<List<ViewConfigDTO>> resultData = new ResultData<List<ViewConfigDTO>>();
		try {
			List<ViewConfigDO> resultList = viewConfigService.listAll();
			if (resultList != null) {
				List<ViewConfigDTO> listViewConfigDTO = new ArrayList<ViewConfigDTO>(resultList.size());
				for (ViewConfigDO viewConfigDOTemp:resultList) {
					ViewConfigDTO viewConfigDTOTemp = new ViewConfigDTO();
					BeanUtils.copyProperties(viewConfigDOTemp,viewConfigDTOTemp);
					listViewConfigDTO.add(viewConfigDTOTemp);
				}
				resultData.setData(listViewConfigDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(ViewConfigDTO viewConfigDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = viewConfigService.listIdsCriteria(viewConfigDO);
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
	
	public ResultData<List<ViewConfigDTO>> listByInIds(ViewConfigDTO viewConfigDTO){
		ResultData<List<ViewConfigDTO>> resultData = new ResultData<List<ViewConfigDTO>>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<ViewConfigDO> resultList = viewConfigService.listByInIds(viewConfigDO);
			if (resultList != null) {
				List<ViewConfigDTO> listViewConfigDTO = new ArrayList<ViewConfigDTO>(resultList.size());
				for (ViewConfigDO viewConfigDOTemp:resultList) {
					ViewConfigDTO viewConfigDTOTemp = new ViewConfigDTO();
					BeanUtils.copyProperties(viewConfigDOTemp,viewConfigDTOTemp);
					listViewConfigDTO.add(viewConfigDTOTemp);
				}
				resultData.setData(listViewConfigDTO);
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
	
	public ResultData<ViewConfigDTO> getOneById(Long id) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			//验证输入参数
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			viewConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ViewConfigDO resultViewConfigDO = viewConfigService.getOneById(id);
			if (resultViewConfigDO != null) {
				ViewConfigDTO resultViewConfigDTO = new ViewConfigDTO();
				BeanUtils.copyProperties(resultViewConfigDO, resultViewConfigDTO);
				resultData.setData(resultViewConfigDTO);
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

	public ResultData<ViewConfigDTO> getOneCriteria(ViewConfigDTO viewConfigDTO) {
		ResultData<ViewConfigDTO> resultData = new ResultData<ViewConfigDTO>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ViewConfigDO resultViewConfigDO = viewConfigService.getOneCriteria(viewConfigDO);
			if (resultViewConfigDO != null) {
				ViewConfigDTO resultViewConfigDTO = new ViewConfigDTO();
				BeanUtils.copyProperties(resultViewConfigDO, resultViewConfigDTO);
				resultData.setData(resultViewConfigDTO);
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

	public ResultData<List<ViewConfigDTO>> paginated(ViewConfigDTO viewConfigDTO) {
		ResultData<List<ViewConfigDTO>> resultData = new ResultData<List<ViewConfigDTO>>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ViewConfigDO> pageInfo = viewConfigService.listPaginated(viewConfigDO);
			if (pageInfo != null) {
				List<ViewConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ViewConfigDTO> listViewConfigDTO = new ArrayList<ViewConfigDTO>(resultList.size());
    				for (ViewConfigDO viewConfigDOTemp:resultList) {
    					ViewConfigDTO viewConfigDTOTemp = new ViewConfigDTO();
    					BeanUtils.copyProperties(viewConfigDOTemp,viewConfigDTOTemp);
    					listViewConfigDTO.add(viewConfigDTOTemp);
    				}
    				resultData.setData(listViewConfigDTO);
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
	
	public ResultData<List<ViewConfigDTO>> paginatedManual(ViewConfigDTO viewConfigDTO) {
		ResultData<List<ViewConfigDTO>> resultData = new ResultData<List<ViewConfigDTO>>();
		try {
			ViewConfigDO viewConfigDO = new ViewConfigDO();
			BeanUtils.copyProperties(viewConfigDTO, viewConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(viewConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", viewConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ViewConfigDO> pageInfo = viewConfigService.listPaginatedManual(viewConfigDO);
			if (pageInfo != null) {
				List<ViewConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ViewConfigDTO> listViewConfigDTO = new ArrayList<ViewConfigDTO>(resultList.size());
    				for (ViewConfigDO viewConfigDOTemp:resultList) {
    					ViewConfigDTO viewConfigDTOTemp = new ViewConfigDTO();
    					BeanUtils.copyProperties(viewConfigDOTemp,viewConfigDTOTemp);
    					listViewConfigDTO.add(viewConfigDTOTemp);
    				}
    				resultData.setData(listViewConfigDTO);
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
