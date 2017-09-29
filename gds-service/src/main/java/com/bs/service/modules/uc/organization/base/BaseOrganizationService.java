package com.bs.service.modules.uc.organization.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.organization.OrganizationDO;
import com.bs.service.modules.uc.organization.IOrganizationDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseOrganizationService<T extends OrganizationDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<OrganizationDO> redisService;
	
	@Autowired
	protected IOrganizationDao organizationDao;

	/**
	 * 保存
	 * @param organizationDO
	 * @return
	 */
	public Integer save(OrganizationDO organizationDO) throws Exception {
		return organizationDao.save(organizationDO);
	}

	/**
	 * 根据id修改
	 * @param organizationDO
	 * @return
	 */
	public Integer updateById(OrganizationDO organizationDO) throws Exception {
		return organizationDao.updateById(organizationDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param organizationDO
	 * @return
	 */
	public Integer updateCriteria(OrganizationDO organizationDO) throws Exception {
		return organizationDao.updateCriteria(organizationDO);
	}
	
	/**
	 * 动态条件删除
	 * @param organizationDO
	 * @return
	 */
	public Integer removeCriteria(OrganizationDO organizationDO) throws Exception {
		return organizationDao.removeCriteria(organizationDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return organizationDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param organizationDO
	 * @return
	 */
	public void removeAll() throws Exception {
		organizationDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param organizationDO
	 * @return
	 */
	public List<OrganizationDO> listCriteria(OrganizationDO organizationDO) throws Exception {
		return organizationDao.listCriteria(organizationDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param organizationDO
	 * @return
	 */
	public List<Long> listIdsCriteria(OrganizationDO organizationDO) throws Exception {
		return organizationDao.listIdsCriteria(organizationDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param organizationDO
	 * @return
	 */
	public List<OrganizationDO> listByInIds(OrganizationDO organizationDO) throws Exception {
		return organizationDao.listByInIds(organizationDO);
	}

	/**
	 * 查询所有数据
	 * @param organizationDO
	 * @return
	 */
	public List<OrganizationDO> listAll() throws Exception {
		return organizationDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public OrganizationDO getOneById(Long id) throws Exception {
		return organizationDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param organizationDO
	 * @return
	 */
	public OrganizationDO getOneCriteria(OrganizationDO organizationDO) throws Exception {
		return organizationDao.getOneCriteria(organizationDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param organizationDO
	 * @return
	 */
	public Long count(OrganizationDO organizationDO) throws Exception {
		return organizationDao.count(organizationDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  organizationDO
	 * @return
	 */
	public PageInfo<OrganizationDO> listPaginated(OrganizationDO organizationDO) throws Exception {
		int page = organizationDO.getPage() == 0?1 : organizationDO.getPage();
		int rows = organizationDO.getRows() == 0?10 : organizationDO.getRows();
		PageHelper.startPage(page, rows);
		List<OrganizationDO> list = organizationDao.listPaginated(organizationDO);
		PageInfo<OrganizationDO> pageInfo = new PageInfo<OrganizationDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param organizationDO
	 * @return
	 */
	public PageInfo<OrganizationDO> listPaginatedManual(OrganizationDO  organizationDO) throws Exception {
		int page = organizationDO.getPage() == 0?1: organizationDO.getPage();
		int rows = organizationDO.getRows() == 0?10: organizationDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		organizationDO.setStart(start);
		organizationDO.setOffset(offset);
		List<OrganizationDO> list = organizationDao.listPaginatedManual(organizationDO);
		Long countRecords = organizationDao.countPaginatedManual(organizationDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<OrganizationDO> pageInfo = new PageInfo<OrganizationDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
