package com.bs.service.modules.uc.userrolerelation.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.UserRoleRelationDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationService;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;

import com.github.pagehelper.PageInfo;

public abstract class BaseUserRoleRelationApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<UserRoleRelationDO> redisService;
	
	@Autowired
	protected UserRoleRelationService userRoleRelationService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,UserRoleRelationDO userRoleRelationDO);

	public ResultData<UserRoleRelationDTO> save(UserRoleRelationDTO userRoleRelationDTO){
		ResultData<UserRoleRelationDTO> resultData = new ResultData<UserRoleRelationDTO>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			//bean 拷贝
			BeanUtils.copyProperties(userRoleRelationDTO,userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = userRoleRelationService.save(userRoleRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(userRoleRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(userRoleRelationDTO);
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

	
	public ResultData<UserRoleRelationDTO> updateCriteria(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<UserRoleRelationDTO> resultData = new ResultData<UserRoleRelationDTO>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = userRoleRelationService.updateCriteria(userRoleRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(userRoleRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(userRoleRelationDTO);
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
	
	public ResultData<UserRoleRelationDTO> removeCriteria(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<UserRoleRelationDTO> resultData = new ResultData<UserRoleRelationDTO>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = userRoleRelationService.removeCriteria(userRoleRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(userRoleRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(userRoleRelationDTO);
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

	

	public ResultData<UserRoleRelationDTO> removeAll() {
		ResultData<UserRoleRelationDTO> resultData = new ResultData<UserRoleRelationDTO>();
		try {
			userRoleRelationService.removeAll();
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
	
	public ResultData<List<UserRoleRelationDTO>> listCriteria(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<List<UserRoleRelationDTO>> resultData = new ResultData<List<UserRoleRelationDTO>>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<UserRoleRelationDO> resultList = userRoleRelationService.listCriteria(userRoleRelationDO);
			if (resultList != null) {
				List<UserRoleRelationDTO> listUserRoleRelationDTO = new ArrayList<UserRoleRelationDTO>(resultList.size());
				for (UserRoleRelationDO userRoleRelationDOTemp:resultList) {
					UserRoleRelationDTO userRoleRelationDTOTemp = new UserRoleRelationDTO();
					BeanUtils.copyProperties(userRoleRelationDOTemp,userRoleRelationDTOTemp);
					listUserRoleRelationDTO.add(userRoleRelationDTOTemp);
				}
				resultData.setData(listUserRoleRelationDTO);
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

	public ResultData<List<UserRoleRelationDTO>> listAll() {
		ResultData<List<UserRoleRelationDTO>> resultData = new ResultData<List<UserRoleRelationDTO>>();
		try {
			List<UserRoleRelationDO> resultList = userRoleRelationService.listAll();
			if (resultList != null) {
				List<UserRoleRelationDTO> listUserRoleRelationDTO = new ArrayList<UserRoleRelationDTO>(resultList.size());
				for (UserRoleRelationDO userRoleRelationDOTemp:resultList) {
					UserRoleRelationDTO userRoleRelationDTOTemp = new UserRoleRelationDTO();
					BeanUtils.copyProperties(userRoleRelationDOTemp,userRoleRelationDTOTemp);
					listUserRoleRelationDTO.add(userRoleRelationDTOTemp);
				}
				resultData.setData(listUserRoleRelationDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(UserRoleRelationDTO userRoleRelationDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = userRoleRelationService.listIdsCriteria(userRoleRelationDO);
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
	
	public ResultData<List<UserRoleRelationDTO>> listByInIds(UserRoleRelationDTO userRoleRelationDTO){
		ResultData<List<UserRoleRelationDTO>> resultData = new ResultData<List<UserRoleRelationDTO>>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<UserRoleRelationDO> resultList = userRoleRelationService.listByInIds(userRoleRelationDO);
			if (resultList != null) {
				List<UserRoleRelationDTO> listUserRoleRelationDTO = new ArrayList<UserRoleRelationDTO>(resultList.size());
				for (UserRoleRelationDO userRoleRelationDOTemp:resultList) {
					UserRoleRelationDTO userRoleRelationDTOTemp = new UserRoleRelationDTO();
					BeanUtils.copyProperties(userRoleRelationDOTemp,userRoleRelationDTOTemp);
					listUserRoleRelationDTO.add(userRoleRelationDTOTemp);
				}
				resultData.setData(listUserRoleRelationDTO);
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
	

	public ResultData<UserRoleRelationDTO> getOneCriteria(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<UserRoleRelationDTO> resultData = new ResultData<UserRoleRelationDTO>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			UserRoleRelationDO resultUserRoleRelationDO = userRoleRelationService.getOneCriteria(userRoleRelationDO);
			if (resultUserRoleRelationDO != null) {
				UserRoleRelationDTO resultUserRoleRelationDTO = new UserRoleRelationDTO();
				BeanUtils.copyProperties(resultUserRoleRelationDO, resultUserRoleRelationDTO);
				resultData.setData(resultUserRoleRelationDTO);
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

	public ResultData<List<UserRoleRelationDTO>> paginated(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<List<UserRoleRelationDTO>> resultData = new ResultData<List<UserRoleRelationDTO>>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<UserRoleRelationDO> pageInfo = userRoleRelationService.listPaginated(userRoleRelationDO);
			if (pageInfo != null) {
				List<UserRoleRelationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<UserRoleRelationDTO> listUserRoleRelationDTO = new ArrayList<UserRoleRelationDTO>(resultList.size());
    				for (UserRoleRelationDO userRoleRelationDOTemp:resultList) {
    					UserRoleRelationDTO userRoleRelationDTOTemp = new UserRoleRelationDTO();
    					BeanUtils.copyProperties(userRoleRelationDOTemp,userRoleRelationDTOTemp);
    					listUserRoleRelationDTO.add(userRoleRelationDTOTemp);
    				}
    				resultData.setData(listUserRoleRelationDTO);
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
	
	public ResultData<List<UserRoleRelationDTO>> paginatedManual(UserRoleRelationDTO userRoleRelationDTO) {
		ResultData<List<UserRoleRelationDTO>> resultData = new ResultData<List<UserRoleRelationDTO>>();
		try {
			UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
			BeanUtils.copyProperties(userRoleRelationDTO, userRoleRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(userRoleRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", userRoleRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<UserRoleRelationDO> pageInfo = userRoleRelationService.listPaginatedManual(userRoleRelationDO);
			if (pageInfo != null) {
				List<UserRoleRelationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<UserRoleRelationDTO> listUserRoleRelationDTO = new ArrayList<UserRoleRelationDTO>(resultList.size());
    				for (UserRoleRelationDO userRoleRelationDOTemp:resultList) {
    					UserRoleRelationDTO userRoleRelationDTOTemp = new UserRoleRelationDTO();
    					BeanUtils.copyProperties(userRoleRelationDOTemp,userRoleRelationDTOTemp);
    					listUserRoleRelationDTO.add(userRoleRelationDTOTemp);
    				}
    				resultData.setData(listUserRoleRelationDTO);
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
