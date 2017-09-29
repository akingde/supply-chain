package com.bs.service.modules.sc.fielddatacategory.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;
import com.bs.service.modules.sc.fielddatacategory.IFieldDataCategoryDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseFieldDataCategoryService<T extends FieldDataCategoryDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<FieldDataCategoryDO> redisService;
	
	@Autowired
	protected IFieldDataCategoryDao fieldDataCategoryDao;

	/**
	 * 保存
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public Integer save(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.save(fieldDataCategoryDO);
	}

	/**
	 * 根据id修改
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public Integer updateById(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.updateById(fieldDataCategoryDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public Integer updateCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.updateCriteria(fieldDataCategoryDO);
	}
	
	/**
	 * 动态条件删除
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public Integer removeCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.removeCriteria(fieldDataCategoryDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return fieldDataCategoryDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public void removeAll() throws Exception {
		fieldDataCategoryDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public List<FieldDataCategoryDO> listCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.listCriteria(fieldDataCategoryDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public List<Long> listIdsCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.listIdsCriteria(fieldDataCategoryDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public List<FieldDataCategoryDO> listByInIds(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.listByInIds(fieldDataCategoryDO);
	}

	/**
	 * 查询所有数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public List<FieldDataCategoryDO> listAll() throws Exception {
		return fieldDataCategoryDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public FieldDataCategoryDO getOneById(Long id) throws Exception {
		return fieldDataCategoryDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public FieldDataCategoryDO getOneCriteria(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.getOneCriteria(fieldDataCategoryDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public Long count(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		return fieldDataCategoryDao.count(fieldDataCategoryDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  fieldDataCategoryDO
	 * @return
	 */
	public PageInfo<FieldDataCategoryDO> listPaginated(FieldDataCategoryDO fieldDataCategoryDO) throws Exception {
		int page = fieldDataCategoryDO.getPage() == 0?1 : fieldDataCategoryDO.getPage();
		int rows = fieldDataCategoryDO.getRows() == 0?10 : fieldDataCategoryDO.getRows();
		PageHelper.startPage(page, rows);
		List<FieldDataCategoryDO> list = fieldDataCategoryDao.listPaginated(fieldDataCategoryDO);
		PageInfo<FieldDataCategoryDO> pageInfo = new PageInfo<FieldDataCategoryDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param fieldDataCategoryDO
	 * @return
	 */
	public PageInfo<FieldDataCategoryDO> listPaginatedManual(FieldDataCategoryDO  fieldDataCategoryDO) throws Exception {
		int page = fieldDataCategoryDO.getPage() == 0?1: fieldDataCategoryDO.getPage();
		int rows = fieldDataCategoryDO.getRows() == 0?10: fieldDataCategoryDO.getRows();
		//计算手动分页参数
		int start = (page - 1) * rows;
		int offset = rows;
		fieldDataCategoryDO.setStart(start);
		fieldDataCategoryDO.setOffset(offset);
		List<FieldDataCategoryDO> list = fieldDataCategoryDao.listPaginatedManual(fieldDataCategoryDO);
		Long countRecords = fieldDataCategoryDao.countPaginatedManual(fieldDataCategoryDO);
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<FieldDataCategoryDO> pageInfo = new PageInfo<FieldDataCategoryDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
