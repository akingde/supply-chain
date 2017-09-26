package com.bs.service.modules.mc.shortmessagesent.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;
import com.bs.service.modules.mc.shortmessagesent.IShortMessageSentDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageSentService<T extends ShortMessageSentDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<ShortMessageSentDO> redisService;
	
	@Autowired
	protected IShortMessageSentDao shortMessageSentDao;

	/**
	 * 保存
	 * @param shortMessageSentDO
	 * @return
	 */
	public Integer save(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.save(shortMessageSentDO);
	}

	/**
	 * 根据id修改
	 * @param shortMessageSentDO
	 * @return
	 */
	public Integer updateById(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.updateById(shortMessageSentDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public Integer updateCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.updateCriteria(shortMessageSentDO);
	}
	
	/**
	 * 动态条件删除
	 * @param shortMessageSentDO
	 * @return
	 */
	public Integer removeCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.removeCriteria(shortMessageSentDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return shortMessageSentDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public void removeAll() throws Exception {
		shortMessageSentDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public List<ShortMessageSentDO> listCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.listCriteria(shortMessageSentDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public List<Long> listIdsCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.listIdsCriteria(shortMessageSentDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public List<ShortMessageSentDO> listByInIds(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.listByInIds(shortMessageSentDO);
	}

	/**
	 * 查询所有数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public List<ShortMessageSentDO> listAll() throws Exception {
		return shortMessageSentDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ShortMessageSentDO getOneById(Long id) throws Exception {
		return shortMessageSentDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public ShortMessageSentDO getOneCriteria(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.getOneCriteria(shortMessageSentDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param shortMessageSentDO
	 * @return
	 */
	public Long count(ShortMessageSentDO shortMessageSentDO) throws Exception {
		return shortMessageSentDao.count(shortMessageSentDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  shortMessageSentDO
	 * @return
	 */
	public PageInfo<ShortMessageSentDO> listPaginated(ShortMessageSentDO shortMessageSentDO) throws Exception {
		int page = shortMessageSentDO.getPage() == 0?1 : shortMessageSentDO.getPage();
		int rows = shortMessageSentDO.getRows() == 0?10 : shortMessageSentDO.getRows();
		PageHelper.startPage(page, rows);
		List<ShortMessageSentDO> list = shortMessageSentDao.listPaginated( shortMessageSentDO);
		PageInfo<ShortMessageSentDO> pageInfo = new PageInfo<ShortMessageSentDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param shortMessageSentDO
	 * @return
	 */
	public PageInfo<ShortMessageSentDO> listPaginatedManual(ShortMessageSentDO  shortMessageSentDO) throws Exception {
		List<ShortMessageSentDO> list = shortMessageSentDao.listPaginatedManual( shortMessageSentDO);
		Long countRecords = shortMessageSentDao.countPaginatedManual( shortMessageSentDO);
		int page = shortMessageSentDO.getPage() == 0?1: shortMessageSentDO.getPage();
		int rows = shortMessageSentDO.getRows() == 0?10: shortMessageSentDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<ShortMessageSentDO> pageInfo = new PageInfo<ShortMessageSentDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
