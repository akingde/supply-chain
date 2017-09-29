package com.bs.service.modules.sc.dictionarycategory.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;
import com.bs.service.modules.sc.dictionarycategory.IDictionaryCategoryDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseDictionaryCategoryService<T extends DictionaryCategoryDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<DictionaryCategoryDO> redisService;
	
	@Autowired
	protected IDictionaryCategoryDao dictionaryCategoryDao;

	/**
	 * 保存
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public Integer save(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.save(dictionaryCategoryDO);
	}

	/**
	 * 根据id修改
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public Integer updateById(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.updateById(dictionaryCategoryDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public Integer updateCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.updateCriteria(dictionaryCategoryDO);
	}
	
	/**
	 * 动态条件删除
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public Integer removeCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.removeCriteria(dictionaryCategoryDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return dictionaryCategoryDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public void removeAll() throws Exception {
		dictionaryCategoryDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public List<DictionaryCategoryDO> listCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.listCriteria(dictionaryCategoryDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public List<Long> listIdsCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.listIdsCriteria(dictionaryCategoryDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public List<DictionaryCategoryDO> listByInIds(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.listByInIds(dictionaryCategoryDO);
	}

	/**
	 * 查询所有数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public List<DictionaryCategoryDO> listAll() throws Exception {
		return dictionaryCategoryDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public DictionaryCategoryDO getOneById(Long id) throws Exception {
		return dictionaryCategoryDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public DictionaryCategoryDO getOneCriteria(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.getOneCriteria(dictionaryCategoryDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public Long count(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		return dictionaryCategoryDao.count(dictionaryCategoryDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  dictionaryCategoryDO
	 * @return
	 */
	public PageInfo<DictionaryCategoryDO> listPaginated(DictionaryCategoryDO dictionaryCategoryDO) throws Exception {
		int page = dictionaryCategoryDO.getPage() == 0?1 : dictionaryCategoryDO.getPage();
		int rows = dictionaryCategoryDO.getRows() == 0?10 : dictionaryCategoryDO.getRows();
		PageHelper.startPage(page, rows);
		List<DictionaryCategoryDO> list = dictionaryCategoryDao.listPaginated(dictionaryCategoryDO);
		PageInfo<DictionaryCategoryDO> pageInfo = new PageInfo<DictionaryCategoryDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param dictionaryCategoryDO
	 * @return
	 */
	public PageInfo<DictionaryCategoryDO> listPaginatedManual(DictionaryCategoryDO  dictionaryCategoryDO) throws Exception {
		int page = dictionaryCategoryDO.getPage() == 0?1: dictionaryCategoryDO.getPage();
		int rows = dictionaryCategoryDO.getRows() == 0?10: dictionaryCategoryDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		dictionaryCategoryDO.setStart(start);
		dictionaryCategoryDO.setOffset(offset);
		List<DictionaryCategoryDO> list = dictionaryCategoryDao.listPaginatedManual(dictionaryCategoryDO);
		Long countRecords = dictionaryCategoryDao.countPaginatedManual(dictionaryCategoryDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<DictionaryCategoryDO> pageInfo = new PageInfo<DictionaryCategoryDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
