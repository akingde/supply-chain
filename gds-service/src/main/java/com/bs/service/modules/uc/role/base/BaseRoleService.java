package com.bs.service.modules.uc.role.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.role.RoleDO;
import com.bs.service.modules.uc.role.IRoleDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseRoleService<T extends RoleDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<RoleDO> redisService;
	
	@Autowired
	protected IRoleDao roleDao;

	/**
	 * 保存
	 * @param roleDO
	 * @return
	 */
	public Integer save(RoleDO roleDO) throws Exception {
		return roleDao.save(roleDO);
	}

	/**
	 * 根据id修改
	 * @param roleDO
	 * @return
	 */
	public Integer updateById(RoleDO roleDO) throws Exception {
		return roleDao.updateById(roleDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param roleDO
	 * @return
	 */
	public Integer updateCriteria(RoleDO roleDO) throws Exception {
		return roleDao.updateCriteria(roleDO);
	}
	
	/**
	 * 动态条件删除
	 * @param roleDO
	 * @return
	 */
	public Integer removeCriteria(RoleDO roleDO) throws Exception {
		return roleDao.removeCriteria(roleDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return roleDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param roleDO
	 * @return
	 */
	public void removeAll() throws Exception {
		roleDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param roleDO
	 * @return
	 */
	public List<RoleDO> listCriteria(RoleDO roleDO) throws Exception {
		return roleDao.listCriteria(roleDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param roleDO
	 * @return
	 */
	public List<Long> listIdsCriteria(RoleDO roleDO) throws Exception {
		return roleDao.listIdsCriteria(roleDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param roleDO
	 * @return
	 */
	public List<RoleDO> listByInIds(RoleDO roleDO) throws Exception {
		return roleDao.listByInIds(roleDO);
	}

	/**
	 * 查询所有数据
	 * @param roleDO
	 * @return
	 */
	public List<RoleDO> listAll() throws Exception {
		return roleDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public RoleDO getOneById(Long id) throws Exception {
		return roleDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param roleDO
	 * @return
	 */
	public RoleDO getOneCriteria(RoleDO roleDO) throws Exception {
		return roleDao.getOneCriteria(roleDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param roleDO
	 * @return
	 */
	public Long count(RoleDO roleDO) throws Exception {
		return roleDao.count(roleDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  roleDO
	 * @return
	 */
	public PageInfo<RoleDO> listPaginated(RoleDO roleDO) throws Exception {
		int page = roleDO.getPage() == 0?1 : roleDO.getPage();
		int rows = roleDO.getRows() == 0?10 : roleDO.getRows();
		PageHelper.startPage(page, rows);
		List<RoleDO> list = roleDao.listPaginated(roleDO);
		PageInfo<RoleDO> pageInfo = new PageInfo<RoleDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param roleDO
	 * @return
	 */
	public PageInfo<RoleDO> listPaginatedManual(RoleDO  roleDO) throws Exception {
		int page = roleDO.getPage() == 0?1: roleDO.getPage();
		int rows = roleDO.getRows() == 0?10: roleDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		roleDO.setStart(start);
		roleDO.setOffset(offset);
		List<RoleDO> list = roleDao.listPaginatedManual(roleDO);
		Long countRecords = roleDao.countPaginatedManual(roleDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<RoleDO> pageInfo = new PageInfo<RoleDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
