package com.bs.api.modules.uc.service;

import com.bs.api.modules.uc.service.base.IBaseAuthorizationService;

import java.util.List;

import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.AuthorizationDTO;

public interface IAuthorizationService extends IBaseAuthorizationService<AuthorizationDTO>{

	/**
	 * 获取所有权限信息，无缓存
	 * @param userId
	 * @param isAdmin
	 * @return
	 */
	public ResultData<List<AuthorizationDTO>> listAuths();
	
	/**
	 * 根据用户id，查询用户拥有的所有权限
	 * @param userId
	 * @param isAdmin
	 * @return
	 */
	public ResultData<List<AuthorizationDTO>> listAuthByUserId(Long userId,Integer isAdmin);
}
