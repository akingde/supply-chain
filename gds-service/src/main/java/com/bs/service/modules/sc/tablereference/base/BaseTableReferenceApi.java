package com.bs.service.modules.sc.tablereference.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.TableReferenceDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.tablereference.TableReferenceService;
import com.bs.service.modules.sc.tablereference.TableReferenceDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseTableReferenceApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<TableReferenceDO> redisService;
	
	@Autowired
	protected TableReferenceService tableReferenceService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,TableReferenceDO tableReferenceDO);

	public ResultData<TableReferenceDTO> save(TableReferenceDTO tableReferenceDTO){
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			//bean 拷贝
			BeanUtils.copyProperties(tableReferenceDTO,tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableReferenceService.save(tableReferenceDO);
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

	public ResultData<TableReferenceDTO> updateById(TableReferenceDTO tableReferenceDTO) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableReferenceService.updateById(tableReferenceDO);
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
	
	public ResultData<TableReferenceDTO> updateCriteria(TableReferenceDTO tableReferenceDTO) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableReferenceService.updateCriteria(tableReferenceDO);
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
	
	public ResultData<TableReferenceDTO> removeCriteria(TableReferenceDTO tableReferenceDTO) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableReferenceService.removeCriteria(tableReferenceDO);
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

	
	public ResultData<TableReferenceDTO> removeById(Long id) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			//验证输入参数
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			tableReferenceDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableReferenceService.removeById(id);
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

	public ResultData<TableReferenceDTO> removeAll() {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			tableReferenceService.removeAll();
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
	
	public ResultData<List<TableReferenceDTO>> listCriteria(TableReferenceDTO tableReferenceDTO) {
		ResultData<List<TableReferenceDTO>> resultData = new ResultData<List<TableReferenceDTO>>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<TableReferenceDO> resultList = tableReferenceService.listCriteria(tableReferenceDO);
			if (resultList != null) {
				List<TableReferenceDTO> listTableReferenceDTO = new ArrayList<TableReferenceDTO>(resultList.size());
				for (TableReferenceDO tableReferenceDOTemp:resultList) {
					TableReferenceDTO tableReferenceDTOTemp = new TableReferenceDTO();
					BeanUtils.copyProperties(tableReferenceDOTemp,tableReferenceDTOTemp);
					listTableReferenceDTO.add(tableReferenceDTOTemp);
				}
				resultData.setData(listTableReferenceDTO);
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

	public ResultData<List<TableReferenceDTO>> listAll() {
		ResultData<List<TableReferenceDTO>> resultData = new ResultData<List<TableReferenceDTO>>();
		try {
			List<TableReferenceDO> resultList = tableReferenceService.listAll();
			if (resultList != null) {
				List<TableReferenceDTO> listTableReferenceDTO = new ArrayList<TableReferenceDTO>(resultList.size());
				for (TableReferenceDO tableReferenceDOTemp:resultList) {
					TableReferenceDTO tableReferenceDTOTemp = new TableReferenceDTO();
					BeanUtils.copyProperties(tableReferenceDOTemp,tableReferenceDTOTemp);
					listTableReferenceDTO.add(tableReferenceDTOTemp);
				}
				resultData.setData(listTableReferenceDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(TableReferenceDTO tableReferenceDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = tableReferenceService.listIdsCriteria(tableReferenceDO);
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
	
	public ResultData<List<TableReferenceDTO>> listByInIds(TableReferenceDTO tableReferenceDTO){
		ResultData<List<TableReferenceDTO>> resultData = new ResultData<List<TableReferenceDTO>>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<TableReferenceDO> resultList = tableReferenceService.listByInIds(tableReferenceDO);
			if (resultList != null) {
				List<TableReferenceDTO> listTableReferenceDTO = new ArrayList<TableReferenceDTO>(resultList.size());
				for (TableReferenceDO tableReferenceDOTemp:resultList) {
					TableReferenceDTO tableReferenceDTOTemp = new TableReferenceDTO();
					BeanUtils.copyProperties(tableReferenceDOTemp,tableReferenceDTOTemp);
					listTableReferenceDTO.add(tableReferenceDTOTemp);
				}
				resultData.setData(listTableReferenceDTO);
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
	
	public ResultData<TableReferenceDTO> getOneById(Long id) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			//验证输入参数
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			tableReferenceDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableReferenceDO resultTableReferenceDO = tableReferenceService.getOneById(id);
			if (resultTableReferenceDO != null) {
				TableReferenceDTO resultTableReferenceDTO = new TableReferenceDTO();
				BeanUtils.copyProperties(resultTableReferenceDO, resultTableReferenceDTO);
				resultData.setData(resultTableReferenceDTO);
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

	public ResultData<TableReferenceDTO> getOneCriteria(TableReferenceDTO tableReferenceDTO) {
		ResultData<TableReferenceDTO> resultData = new ResultData<TableReferenceDTO>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableReferenceDO resultTableReferenceDO = tableReferenceService.getOneCriteria(tableReferenceDO);
			if (resultTableReferenceDO != null) {
				TableReferenceDTO resultTableReferenceDTO = new TableReferenceDTO();
				BeanUtils.copyProperties(resultTableReferenceDO, resultTableReferenceDTO);
				resultData.setData(resultTableReferenceDTO);
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

	public ResultData<List<TableReferenceDTO>> paginated(TableReferenceDTO tableReferenceDTO) {
		ResultData<List<TableReferenceDTO>> resultData = new ResultData<List<TableReferenceDTO>>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableReferenceDO> pageInfo = tableReferenceService.listPaginated(tableReferenceDO);
			if (pageInfo != null) {
				List<TableReferenceDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableReferenceDTO> listTableReferenceDTO = new ArrayList<TableReferenceDTO>(resultList.size());
    				for (TableReferenceDO tableReferenceDOTemp:resultList) {
    					TableReferenceDTO tableReferenceDTOTemp = new TableReferenceDTO();
    					BeanUtils.copyProperties(tableReferenceDOTemp,tableReferenceDTOTemp);
    					listTableReferenceDTO.add(tableReferenceDTOTemp);
    				}
    				resultData.setData(listTableReferenceDTO);
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
	
	public ResultData<List<TableReferenceDTO>> paginatedManual(TableReferenceDTO tableReferenceDTO) {
		ResultData<List<TableReferenceDTO>> resultData = new ResultData<List<TableReferenceDTO>>();
		try {
			TableReferenceDO tableReferenceDO = new TableReferenceDO();
			BeanUtils.copyProperties(tableReferenceDTO, tableReferenceDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(tableReferenceDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", tableReferenceDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableReferenceDO> pageInfo = tableReferenceService.listPaginatedManual(tableReferenceDO);
			if (pageInfo != null) {
				List<TableReferenceDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableReferenceDTO> listTableReferenceDTO = new ArrayList<TableReferenceDTO>(resultList.size());
    				for (TableReferenceDO tableReferenceDOTemp:resultList) {
    					TableReferenceDTO tableReferenceDTOTemp = new TableReferenceDTO();
    					BeanUtils.copyProperties(tableReferenceDOTemp,tableReferenceDTOTemp);
    					listTableReferenceDTO.add(tableReferenceDTOTemp);
    				}
    				resultData.setData(listTableReferenceDTO);
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
