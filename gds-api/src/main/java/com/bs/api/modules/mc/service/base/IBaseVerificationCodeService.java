package com.bs.api.modules.mc.service.base;

import java.util.List;
import com.bs.api.core.entity.ResultData;
import com.bs.api.core.service.IService;
import com.bs.api.modules.mc.dto.VerificationCodeDTO;

public interface IBaseVerificationCodeService<T> extends IService<VerificationCodeDTO>{

	/**
	 * 保存
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<VerificationCodeDTO> save(VerificationCodeDTO verificationCodeDTO);

	/**
	 * 根据id修改
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<VerificationCodeDTO> updateById(VerificationCodeDTO verificationCodeDTO);
	
	/**
	 * 动态条件删除
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<VerificationCodeDTO> removeCriteria(VerificationCodeDTO verificationCodeDTO);
	
	/**
	 * 根据Id删除数据
	 * @param id
	 * @return
	 */
	public ResultData<Long> removeById(Long id);

	/**
	 * 删除所有数据
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<VerificationCodeDTO> removeAll();
	
	/**
	 * 删除所有数据
	 * @param verificationCodeDTO
	 * @return list
	 */
	public ResultData<List<VerificationCodeDTO>> listCriteria(VerificationCodeDTO verificationCodeDTO);

	/**
	 * 查询所有数据
	 * @return list
	 */
	public ResultData<List<VerificationCodeDTO>> listAll();
	
	/**
	 * 查询所有id列表
	 * @return list
	 */
	public ResultData<List<Long>> listIdsCriteria(VerificationCodeDTO verificationCodeDTO);
	
	/**
	 * 根据id数组，查询所有数据
	 * @return list
	 */
	public ResultData<List<VerificationCodeDTO>> listByInIds(VerificationCodeDTO verificationCodeDTO);
	
	/**
	 * 根据id，获取单条数据
	 * @param id
	 * @return
	 */
	public ResultData<VerificationCodeDTO> getOneById(Long id);

	/**
	 * 动态条件，获取单条数据
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<VerificationCodeDTO> getOneCriteria(VerificationCodeDTO verificationCodeDTO);

	/**
	 * 动态条件，查询分页列表数据
	 * @param verificationCodeDTO
	 * @return
	 */
	public ResultData<List<VerificationCodeDTO>> paginated(VerificationCodeDTO verificationCodeDTO);

}
