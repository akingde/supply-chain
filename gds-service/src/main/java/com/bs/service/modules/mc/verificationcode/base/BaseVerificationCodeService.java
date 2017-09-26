package com.bs.service.modules.mc.verificationcode.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

import com.bs.service.core.service.BaseService;
import com.bs.service.core.service.RedisService;
import com.bs.service.modules.mc.verificationcode.VerificationCodeDO;
import com.bs.service.modules.mc.verificationcode.IVerificationCodeDao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseVerificationCodeService<T extends VerificationCodeDO> extends BaseService implements InitializingBean{

	@Autowired
	protected RedisService<VerificationCodeDO> redisService;
	
	@Autowired
	protected IVerificationCodeDao verificationCodeDao;

	/**
	 * 保存
	 * @param verificationCodeDO
	 * @return
	 */
	public Integer save(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.save(verificationCodeDO);
	}

	/**
	 * 根据id修改
	 * @param verificationCodeDO
	 * @return
	 */
	public Integer updateById(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.updateById(verificationCodeDO);
	}
	
	/**
	 * 动态条件修改数据
	 * @param verificationCodeDO
	 * @return
	 */
	public Integer updateCriteria(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.updateCriteria(verificationCodeDO);
	}
	
	/**
	 * 动态条件删除
	 * @param verificationCodeDO
	 * @return
	 */
	public Integer removeCriteria(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.removeCriteria(verificationCodeDO);
	}
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public Integer removeById(Long id) throws Exception {
		return verificationCodeDao.removeById(id);
	}

	/**
	 * 删除所有数据
	 * @param verificationCodeDO
	 * @return
	 */
	public void removeAll() throws Exception {
		verificationCodeDao.removeAll();
	}
	
	/**
	 * 动态条件查询列表数据
	 * @param verificationCodeDO
	 * @return
	 */
	public List<VerificationCodeDO> listCriteria(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.listCriteria(verificationCodeDO);
	}

	/**
	 * 动态条件查询主键Id数据
	 * @param verificationCodeDO
	 * @return
	 */
	public List<Long> listIdsCriteria(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.listIdsCriteria(verificationCodeDO);
	}

	/**
	 * 根据id串，in的方式查询数据
	 * @param verificationCodeDO
	 * @return
	 */
	public List<VerificationCodeDO> listByInIds(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.listByInIds(verificationCodeDO);
	}

	/**
	 * 查询所有数据
	 * @param verificationCodeDO
	 * @return
	 */
	public List<VerificationCodeDO> listAll() throws Exception {
		return verificationCodeDao.listAll();
	}
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public VerificationCodeDO getOneById(Long id) throws Exception {
		return verificationCodeDao.getOneById(id);
	}

	/**
	 * 动态条件，获取单条数据
	 * @param verificationCodeDO
	 * @return
	 */
	public VerificationCodeDO getOneCriteria(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.getOneCriteria(verificationCodeDO);
	}

	/**
	 * 动态条件，查询记录总数
	 * @param verificationCodeDO
	 * @return
	 */
	public Long count(VerificationCodeDO verificationCodeDO) throws Exception {
		return verificationCodeDao.count(verificationCodeDO);
	}

	/**
	 * 动态条件，自动分页查询列表数据
	 * @param  verificationCodeDO
	 * @return
	 */
	public PageInfo<VerificationCodeDO> listPaginated(VerificationCodeDO verificationCodeDO) throws Exception {
		int page = verificationCodeDO.getPage() == 0?1 : verificationCodeDO.getPage();
		int rows = verificationCodeDO.getRows() == 0?10 : verificationCodeDO.getRows();
		PageHelper.startPage(page, rows);
		List<VerificationCodeDO> list = verificationCodeDao.listPaginated( verificationCodeDO);
		PageInfo<VerificationCodeDO> pageInfo = new PageInfo<VerificationCodeDO>(list);
		return pageInfo;
	}

	/**
	 * 动态条件，手动分页查询列表数据
	 * @param verificationCodeDO
	 * @return
	 */
	public PageInfo<VerificationCodeDO> listPaginatedManual(VerificationCodeDO  verificationCodeDO) throws Exception {
		List<VerificationCodeDO> list = verificationCodeDao.listPaginatedManual( verificationCodeDO);
		Long countRecords = verificationCodeDao.countPaginatedManual( verificationCodeDO);
		int page = verificationCodeDO.getPage() == 0?1: verificationCodeDO.getPage();
		int rows = verificationCodeDO.getRows() == 0?10: verificationCodeDO.getRows();
		long record = countRecords == null?0:countRecords;
		int pageTotal = (int) Math.ceil(record / (double) rows);
		PageInfo<VerificationCodeDO> pageInfo = new PageInfo<VerificationCodeDO>(list);
		pageInfo.setPageNum(page);
		pageInfo.setPageSize(rows);
		pageInfo.setPages(pageTotal);
		pageInfo.setTotal(record);
		return pageInfo;
	}
	
}
