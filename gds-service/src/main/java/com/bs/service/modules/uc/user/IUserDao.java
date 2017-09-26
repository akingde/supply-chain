package com.bs.service.modules.uc.user;

import org.apache.ibatis.annotations.Mapper;

import com.bs.service.modules.uc.user.base.BaseUserDao;

@Mapper
public interface IUserDao extends BaseUserDao{

	/**
	 * 根据账户查询用户信息
	 * @param account
	 * @return
	 */
	public UserDO getOneByAccount(String account);
}
