package com.bs.service.modules.sc.table.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.table.TableDO;
import com.bs.service.modules.sc.table.ITableDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseTableService<T extends TableDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<TableDO> redisService;
	
	@Autowired
	protected ITableDao tableDao;

	/**
	 * 保存
	 * @param tableDO
	 * @return
	 */
	public Integer save(TableDO tableDO) throws Exception {
		return tableDao.save(tableDO);
	}

	/**
	 * 根据id修改
	 * @param tableDO
	 * @return
	 */
	public Integer updateById(TableDO tableDO) throws Exception {
		return tableDao.updateById(tableDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param tableDO
	 * @return
	 */
	public Integer updateCriteria(TableDO tableDO) throws Exception {
		return tableDao.updateCriteria(tableDO);
	}
	
	/**
	 * 动态条件删除
	 * @param tableDO
	 * @return
	 */
	public Integer removeCriteria(TableDO tableDO) throws Exception {
		return tableDao.removeCriteria(tableDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return tableDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param tableDO
	 * @return
	 */
	public void removeAll() throws Exception {
		tableDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param tableDO
	 * @return
	 */
	public List<TableDO> listCriteria(TableDO tableDO) throws Exception {
		return tableDao.listCriteria(tableDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param tableDO
	 * @return
	 */
	public List<Long> listIdsCriteria(TableDO tableDO) throws Exception {
		return tableDao.listIdsCriteria(tableDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param tableDO
	 * @return
	 */
	public List<TableDO> listByInIds(TableDO tableDO) throws Exception {
		return tableDao.listByInIds(tableDO);
	}

	/**
	 * 查询所有数据
	 * @param tableDO
	 * @return
	 */
	public List<TableDO> listAll() throws Exception {
		return tableDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public TableDO getOneById(Long id) throws Exception {
		return tableDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param tableDO
	 * @return
	 */
	public TableDO getOneCriteria(TableDO tableDO) throws Exception {
		return tableDao.getOneCriteria(tableDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param tableDO
	 * @return
	 */
	public Long count(TableDO tableDO) throws Exception {
		return tableDao.count(tableDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  tableDO
	 * @return
	 */
	public PageInfo<TableDO> listPaginated(TableDO tableDO) throws Exception {
		int page = tableDO.getPage() == 0?1 : tableDO.getPage();
		int rows = tableDO.getRows() == 0?10 : tableDO.getRows();
		PageHelper.startPage(page, rows);
		List<TableDO> list = tableDao.listPaginated( tableDO);
		PageInfo<TableDO> pageInfo = new PageInfo<TableDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param tableDO
	 * @return
	 */
	public PageInfo<TableDO> listPaginatedManual(TableDO  tableDO) throws Exception {
		List<TableDO> list = tableDao.listPaginatedManual( tableDO);
		Long countRecords = tableDao.countPaginatedManual( tableDO);
		int page = tableDO.getPage() == 0?1: tableDO.getPage();
		int rows = tableDO.getRows() == 0?10: tableDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<TableDO> pageInfo = new PageInfo<TableDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
