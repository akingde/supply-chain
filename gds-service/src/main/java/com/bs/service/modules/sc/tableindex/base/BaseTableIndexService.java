package com.bs.service.modules.sc.tableindex.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.tableindex.TableIndexDO;
import com.bs.service.modules.sc.tableindex.ITableIndexDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseTableIndexService<T extends TableIndexDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<TableIndexDO> redisService;
	
	@Autowired
	protected ITableIndexDao tableIndexDao;

	/**
	 * 保存
	 * @param tableIndexDO
	 * @return
	 */
	public Integer save(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.save(tableIndexDO);
	}

	/**
	 * 根据id修改
	 * @param tableIndexDO
	 * @return
	 */
	public Integer updateById(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.updateById(tableIndexDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param tableIndexDO
	 * @return
	 */
	public Integer updateCriteria(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.updateCriteria(tableIndexDO);
	}
	
	/**
	 * 动态条件删除
	 * @param tableIndexDO
	 * @return
	 */
	public Integer removeCriteria(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.removeCriteria(tableIndexDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return tableIndexDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param tableIndexDO
	 * @return
	 */
	public void removeAll() throws Exception {
		tableIndexDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param tableIndexDO
	 * @return
	 */
	public List<TableIndexDO> listCriteria(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.listCriteria(tableIndexDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param tableIndexDO
	 * @return
	 */
	public List<Long> listIdsCriteria(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.listIdsCriteria(tableIndexDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param tableIndexDO
	 * @return
	 */
	public List<TableIndexDO> listByInIds(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.listByInIds(tableIndexDO);
	}

	/**
	 * 查询所有数据
	 * @param tableIndexDO
	 * @return
	 */
	public List<TableIndexDO> listAll() throws Exception {
		return tableIndexDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public TableIndexDO getOneById(Long id) throws Exception {
		return tableIndexDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param tableIndexDO
	 * @return
	 */
	public TableIndexDO getOneCriteria(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.getOneCriteria(tableIndexDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param tableIndexDO
	 * @return
	 */
	public Long count(TableIndexDO tableIndexDO) throws Exception {
		return tableIndexDao.count(tableIndexDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  tableIndexDO
	 * @return
	 */
	public PageInfo<TableIndexDO> listPaginated(TableIndexDO tableIndexDO) throws Exception {
		int page = tableIndexDO.getPage() == 0?1 : tableIndexDO.getPage();
		int rows = tableIndexDO.getRows() == 0?10 : tableIndexDO.getRows();
		PageHelper.startPage(page, rows);
		List<TableIndexDO> list = tableIndexDao.listPaginated(tableIndexDO);
		PageInfo<TableIndexDO> pageInfo = new PageInfo<TableIndexDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param tableIndexDO
	 * @return
	 */
	public PageInfo<TableIndexDO> listPaginatedManual(TableIndexDO  tableIndexDO) throws Exception {
		int page = tableIndexDO.getPage() == 0?1: tableIndexDO.getPage();
		int rows = tableIndexDO.getRows() == 0?10: tableIndexDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		tableIndexDO.setStart(start);
		tableIndexDO.setOffset(offset);
		List<TableIndexDO> list = tableIndexDao.listPaginatedManual(tableIndexDO);
		Long countRecords = tableIndexDao.countPaginatedManual(tableIndexDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<TableIndexDO> pageInfo = new PageInfo<TableIndexDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
