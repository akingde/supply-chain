package com.bs.service.modules.sc.fielddataconfig.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.FieldDataConfigDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigService;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseFieldDataConfigApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<FieldDataConfigDO> redisService;
	
	@Autowired
	protected FieldDataConfigService fieldDataConfigService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,FieldDataConfigDO fieldDataConfigDO);

	public ResultData<FieldDataConfigDTO> save(FieldDataConfigDTO fieldDataConfigDTO){
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			//bean 拷贝
			BeanUtils.copyProperties(fieldDataConfigDTO,fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataConfigService.save(fieldDataConfigDO);
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

	public ResultData<FieldDataConfigDTO> updateById(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataConfigService.updateById(fieldDataConfigDO);
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
	
	public ResultData<FieldDataConfigDTO> updateCriteria(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataConfigService.updateCriteria(fieldDataConfigDO);
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
	
	public ResultData<FieldDataConfigDTO> removeCriteria(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataConfigService.removeCriteria(fieldDataConfigDO);
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

	
	public ResultData<FieldDataConfigDTO> removeById(Long id) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			//验证输入参数
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			fieldDataConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataConfigService.removeById(id);
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

	public ResultData<FieldDataConfigDTO> removeAll() {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			fieldDataConfigService.removeAll();
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
	
	public ResultData<List<FieldDataConfigDTO>> listCriteria(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<List<FieldDataConfigDTO>> resultData = new ResultData<List<FieldDataConfigDTO>>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<FieldDataConfigDO> resultList = fieldDataConfigService.listCriteria(fieldDataConfigDO);
			if (resultList != null) {
				List<FieldDataConfigDTO> listFieldDataConfigDTO = new ArrayList<FieldDataConfigDTO>(resultList.size());
				for (FieldDataConfigDO fieldDataConfigDOTemp:resultList) {
					FieldDataConfigDTO fieldDataConfigDTOTemp = new FieldDataConfigDTO();
					BeanUtils.copyProperties(fieldDataConfigDOTemp,fieldDataConfigDTOTemp);
					listFieldDataConfigDTO.add(fieldDataConfigDTOTemp);
				}
				resultData.setData(listFieldDataConfigDTO);
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

	public ResultData<List<FieldDataConfigDTO>> listAll() {
		ResultData<List<FieldDataConfigDTO>> resultData = new ResultData<List<FieldDataConfigDTO>>();
		try {
			List<FieldDataConfigDO> resultList = fieldDataConfigService.listAll();
			if (resultList != null) {
				List<FieldDataConfigDTO> listFieldDataConfigDTO = new ArrayList<FieldDataConfigDTO>(resultList.size());
				for (FieldDataConfigDO fieldDataConfigDOTemp:resultList) {
					FieldDataConfigDTO fieldDataConfigDTOTemp = new FieldDataConfigDTO();
					BeanUtils.copyProperties(fieldDataConfigDOTemp,fieldDataConfigDTOTemp);
					listFieldDataConfigDTO.add(fieldDataConfigDTOTemp);
				}
				resultData.setData(listFieldDataConfigDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(FieldDataConfigDTO fieldDataConfigDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = fieldDataConfigService.listIdsCriteria(fieldDataConfigDO);
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
	
	public ResultData<List<FieldDataConfigDTO>> listByInIds(FieldDataConfigDTO fieldDataConfigDTO){
		ResultData<List<FieldDataConfigDTO>> resultData = new ResultData<List<FieldDataConfigDTO>>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<FieldDataConfigDO> resultList = fieldDataConfigService.listByInIds(fieldDataConfigDO);
			if (resultList != null) {
				List<FieldDataConfigDTO> listFieldDataConfigDTO = new ArrayList<FieldDataConfigDTO>(resultList.size());
				for (FieldDataConfigDO fieldDataConfigDOTemp:resultList) {
					FieldDataConfigDTO fieldDataConfigDTOTemp = new FieldDataConfigDTO();
					BeanUtils.copyProperties(fieldDataConfigDOTemp,fieldDataConfigDTOTemp);
					listFieldDataConfigDTO.add(fieldDataConfigDTOTemp);
				}
				resultData.setData(listFieldDataConfigDTO);
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
	
	public ResultData<FieldDataConfigDTO> getOneById(Long id) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			//验证输入参数
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			fieldDataConfigDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			FieldDataConfigDO resultFieldDataConfigDO = fieldDataConfigService.getOneById(id);
			if (resultFieldDataConfigDO != null) {
				FieldDataConfigDTO resultFieldDataConfigDTO = new FieldDataConfigDTO();
				BeanUtils.copyProperties(resultFieldDataConfigDO, resultFieldDataConfigDTO);
				resultData.setData(resultFieldDataConfigDTO);
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

	public ResultData<FieldDataConfigDTO> getOneCriteria(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<FieldDataConfigDTO> resultData = new ResultData<FieldDataConfigDTO>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			FieldDataConfigDO resultFieldDataConfigDO = fieldDataConfigService.getOneCriteria(fieldDataConfigDO);
			if (resultFieldDataConfigDO != null) {
				FieldDataConfigDTO resultFieldDataConfigDTO = new FieldDataConfigDTO();
				BeanUtils.copyProperties(resultFieldDataConfigDO, resultFieldDataConfigDTO);
				resultData.setData(resultFieldDataConfigDTO);
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

	public ResultData<List<FieldDataConfigDTO>> paginated(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<List<FieldDataConfigDTO>> resultData = new ResultData<List<FieldDataConfigDTO>>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<FieldDataConfigDO> pageInfo = fieldDataConfigService.listPaginated(fieldDataConfigDO);
			if (pageInfo != null) {
				List<FieldDataConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<FieldDataConfigDTO> listFieldDataConfigDTO = new ArrayList<FieldDataConfigDTO>(resultList.size());
    				for (FieldDataConfigDO fieldDataConfigDOTemp:resultList) {
    					FieldDataConfigDTO fieldDataConfigDTOTemp = new FieldDataConfigDTO();
    					BeanUtils.copyProperties(fieldDataConfigDOTemp,fieldDataConfigDTOTemp);
    					listFieldDataConfigDTO.add(fieldDataConfigDTOTemp);
    				}
    				resultData.setData(listFieldDataConfigDTO);
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
	
	public ResultData<List<FieldDataConfigDTO>> paginatedManual(FieldDataConfigDTO fieldDataConfigDTO) {
		ResultData<List<FieldDataConfigDTO>> resultData = new ResultData<List<FieldDataConfigDTO>>();
		try {
			FieldDataConfigDO fieldDataConfigDO = new FieldDataConfigDO();
			BeanUtils.copyProperties(fieldDataConfigDTO, fieldDataConfigDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(fieldDataConfigDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", fieldDataConfigDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<FieldDataConfigDO> pageInfo = fieldDataConfigService.listPaginatedManual(fieldDataConfigDO);
			if (pageInfo != null) {
				List<FieldDataConfigDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<FieldDataConfigDTO> listFieldDataConfigDTO = new ArrayList<FieldDataConfigDTO>(resultList.size());
    				for (FieldDataConfigDO fieldDataConfigDOTemp:resultList) {
    					FieldDataConfigDTO fieldDataConfigDTOTemp = new FieldDataConfigDTO();
    					BeanUtils.copyProperties(fieldDataConfigDOTemp,fieldDataConfigDTOTemp);
    					listFieldDataConfigDTO.add(fieldDataConfigDTOTemp);
    				}
    				resultData.setData(listFieldDataConfigDTO);
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
