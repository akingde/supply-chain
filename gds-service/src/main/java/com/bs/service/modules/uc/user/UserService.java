package com.bs.service.modules.uc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.config.InitalDataConfig;
import com.bs.service.core.utils.Encrypt;
import com.bs.service.modules.uc.organization.IOrganizationDao;
import com.bs.service.modules.uc.organization.OrganizationDO;
import com.bs.service.modules.uc.user.base.BaseUserService;

@Service
@Transactional(readOnly = true)
public class UserService extends BaseUserService<UserDO> {
	
	@Autowired
	private IOrganizationDao organizationDao;
	
	@Autowired
	private InitalDataConfig initalDataConfig;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//初始化机构信息
		String orgCode = initalDataConfig.getOrgCode();
		String orgShortName = initalDataConfig.getOrgShortName();
		String orgName = initalDataConfig.getOrgName();
		OrganizationDO organizationDO = new OrganizationDO();
		organizationDO.setName(orgName);
		organizationDO.setCode(orgCode);
		organizationDO.setOrgType(1);
		organizationDO.setShortName(orgShortName);
		organizationDO.setParentId(0L);
		Integer rval = 0;
		Long orgId = null;
		//判断机构是否存在
		OrganizationDO organizationDOResult = organizationDao.getOneByCode(orgCode);
		if (organizationDOResult == null) {
			rval = organizationDao.save(organizationDO);
			orgId = organizationDO.getGeneratedKey();
		}
		else {
			orgId = organizationDOResult.getId();
			organizationDO.setId(orgId);
			rval = organizationDao.updateById(organizationDO);
		}
		//机构处理成功，插入超级管理员用户
		if (rval != null && rval.intValue() > 0) {
			UserDO userDO = new UserDO();
			String userAccount = initalDataConfig.getUserAccount();
			String userName = initalDataConfig.getUserName();
			String userPassword = initalDataConfig.getUserPassword();
			userDO.setAccount(userAccount);
			userDO.setIsAdmin(1);
			userDO.setName(userName);
			userDO.setUserType(1);
			userDO.setIsPosition(1);
			userDO.setStart(1);
			//判断用户是否存在
			UserDO userDOResult = userDao.getOneByAccount(userAccount);
			if (userDOResult == null) {
				//密码进行md5 加密
				userPassword = Encrypt.getMD5(userPassword);
				userDO.setPassword(userPassword);
				userDO.setOrgId(orgId);
				userDO.setOrgCode(orgCode);
				userDao.save(userDO);
			}
			else {
				//更新超级管理员信息，不更新密码
				Long userId = userDOResult.getId();
				userDO.setId(userId);
				userDO.setOrgCode(orgCode);
				userDO.setOrgId(orgId);
				userDO.setPassword(null);
				userDao.updateById(userDO);
			}
		}
	}
	
	/**
	 * 根据用户账户获取用户信息
	 * @param account
	 * @return
	 */
	public UserDO getUserByAccount(String account) {
		return userDao.getOneByAccount(account);
	}
	
}
