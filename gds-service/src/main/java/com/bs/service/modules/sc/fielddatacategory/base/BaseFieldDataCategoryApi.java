package com.bs.service.modules.sc.fielddatacategory.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.FieldDataCategoryDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryService;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseFieldDataCategoryApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<FieldDataCategoryDO> redisService;
	
	@Autowired
	protected FieldDataCategoryService fieldDataCategoryService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,FieldDataCategoryDO fieldDataCategoryDO);

	public ResultData<FieldDataCategoryDTO> save(FieldDataCategoryDTO fieldDataCategoryDTO){
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			//bean 拷贝
			BeanUtils.copyProperties(fieldDataCategoryDTO,fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataCategoryService.save(fieldDataCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(fieldDataCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(fieldDataCategoryDTO);
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

	public ResultData<FieldDataCategoryDTO> updateById(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataCategoryService.updateById(fieldDataCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(fieldDataCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(fieldDataCategoryDTO);
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
	
	public ResultData<FieldDataCategoryDTO> updateCriteria(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataCategoryService.updateCriteria(fieldDataCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(fieldDataCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(fieldDataCategoryDTO);
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
	
	public ResultData<FieldDataCategoryDTO> removeCriteria(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataCategoryService.removeCriteria(fieldDataCategoryDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(fieldDataCategoryDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(fieldDataCategoryDTO);
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
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			fieldDataCategoryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = fieldDataCategoryService.removeById(id);
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

	public ResultData<FieldDataCategoryDTO> removeAll() {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			fieldDataCategoryService.removeAll();
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
	
	public ResultData<List<FieldDataCategoryDTO>> listCriteria(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<List<FieldDataCategoryDTO>> resultData = new ResultData<List<FieldDataCategoryDTO>>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<FieldDataCategoryDO> resultList = fieldDataCategoryService.listCriteria(fieldDataCategoryDO);
			if (resultList != null) {
				List<FieldDataCategoryDTO> listFieldDataCategoryDTO = new ArrayList<FieldDataCategoryDTO>(resultList.size());
				for (FieldDataCategoryDO fieldDataCategoryDOTemp:resultList) {
					FieldDataCategoryDTO fieldDataCategoryDTOTemp = new FieldDataCategoryDTO();
					BeanUtils.copyProperties(fieldDataCategoryDOTemp,fieldDataCategoryDTOTemp);
					listFieldDataCategoryDTO.add(fieldDataCategoryDTOTemp);
				}
				resultData.setData(listFieldDataCategoryDTO);
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

	public ResultData<List<FieldDataCategoryDTO>> listAll() {
		ResultData<List<FieldDataCategoryDTO>> resultData = new ResultData<List<FieldDataCategoryDTO>>();
		try {
			List<FieldDataCategoryDO> resultList = fieldDataCategoryService.listAll();
			if (resultList != null) {
				List<FieldDataCategoryDTO> listFieldDataCategoryDTO = new ArrayList<FieldDataCategoryDTO>(resultList.size());
				for (FieldDataCategoryDO fieldDataCategoryDOTemp:resultList) {
					FieldDataCategoryDTO fieldDataCategoryDTOTemp = new FieldDataCategoryDTO();
					BeanUtils.copyProperties(fieldDataCategoryDOTemp,fieldDataCategoryDTOTemp);
					listFieldDataCategoryDTO.add(fieldDataCategoryDTOTemp);
				}
				resultData.setData(listFieldDataCategoryDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(FieldDataCategoryDTO fieldDataCategoryDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = fieldDataCategoryService.listIdsCriteria(fieldDataCategoryDO);
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
	
	public ResultData<List<FieldDataCategoryDTO>> listByInIds(FieldDataCategoryDTO fieldDataCategoryDTO){
		ResultData<List<FieldDataCategoryDTO>> resultData = new ResultData<List<FieldDataCategoryDTO>>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<FieldDataCategoryDO> resultList = fieldDataCategoryService.listByInIds(fieldDataCategoryDO);
			if (resultList != null) {
				List<FieldDataCategoryDTO> listFieldDataCategoryDTO = new ArrayList<FieldDataCategoryDTO>(resultList.size());
				for (FieldDataCategoryDO fieldDataCategoryDOTemp:resultList) {
					FieldDataCategoryDTO fieldDataCategoryDTOTemp = new FieldDataCategoryDTO();
					BeanUtils.copyProperties(fieldDataCategoryDOTemp,fieldDataCategoryDTOTemp);
					listFieldDataCategoryDTO.add(fieldDataCategoryDTOTemp);
				}
				resultData.setData(listFieldDataCategoryDTO);
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
	
	public ResultData<FieldDataCategoryDTO> getOneById(Long id) {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			//验证输入参数
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			fieldDataCategoryDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			FieldDataCategoryDO resultFieldDataCategoryDO = fieldDataCategoryService.getOneById(id);
			if (resultFieldDataCategoryDO != null) {
				FieldDataCategoryDTO resultFieldDataCategoryDTO = new FieldDataCategoryDTO();
				BeanUtils.copyProperties(resultFieldDataCategoryDO, resultFieldDataCategoryDTO);
				resultData.setData(resultFieldDataCategoryDTO);
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

	public ResultData<FieldDataCategoryDTO> getOneCriteria(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<FieldDataCategoryDTO> resultData = new ResultData<FieldDataCategoryDTO>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			FieldDataCategoryDO resultFieldDataCategoryDO = fieldDataCategoryService.getOneCriteria(fieldDataCategoryDO);
			if (resultFieldDataCategoryDO != null) {
				FieldDataCategoryDTO resultFieldDataCategoryDTO = new FieldDataCategoryDTO();
				BeanUtils.copyProperties(resultFieldDataCategoryDO, resultFieldDataCategoryDTO);
				resultData.setData(resultFieldDataCategoryDTO);
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

	public ResultData<List<FieldDataCategoryDTO>> paginated(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<List<FieldDataCategoryDTO>> resultData = new ResultData<List<FieldDataCategoryDTO>>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<FieldDataCategoryDO> pageInfo = fieldDataCategoryService.listPaginated(fieldDataCategoryDO);
			if (pageInfo != null) {
				List<FieldDataCategoryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<FieldDataCategoryDTO> listFieldDataCategoryDTO = new ArrayList<FieldDataCategoryDTO>(resultList.size());
    				for (FieldDataCategoryDO fieldDataCategoryDOTemp:resultList) {
    					FieldDataCategoryDTO fieldDataCategoryDTOTemp = new FieldDataCategoryDTO();
    					BeanUtils.copyProperties(fieldDataCategoryDOTemp,fieldDataCategoryDTOTemp);
    					listFieldDataCategoryDTO.add(fieldDataCategoryDTOTemp);
    				}
    				resultData.setData(listFieldDataCategoryDTO);
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
	
	public ResultData<List<FieldDataCategoryDTO>> paginatedManual(FieldDataCategoryDTO fieldDataCategoryDTO) {
		ResultData<List<FieldDataCategoryDTO>> resultData = new ResultData<List<FieldDataCategoryDTO>>();
		try {
			FieldDataCategoryDO fieldDataCategoryDO = new FieldDataCategoryDO();
			BeanUtils.copyProperties(fieldDataCategoryDTO, fieldDataCategoryDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(fieldDataCategoryDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", fieldDataCategoryDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<FieldDataCategoryDO> pageInfo = fieldDataCategoryService.listPaginatedManual(fieldDataCategoryDO);
			if (pageInfo != null) {
				List<FieldDataCategoryDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<FieldDataCategoryDTO> listFieldDataCategoryDTO = new ArrayList<FieldDataCategoryDTO>(resultList.size());
    				for (FieldDataCategoryDO fieldDataCategoryDOTemp:resultList) {
    					FieldDataCategoryDTO fieldDataCategoryDTOTemp = new FieldDataCategoryDTO();
    					BeanUtils.copyProperties(fieldDataCategoryDOTemp,fieldDataCategoryDTOTemp);
    					listFieldDataCategoryDTO.add(fieldDataCategoryDTOTemp);
    				}
    				resultData.setData(listFieldDataCategoryDTO);
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
