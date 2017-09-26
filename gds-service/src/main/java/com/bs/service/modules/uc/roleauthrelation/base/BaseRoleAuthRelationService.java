package com.bs.service.modules.uc.roleauthrelation.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.roleauthrelation.RoleAuthRelationDO;
import com.bs.service.modules.uc.roleauthrelation.IRoleAuthRelationDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseRoleAuthRelationService<T extends RoleAuthRelationDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<RoleAuthRelationDO> redisService;
	
	@Autowired
	protected IRoleAuthRelationDao roleAuthRelationDao;

	/**
	 * 保存
	 * @param roleAuthRelationDO
	 * @return
	 */
	public Integer save(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.save(roleAuthRelationDO);
	}

	
	/**
	 * 动态条件修改数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public Integer updateCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.updateCriteria(roleAuthRelationDO);
	}
	
	/**
	 * 动态条件删除
	 * @param roleAuthRelationDO
	 * @return
	 */
	public Integer removeCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.removeCriteria(roleAuthRelationDO);
	}
	

	/**
	 * 删除所有数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public void removeAll() throws Exception {
		roleAuthRelationDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public List<RoleAuthRelationDO> listCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.listCriteria(roleAuthRelationDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public List<Long> listIdsCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.listIdsCriteria(roleAuthRelationDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public List<RoleAuthRelationDO> listByInIds(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.listByInIds(roleAuthRelationDO);
	}

	/**
	 * 查询所有数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public List<RoleAuthRelationDO> listAll() throws Exception {
		return roleAuthRelationDao.listAll();
	}
	

	/**
	 * 动态条件，获取单条数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public RoleAuthRelationDO getOneCriteria(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.getOneCriteria(roleAuthRelationDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param roleAuthRelationDO
	 * @return
	 */
	public Long count(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		return roleAuthRelationDao.count(roleAuthRelationDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  roleAuthRelationDO
	 * @return
	 */
	public PageInfo<RoleAuthRelationDO> listPaginated(RoleAuthRelationDO roleAuthRelationDO) throws Exception {
		int page = roleAuthRelationDO.getPage() == 0?1 : roleAuthRelationDO.getPage();
		int rows = roleAuthRelationDO.getRows() == 0?10 : roleAuthRelationDO.getRows();
		PageHelper.startPage(page, rows);
		List<RoleAuthRelationDO> list = roleAuthRelationDao.listPaginated( roleAuthRelationDO);
		PageInfo<RoleAuthRelationDO> pageInfo = new PageInfo<RoleAuthRelationDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param roleAuthRelationDO
	 * @return
	 */
	public PageInfo<RoleAuthRelationDO> listPaginatedManual(RoleAuthRelationDO  roleAuthRelationDO) throws Exception {
		List<RoleAuthRelationDO> list = roleAuthRelationDao.listPaginatedManual( roleAuthRelationDO);
		Long countRecords = roleAuthRelationDao.countPaginatedManual( roleAuthRelationDO);
		int page = roleAuthRelationDO.getPage() == 0?1: roleAuthRelationDO.getPage();
		int rows = roleAuthRelationDO.getRows() == 0?10: roleAuthRelationDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<RoleAuthRelationDO> pageInfo = new PageInfo<RoleAuthRelationDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
