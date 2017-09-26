package com.bs.service.modules.mc.verificationcode.base;

import java.util.List;
import com.bs.service.modules.mc.verificationcode.VerificationCodeDO;

public interface BaseVerificationCodeDao{
	/**
	 * 保存数据
	 * @param verificationCodeDO
	 */
	public Integer save(VerificationCodeDO verificationCodeDO) throws Exception;
	
	/**
	 * 数据库修改
	 * @param verificationCodeDO
	 */
	public Integer updateById(VerificationCodeDO verificationCodeDO) throws Exception;
	
	/**
	 * 动态条件修改
	 * @param verificationCodeDO
	 */
	public Integer updateCriteria(VerificationCodeDO verificationCodeDO) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param verificationCodeDO
	 */
	public Integer removeCriteria(VerificationCodeDO verificationCodeDO) throws Exception;

	/**
	 * 根据主键ID删除数据
	 * @param id
	 */
	public Integer removeById(Long id) throws Exception;
	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param verificationCodeDO
	 * @return List
	 */
	public List<VerificationCodeDO> listCriteria(VerificationCodeDO verificationCodeDO) throws Exception;

	/**
	 * 查询所有Id列表
	 * @return List
	 */
	public List<Long> listIdsCriteria(VerificationCodeDO verificationCodeDO) throws Exception;

	/**
	 * 根绝Ids查询列表数据
	 * @return List
	 */
	public List<VerificationCodeDO> listByInIds(VerificationCodeDO verificationCodeDO) throws Exception;
		
	/**
	 * 查询所有数据
	 * @return List
	 */
	public List<VerificationCodeDO> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public VerificationCodeDO getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param verificationCodeDO
	 * @return
	 */
	public VerificationCodeDO getOneCriteria(VerificationCodeDO verificationCodeDO) throws Exception;

	/**
	 * 统计记录数
	 * @param verificationCodeDO
	 */
	public Long count(VerificationCodeDO verificationCodeDO) throws Exception;

	/**
	 * 自动分页查询列表（PageHelper 插件）
	 * @param verificationCodeDO
	 * @return list
	 */
	public List<VerificationCodeDO> listPaginated(VerificationCodeDO verificationCodeDO) throws Exception;
	
	
	/**
	 * 手动分页查询
	 * @param verificationCodeDO
	 * @return list
	 */
	public List<VerificationCodeDO> listPaginatedManual(VerificationCodeDO verificationCodeDO) throws Exception;
	
	/**
	 * 手动分页查询总记录数
	 * @param verificationCodeDO
	 */
	public Long countPaginatedManual(VerificationCodeDO verificationCodeDO) throws Exception;
}
