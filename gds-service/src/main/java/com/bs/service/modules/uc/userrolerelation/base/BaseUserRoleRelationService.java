package com.bs.service.modules.uc.userrolerelation.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.userrolerelation.UserRoleRelationDO;
import com.bs.service.modules.uc.userrolerelation.IUserRoleRelationDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseUserRoleRelationService<T extends UserRoleRelationDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<UserRoleRelationDO> redisService;
	
	@Autowired
	protected IUserRoleRelationDao userRoleRelationDao;

	/**
	 * 保存
	 * @param userRoleRelationDO
	 * @return
	 */
	public Integer save(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.save(userRoleRelationDO);
	}

	
	/**
	 * 动态条件修改数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public Integer updateCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.updateCriteria(userRoleRelationDO);
	}
	
	/**
	 * 动态条件删除
	 * @param userRoleRelationDO
	 * @return
	 */
	public Integer removeCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.removeCriteria(userRoleRelationDO);
	}
	

	/**
	 * 删除所有数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public void removeAll() throws Exception {
		userRoleRelationDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public List<UserRoleRelationDO> listCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.listCriteria(userRoleRelationDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public List<Long> listIdsCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.listIdsCriteria(userRoleRelationDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public List<UserRoleRelationDO> listByInIds(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.listByInIds(userRoleRelationDO);
	}

	/**
	 * 查询所有数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public List<UserRoleRelationDO> listAll() throws Exception {
		return userRoleRelationDao.listAll();
	}
	

	/**
	 * 动态条件，获取单条数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public UserRoleRelationDO getOneCriteria(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.getOneCriteria(userRoleRelationDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param userRoleRelationDO
	 * @return
	 */
	public Long count(UserRoleRelationDO userRoleRelationDO) throws Exception {
		return userRoleRelationDao.count(userRoleRelationDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  userRoleRelationDO
	 * @return
	 */
	public PageInfo<UserRoleRelationDO> listPaginated(UserRoleRelationDO userRoleRelationDO) throws Exception {
		int page = userRoleRelationDO.getPage() == 0?1 : userRoleRelationDO.getPage();
		int rows = userRoleRelationDO.getRows() == 0?10 : userRoleRelationDO.getRows();
		PageHelper.startPage(page, rows);
		List<UserRoleRelationDO> list = userRoleRelationDao.listPaginated(userRoleRelationDO);
		PageInfo<UserRoleRelationDO> pageInfo = new PageInfo<UserRoleRelationDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param userRoleRelationDO
	 * @return
	 */
	public PageInfo<UserRoleRelationDO> listPaginatedManual(UserRoleRelationDO  userRoleRelationDO) throws Exception {
		int page = userRoleRelationDO.getPage() == 0?1: userRoleRelationDO.getPage();
		int rows = userRoleRelationDO.getRows() == 0?10: userRoleRelationDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		userRoleRelationDO.setStart(start);
		userRoleRelationDO.setOffset(offset);
		List<UserRoleRelationDO> list = userRoleRelationDao.listPaginatedManual(userRoleRelationDO);
		Long countRecords = userRoleRelationDao.countPaginatedManual(userRoleRelationDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<UserRoleRelationDO> pageInfo = new PageInfo<UserRoleRelationDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
