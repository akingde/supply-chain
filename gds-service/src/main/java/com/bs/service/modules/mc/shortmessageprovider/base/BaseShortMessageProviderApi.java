package com.bs.service.modules.mc.shortmessageprovider.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.mc.dto.ShortMessageProviderDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderService;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageProviderApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<ShortMessageProviderDO> redisService;
	
	@Autowired
	protected ShortMessageProviderService shortMessageProviderService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,ShortMessageProviderDO shortMessageProviderDO);

	public ResultData<ShortMessageProviderDTO> save(ShortMessageProviderDTO shortMessageProviderDTO){
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			//bean 拷贝
			BeanUtils.copyProperties(shortMessageProviderDTO,shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageProviderService.save(shortMessageProviderDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageProviderDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageProviderDTO);
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

	public ResultData<ShortMessageProviderDTO> updateById(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageProviderService.updateById(shortMessageProviderDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageProviderDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageProviderDTO);
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
	
	public ResultData<ShortMessageProviderDTO> updateCriteria(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageProviderService.updateCriteria(shortMessageProviderDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageProviderDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageProviderDTO);
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
	
	public ResultData<ShortMessageProviderDTO> removeCriteria(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageProviderService.removeCriteria(shortMessageProviderDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(shortMessageProviderDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(shortMessageProviderDTO);
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
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			shortMessageProviderDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = shortMessageProviderService.removeById(id);
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

	public ResultData<ShortMessageProviderDTO> removeAll() {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			shortMessageProviderService.removeAll();
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
	
	public ResultData<List<ShortMessageProviderDTO>> listCriteria(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<List<ShortMessageProviderDTO>> resultData = new ResultData<List<ShortMessageProviderDTO>>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<ShortMessageProviderDO> resultList = shortMessageProviderService.listCriteria(shortMessageProviderDO);
			if (resultList != null) {
				List<ShortMessageProviderDTO> listShortMessageProviderDTO = new ArrayList<ShortMessageProviderDTO>(resultList.size());
				for (ShortMessageProviderDO shortMessageProviderDOTemp:resultList) {
					ShortMessageProviderDTO shortMessageProviderDTOTemp = new ShortMessageProviderDTO();
					BeanUtils.copyProperties(shortMessageProviderDOTemp,shortMessageProviderDTOTemp);
					listShortMessageProviderDTO.add(shortMessageProviderDTOTemp);
				}
				resultData.setData(listShortMessageProviderDTO);
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

	public ResultData<List<ShortMessageProviderDTO>> listAll() {
		ResultData<List<ShortMessageProviderDTO>> resultData = new ResultData<List<ShortMessageProviderDTO>>();
		try {
			List<ShortMessageProviderDO> resultList = shortMessageProviderService.listAll();
			if (resultList != null) {
				List<ShortMessageProviderDTO> listShortMessageProviderDTO = new ArrayList<ShortMessageProviderDTO>(resultList.size());
				for (ShortMessageProviderDO shortMessageProviderDOTemp:resultList) {
					ShortMessageProviderDTO shortMessageProviderDTOTemp = new ShortMessageProviderDTO();
					BeanUtils.copyProperties(shortMessageProviderDOTemp,shortMessageProviderDTOTemp);
					listShortMessageProviderDTO.add(shortMessageProviderDTOTemp);
				}
				resultData.setData(listShortMessageProviderDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(ShortMessageProviderDTO shortMessageProviderDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = shortMessageProviderService.listIdsCriteria(shortMessageProviderDO);
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
	
	public ResultData<List<ShortMessageProviderDTO>> listByInIds(ShortMessageProviderDTO shortMessageProviderDTO){
		ResultData<List<ShortMessageProviderDTO>> resultData = new ResultData<List<ShortMessageProviderDTO>>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<ShortMessageProviderDO> resultList = shortMessageProviderService.listByInIds(shortMessageProviderDO);
			if (resultList != null) {
				List<ShortMessageProviderDTO> listShortMessageProviderDTO = new ArrayList<ShortMessageProviderDTO>(resultList.size());
				for (ShortMessageProviderDO shortMessageProviderDOTemp:resultList) {
					ShortMessageProviderDTO shortMessageProviderDTOTemp = new ShortMessageProviderDTO();
					BeanUtils.copyProperties(shortMessageProviderDOTemp,shortMessageProviderDTOTemp);
					listShortMessageProviderDTO.add(shortMessageProviderDTOTemp);
				}
				resultData.setData(listShortMessageProviderDTO);
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
	
	public ResultData<ShortMessageProviderDTO> getOneById(Long id) {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			//验证输入参数
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			shortMessageProviderDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageProviderDO resultShortMessageProviderDO = shortMessageProviderService.getOneById(id);
			if (resultShortMessageProviderDO != null) {
				ShortMessageProviderDTO resultShortMessageProviderDTO = new ShortMessageProviderDTO();
				BeanUtils.copyProperties(resultShortMessageProviderDO, resultShortMessageProviderDTO);
				resultData.setData(resultShortMessageProviderDTO);
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

	public ResultData<ShortMessageProviderDTO> getOneCriteria(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<ShortMessageProviderDTO> resultData = new ResultData<ShortMessageProviderDTO>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			ShortMessageProviderDO resultShortMessageProviderDO = shortMessageProviderService.getOneCriteria(shortMessageProviderDO);
			if (resultShortMessageProviderDO != null) {
				ShortMessageProviderDTO resultShortMessageProviderDTO = new ShortMessageProviderDTO();
				BeanUtils.copyProperties(resultShortMessageProviderDO, resultShortMessageProviderDTO);
				resultData.setData(resultShortMessageProviderDTO);
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

	public ResultData<List<ShortMessageProviderDTO>> paginated(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<List<ShortMessageProviderDTO>> resultData = new ResultData<List<ShortMessageProviderDTO>>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageProviderDO> pageInfo = shortMessageProviderService.listPaginated(shortMessageProviderDO);
			if (pageInfo != null) {
				List<ShortMessageProviderDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageProviderDTO> listShortMessageProviderDTO = new ArrayList<ShortMessageProviderDTO>(resultList.size());
    				for (ShortMessageProviderDO shortMessageProviderDOTemp:resultList) {
    					ShortMessageProviderDTO shortMessageProviderDTOTemp = new ShortMessageProviderDTO();
    					BeanUtils.copyProperties(shortMessageProviderDOTemp,shortMessageProviderDTOTemp);
    					listShortMessageProviderDTO.add(shortMessageProviderDTOTemp);
    				}
    				resultData.setData(listShortMessageProviderDTO);
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
	
	public ResultData<List<ShortMessageProviderDTO>> paginatedManual(ShortMessageProviderDTO shortMessageProviderDTO) {
		ResultData<List<ShortMessageProviderDTO>> resultData = new ResultData<List<ShortMessageProviderDTO>>();
		try {
			ShortMessageProviderDO shortMessageProviderDO = new ShortMessageProviderDO();
			BeanUtils.copyProperties(shortMessageProviderDTO, shortMessageProviderDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(shortMessageProviderDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", shortMessageProviderDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<ShortMessageProviderDO> pageInfo = shortMessageProviderService.listPaginatedManual(shortMessageProviderDO);
			if (pageInfo != null) {
				List<ShortMessageProviderDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<ShortMessageProviderDTO> listShortMessageProviderDTO = new ArrayList<ShortMessageProviderDTO>(resultList.size());
    				for (ShortMessageProviderDO shortMessageProviderDOTemp:resultList) {
    					ShortMessageProviderDTO shortMessageProviderDTOTemp = new ShortMessageProviderDTO();
    					BeanUtils.copyProperties(shortMessageProviderDOTemp,shortMessageProviderDTOTemp);
    					listShortMessageProviderDTO.add(shortMessageProviderDTOTemp);
    				}
    				resultData.setData(listShortMessageProviderDTO);
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
