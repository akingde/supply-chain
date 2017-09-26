package com.bs.service.modules.sc.tablecolumn.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;
import com.bs.service.modules.sc.tablecolumn.ITableColumnDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseTableColumnService<T extends TableColumnDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<TableColumnDO> redisService;
	
	@Autowired
	protected ITableColumnDao tableColumnDao;

	/**
	 * 保存
	 * @param tableColumnDO
	 * @return
	 */
	public Integer save(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.save(tableColumnDO);
	}

	/**
	 * 根据id修改
	 * @param tableColumnDO
	 * @return
	 */
	public Integer updateById(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.updateById(tableColumnDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param tableColumnDO
	 * @return
	 */
	public Integer updateCriteria(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.updateCriteria(tableColumnDO);
	}
	
	/**
	 * 动态条件删除
	 * @param tableColumnDO
	 * @return
	 */
	public Integer removeCriteria(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.removeCriteria(tableColumnDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return tableColumnDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param tableColumnDO
	 * @return
	 */
	public void removeAll() throws Exception {
		tableColumnDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param tableColumnDO
	 * @return
	 */
	public List<TableColumnDO> listCriteria(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.listCriteria(tableColumnDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param tableColumnDO
	 * @return
	 */
	public List<Long> listIdsCriteria(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.listIdsCriteria(tableColumnDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param tableColumnDO
	 * @return
	 */
	public List<TableColumnDO> listByInIds(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.listByInIds(tableColumnDO);
	}

	/**
	 * 查询所有数据
	 * @param tableColumnDO
	 * @return
	 */
	public List<TableColumnDO> listAll() throws Exception {
		return tableColumnDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public TableColumnDO getOneById(Long id) throws Exception {
		return tableColumnDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param tableColumnDO
	 * @return
	 */
	public TableColumnDO getOneCriteria(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.getOneCriteria(tableColumnDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param tableColumnDO
	 * @return
	 */
	public Long count(TableColumnDO tableColumnDO) throws Exception {
		return tableColumnDao.count(tableColumnDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  tableColumnDO
	 * @return
	 */
	public PageInfo<TableColumnDO> listPaginated(TableColumnDO tableColumnDO) throws Exception {
		int page = tableColumnDO.getPage() == 0?1 : tableColumnDO.getPage();
		int rows = tableColumnDO.getRows() == 0?10 : tableColumnDO.getRows();
		PageHelper.startPage(page, rows);
		List<TableColumnDO> list = tableColumnDao.listPaginated( tableColumnDO);
		PageInfo<TableColumnDO> pageInfo = new PageInfo<TableColumnDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param tableColumnDO
	 * @return
	 */
	public PageInfo<TableColumnDO> listPaginatedManual(TableColumnDO  tableColumnDO) throws Exception {
		List<TableColumnDO> list = tableColumnDao.listPaginatedManual( tableColumnDO);
		Long countRecords = tableColumnDao.countPaginatedManual( tableColumnDO);
		int page = tableColumnDO.getPage() == 0?1: tableColumnDO.getPage();
		int rows = tableColumnDO.getRows() == 0?10: tableColumnDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<TableColumnDO> pageInfo = new PageInfo<TableColumnDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
