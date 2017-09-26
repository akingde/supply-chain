package com.bs.service.modules.mc.shortmessagesend.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.mc.dto.ShortMessageSendDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendService;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageSendApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<ShortMessageSendDO> redisService;
	
	@Autowired
	protected ShortMessageSendService shortMessageSendService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,ShortMessageSendDO shortMessageSendDO);

	public ResultData<ShortMessageSendDTO> save(ShortMessageSendDTO shortMessageSendDTO){
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			//bean 拷贝
			BeanUtils.copyProperties(shortMessageSendDTO,shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSendService.save(shortMessageSendDO);
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

	public ResultData<ShortMessageSendDTO> updateById(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSendService.updateById(shortMessageSendDO);
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
	
	public ResultData<ShortMessageSendDTO> updateCriteria(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSendService.updateCriteria(shortMessageSendDO);
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
	
	public ResultData<ShortMessageSendDTO> removeCriteria(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSendService.removeCriteria(shortMessageSendDO);
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

	
	public ResultData<ShortMessageSendDTO> removeById(Long id) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			//验证输入参数
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			shortMessageSendDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSendService.removeById(id);
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

	public ResultData<ShortMessageSendDTO> removeAll() {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			shortMessageSendService.removeAll();
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
	
	public ResultData<List<ShortMessageSendDTO>> listCriteria(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<List<ShortMessageSendDTO>> resultData = new ResultData<List<ShortMessageSendDTO>>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<ShortMessageSendDO> resultList = shortMessageSendService.listCriteria(shortMessageSendDO);
			if (resultList != null) {
				List<ShortMessageSendDTO> listShortMessageSendDTO = new ArrayList<ShortMessageSendDTO>(resultList.size());
				for (ShortMessageSendDO shortMessageSendDOTemp:resultList) {
					ShortMessageSendDTO shortMessageSendDTOTemp = new ShortMessageSendDTO();
					BeanUtils.copyProperties(shortMessageSendDOTemp,shortMessageSendDTOTemp);
					listShortMessageSendDTO.add(shortMessageSendDTOTemp);
				}
				resultData.setData(listShortMessageSendDTO);
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

	public ResultData<List<ShortMessageSendDTO>> listAll() {
		ResultData<List<ShortMessageSendDTO>> resultData = new ResultData<List<ShortMessageSendDTO>>();
		try {
			List<ShortMessageSendDO> resultList = shortMessageSendService.listAll();
			if (resultList != null) {
				List<ShortMessageSendDTO> listShortMessageSendDTO = new ArrayList<ShortMessageSendDTO>(resultList.size());
				for (ShortMessageSendDO shortMessageSendDOTemp:resultList) {
					ShortMessageSendDTO shortMessageSendDTOTemp = new ShortMessageSendDTO();
					BeanUtils.copyProperties(shortMessageSendDOTemp,shortMessageSendDTOTemp);
					listShortMessageSendDTO.add(shortMessageSendDTOTemp);
				}
				resultData.setData(listShortMessageSendDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(ShortMessageSendDTO shortMessageSendDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = shortMessageSendService.listIdsCriteria(shortMessageSendDO);
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
	
	public ResultData<List<ShortMessageSendDTO>> listByInIds(ShortMessageSendDTO shortMessageSendDTO){
		ResultData<List<ShortMessageSendDTO>> resultData = new ResultData<List<ShortMessageSendDTO>>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<ShortMessageSendDO> resultList = shortMessageSendService.listByInIds(shortMessageSendDO);
			if (resultList != null) {
				List<ShortMessageSendDTO> listShortMessageSendDTO = new ArrayList<ShortMessageSendDTO>(resultList.size());
				for (ShortMessageSendDO shortMessageSendDOTemp:resultList) {
					ShortMessageSendDTO shortMessageSendDTOTemp = new ShortMessageSendDTO();
					BeanUtils.copyProperties(shortMessageSendDOTemp,shortMessageSendDTOTemp);
					listShortMessageSendDTO.add(shortMessageSendDTOTemp);
				}
				resultData.setData(listShortMessageSendDTO);
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
	
	public ResultData<ShortMessageSendDTO> getOneById(Long id) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			//验证输入参数
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			shortMessageSendDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageSendDO resultShortMessageSendDO = shortMessageSendService.getOneById(id);
			if (resultShortMessageSendDO != null) {
				ShortMessageSendDTO resultShortMessageSendDTO = new ShortMessageSendDTO();
				BeanUtils.copyProperties(resultShortMessageSendDO, resultShortMessageSendDTO);
				resultData.setData(resultShortMessageSendDTO);
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

	public ResultData<ShortMessageSendDTO> getOneCriteria(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<ShortMessageSendDTO> resultData = new ResultData<ShortMessageSendDTO>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageSendDO resultShortMessageSendDO = shortMessageSendService.getOneCriteria(shortMessageSendDO);
			if (resultShortMessageSendDO != null) {
				ShortMessageSendDTO resultShortMessageSendDTO = new ShortMessageSendDTO();
				BeanUtils.copyProperties(resultShortMessageSendDO, resultShortMessageSendDTO);
				resultData.setData(resultShortMessageSendDTO);
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

	public ResultData<List<ShortMessageSendDTO>> paginated(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<List<ShortMessageSendDTO>> resultData = new ResultData<List<ShortMessageSendDTO>>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageSendDO> pageInfo = shortMessageSendService.listPaginated(shortMessageSendDO);
			if (pageInfo != null) {
				List<ShortMessageSendDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageSendDTO> listShortMessageSendDTO = new ArrayList<ShortMessageSendDTO>(resultList.size());
    				for (ShortMessageSendDO shortMessageSendDOTemp:resultList) {
    					ShortMessageSendDTO shortMessageSendDTOTemp = new ShortMessageSendDTO();
    					BeanUtils.copyProperties(shortMessageSendDOTemp,shortMessageSendDTOTemp);
    					listShortMessageSendDTO.add(shortMessageSendDTOTemp);
    				}
    				resultData.setData(listShortMessageSendDTO);
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
	
	public ResultData<List<ShortMessageSendDTO>> paginatedManual(ShortMessageSendDTO shortMessageSendDTO) {
		ResultData<List<ShortMessageSendDTO>> resultData = new ResultData<List<ShortMessageSendDTO>>();
		try {
			ShortMessageSendDO shortMessageSendDO = new ShortMessageSendDO();
			BeanUtils.copyProperties(shortMessageSendDTO, shortMessageSendDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(shortMessageSendDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", shortMessageSendDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageSendDO> pageInfo = shortMessageSendService.listPaginatedManual(shortMessageSendDO);
			if (pageInfo != null) {
				List<ShortMessageSendDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageSendDTO> listShortMessageSendDTO = new ArrayList<ShortMessageSendDTO>(resultList.size());
    				for (ShortMessageSendDO shortMessageSendDOTemp:resultList) {
    					ShortMessageSendDTO shortMessageSendDTOTemp = new ShortMessageSendDTO();
    					BeanUtils.copyProperties(shortMessageSendDOTemp,shortMessageSendDTOTemp);
    					listShortMessageSendDTO.add(shortMessageSendDTOTemp);
    				}
    				resultData.setData(listShortMessageSendDTO);
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
