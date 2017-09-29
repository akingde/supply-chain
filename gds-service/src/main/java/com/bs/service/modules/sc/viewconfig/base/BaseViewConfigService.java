package com.bs.service.modules.sc.viewconfig.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;
import com.bs.service.modules.sc.viewconfig.IViewConfigDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseViewConfigService<T extends ViewConfigDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<ViewConfigDO> redisService;
	
	@Autowired
	protected IViewConfigDao viewConfigDao;

	/**
	 * 保存
	 * @param viewConfigDO
	 * @return
	 */
	public Integer save(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.save(viewConfigDO);
	}

	/**
	 * 根据id修改
	 * @param viewConfigDO
	 * @return
	 */
	public Integer updateById(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.updateById(viewConfigDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param viewConfigDO
	 * @return
	 */
	public Integer updateCriteria(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.updateCriteria(viewConfigDO);
	}
	
	/**
	 * 动态条件删除
	 * @param viewConfigDO
	 * @return
	 */
	public Integer removeCriteria(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.removeCriteria(viewConfigDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return viewConfigDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param viewConfigDO
	 * @return
	 */
	public void removeAll() throws Exception {
		viewConfigDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param viewConfigDO
	 * @return
	 */
	public List<ViewConfigDO> listCriteria(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.listCriteria(viewConfigDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param viewConfigDO
	 * @return
	 */
	public List<Long> listIdsCriteria(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.listIdsCriteria(viewConfigDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param viewConfigDO
	 * @return
	 */
	public List<ViewConfigDO> listByInIds(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.listByInIds(viewConfigDO);
	}

	/**
	 * 查询所有数据
	 * @param viewConfigDO
	 * @return
	 */
	public List<ViewConfigDO> listAll() throws Exception {
		return viewConfigDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ViewConfigDO getOneById(Long id) throws Exception {
		return viewConfigDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param viewConfigDO
	 * @return
	 */
	public ViewConfigDO getOneCriteria(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.getOneCriteria(viewConfigDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param viewConfigDO
	 * @return
	 */
	public Long count(ViewConfigDO viewConfigDO) throws Exception {
		return viewConfigDao.count(viewConfigDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  viewConfigDO
	 * @return
	 */
	public PageInfo<ViewConfigDO> listPaginated(ViewConfigDO viewConfigDO) throws Exception {
		int page = viewConfigDO.getPage() == 0?1 : viewConfigDO.getPage();
		int rows = viewConfigDO.getRows() == 0?10 : viewConfigDO.getRows();
		PageHelper.startPage(page, rows);
		List<ViewConfigDO> list = viewConfigDao.listPaginated(viewConfigDO);
		PageInfo<ViewConfigDO> pageInfo = new PageInfo<ViewConfigDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param viewConfigDO
	 * @return
	 */
	public PageInfo<ViewConfigDO> listPaginatedManual(ViewConfigDO  viewConfigDO) throws Exception {
		int page = viewConfigDO.getPage() == 0?1: viewConfigDO.getPage();
		int rows = viewConfigDO.getRows() == 0?10: viewConfigDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		viewConfigDO.setStart(start);
		viewConfigDO.setOffset(offset);
		List<ViewConfigDO> list = viewConfigDao.listPaginatedManual(viewConfigDO);
		Long countRecords = viewConfigDao.countPaginatedManual(viewConfigDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<ViewConfigDO> pageInfo = new PageInfo<ViewConfigDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
