package com.bs.service.modules.sc.fielddataconfig.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;
import com.bs.service.modules.sc.fielddataconfig.IFieldDataConfigDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseFieldDataConfigService<T extends FieldDataConfigDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<FieldDataConfigDO> redisService;
	
	@Autowired
	protected IFieldDataConfigDao fieldDataConfigDao;

	/**
	 * 保存
	 * @param fieldDataConfigDO
	 * @return
	 */
	public Integer save(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.save(fieldDataConfigDO);
	}

	/**
	 * 根据id修改
	 * @param fieldDataConfigDO
	 * @return
	 */
	public Integer updateById(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.updateById(fieldDataConfigDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public Integer updateCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.updateCriteria(fieldDataConfigDO);
	}
	
	/**
	 * 动态条件删除
	 * @param fieldDataConfigDO
	 * @return
	 */
	public Integer removeCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.removeCriteria(fieldDataConfigDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return fieldDataConfigDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public void removeAll() throws Exception {
		fieldDataConfigDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public List<FieldDataConfigDO> listCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.listCriteria(fieldDataConfigDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public List<Long> listIdsCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.listIdsCriteria(fieldDataConfigDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public List<FieldDataConfigDO> listByInIds(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.listByInIds(fieldDataConfigDO);
	}

	/**
	 * 查询所有数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public List<FieldDataConfigDO> listAll() throws Exception {
		return fieldDataConfigDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public FieldDataConfigDO getOneById(Long id) throws Exception {
		return fieldDataConfigDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public FieldDataConfigDO getOneCriteria(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.getOneCriteria(fieldDataConfigDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param fieldDataConfigDO
	 * @return
	 */
	public Long count(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		return fieldDataConfigDao.count(fieldDataConfigDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  fieldDataConfigDO
	 * @return
	 */
	public PageInfo<FieldDataConfigDO> listPaginated(FieldDataConfigDO fieldDataConfigDO) throws Exception {
		int page = fieldDataConfigDO.getPage() == 0?1 : fieldDataConfigDO.getPage();
		int rows = fieldDataConfigDO.getRows() == 0?10 : fieldDataConfigDO.getRows();
		PageHelper.startPage(page, rows);
		List<FieldDataConfigDO> list = fieldDataConfigDao.listPaginated( fieldDataConfigDO);
		PageInfo<FieldDataConfigDO> pageInfo = new PageInfo<FieldDataConfigDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param fieldDataConfigDO
	 * @return
	 */
	public PageInfo<FieldDataConfigDO> listPaginatedManual(FieldDataConfigDO  fieldDataConfigDO) throws Exception {
		List<FieldDataConfigDO> list = fieldDataConfigDao.listPaginatedManual( fieldDataConfigDO);
		Long countRecords = fieldDataConfigDao.countPaginatedManual( fieldDataConfigDO);
		int page = fieldDataConfigDO.getPage() == 0?1: fieldDataConfigDO.getPage();
		int rows = fieldDataConfigDO.getRows() == 0?10: fieldDataConfigDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<FieldDataConfigDO> pageInfo = new PageInfo<FieldDataConfigDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
