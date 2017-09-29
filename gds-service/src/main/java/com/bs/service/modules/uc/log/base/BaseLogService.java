package com.bs.service.modules.uc.log.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.uc.log.LogDO;
import com.bs.service.modules.uc.log.ILogDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseLogService<T extends LogDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<LogDO> redisService;
	
	@Autowired
	protected ILogDao logDao;

	/**
	 * 保存
	 * @param logDO
	 * @return
	 */
	public Integer save(LogDO logDO) throws Exception {
		return logDao.save(logDO);
	}

	/**
	 * 根据id修改
	 * @param logDO
	 * @return
	 */
	public Integer updateById(LogDO logDO) throws Exception {
		return logDao.updateById(logDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param logDO
	 * @return
	 */
	public Integer updateCriteria(LogDO logDO) throws Exception {
		return logDao.updateCriteria(logDO);
	}
	
	/**
	 * 动态条件删除
	 * @param logDO
	 * @return
	 */
	public Integer removeCriteria(LogDO logDO) throws Exception {
		return logDao.removeCriteria(logDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return logDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param logDO
	 * @return
	 */
	public void removeAll() throws Exception {
		logDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param logDO
	 * @return
	 */
	public List<LogDO> listCriteria(LogDO logDO) throws Exception {
		return logDao.listCriteria(logDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param logDO
	 * @return
	 */
	public List<Long> listIdsCriteria(LogDO logDO) throws Exception {
		return logDao.listIdsCriteria(logDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param logDO
	 * @return
	 */
	public List<LogDO> listByInIds(LogDO logDO) throws Exception {
		return logDao.listByInIds(logDO);
	}

	/**
	 * 查询所有数据
	 * @param logDO
	 * @return
	 */
	public List<LogDO> listAll() throws Exception {
		return logDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public LogDO getOneById(Long id) throws Exception {
		return logDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param logDO
	 * @return
	 */
	public LogDO getOneCriteria(LogDO logDO) throws Exception {
		return logDao.getOneCriteria(logDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param logDO
	 * @return
	 */
	public Long count(LogDO logDO) throws Exception {
		return logDao.count(logDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  logDO
	 * @return
	 */
	public PageInfo<LogDO> listPaginated(LogDO logDO) throws Exception {
		int page = logDO.getPage() == 0?1 : logDO.getPage();
		int rows = logDO.getRows() == 0?10 : logDO.getRows();
		PageHelper.startPage(page, rows);
		List<LogDO> list = logDao.listPaginated(logDO);
		PageInfo<LogDO> pageInfo = new PageInfo<LogDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param logDO
	 * @return
	 */
	public PageInfo<LogDO> listPaginatedManual(LogDO  logDO) throws Exception {
		int page = logDO.getPage() == 0?1: logDO.getPage();
		int rows = logDO.getRows() == 0?10: logDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		logDO.setStart(start);
		logDO.setOffset(offset);
		List<LogDO> list = logDao.listPaginatedManual(logDO);
		Long countRecords = logDao.countPaginatedManual(logDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<LogDO> pageInfo = new PageInfo<LogDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
