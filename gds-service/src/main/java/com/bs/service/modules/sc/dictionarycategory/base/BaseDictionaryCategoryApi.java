package com.bs.service.modules.sc.dictionarycategory.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.DictionaryCategoryDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryService;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseDictionaryCategoryApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<DictionaryCategoryDO> redisService;
	
	@Autowired
	protected DictionaryCategoryService dictionaryCategoryService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,DictionaryCategoryDO dictionaryCategoryDO);

	public ResultData<DictionaryCategoryDTO> save(DictionaryCategoryDTO dictionaryCategoryDTO){
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			//bean 拷贝
			BeanUtils.copyProperties(dictionaryCategoryDTO,dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryCategoryService.save(dictionaryCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(dictionaryCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(dictionaryCategoryDTO);
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

	public ResultData<DictionaryCategoryDTO> updateById(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryCategoryService.updateById(dictionaryCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(dictionaryCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(dictionaryCategoryDTO);
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
	
	public ResultData<DictionaryCategoryDTO> updateCriteria(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryCategoryService.updateCriteria(dictionaryCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(dictionaryCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(dictionaryCategoryDTO);
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
	
	public ResultData<DictionaryCategoryDTO> removeCriteria(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryCategoryService.removeCriteria(dictionaryCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(dictionaryCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(dictionaryCategoryDTO);
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
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			dictionaryCategoryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = dictionaryCategoryService.removeById(id);
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

	public ResultData<DictionaryCategoryDTO> removeAll() {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			dictionaryCategoryService.removeAll();
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
	
	public ResultData<List<DictionaryCategoryDTO>> listCriteria(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<List<DictionaryCategoryDTO>> resultData = new ResultData<List<DictionaryCategoryDTO>>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<DictionaryCategoryDO> resultList = dictionaryCategoryService.listCriteria(dictionaryCategoryDO);
			if (resultList != null) {
				List<DictionaryCategoryDTO> listDictionaryCategoryDTO = new ArrayList<DictionaryCategoryDTO>(resultList.size());
				for (DictionaryCategoryDO dictionaryCategoryDOTemp:resultList) {
					DictionaryCategoryDTO dictionaryCategoryDTOTemp = new DictionaryCategoryDTO();
					BeanUtils.copyProperties(dictionaryCategoryDOTemp,dictionaryCategoryDTOTemp);
					listDictionaryCategoryDTO.add(dictionaryCategoryDTOTemp);
				}
				resultData.setData(listDictionaryCategoryDTO);
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

	public ResultData<List<DictionaryCategoryDTO>> listAll() {
		ResultData<List<DictionaryCategoryDTO>> resultData = new ResultData<List<DictionaryCategoryDTO>>();
		try {
			List<DictionaryCategoryDO> resultList = dictionaryCategoryService.listAll();
			if (resultList != null) {
				List<DictionaryCategoryDTO> listDictionaryCategoryDTO = new ArrayList<DictionaryCategoryDTO>(resultList.size());
				for (DictionaryCategoryDO dictionaryCategoryDOTemp:resultList) {
					DictionaryCategoryDTO dictionaryCategoryDTOTemp = new DictionaryCategoryDTO();
					BeanUtils.copyProperties(dictionaryCategoryDOTemp,dictionaryCategoryDTOTemp);
					listDictionaryCategoryDTO.add(dictionaryCategoryDTOTemp);
				}
				resultData.setData(listDictionaryCategoryDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(DictionaryCategoryDTO dictionaryCategoryDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = dictionaryCategoryService.listIdsCriteria(dictionaryCategoryDO);
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
	
	public ResultData<List<DictionaryCategoryDTO>> listByInIds(DictionaryCategoryDTO dictionaryCategoryDTO){
		ResultData<List<DictionaryCategoryDTO>> resultData = new ResultData<List<DictionaryCategoryDTO>>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<DictionaryCategoryDO> resultList = dictionaryCategoryService.listByInIds(dictionaryCategoryDO);
			if (resultList != null) {
				List<DictionaryCategoryDTO> listDictionaryCategoryDTO = new ArrayList<DictionaryCategoryDTO>(resultList.size());
				for (DictionaryCategoryDO dictionaryCategoryDOTemp:resultList) {
					DictionaryCategoryDTO dictionaryCategoryDTOTemp = new DictionaryCategoryDTO();
					BeanUtils.copyProperties(dictionaryCategoryDOTemp,dictionaryCategoryDTOTemp);
					listDictionaryCategoryDTO.add(dictionaryCategoryDTOTemp);
				}
				resultData.setData(listDictionaryCategoryDTO);
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
	
	public ResultData<DictionaryCategoryDTO> getOneById(Long id) {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			//验证输入参数
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			dictionaryCategoryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			DictionaryCategoryDO resultDictionaryCategoryDO = dictionaryCategoryService.getOneById(id);
			if (resultDictionaryCategoryDO != null) {
				DictionaryCategoryDTO resultDictionaryCategoryDTO = new DictionaryCategoryDTO();
				BeanUtils.copyProperties(resultDictionaryCategoryDO, resultDictionaryCategoryDTO);
				resultData.setData(resultDictionaryCategoryDTO);
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

	public ResultData<DictionaryCategoryDTO> getOneCriteria(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<DictionaryCategoryDTO> resultData = new ResultData<DictionaryCategoryDTO>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			DictionaryCategoryDO resultDictionaryCategoryDO = dictionaryCategoryService.getOneCriteria(dictionaryCategoryDO);
			if (resultDictionaryCategoryDO != null) {
				DictionaryCategoryDTO resultDictionaryCategoryDTO = new DictionaryCategoryDTO();
				BeanUtils.copyProperties(resultDictionaryCategoryDO, resultDictionaryCategoryDTO);
				resultData.setData(resultDictionaryCategoryDTO);
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

	public ResultData<List<DictionaryCategoryDTO>> paginated(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<List<DictionaryCategoryDTO>> resultData = new ResultData<List<DictionaryCategoryDTO>>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<DictionaryCategoryDO> pageInfo = dictionaryCategoryService.listPaginated(dictionaryCategoryDO);
			if (pageInfo != null) {
				List<DictionaryCategoryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<DictionaryCategoryDTO> listDictionaryCategoryDTO = new ArrayList<DictionaryCategoryDTO>(resultList.size());
    				for (DictionaryCategoryDO dictionaryCategoryDOTemp:resultList) {
    					DictionaryCategoryDTO dictionaryCategoryDTOTemp = new DictionaryCategoryDTO();
    					BeanUtils.copyProperties(dictionaryCategoryDOTemp,dictionaryCategoryDTOTemp);
    					listDictionaryCategoryDTO.add(dictionaryCategoryDTOTemp);
    				}
    				resultData.setData(listDictionaryCategoryDTO);
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
	
	public ResultData<List<DictionaryCategoryDTO>> paginatedManual(DictionaryCategoryDTO dictionaryCategoryDTO) {
		ResultData<List<DictionaryCategoryDTO>> resultData = new ResultData<List<DictionaryCategoryDTO>>();
		try {
			DictionaryCategoryDO dictionaryCategoryDO = new DictionaryCategoryDO();
			BeanUtils.copyProperties(dictionaryCategoryDTO, dictionaryCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(dictionaryCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", dictionaryCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<DictionaryCategoryDO> pageInfo = dictionaryCategoryService.listPaginatedManual(dictionaryCategoryDO);
			if (pageInfo != null) {
				List<DictionaryCategoryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<DictionaryCategoryDTO> listDictionaryCategoryDTO = new ArrayList<DictionaryCategoryDTO>(resultList.size());
    				for (DictionaryCategoryDO dictionaryCategoryDOTemp:resultList) {
    					DictionaryCategoryDTO dictionaryCategoryDTOTemp = new DictionaryCategoryDTO();
    					BeanUtils.copyProperties(dictionaryCategoryDOTemp,dictionaryCategoryDTOTemp);
    					listDictionaryCategoryDTO.add(dictionaryCategoryDTOTemp);
    				}
    				resultData.setData(listDictionaryCategoryDTO);
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
