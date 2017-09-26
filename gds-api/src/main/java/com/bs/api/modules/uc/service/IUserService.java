package com.bs.api.modules.uc.service;

import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.UserDTO;
import com.bs.api.modules.uc.service.base.IBaseUserService;

public interface IUserService extends IBaseUserService<UserDTO>{

	/**
	 * 根据用户账户查询用户
	 * @param account
	 * @return
	 */
	public ResultData<UserDTO> getUserByAccount(String account);
}
