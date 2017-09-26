package com.bs.service.modules.sc.viewfieldconfig.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;
import com.bs.service.modules.sc.viewfieldconfig.IViewFieldConfigDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseViewFieldConfigService<T extends ViewFieldConfigDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<ViewFieldConfigDO> redisService;
	
	@Autowired
	protected IViewFieldConfigDao viewFieldConfigDao;

	/**
	 * 保存
	 * @param viewFieldConfigDO
	 * @return
	 */
	public Integer save(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.save(viewFieldConfigDO);
	}

	/**
	 * 根据id修改
	 * @param viewFieldConfigDO
	 * @return
	 */
	public Integer updateById(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.updateById(viewFieldConfigDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public Integer updateCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.updateCriteria(viewFieldConfigDO);
	}
	
	/**
	 * 动态条件删除
	 * @param viewFieldConfigDO
	 * @return
	 */
	public Integer removeCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.removeCriteria(viewFieldConfigDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return viewFieldConfigDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public void removeAll() throws Exception {
		viewFieldConfigDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public List<ViewFieldConfigDO> listCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.listCriteria(viewFieldConfigDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public List<Long> listIdsCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.listIdsCriteria(viewFieldConfigDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public List<ViewFieldConfigDO> listByInIds(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.listByInIds(viewFieldConfigDO);
	}

	/**
	 * 查询所有数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public List<ViewFieldConfigDO> listAll() throws Exception {
		return viewFieldConfigDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ViewFieldConfigDO getOneById(Long id) throws Exception {
		return viewFieldConfigDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public ViewFieldConfigDO getOneCriteria(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.getOneCriteria(viewFieldConfigDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param viewFieldConfigDO
	 * @return
	 */
	public Long count(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		return viewFieldConfigDao.count(viewFieldConfigDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  viewFieldConfigDO
	 * @return
	 */
	public PageInfo<ViewFieldConfigDO> listPaginated(ViewFieldConfigDO viewFieldConfigDO) throws Exception {
		int page = viewFieldConfigDO.getPage() == 0?1 : viewFieldConfigDO.getPage();
		int rows = viewFieldConfigDO.getRows() == 0?10 : viewFieldConfigDO.getRows();
		PageHelper.startPage(page, rows);
		List<ViewFieldConfigDO> list = viewFieldConfigDao.listPaginated( viewFieldConfigDO);
		PageInfo<ViewFieldConfigDO> pageInfo = new PageInfo<ViewFieldConfigDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param viewFieldConfigDO
	 * @return
	 */
	public PageInfo<ViewFieldConfigDO> listPaginatedManual(ViewFieldConfigDO  viewFieldConfigDO) throws Exception {
		List<ViewFieldConfigDO> list = viewFieldConfigDao.listPaginatedManual( viewFieldConfigDO);
		Long countRecords = viewFieldConfigDao.countPaginatedManual( viewFieldConfigDO);
		int page = viewFieldConfigDO.getPage() == 0?1: viewFieldConfigDO.getPage();
		int rows = viewFieldConfigDO.getRows() == 0?10: viewFieldConfigDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<ViewFieldConfigDO> pageInfo = new PageInfo<ViewFieldConfigDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
