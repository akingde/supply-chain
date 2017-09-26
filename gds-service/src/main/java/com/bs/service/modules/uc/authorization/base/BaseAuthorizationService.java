package com.bs.service.modules.uc.authorization.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.authorization.AuthorizationDO;
import com.bs.service.modules.uc.authorization.IAuthorizationDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseAuthorizationService<T extends AuthorizationDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<AuthorizationDO> redisService;
	
	@Autowired
	protected IAuthorizationDao authorizationDao;

	/**
	 * 保存
	 * @param authorizationDO
	 * @return
	 */
	public Integer save(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.save(authorizationDO);
	}

	/**
	 * 根据id修改
	 * @param authorizationDO
	 * @return
	 */
	public Integer updateById(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.updateById(authorizationDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param authorizationDO
	 * @return
	 */
	public Integer updateCriteria(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.updateCriteria(authorizationDO);
	}
	
	/**
	 * 动态条件删除
	 * @param authorizationDO
	 * @return
	 */
	public Integer removeCriteria(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.removeCriteria(authorizationDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return authorizationDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param authorizationDO
	 * @return
	 */
	public void removeAll() throws Exception {
		authorizationDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param authorizationDO
	 * @return
	 */
	public List<AuthorizationDO> listCriteria(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.listCriteria(authorizationDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param authorizationDO
	 * @return
	 */
	public List<Long> listIdsCriteria(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.listIdsCriteria(authorizationDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param authorizationDO
	 * @return
	 */
	public List<AuthorizationDO> listByInIds(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.listByInIds(authorizationDO);
	}

	/**
	 * 查询所有数据
	 * @param authorizationDO
	 * @return
	 */
	public List<AuthorizationDO> listAll() throws Exception {
		return authorizationDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public AuthorizationDO getOneById(Long id) throws Exception {
		return authorizationDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param authorizationDO
	 * @return
	 */
	public AuthorizationDO getOneCriteria(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.getOneCriteria(authorizationDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param authorizationDO
	 * @return
	 */
	public Long count(AuthorizationDO authorizationDO) throws Exception {
		return authorizationDao.count(authorizationDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  authorizationDO
	 * @return
	 */
	public PageInfo<AuthorizationDO> listPaginated(AuthorizationDO authorizationDO) throws Exception {
		int page = authorizationDO.getPage() == 0?1 : authorizationDO.getPage();
		int rows = authorizationDO.getRows() == 0?10 : authorizationDO.getRows();
		PageHelper.startPage(page, rows);
		List<AuthorizationDO> list = authorizationDao.listPaginated( authorizationDO);
		PageInfo<AuthorizationDO> pageInfo = new PageInfo<AuthorizationDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param authorizationDO
	 * @return
	 */
	public PageInfo<AuthorizationDO> listPaginatedManual(AuthorizationDO  authorizationDO) throws Exception {
		List<AuthorizationDO> list = authorizationDao.listPaginatedManual( authorizationDO);
		Long countRecords = authorizationDao.countPaginatedManual( authorizationDO);
		int page = authorizationDO.getPage() == 0?1: authorizationDO.getPage();
		int rows = authorizationDO.getRows() == 0?10: authorizationDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<AuthorizationDO> pageInfo = new PageInfo<AuthorizationDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
