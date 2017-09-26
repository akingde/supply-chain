package com.bs.service.modules.uc.authorization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.AuthorizationDTO;
import com.bs.api.modules.uc.service.IAuthorizationService;
import com.bs.service.core.group.Id;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.authorization.base.BaseAuthorizationApi;
import com.bs.service.modules.uc.user.UserDO;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationService;

@Service(version = "1.0.0")
public class AuthorizationApi extends BaseAuthorizationApi<AuthorizationDTO> implements IAuthorizationService{
	
	@Autowired
	private UserRoleRelationService userRoleRelationService;
	
	@Override
	public String bizValid(String method, AuthorizationDO authorizationDO) {
		return null;
	}

	@Override
	public ResultData<List<AuthorizationDTO>> listAuthByUserId(Long userId, Integer isAdmin) {
		ResultData<List<AuthorizationDTO>> resultData = new ResultData<List<AuthorizationDTO>>();
		try {
			//验证输入参数
			UserDO userDO = new UserDO();
			userDO.setId(userId);
			userDO.setIsAdmin(isAdmin);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(userDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			List<AuthorizationDTO> listDtos = null;
			//超级管理员获取所有权限 [isAdmin]1:超级管理员 0:普通用户
			if (isAdmin != null && isAdmin.intValue() == 1) {
				List<AuthorizationDO> authorizations = super.authorizationService.listAll();
				if (authorizations != null) {
					listDtos = new ArrayList<AuthorizationDTO>(authorizations.size());
					//do 转成dto
					for (AuthorizationDO authorizationDO:authorizations) {
						AuthorizationDTO authorizationDTO = new AuthorizationDTO();
						BeanUtils.copyProperties(authorizationDO, authorizationDTO);
						listDtos.add(authorizationDTO);
					}
					resultData.setData(listDtos);
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
			else {
				//普通管理员获取该用户具有的角色，并获取对应的权限信息
				UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO();
				userRoleRelationDO.setUserId(userId);
				List<Long> ids = userRoleRelationService.listIdsCriteria(userRoleRelationDO);
				AuthorizationDO authorizationDO = new AuthorizationDO();
				authorizationDO.setIds(ids);
				//根据角色id数据，查询权限信息
				List<AuthorizationDO> authorizations = authorizationService.listAuthByRoleIds(authorizationDO);
				if (authorizations != null) {
					listDtos = new ArrayList<AuthorizationDTO>(authorizations.size());
					//do 转成dto
					for (AuthorizationDO authorizationDOTemp:authorizations) {
						AuthorizationDTO authorizationDTO = new AuthorizationDTO();
						BeanUtils.copyProperties(authorizationDOTemp, authorizationDTO);
						listDtos.add(authorizationDTO);
					}
					resultData.setData(listDtos);
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
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
}
