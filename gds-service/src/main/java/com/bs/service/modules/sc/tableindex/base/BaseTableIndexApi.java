package com.bs.service.modules.sc.tableindex.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.TableIndexDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.tableindex.TableIndexService;
import com.bs.service.modules.sc.tableindex.TableIndexDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseTableIndexApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<TableIndexDO> redisService;
	
	@Autowired
	protected TableIndexService tableIndexService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,TableIndexDO tableIndexDO);

	public ResultData<TableIndexDTO> save(TableIndexDTO tableIndexDTO){
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			//bean 拷贝
			BeanUtils.copyProperties(tableIndexDTO,tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableIndexService.save(tableIndexDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableIndexDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableIndexDTO);
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

	public ResultData<TableIndexDTO> updateById(TableIndexDTO tableIndexDTO) {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableIndexService.updateById(tableIndexDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableIndexDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableIndexDTO);
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
	
	public ResultData<TableIndexDTO> updateCriteria(TableIndexDTO tableIndexDTO) {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableIndexService.updateCriteria(tableIndexDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableIndexDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableIndexDTO);
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
	
	public ResultData<TableIndexDTO> removeCriteria(TableIndexDTO tableIndexDTO) {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableIndexService.removeCriteria(tableIndexDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableIndexDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableIndexDTO);
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
			TableIndexDO tableIndexDO = new TableIndexDO();
			tableIndexDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableIndexService.removeById(id);
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

	public ResultData<TableIndexDTO> removeAll() {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			tableIndexService.removeAll();
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
	
	public ResultData<List<TableIndexDTO>> listCriteria(TableIndexDTO tableIndexDTO) {
		ResultData<List<TableIndexDTO>> resultData = new ResultData<List<TableIndexDTO>>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<TableIndexDO> resultList = tableIndexService.listCriteria(tableIndexDO);
			if (resultList != null) {
				List<TableIndexDTO> listTableIndexDTO = new ArrayList<TableIndexDTO>(resultList.size());
				for (TableIndexDO tableIndexDOTemp:resultList) {
					TableIndexDTO tableIndexDTOTemp = new TableIndexDTO();
					BeanUtils.copyProperties(tableIndexDOTemp,tableIndexDTOTemp);
					listTableIndexDTO.add(tableIndexDTOTemp);
				}
				resultData.setData(listTableIndexDTO);
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

	public ResultData<List<TableIndexDTO>> listAll() {
		ResultData<List<TableIndexDTO>> resultData = new ResultData<List<TableIndexDTO>>();
		try {
			List<TableIndexDO> resultList = tableIndexService.listAll();
			if (resultList != null) {
				List<TableIndexDTO> listTableIndexDTO = new ArrayList<TableIndexDTO>(resultList.size());
				for (TableIndexDO tableIndexDOTemp:resultList) {
					TableIndexDTO tableIndexDTOTemp = new TableIndexDTO();
					BeanUtils.copyProperties(tableIndexDOTemp,tableIndexDTOTemp);
					listTableIndexDTO.add(tableIndexDTOTemp);
				}
				resultData.setData(listTableIndexDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(TableIndexDTO tableIndexDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = tableIndexService.listIdsCriteria(tableIndexDO);
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
	
	public ResultData<List<TableIndexDTO>> listByInIds(TableIndexDTO tableIndexDTO){
		ResultData<List<TableIndexDTO>> resultData = new ResultData<List<TableIndexDTO>>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<TableIndexDO> resultList = tableIndexService.listByInIds(tableIndexDO);
			if (resultList != null) {
				List<TableIndexDTO> listTableIndexDTO = new ArrayList<TableIndexDTO>(resultList.size());
				for (TableIndexDO tableIndexDOTemp:resultList) {
					TableIndexDTO tableIndexDTOTemp = new TableIndexDTO();
					BeanUtils.copyProperties(tableIndexDOTemp,tableIndexDTOTemp);
					listTableIndexDTO.add(tableIndexDTOTemp);
				}
				resultData.setData(listTableIndexDTO);
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
	
	public ResultData<TableIndexDTO> getOneById(Long id) {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			//验证输入参数
			TableIndexDO tableIndexDO = new TableIndexDO();
			tableIndexDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableIndexDO resultTableIndexDO = tableIndexService.getOneById(id);
			if (resultTableIndexDO != null) {
				TableIndexDTO resultTableIndexDTO = new TableIndexDTO();
				BeanUtils.copyProperties(resultTableIndexDO, resultTableIndexDTO);
				resultData.setData(resultTableIndexDTO);
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

	public ResultData<TableIndexDTO> getOneCriteria(TableIndexDTO tableIndexDTO) {
		ResultData<TableIndexDTO> resultData = new ResultData<TableIndexDTO>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableIndexDO resultTableIndexDO = tableIndexService.getOneCriteria(tableIndexDO);
			if (resultTableIndexDO != null) {
				TableIndexDTO resultTableIndexDTO = new TableIndexDTO();
				BeanUtils.copyProperties(resultTableIndexDO, resultTableIndexDTO);
				resultData.setData(resultTableIndexDTO);
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

	public ResultData<List<TableIndexDTO>> paginated(TableIndexDTO tableIndexDTO) {
		ResultData<List<TableIndexDTO>> resultData = new ResultData<List<TableIndexDTO>>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableIndexDO> pageInfo = tableIndexService.listPaginated(tableIndexDO);
			if (pageInfo != null) {
				List<TableIndexDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableIndexDTO> listTableIndexDTO = new ArrayList<TableIndexDTO>(resultList.size());
    				for (TableIndexDO tableIndexDOTemp:resultList) {
    					TableIndexDTO tableIndexDTOTemp = new TableIndexDTO();
    					BeanUtils.copyProperties(tableIndexDOTemp,tableIndexDTOTemp);
    					listTableIndexDTO.add(tableIndexDTOTemp);
    				}
    				resultData.setData(listTableIndexDTO);
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
	
	public ResultData<List<TableIndexDTO>> paginatedManual(TableIndexDTO tableIndexDTO) {
		ResultData<List<TableIndexDTO>> resultData = new ResultData<List<TableIndexDTO>>();
		try {
			TableIndexDO tableIndexDO = new TableIndexDO();
			BeanUtils.copyProperties(tableIndexDTO, tableIndexDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(tableIndexDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", tableIndexDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableIndexDO> pageInfo = tableIndexService.listPaginatedManual(tableIndexDO);
			if (pageInfo != null) {
				List<TableIndexDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableIndexDTO> listTableIndexDTO = new ArrayList<TableIndexDTO>(resultList.size());
    				for (TableIndexDO tableIndexDOTemp:resultList) {
    					TableIndexDTO tableIndexDTOTemp = new TableIndexDTO();
    					BeanUtils.copyProperties(tableIndexDOTemp,tableIndexDTOTemp);
    					listTableIndexDTO.add(tableIndexDTOTemp);
    				}
    				resultData.setData(listTableIndexDTO);
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
