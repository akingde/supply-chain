package com.bs.service.modules.uc.roleauthrelation.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.RoleAuthRelationDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationService;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;

import com.github.pagehelper.PageInfo;

public abstract class BaseRoleAuthRelationApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<RoleAuthRelationDO> redisService;
	
	@Autowired
	protected RoleAuthRelationService roleAuthRelationService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,RoleAuthRelationDO roleAuthRelationDO);

	public ResultData<RoleAuthRelationDTO> save(RoleAuthRelationDTO roleAuthRelationDTO){
		ResultData<RoleAuthRelationDTO> resultData = new ResultData<RoleAuthRelationDTO>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			//bean 拷贝
			BeanUtils.copyProperties(roleAuthRelationDTO,roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = roleAuthRelationService.save(roleAuthRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(roleAuthRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(roleAuthRelationDTO);
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

	
	public ResultData<RoleAuthRelationDTO> updateCriteria(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<RoleAuthRelationDTO> resultData = new ResultData<RoleAuthRelationDTO>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = roleAuthRelationService.updateCriteria(roleAuthRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(roleAuthRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(roleAuthRelationDTO);
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
	
	public ResultData<RoleAuthRelationDTO> removeCriteria(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<RoleAuthRelationDTO> resultData = new ResultData<RoleAuthRelationDTO>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = roleAuthRelationService.removeCriteria(roleAuthRelationDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(roleAuthRelationDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(roleAuthRelationDTO);
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

	

	public ResultData<RoleAuthRelationDTO> removeAll() {
		ResultData<RoleAuthRelationDTO> resultData = new ResultData<RoleAuthRelationDTO>();
		try {
			roleAuthRelationService.removeAll();
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
	
	public ResultData<List<RoleAuthRelationDTO>> listCriteria(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<List<RoleAuthRelationDTO>> resultData = new ResultData<List<RoleAuthRelationDTO>>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<RoleAuthRelationDO> resultList = roleAuthRelationService.listCriteria(roleAuthRelationDO);
			if (resultList != null) {
				List<RoleAuthRelationDTO> listRoleAuthRelationDTO = new ArrayList<RoleAuthRelationDTO>(resultList.size());
				for (RoleAuthRelationDO roleAuthRelationDOTemp:resultList) {
					RoleAuthRelationDTO roleAuthRelationDTOTemp = new RoleAuthRelationDTO();
					BeanUtils.copyProperties(roleAuthRelationDOTemp,roleAuthRelationDTOTemp);
					listRoleAuthRelationDTO.add(roleAuthRelationDTOTemp);
				}
				resultData.setData(listRoleAuthRelationDTO);
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

	public ResultData<List<RoleAuthRelationDTO>> listAll() {
		ResultData<List<RoleAuthRelationDTO>> resultData = new ResultData<List<RoleAuthRelationDTO>>();
		try {
			List<RoleAuthRelationDO> resultList = roleAuthRelationService.listAll();
			if (resultList != null) {
				List<RoleAuthRelationDTO> listRoleAuthRelationDTO = new ArrayList<RoleAuthRelationDTO>(resultList.size());
				for (RoleAuthRelationDO roleAuthRelationDOTemp:resultList) {
					RoleAuthRelationDTO roleAuthRelationDTOTemp = new RoleAuthRelationDTO();
					BeanUtils.copyProperties(roleAuthRelationDOTemp,roleAuthRelationDTOTemp);
					listRoleAuthRelationDTO.add(roleAuthRelationDTOTemp);
				}
				resultData.setData(listRoleAuthRelationDTO);
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
	
	public ResultData<List<Long>> listIdsCriteria(RoleAuthRelationDTO roleAuthRelationDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = roleAuthRelationService.listIdsCriteria(roleAuthRelationDO);
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
	
	public ResultData<List<RoleAuthRelationDTO>> listByInIds(RoleAuthRelationDTO roleAuthRelationDTO){
		ResultData<List<RoleAuthRelationDTO>> resultData = new ResultData<List<RoleAuthRelationDTO>>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<RoleAuthRelationDO> resultList = roleAuthRelationService.listByInIds(roleAuthRelationDO);
			if (resultList != null) {
				List<RoleAuthRelationDTO> listRoleAuthRelationDTO = new ArrayList<RoleAuthRelationDTO>(resultList.size());
				for (RoleAuthRelationDO roleAuthRelationDOTemp:resultList) {
					RoleAuthRelationDTO roleAuthRelationDTOTemp = new RoleAuthRelationDTO();
					BeanUtils.copyProperties(roleAuthRelationDOTemp,roleAuthRelationDTOTemp);
					listRoleAuthRelationDTO.add(roleAuthRelationDTOTemp);
				}
				resultData.setData(listRoleAuthRelationDTO);
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
	

	public ResultData<RoleAuthRelationDTO> getOneCriteria(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<RoleAuthRelationDTO> resultData = new ResultData<RoleAuthRelationDTO>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			RoleAuthRelationDO resultRoleAuthRelationDO = roleAuthRelationService.getOneCriteria(roleAuthRelationDO);
			if (resultRoleAuthRelationDO != null) {
				RoleAuthRelationDTO resultRoleAuthRelationDTO = new RoleAuthRelationDTO();
				BeanUtils.copyProperties(resultRoleAuthRelationDO, resultRoleAuthRelationDTO);
				resultData.setData(resultRoleAuthRelationDTO);
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

	public ResultData<List<RoleAuthRelationDTO>> paginated(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<List<RoleAuthRelationDTO>> resultData = new ResultData<List<RoleAuthRelationDTO>>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<RoleAuthRelationDO> pageInfo = roleAuthRelationService.listPaginated(roleAuthRelationDO);
			if (pageInfo != null) {
				List<RoleAuthRelationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<RoleAuthRelationDTO> listRoleAuthRelationDTO = new ArrayList<RoleAuthRelationDTO>(resultList.size());
    				for (RoleAuthRelationDO roleAuthRelationDOTemp:resultList) {
    					RoleAuthRelationDTO roleAuthRelationDTOTemp = new RoleAuthRelationDTO();
    					BeanUtils.copyProperties(roleAuthRelationDOTemp,roleAuthRelationDTOTemp);
    					listRoleAuthRelationDTO.add(roleAuthRelationDTOTemp);
    				}
    				resultData.setData(listRoleAuthRelationDTO);
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
	
	public ResultData<List<RoleAuthRelationDTO>> paginatedManual(RoleAuthRelationDTO roleAuthRelationDTO) {
		ResultData<List<RoleAuthRelationDTO>> resultData = new ResultData<List<RoleAuthRelationDTO>>();
		try {
			RoleAuthRelationDO roleAuthRelationDO = new RoleAuthRelationDO();
			BeanUtils.copyProperties(roleAuthRelationDTO, roleAuthRelationDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(roleAuthRelationDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", roleAuthRelationDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<RoleAuthRelationDO> pageInfo = roleAuthRelationService.listPaginatedManual(roleAuthRelationDO);
			if (pageInfo != null) {
				List<RoleAuthRelationDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<RoleAuthRelationDTO> listRoleAuthRelationDTO = new ArrayList<RoleAuthRelationDTO>(resultList.size());
    				for (RoleAuthRelationDO roleAuthRelationDOTemp:resultList) {
    					RoleAuthRelationDTO roleAuthRelationDTOTemp = new RoleAuthRelationDTO();
    					BeanUtils.copyProperties(roleAuthRelationDOTemp,roleAuthRelationDTOTemp);
    					listRoleAuthRelationDTO.add(roleAuthRelationDTOTemp);
    				}
    				resultData.setData(listRoleAuthRelationDTO);
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
