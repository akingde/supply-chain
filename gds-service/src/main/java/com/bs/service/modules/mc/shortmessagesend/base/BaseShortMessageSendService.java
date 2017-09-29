package com.bs.service.modules.mc.shortmessagesend.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;
import com.bs.service.modules.mc.shortmessagesend.IShortMessageSendDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseShortMessageSendService<T extends ShortMessageSendDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<ShortMessageSendDO> redisService;
	
	@Autowired
	protected IShortMessageSendDao shortMessageSendDao;

	/**
	 * 保存
	 * @param shortMessageSendDO
	 * @return
	 */
	public Integer save(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.save(shortMessageSendDO);
	}

	/**
	 * 根据id修改
	 * @param shortMessageSendDO
	 * @return
	 */
	public Integer updateById(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.updateById(shortMessageSendDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public Integer updateCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.updateCriteria(shortMessageSendDO);
	}
	
	/**
	 * 动态条件删除
	 * @param shortMessageSendDO
	 * @return
	 */
	public Integer removeCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.removeCriteria(shortMessageSendDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return shortMessageSendDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public void removeAll() throws Exception {
		shortMessageSendDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public List<ShortMessageSendDO> listCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.listCriteria(shortMessageSendDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public List<Long> listIdsCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.listIdsCriteria(shortMessageSendDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public List<ShortMessageSendDO> listByInIds(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.listByInIds(shortMessageSendDO);
	}

	/**
	 * 查询所有数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public List<ShortMessageSendDO> listAll() throws Exception {
		return shortMessageSendDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ShortMessageSendDO getOneById(Long id) throws Exception {
		return shortMessageSendDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public ShortMessageSendDO getOneCriteria(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.getOneCriteria(shortMessageSendDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param shortMessageSendDO
	 * @return
	 */
	public Long count(ShortMessageSendDO shortMessageSendDO) throws Exception {
		return shortMessageSendDao.count(shortMessageSendDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  shortMessageSendDO
	 * @return
	 */
	public PageInfo<ShortMessageSendDO> listPaginated(ShortMessageSendDO shortMessageSendDO) throws Exception {
		int page = shortMessageSendDO.getPage() == 0?1 : shortMessageSendDO.getPage();
		int rows = shortMessageSendDO.getRows() == 0?10 : shortMessageSendDO.getRows();
		PageHelper.startPage(page, rows);
		List<ShortMessageSendDO> list = shortMessageSendDao.listPaginated(shortMessageSendDO);
		PageInfo<ShortMessageSendDO> pageInfo = new PageInfo<ShortMessageSendDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param shortMessageSendDO
	 * @return
	 */
	public PageInfo<ShortMessageSendDO> listPaginatedManual(ShortMessageSendDO  shortMessageSendDO) throws Exception {
		int page = shortMessageSendDO.getPage() == 0?1: shortMessageSendDO.getPage();
		int rows = shortMessageSendDO.getRows() == 0?10: shortMessageSendDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		shortMessageSendDO.setStart(start);
		shortMessageSendDO.setOffset(offset);
		List<ShortMessageSendDO> list = shortMessageSendDao.listPaginatedManual(shortMessageSendDO);
		Long countRecords = shortMessageSendDao.countPaginatedManual(shortMessageSendDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<ShortMessageSendDO> pageInfo = new PageInfo<ShortMessageSendDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
