package com.bs.service.modules.uc.userrolerelation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bs.service.modules.uc.userrolerelation.base.BaseUserRoleRelationDao;

@Mapper
public interface IUserRoleRelationDao extends BaseUserRoleRelationDao{
	
	/**
	 * 根据用户id，查询角色Id列表
	 * @param userRoleRelationDO
	 * @return
	 */
	public List<Long> listRoleIdsByUserId(UserRoleRelationDO userRoleRelationDO);
}
