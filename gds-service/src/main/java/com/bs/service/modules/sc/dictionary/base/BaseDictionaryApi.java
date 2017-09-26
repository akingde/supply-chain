package com.bs.service.modules.sc.dictionary.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.DictionaryDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.dictionary.DictionaryService;
import com.bs.service.modules.sc.dictionary.DictionaryDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseDictionaryApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<DictionaryDO> redisService;
	
	@Autowired
	protected DictionaryService dictionaryService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,DictionaryDO dictionaryDO);

	public ResultData<DictionaryDTO> save(DictionaryDTO dictionaryDTO){
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			//bean 拷贝
			BeanUtils.copyProperties(dictionaryDTO,dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryService.save(dictionaryDO);
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

	public ResultData<DictionaryDTO> updateById(DictionaryDTO dictionaryDTO) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryService.updateById(dictionaryDO);
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
	
	public ResultData<DictionaryDTO> updateCriteria(DictionaryDTO dictionaryDTO) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryService.updateCriteria(dictionaryDO);
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
	
	public ResultData<DictionaryDTO> removeCriteria(DictionaryDTO dictionaryDTO) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryService.removeCriteria(dictionaryDO);
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

	
	public ResultData<DictionaryDTO> removeById(Long id) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			//验证输入参数
			DictionaryDO dictionaryDO = new DictionaryDO();
			dictionaryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryService.removeById(id);
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

	public ResultData<DictionaryDTO> removeAll() {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			dictionaryService.removeAll();
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
	
	public ResultData<List<DictionaryDTO>> listCriteria(DictionaryDTO dictionaryDTO) {
		ResultData<List<DictionaryDTO>> resultData = new ResultData<List<DictionaryDTO>>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<DictionaryDO> resultList = dictionaryService.listCriteria(dictionaryDO);
			if (resultList != null) {
				List<DictionaryDTO> listDictionaryDTO = new ArrayList<DictionaryDTO>(resultList.size());
				for (DictionaryDO dictionaryDOTemp:resultList) {
					DictionaryDTO dictionaryDTOTemp = new DictionaryDTO();
					BeanUtils.copyProperties(dictionaryDOTemp,dictionaryDTOTemp);
					listDictionaryDTO.add(dictionaryDTOTemp);
				}
				resultData.setData(listDictionaryDTO);
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

	public ResultData<List<DictionaryDTO>> listAll() {
		ResultData<List<DictionaryDTO>> resultData = new ResultData<List<DictionaryDTO>>();
		try {
			List<DictionaryDO> resultList = dictionaryService.listAll();
			if (resultList != null) {
				List<DictionaryDTO> listDictionaryDTO = new ArrayList<DictionaryDTO>(resultList.size());
				for (DictionaryDO dictionaryDOTemp:resultList) {
					DictionaryDTO dictionaryDTOTemp = new DictionaryDTO();
					BeanUtils.copyProperties(dictionaryDOTemp,dictionaryDTOTemp);
					listDictionaryDTO.add(dictionaryDTOTemp);
				}
				resultData.setData(listDictionaryDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(DictionaryDTO dictionaryDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = dictionaryService.listIdsCriteria(dictionaryDO);
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
	
	public ResultData<List<DictionaryDTO>> listByInIds(DictionaryDTO dictionaryDTO){
		ResultData<List<DictionaryDTO>> resultData = new ResultData<List<DictionaryDTO>>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<DictionaryDO> resultList = dictionaryService.listByInIds(dictionaryDO);
			if (resultList != null) {
				List<DictionaryDTO> listDictionaryDTO = new ArrayList<DictionaryDTO>(resultList.size());
				for (DictionaryDO dictionaryDOTemp:resultList) {
					DictionaryDTO dictionaryDTOTemp = new DictionaryDTO();
					BeanUtils.copyProperties(dictionaryDOTemp,dictionaryDTOTemp);
					listDictionaryDTO.add(dictionaryDTOTemp);
				}
				resultData.setData(listDictionaryDTO);
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
	
	public ResultData<DictionaryDTO> getOneById(Long id) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			//验证输入参数
			DictionaryDO dictionaryDO = new DictionaryDO();
			dictionaryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			DictionaryDO resultDictionaryDO = dictionaryService.getOneById(id);
			if (resultDictionaryDO != null) {
				DictionaryDTO resultDictionaryDTO = new DictionaryDTO();
				BeanUtils.copyProperties(resultDictionaryDO, resultDictionaryDTO);
				resultData.setData(resultDictionaryDTO);
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

	public ResultData<DictionaryDTO> getOneCriteria(DictionaryDTO dictionaryDTO) {
		ResultData<DictionaryDTO> resultData = new ResultData<DictionaryDTO>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			DictionaryDO resultDictionaryDO = dictionaryService.getOneCriteria(dictionaryDO);
			if (resultDictionaryDO != null) {
				DictionaryDTO resultDictionaryDTO = new DictionaryDTO();
				BeanUtils.copyProperties(resultDictionaryDO, resultDictionaryDTO);
				resultData.setData(resultDictionaryDTO);
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

	public ResultData<List<DictionaryDTO>> paginated(DictionaryDTO dictionaryDTO) {
		ResultData<List<DictionaryDTO>> resultData = new ResultData<List<DictionaryDTO>>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<DictionaryDO> pageInfo = dictionaryService.listPaginated(dictionaryDO);
			if (pageInfo != null) {
				List<DictionaryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<DictionaryDTO> listDictionaryDTO = new ArrayList<DictionaryDTO>(resultList.size());
    				for (DictionaryDO dictionaryDOTemp:resultList) {
    					DictionaryDTO dictionaryDTOTemp = new DictionaryDTO();
    					BeanUtils.copyProperties(dictionaryDOTemp,dictionaryDTOTemp);
    					listDictionaryDTO.add(dictionaryDTOTemp);
    				}
    				resultData.setData(listDictionaryDTO);
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
	
	public ResultData<List<DictionaryDTO>> paginatedManual(DictionaryDTO dictionaryDTO) {
		ResultData<List<DictionaryDTO>> resultData = new ResultData<List<DictionaryDTO>>();
		try {
			DictionaryDO dictionaryDO = new DictionaryDO();
			BeanUtils.copyProperties(dictionaryDTO, dictionaryDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(dictionaryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", dictionaryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<DictionaryDO> pageInfo = dictionaryService.listPaginatedManual(dictionaryDO);
			if (pageInfo != null) {
				List<DictionaryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<DictionaryDTO> listDictionaryDTO = new ArrayList<DictionaryDTO>(resultList.size());
    				for (DictionaryDO dictionaryDOTemp:resultList) {
    					DictionaryDTO dictionaryDTOTemp = new DictionaryDTO();
    					BeanUtils.copyProperties(dictionaryDOTemp,dictionaryDTOTemp);
    					listDictionaryDTO.add(dictionaryDTOTemp);
    				}
    				resultData.setData(listDictionaryDTO);
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
