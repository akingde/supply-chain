package com.bs.service.modules.uc.roleauthrelation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bs.service.modules.uc.authorization.AuthorizationDO;
import com.bs.service.modules.uc.roleauthrelation.base.BaseRoleAuthRelationDao;

@Mapper
public interface IRoleAuthRelationDao extends BaseRoleAuthRelationDao{
	/**
	 * 根据角色Id查询角
	 * @param roleAuthRelationDO
	 * @return
	 */
	public List<AuthorizationDO> listAuthByRoleId(Long roleId);
}
