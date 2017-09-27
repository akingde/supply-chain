package com.bs.service.modules.mc.shortmessagesent.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.mc.dto.ShortMessageSentDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentService;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageSentApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<ShortMessageSentDO> redisService;
	
	@Autowired
	protected ShortMessageSentService shortMessageSentService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,ShortMessageSentDO shortMessageSentDO);

	public ResultData<ShortMessageSentDTO> save(ShortMessageSentDTO shortMessageSentDTO){
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			//bean 拷贝
			BeanUtils.copyProperties(shortMessageSentDTO,shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSentService.save(shortMessageSentDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageSentDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageSentDTO);
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

	public ResultData<ShortMessageSentDTO> updateById(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSentService.updateById(shortMessageSentDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageSentDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageSentDTO);
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
	
	public ResultData<ShortMessageSentDTO> updateCriteria(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSentService.updateCriteria(shortMessageSentDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageSentDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageSentDTO);
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
	
	public ResultData<ShortMessageSentDTO> removeCriteria(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSentService.removeCriteria(shortMessageSentDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageSentDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageSentDTO);
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

	
	public ResultData<Long> removeById(Long id) {
		ResultData<Long> resultData = new ResultData<Long>();
		try {
			//验证输入参数
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			shortMessageSentDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageSentService.removeById(id);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(id);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(id);
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

	public ResultData<ShortMessageSentDTO> removeAll() {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			shortMessageSentService.removeAll();
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"removeAll",ResultCode.RCODE_SUCCESS, null);
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
	
	public ResultData<List<ShortMessageSentDTO>> listCriteria(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<List<ShortMessageSentDTO>> resultData = new ResultData<List<ShortMessageSentDTO>>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<ShortMessageSentDO> resultList = shortMessageSentService.listCriteria(shortMessageSentDO);
			if (resultList != null) {
				List<ShortMessageSentDTO> listShortMessageSentDTO = new ArrayList<ShortMessageSentDTO>(resultList.size());
				for (ShortMessageSentDO shortMessageSentDOTemp:resultList) {
					ShortMessageSentDTO shortMessageSentDTOTemp = new ShortMessageSentDTO();
					BeanUtils.copyProperties(shortMessageSentDOTemp,shortMessageSentDTOTemp);
					listShortMessageSentDTO.add(shortMessageSentDTOTemp);
				}
				resultData.setData(listShortMessageSentDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listCriteria",ResultCode.RCODE_SUCCESS, null);
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

	public ResultData<List<ShortMessageSentDTO>> listAll() {
		ResultData<List<ShortMessageSentDTO>> resultData = new ResultData<List<ShortMessageSentDTO>>();
		try {
			List<ShortMessageSentDO> resultList = shortMessageSentService.listAll();
			if (resultList != null) {
				List<ShortMessageSentDTO> listShortMessageSentDTO = new ArrayList<ShortMessageSentDTO>(resultList.size());
				for (ShortMessageSentDO shortMessageSentDOTemp:resultList) {
					ShortMessageSentDTO shortMessageSentDTOTemp = new ShortMessageSentDTO();
					BeanUtils.copyProperties(shortMessageSentDOTemp,shortMessageSentDTOTemp);
					listShortMessageSentDTO.add(shortMessageSentDTOTemp);
				}
				resultData.setData(listShortMessageSentDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listAll",ResultCode.RCODE_SUCCESS, null);
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
	
	public ResultData<List<Long>> listIdsCriteria(ShortMessageSentDTO shortMessageSentDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = shortMessageSentService.listIdsCriteria(shortMessageSentDO);
			resultData.setData(resultList);
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listIdsCriteria",ResultCode.RCODE_SUCCESS, null);
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
	
	public ResultData<List<ShortMessageSentDTO>> listByInIds(ShortMessageSentDTO shortMessageSentDTO){
		ResultData<List<ShortMessageSentDTO>> resultData = new ResultData<List<ShortMessageSentDTO>>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<ShortMessageSentDO> resultList = shortMessageSentService.listByInIds(shortMessageSentDO);
			if (resultList != null) {
				List<ShortMessageSentDTO> listShortMessageSentDTO = new ArrayList<ShortMessageSentDTO>(resultList.size());
				for (ShortMessageSentDO shortMessageSentDOTemp:resultList) {
					ShortMessageSentDTO shortMessageSentDTOTemp = new ShortMessageSentDTO();
					BeanUtils.copyProperties(shortMessageSentDOTemp,shortMessageSentDTOTemp);
					listShortMessageSentDTO.add(shortMessageSentDTOTemp);
				}
				resultData.setData(listShortMessageSentDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listByInIds",ResultCode.RCODE_SUCCESS, null);
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
	
	public ResultData<ShortMessageSentDTO> getOneById(Long id) {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			//验证输入参数
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			shortMessageSentDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageSentDO resultShortMessageSentDO = shortMessageSentService.getOneById(id);
			if (resultShortMessageSentDO != null) {
				ShortMessageSentDTO resultShortMessageSentDTO = new ShortMessageSentDTO();
				BeanUtils.copyProperties(resultShortMessageSentDO, resultShortMessageSentDTO);
				resultData.setData(resultShortMessageSentDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"getOneById",ResultCode.RCODE_SUCCESS, null);
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

	public ResultData<ShortMessageSentDTO> getOneCriteria(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<ShortMessageSentDTO> resultData = new ResultData<ShortMessageSentDTO>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageSentDO resultShortMessageSentDO = shortMessageSentService.getOneCriteria(shortMessageSentDO);
			if (resultShortMessageSentDO != null) {
				ShortMessageSentDTO resultShortMessageSentDTO = new ShortMessageSentDTO();
				BeanUtils.copyProperties(resultShortMessageSentDO, resultShortMessageSentDTO);
				resultData.setData(resultShortMessageSentDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"getOneCriteria",ResultCode.RCODE_SUCCESS, null);
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

	public ResultData<List<ShortMessageSentDTO>> paginated(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<List<ShortMessageSentDTO>> resultData = new ResultData<List<ShortMessageSentDTO>>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageSentDO> pageInfo = shortMessageSentService.listPaginated(shortMessageSentDO);
			if (pageInfo != null) {
				List<ShortMessageSentDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageSentDTO> listShortMessageSentDTO = new ArrayList<ShortMessageSentDTO>(resultList.size());
    				for (ShortMessageSentDO shortMessageSentDOTemp:resultList) {
    					ShortMessageSentDTO shortMessageSentDTOTemp = new ShortMessageSentDTO();
    					BeanUtils.copyProperties(shortMessageSentDOTemp,shortMessageSentDTOTemp);
    					listShortMessageSentDTO.add(shortMessageSentDTOTemp);
    				}
    				resultData.setData(listShortMessageSentDTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"paginated",ResultCode.RCODE_SUCCESS, null);
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
	
	public ResultData<List<ShortMessageSentDTO>> paginatedManual(ShortMessageSentDTO shortMessageSentDTO) {
		ResultData<List<ShortMessageSentDTO>> resultData = new ResultData<List<ShortMessageSentDTO>>();
		try {
			ShortMessageSentDO shortMessageSentDO = new ShortMessageSentDO();
			BeanUtils.copyProperties(shortMessageSentDTO, shortMessageSentDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(shortMessageSentDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", shortMessageSentDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageSentDO> pageInfo = shortMessageSentService.listPaginatedManual(shortMessageSentDO);
			if (pageInfo != null) {
				List<ShortMessageSentDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageSentDTO> listShortMessageSentDTO = new ArrayList<ShortMessageSentDTO>(resultList.size());
    				for (ShortMessageSentDO shortMessageSentDOTemp:resultList) {
    					ShortMessageSentDTO shortMessageSentDTOTemp = new ShortMessageSentDTO();
    					BeanUtils.copyProperties(shortMessageSentDOTemp,shortMessageSentDTOTemp);
    					listShortMessageSentDTO.add(shortMessageSentDTOTemp);
    				}
    				resultData.setData(listShortMessageSentDTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"paginatedManual",ResultCode.RCODE_SUCCESS, null);
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
}
