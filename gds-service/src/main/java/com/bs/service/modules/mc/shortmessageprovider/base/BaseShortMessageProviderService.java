package com.bs.service.modules.mc.shortmessageprovider.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;
import com.bs.service.modules.mc.shortmessageprovider.IShortMessageProviderDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageProviderService<T extends ShortMessageProviderDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<ShortMessageProviderDO> redisService;
	
	@Autowired
	protected IShortMessageProviderDao shortMessageProviderDao;

	/**
	 * 保存
	 * @param shortMessageProviderDO
	 * @return
	 */
	public Integer save(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.save(shortMessageProviderDO);
	}

	/**
	 * 根据id修改
	 * @param shortMessageProviderDO
	 * @return
	 */
	public Integer updateById(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.updateById(shortMessageProviderDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public Integer updateCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.updateCriteria(shortMessageProviderDO);
	}
	
	/**
	 * 动态条件删除
	 * @param shortMessageProviderDO
	 * @return
	 */
	public Integer removeCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.removeCriteria(shortMessageProviderDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return shortMessageProviderDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public void removeAll() throws Exception {
		shortMessageProviderDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public List<ShortMessageProviderDO> listCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.listCriteria(shortMessageProviderDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public List<Long> listIdsCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.listIdsCriteria(shortMessageProviderDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public List<ShortMessageProviderDO> listByInIds(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.listByInIds(shortMessageProviderDO);
	}

	/**
	 * 查询所有数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public List<ShortMessageProviderDO> listAll() throws Exception {
		return shortMessageProviderDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ShortMessageProviderDO getOneById(Long id) throws Exception {
		return shortMessageProviderDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public ShortMessageProviderDO getOneCriteria(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.getOneCriteria(shortMessageProviderDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param shortMessageProviderDO
	 * @return
	 */
	public Long count(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		return shortMessageProviderDao.count(shortMessageProviderDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  shortMessageProviderDO
	 * @return
	 */
	public PageInfo<ShortMessageProviderDO> listPaginated(ShortMessageProviderDO shortMessageProviderDO) throws Exception {
		int page = shortMessageProviderDO.getPage() == 0?1 : shortMessageProviderDO.getPage();
		int rows = shortMessageProviderDO.getRows() == 0?10 : shortMessageProviderDO.getRows();
		PageHelper.startPage(page, rows);
		List<ShortMessageProviderDO> list = shortMessageProviderDao.listPaginated( shortMessageProviderDO);
		PageInfo<ShortMessageProviderDO> pageInfo = new PageInfo<ShortMessageProviderDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param shortMessageProviderDO
	 * @return
	 */
	public PageInfo<ShortMessageProviderDO> listPaginatedManual(ShortMessageProviderDO  shortMessageProviderDO) throws Exception {
		List<ShortMessageProviderDO> list = shortMessageProviderDao.listPaginatedManual( shortMessageProviderDO);
		Long countRecords = shortMessageProviderDao.countPaginatedManual( shortMessageProviderDO);
		int page = shortMessageProviderDO.getPage() == 0?1: shortMessageProviderDO.getPage();
		int rows = shortMessageProviderDO.getRows() == 0?10: shortMessageProviderDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<ShortMessageProviderDO> pageInfo = new PageInfo<ShortMessageProviderDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
