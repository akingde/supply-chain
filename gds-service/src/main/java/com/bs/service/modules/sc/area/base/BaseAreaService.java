package com.bs.service.modules.sc.area.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.area.AreaDO;
import com.bs.service.modules.sc.area.IAreaDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseAreaService<T extends AreaDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<AreaDO> redisService;
	
	@Autowired
	protected IAreaDao areaDao;

	/**
	 * 保存
	 * @param areaDO
	 * @return
	 */
	public Integer save(AreaDO areaDO) throws Exception {
		return areaDao.save(areaDO);
	}

	/**
	 * 根据id修改
	 * @param areaDO
	 * @return
	 */
	public Integer updateById(AreaDO areaDO) throws Exception {
		return areaDao.updateById(areaDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param areaDO
	 * @return
	 */
	public Integer updateCriteria(AreaDO areaDO) throws Exception {
		return areaDao.updateCriteria(areaDO);
	}
	
	/**
	 * 动态条件删除
	 * @param areaDO
	 * @return
	 */
	public Integer removeCriteria(AreaDO areaDO) throws Exception {
		return areaDao.removeCriteria(areaDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return areaDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param areaDO
	 * @return
	 */
	public void removeAll() throws Exception {
		areaDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param areaDO
	 * @return
	 */
	public List<AreaDO> listCriteria(AreaDO areaDO) throws Exception {
		return areaDao.listCriteria(areaDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param areaDO
	 * @return
	 */
	public List<Long> listIdsCriteria(AreaDO areaDO) throws Exception {
		return areaDao.listIdsCriteria(areaDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param areaDO
	 * @return
	 */
	public List<AreaDO> listByInIds(AreaDO areaDO) throws Exception {
		return areaDao.listByInIds(areaDO);
	}

	/**
	 * 查询所有数据
	 * @param areaDO
	 * @return
	 */
	public List<AreaDO> listAll() throws Exception {
		return areaDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public AreaDO getOneById(Long id) throws Exception {
		return areaDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param areaDO
	 * @return
	 */
	public AreaDO getOneCriteria(AreaDO areaDO) throws Exception {
		return areaDao.getOneCriteria(areaDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param areaDO
	 * @return
	 */
	public Long count(AreaDO areaDO) throws Exception {
		return areaDao.count(areaDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  areaDO
	 * @return
	 */
	public PageInfo<AreaDO> listPaginated(AreaDO areaDO) throws Exception {
		int page = areaDO.getPage() == 0?1 : areaDO.getPage();
		int rows = areaDO.getRows() == 0?10 : areaDO.getRows();
		PageHelper.startPage(page, rows);
		List<AreaDO> list = areaDao.listPaginated( areaDO);
		PageInfo<AreaDO> pageInfo = new PageInfo<AreaDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param areaDO
	 * @return
	 */
	public PageInfo<AreaDO> listPaginatedManual(AreaDO  areaDO) throws Exception {
		List<AreaDO> list = areaDao.listPaginatedManual( areaDO);
		Long countRecords = areaDao.countPaginatedManual( areaDO);
		int page = areaDO.getPage() == 0?1: areaDO.getPage();
		int rows = areaDO.getRows() == 0?10: areaDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<AreaDO> pageInfo = new PageInfo<AreaDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
