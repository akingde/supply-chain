package com.bs.service.modules.uc.authorization;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bs.service.modules.uc.authorization.base.BaseAuthorizationDao;

@Mapper
public interface IAuthorizationDao extends BaseAuthorizationDao{

	
	/**
	 * 查询所有权限信息，无缓存
	 * @return
	 */
	public List<AuthorizationDO> listAuths();
	
	/**
	 * 根据权限code查询权限信息
	 * @param authorizationDO
	 * @return
	 */
	public AuthorizationDO getOneByCode(String code);
	
	/**
	 * 根据角色id数组，查询权限列表
	 * @param authorizationDO
	 * @return
	 */
	public List<AuthorizationDO> listAuthByRoleIds(AuthorizationDO authorizationDO);
	
}
