package com.bs.service.modules.sc.tablecolumn.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.sc.dto.TableColumnDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.sc.tablecolumn.TableColumnService;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseTableColumnApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<TableColumnDO> redisService;
	
	@Autowired
	protected TableColumnService tableColumnService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,TableColumnDO tableColumnDO);

	public ResultData<TableColumnDTO> save(TableColumnDTO tableColumnDTO){
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			//bean 拷贝
			BeanUtils.copyProperties(tableColumnDTO,tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableColumnService.save(tableColumnDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableColumnDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableColumnDTO);
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

	public ResultData<TableColumnDTO> updateById(TableColumnDTO tableColumnDTO) {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableColumnService.updateById(tableColumnDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableColumnDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableColumnDTO);
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
	
	public ResultData<TableColumnDTO> updateCriteria(TableColumnDTO tableColumnDTO) {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableColumnService.updateCriteria(tableColumnDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableColumnDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableColumnDTO);
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
	
	public ResultData<TableColumnDTO> removeCriteria(TableColumnDTO tableColumnDTO) {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableColumnService.removeCriteria(tableColumnDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(tableColumnDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(tableColumnDTO);
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
			TableColumnDO tableColumnDO = new TableColumnDO();
			tableColumnDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = tableColumnService.removeById(id);
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

	public ResultData<TableColumnDTO> removeAll() {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			tableColumnService.removeAll();
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
	
	public ResultData<List<TableColumnDTO>> listCriteria(TableColumnDTO tableColumnDTO) {
		ResultData<List<TableColumnDTO>> resultData = new ResultData<List<TableColumnDTO>>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<TableColumnDO> resultList = tableColumnService.listCriteria(tableColumnDO);
			if (resultList != null) {
				List<TableColumnDTO> listTableColumnDTO = new ArrayList<TableColumnDTO>(resultList.size());
				for (TableColumnDO tableColumnDOTemp:resultList) {
					TableColumnDTO tableColumnDTOTemp = new TableColumnDTO();
					BeanUtils.copyProperties(tableColumnDOTemp,tableColumnDTOTemp);
					listTableColumnDTO.add(tableColumnDTOTemp);
				}
				resultData.setData(listTableColumnDTO);
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

	public ResultData<List<TableColumnDTO>> listAll() {
		ResultData<List<TableColumnDTO>> resultData = new ResultData<List<TableColumnDTO>>();
		try {
			List<TableColumnDO> resultList = tableColumnService.listAll();
			if (resultList != null) {
				List<TableColumnDTO> listTableColumnDTO = new ArrayList<TableColumnDTO>(resultList.size());
				for (TableColumnDO tableColumnDOTemp:resultList) {
					TableColumnDTO tableColumnDTOTemp = new TableColumnDTO();
					BeanUtils.copyProperties(tableColumnDOTemp,tableColumnDTOTemp);
					listTableColumnDTO.add(tableColumnDTOTemp);
				}
				resultData.setData(listTableColumnDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(TableColumnDTO tableColumnDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = tableColumnService.listIdsCriteria(tableColumnDO);
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
	
	public ResultData<List<TableColumnDTO>> listByInIds(TableColumnDTO tableColumnDTO){
		ResultData<List<TableColumnDTO>> resultData = new ResultData<List<TableColumnDTO>>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<TableColumnDO> resultList = tableColumnService.listByInIds(tableColumnDO);
			if (resultList != null) {
				List<TableColumnDTO> listTableColumnDTO = new ArrayList<TableColumnDTO>(resultList.size());
				for (TableColumnDO tableColumnDOTemp:resultList) {
					TableColumnDTO tableColumnDTOTemp = new TableColumnDTO();
					BeanUtils.copyProperties(tableColumnDOTemp,tableColumnDTOTemp);
					listTableColumnDTO.add(tableColumnDTOTemp);
				}
				resultData.setData(listTableColumnDTO);
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
	
	public ResultData<TableColumnDTO> getOneById(Long id) {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			//验证输入参数
			TableColumnDO tableColumnDO = new TableColumnDO();
			tableColumnDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableColumnDO resultTableColumnDO = tableColumnService.getOneById(id);
			if (resultTableColumnDO != null) {
				TableColumnDTO resultTableColumnDTO = new TableColumnDTO();
				BeanUtils.copyProperties(resultTableColumnDO, resultTableColumnDTO);
				resultData.setData(resultTableColumnDTO);
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

	public ResultData<TableColumnDTO> getOneCriteria(TableColumnDTO tableColumnDTO) {
		ResultData<TableColumnDTO> resultData = new ResultData<TableColumnDTO>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			TableColumnDO resultTableColumnDO = tableColumnService.getOneCriteria(tableColumnDO);
			if (resultTableColumnDO != null) {
				TableColumnDTO resultTableColumnDTO = new TableColumnDTO();
				BeanUtils.copyProperties(resultTableColumnDO, resultTableColumnDTO);
				resultData.setData(resultTableColumnDTO);
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

	public ResultData<List<TableColumnDTO>> paginated(TableColumnDTO tableColumnDTO) {
		ResultData<List<TableColumnDTO>> resultData = new ResultData<List<TableColumnDTO>>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableColumnDO> pageInfo = tableColumnService.listPaginated(tableColumnDO);
			if (pageInfo != null) {
				List<TableColumnDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableColumnDTO> listTableColumnDTO = new ArrayList<TableColumnDTO>(resultList.size());
    				for (TableColumnDO tableColumnDOTemp:resultList) {
    					TableColumnDTO tableColumnDTOTemp = new TableColumnDTO();
    					BeanUtils.copyProperties(tableColumnDOTemp,tableColumnDTOTemp);
    					listTableColumnDTO.add(tableColumnDTOTemp);
    				}
    				resultData.setData(listTableColumnDTO);
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
	
	public ResultData<List<TableColumnDTO>> paginatedManual(TableColumnDTO tableColumnDTO) {
		ResultData<List<TableColumnDTO>> resultData = new ResultData<List<TableColumnDTO>>();
		try {
			TableColumnDO tableColumnDO = new TableColumnDO();
			BeanUtils.copyProperties(tableColumnDTO, tableColumnDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(tableColumnDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", tableColumnDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<TableColumnDO> pageInfo = tableColumnService.listPaginatedManual(tableColumnDO);
			if (pageInfo != null) {
				List<TableColumnDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<TableColumnDTO> listTableColumnDTO = new ArrayList<TableColumnDTO>(resultList.size());
    				for (TableColumnDO tableColumnDOTemp:resultList) {
    					TableColumnDTO tableColumnDTOTemp = new TableColumnDTO();
    					BeanUtils.copyProperties(tableColumnDOTemp,tableColumnDTOTemp);
    					listTableColumnDTO.add(tableColumnDTOTemp);
    				}
    				resultData.setData(listTableColumnDTO);
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
