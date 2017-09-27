package com.bs.service.modules.uc.authorization.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.AuthorizationDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.authorization.AuthorizationService;
import com.bs.service.modules.uc.authorization.AuthorizationDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseAuthorizationApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<AuthorizationDO> redisService;
	
	@Autowired
	protected AuthorizationService authorizationService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,AuthorizationDO authorizationDO);

	public ResultData<AuthorizationDTO> save(AuthorizationDTO authorizationDTO){
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			//bean 拷贝
			BeanUtils.copyProperties(authorizationDTO,authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = authorizationService.save(authorizationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(authorizationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(authorizationDTO);
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

	public ResultData<AuthorizationDTO> updateById(AuthorizationDTO authorizationDTO) {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = authorizationService.updateById(authorizationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(authorizationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(authorizationDTO);
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
	
	public ResultData<AuthorizationDTO> updateCriteria(AuthorizationDTO authorizationDTO) {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = authorizationService.updateCriteria(authorizationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(authorizationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(authorizationDTO);
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
	
	public ResultData<AuthorizationDTO> removeCriteria(AuthorizationDTO authorizationDTO) {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = authorizationService.removeCriteria(authorizationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(authorizationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(authorizationDTO);
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
			AuthorizationDO authorizationDO = new AuthorizationDO();
			authorizationDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = authorizationService.removeById(id);
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

	public ResultData<AuthorizationDTO> removeAll() {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			authorizationService.removeAll();
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
	
	public ResultData<List<AuthorizationDTO>> listCriteria(AuthorizationDTO authorizationDTO) {
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<AuthorizationDO> resultList = authorizationService.listCriteria(authorizationDO);
			if (resultList != null) {
				List<AuthorizationDTO> listAuthorizationDTO = new ArrayList<AuthorizationDTO>(resultList.size());
				for (AuthorizationDO authorizationDOTemp:resultList) {
					AuthorizationDTO authorizationDTOTemp = new AuthorizationDTO();
					BeanUtils.copyProperties(authorizationDOTemp,authorizationDTOTemp);
					listAuthorizationDTO.add(authorizationDTOTemp);
				}
				resultData.setData(listAuthorizationDTO);
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

	public ResultData<List<AuthorizationDTO>> listAll() {
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			List<AuthorizationDO> resultList = authorizationService.listAll();
			if (resultList != null) {
				List<AuthorizationDTO> listAuthorizationDTO = new ArrayList<AuthorizationDTO>(resultList.size());
				for (AuthorizationDO authorizationDOTemp:resultList) {
					AuthorizationDTO authorizationDTOTemp = new AuthorizationDTO();
					BeanUtils.copyProperties(authorizationDOTemp,authorizationDTOTemp);
					listAuthorizationDTO.add(authorizationDTOTemp);
				}
				resultData.setData(listAuthorizationDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(AuthorizationDTO authorizationDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = authorizationService.listIdsCriteria(authorizationDO);
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
	
	public ResultData<List<AuthorizationDTO>> listByInIds(AuthorizationDTO authorizationDTO){
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<AuthorizationDO> resultList = authorizationService.listByInIds(authorizationDO);
			if (resultList != null) {
				List<AuthorizationDTO> listAuthorizationDTO = new ArrayList<AuthorizationDTO>(resultList.size());
				for (AuthorizationDO authorizationDOTemp:resultList) {
					AuthorizationDTO authorizationDTOTemp = new AuthorizationDTO();
					BeanUtils.copyProperties(authorizationDOTemp,authorizationDTOTemp);
					listAuthorizationDTO.add(authorizationDTOTemp);
				}
				resultData.setData(listAuthorizationDTO);
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
	
	public ResultData<AuthorizationDTO> getOneById(Long id) {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			//验证输入参数
			AuthorizationDO authorizationDO = new AuthorizationDO();
			authorizationDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			AuthorizationDO resultAuthorizationDO = authorizationService.getOneById(id);
			if (resultAuthorizationDO != null) {
				AuthorizationDTO resultAuthorizationDTO = new AuthorizationDTO();
				BeanUtils.copyProperties(resultAuthorizationDO, resultAuthorizationDTO);
				resultData.setData(resultAuthorizationDTO);
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

	public ResultData<AuthorizationDTO> getOneCriteria(AuthorizationDTO authorizationDTO) {
		ResultData<AuthorizationDTO> resultData = new ResultData<AuthorizationDTO>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			AuthorizationDO resultAuthorizationDO = authorizationService.getOneCriteria(authorizationDO);
			if (resultAuthorizationDO != null) {
				AuthorizationDTO resultAuthorizationDTO = new AuthorizationDTO();
				BeanUtils.copyProperties(resultAuthorizationDO, resultAuthorizationDTO);
				resultData.setData(resultAuthorizationDTO);
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

	public ResultData<List<AuthorizationDTO>> paginated(AuthorizationDTO authorizationDTO) {
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<AuthorizationDO> pageInfo = authorizationService.listPaginated(authorizationDO);
			if (pageInfo != null) {
				List<AuthorizationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<AuthorizationDTO> listAuthorizationDTO = new ArrayList<AuthorizationDTO>(resultList.size());
    				for (AuthorizationDO authorizationDOTemp:resultList) {
    					AuthorizationDTO authorizationDTOTemp = new AuthorizationDTO();
    					BeanUtils.copyProperties(authorizationDOTemp,authorizationDTOTemp);
    					listAuthorizationDTO.add(authorizationDTOTemp);
    				}
    				resultData.setData(listAuthorizationDTO);
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
	
	public ResultData<List<AuthorizationDTO>> paginatedManual(AuthorizationDTO authorizationDTO) {
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			AuthorizationDO authorizationDO = new AuthorizationDO();
			BeanUtils.copyProperties(authorizationDTO, authorizationDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(authorizationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", authorizationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<AuthorizationDO> pageInfo = authorizationService.listPaginatedManual(authorizationDO);
			if (pageInfo != null) {
				List<AuthorizationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<AuthorizationDTO> listAuthorizationDTO = new ArrayList<AuthorizationDTO>(resultList.size());
    				for (AuthorizationDO authorizationDOTemp:resultList) {
    					AuthorizationDTO authorizationDTOTemp = new AuthorizationDTO();
    					BeanUtils.copyProperties(authorizationDOTemp,authorizationDTOTemp);
    					listAuthorizationDTO.add(authorizationDTOTemp);
    				}
    				resultData.setData(listAuthorizationDTO);
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
