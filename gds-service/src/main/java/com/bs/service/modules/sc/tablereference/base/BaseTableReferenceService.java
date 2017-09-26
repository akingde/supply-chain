package com.bs.service.modules.sc.tablereference.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.tablereference.TableReferenceDO;
import com.bs.service.modules.sc.tablereference.ITableReferenceDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseTableReferenceService<T extends TableReferenceDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<TableReferenceDO> redisService;
	
	@Autowired
	protected ITableReferenceDao tableReferenceDao;

	/**
	 * 保存
	 * @param tableReferenceDO
	 * @return
	 */
	public Integer save(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.save(tableReferenceDO);
	}

	/**
	 * 根据id修改
	 * @param tableReferenceDO
	 * @return
	 */
	public Integer updateById(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.updateById(tableReferenceDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param tableReferenceDO
	 * @return
	 */
	public Integer updateCriteria(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.updateCriteria(tableReferenceDO);
	}
	
	/**
	 * 动态条件删除
	 * @param tableReferenceDO
	 * @return
	 */
	public Integer removeCriteria(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.removeCriteria(tableReferenceDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return tableReferenceDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param tableReferenceDO
	 * @return
	 */
	public void removeAll() throws Exception {
		tableReferenceDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param tableReferenceDO
	 * @return
	 */
	public List<TableReferenceDO> listCriteria(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.listCriteria(tableReferenceDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param tableReferenceDO
	 * @return
	 */
	public List<Long> listIdsCriteria(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.listIdsCriteria(tableReferenceDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param tableReferenceDO
	 * @return
	 */
	public List<TableReferenceDO> listByInIds(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.listByInIds(tableReferenceDO);
	}

	/**
	 * 查询所有数据
	 * @param tableReferenceDO
	 * @return
	 */
	public List<TableReferenceDO> listAll() throws Exception {
		return tableReferenceDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public TableReferenceDO getOneById(Long id) throws Exception {
		return tableReferenceDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param tableReferenceDO
	 * @return
	 */
	public TableReferenceDO getOneCriteria(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.getOneCriteria(tableReferenceDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param tableReferenceDO
	 * @return
	 */
	public Long count(TableReferenceDO tableReferenceDO) throws Exception {
		return tableReferenceDao.count(tableReferenceDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  tableReferenceDO
	 * @return
	 */
	public PageInfo<TableReferenceDO> listPaginated(TableReferenceDO tableReferenceDO) throws Exception {
		int page = tableReferenceDO.getPage() == 0?1 : tableReferenceDO.getPage();
		int rows = tableReferenceDO.getRows() == 0?10 : tableReferenceDO.getRows();
		PageHelper.startPage(page, rows);
		List<TableReferenceDO> list = tableReferenceDao.listPaginated( tableReferenceDO);
		PageInfo<TableReferenceDO> pageInfo = new PageInfo<TableReferenceDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param tableReferenceDO
	 * @return
	 */
	public PageInfo<TableReferenceDO> listPaginatedManual(TableReferenceDO  tableReferenceDO) throws Exception {
		List<TableReferenceDO> list = tableReferenceDao.listPaginatedManual( tableReferenceDO);
		Long countRecords = tableReferenceDao.countPaginatedManual( tableReferenceDO);
		int page = tableReferenceDO.getPage() == 0?1: tableReferenceDO.getPage();
		int rows = tableReferenceDO.getRows() == 0?10: tableReferenceDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<TableReferenceDO> pageInfo = new PageInfo<TableReferenceDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
