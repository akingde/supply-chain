package com.bs.service.modules.uc.user.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.user.UserDO;
import com.bs.service.modules.uc.user.IUserDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseUserService<T extends UserDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<UserDO> redisService;
	
	@Autowired
	protected IUserDao userDao;

	/**
	 * 保存
	 * @param userDO
	 * @return
	 */
	public Integer save(UserDO userDO) throws Exception {
		return userDao.save(userDO);
	}

	/**
	 * 根据id修改
	 * @param userDO
	 * @return
	 */
	public Integer updateById(UserDO userDO) throws Exception {
		return userDao.updateById(userDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param userDO
	 * @return
	 */
	public Integer updateCriteria(UserDO userDO) throws Exception {
		return userDao.updateCriteria(userDO);
	}
	
	/**
	 * 动态条件删除
	 * @param userDO
	 * @return
	 */
	public Integer removeCriteria(UserDO userDO) throws Exception {
		return userDao.removeCriteria(userDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return userDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param userDO
	 * @return
	 */
	public void removeAll() throws Exception {
		userDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param userDO
	 * @return
	 */
	public List<UserDO> listCriteria(UserDO userDO) throws Exception {
		return userDao.listCriteria(userDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param userDO
	 * @return
	 */
	public List<Long> listIdsCriteria(UserDO userDO) throws Exception {
		return userDao.listIdsCriteria(userDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param userDO
	 * @return
	 */
	public List<UserDO> listByInIds(UserDO userDO) throws Exception {
		return userDao.listByInIds(userDO);
	}

	/**
	 * 查询所有数据
	 * @param userDO
	 * @return
	 */
	public List<UserDO> listAll() throws Exception {
		return userDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public UserDO getOneById(Long id) throws Exception {
		return userDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param userDO
	 * @return
	 */
	public UserDO getOneCriteria(UserDO userDO) throws Exception {
		return userDao.getOneCriteria(userDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param userDO
	 * @return
	 */
	public Long count(UserDO userDO) throws Exception {
		return userDao.count(userDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  userDO
	 * @return
	 */
	public PageInfo<UserDO> listPaginated(UserDO userDO) throws Exception {
		int page = userDO.getPage() == 0?1 : userDO.getPage();
		int rows = userDO.getRows() == 0?10 : userDO.getRows();
		PageHelper.startPage(page, rows);
		List<UserDO> list = userDao.listPaginated(userDO);
		PageInfo<UserDO> pageInfo = new PageInfo<UserDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param userDO
	 * @return
	 */
	public PageInfo<UserDO> listPaginatedManual(UserDO  userDO) throws Exception {
		int page = userDO.getPage() == 0?1: userDO.getPage();
		int rows = userDO.getRows() == 0?10: userDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		userDO.setStart(start);
		userDO.setOffset(offset);
		List<UserDO> list = userDao.listPaginatedManual(userDO);
		Long countRecords = userDao.countPaginatedManual(userDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<UserDO> pageInfo = new PageInfo<UserDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
