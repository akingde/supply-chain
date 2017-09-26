package com.bs.service.modules.sc.dictionary.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.dictionary.DictionaryDO;
import com.bs.service.modules.sc.dictionary.IDictionaryDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseDictionaryService<T extends DictionaryDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<DictionaryDO> redisService;
	
	@Autowired
	protected IDictionaryDao dictionaryDao;

	/**
	 * 保存
	 * @param dictionaryDO
	 * @return
	 */
	public Integer save(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.save(dictionaryDO);
	}

	/**
	 * 根据id修改
	 * @param dictionaryDO
	 * @return
	 */
	public Integer updateById(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.updateById(dictionaryDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param dictionaryDO
	 * @return
	 */
	public Integer updateCriteria(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.updateCriteria(dictionaryDO);
	}
	
	/**
	 * 动态条件删除
	 * @param dictionaryDO
	 * @return
	 */
	public Integer removeCriteria(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.removeCriteria(dictionaryDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return dictionaryDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param dictionaryDO
	 * @return
	 */
	public void removeAll() throws Exception {
		dictionaryDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param dictionaryDO
	 * @return
	 */
	public List<DictionaryDO> listCriteria(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.listCriteria(dictionaryDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param dictionaryDO
	 * @return
	 */
	public List<Long> listIdsCriteria(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.listIdsCriteria(dictionaryDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param dictionaryDO
	 * @return
	 */
	public List<DictionaryDO> listByInIds(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.listByInIds(dictionaryDO);
	}

	/**
	 * 查询所有数据
	 * @param dictionaryDO
	 * @return
	 */
	public List<DictionaryDO> listAll() throws Exception {
		return dictionaryDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public DictionaryDO getOneById(Long id) throws Exception {
		return dictionaryDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param dictionaryDO
	 * @return
	 */
	public DictionaryDO getOneCriteria(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.getOneCriteria(dictionaryDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param dictionaryDO
	 * @return
	 */
	public Long count(DictionaryDO dictionaryDO) throws Exception {
		return dictionaryDao.count(dictionaryDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  dictionaryDO
	 * @return
	 */
	public PageInfo<DictionaryDO> listPaginated(DictionaryDO dictionaryDO) throws Exception {
		int page = dictionaryDO.getPage() == 0?1 : dictionaryDO.getPage();
		int rows = dictionaryDO.getRows() == 0?10 : dictionaryDO.getRows();
		PageHelper.startPage(page, rows);
		List<DictionaryDO> list = dictionaryDao.listPaginated( dictionaryDO);
		PageInfo<DictionaryDO> pageInfo = new PageInfo<DictionaryDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param dictionaryDO
	 * @return
	 */
	public PageInfo<DictionaryDO> listPaginatedManual(DictionaryDO  dictionaryDO) throws Exception {
		List<DictionaryDO> list = dictionaryDao.listPaginatedManual( dictionaryDO);
		Long countRecords = dictionaryDao.countPaginatedManual( dictionaryDO);
		int page = dictionaryDO.getPage() == 0?1: dictionaryDO.getPage();
		int rows = dictionaryDO.getRows() == 0?10: dictionaryDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<DictionaryDO> pageInfo = new PageInfo<DictionaryDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
