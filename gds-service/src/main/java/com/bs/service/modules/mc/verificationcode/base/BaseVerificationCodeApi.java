package com.bs.service.modules.mc.verificationcode.base;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.mc.dto.VerificationCodeDTO;

import com.bs.service.core.service.RedisService;
import com.bs.service.core.service.BaseService;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.mc.verificationcode.VerificationCodeService;
import com.bs.service.modules.mc.verificationcode.VerificationCodeDO;

import com.bs.service.core.group.Save;
import com.bs.service.core.group.UpdateCriteria;
import com.bs.service.core.group.Remove;
import com.bs.service.core.group.ListCriteria;
import com.bs.service.core.group.GetCriteria;
import com.bs.service.core.group.Paginated;
import com.bs.service.core.group.PageManual;
import com.bs.service.core.group.Id;

import com.github.pagehelper.PageInfo;

public abstract class BaseVerificationCodeApi<T> extends BaseService{
	
	@Autowired
	protected RedisService<VerificationCodeDO> redisService;
	
	@Autowired
	protected VerificationCodeService verificationCodeService;

	/**
	 * 回调-自定义验证逻辑
	 * @param roleDTO
	 * @param method
	 * @return
	 */
	public abstract String bizValid(String method,VerificationCodeDO verificationCodeDO);

	public ResultData<VerificationCodeDTO> save(VerificationCodeDTO verificationCodeDTO){
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			//bean 拷贝
			BeanUtils.copyProperties(verificationCodeDTO,verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("save", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = verificationCodeService.save(verificationCodeDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"save",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<VerificationCodeDTO> updateById(VerificationCodeDTO verificationCodeDTO) {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateById", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = verificationCodeService.updateById(verificationCodeDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<VerificationCodeDTO> updateCriteria(VerificationCodeDTO verificationCodeDTO) {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {UpdateCriteria.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("updateCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = verificationCodeService.updateCriteria(verificationCodeDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"updateCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<VerificationCodeDTO> removeCriteria(VerificationCodeDTO verificationCodeDTO) {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = verificationCodeService.removeCriteria(verificationCodeDO);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeCriteria",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(verificationCodeDTO);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();		
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	
	public ResultData<Long> removeById(Long id) {
		ResultData<Long> resultData = new ResultData<Long>();
		try {
			//验证输入参数
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			verificationCodeDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("removeById", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			Integer result = verificationCodeService.removeById(id);
			if (result != null && result.compareTo(0) > 0) {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeById",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setData(id);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"removeById",ResultCode.RCODE_EXECUTE_FAIL, null);
				resultData.setCode(ResultCode.RCODE_EXECUTE_FAIL);
				resultData.setData(id);
				resultData.setMessage(promptMessage);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<VerificationCodeDTO> removeAll() {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			verificationCodeService.removeAll();
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"removeAll",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<VerificationCodeDTO>> listCriteria(VerificationCodeDTO verificationCodeDTO) {
		ResultData<List<VerificationCodeDTO>> resultData = new ResultData<List<VerificationCodeDTO>>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			List<VerificationCodeDO> resultList = verificationCodeService.listCriteria(verificationCodeDO);
			if (resultList != null) {
				List<VerificationCodeDTO> listVerificationCodeDTO = new ArrayList<VerificationCodeDTO>(resultList.size());
				for (VerificationCodeDO verificationCodeDOTemp:resultList) {
					VerificationCodeDTO verificationCodeDTOTemp = new VerificationCodeDTO();
					BeanUtils.copyProperties(verificationCodeDOTemp,verificationCodeDTOTemp);
					listVerificationCodeDTO.add(verificationCodeDTOTemp);
				}
				resultData.setData(listVerificationCodeDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listCriteria",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<List<VerificationCodeDTO>> listAll() {
		ResultData<List<VerificationCodeDTO>> resultData = new ResultData<List<VerificationCodeDTO>>();
		try {
			List<VerificationCodeDO> resultList = verificationCodeService.listAll();
			if (resultList != null) {
				List<VerificationCodeDTO> listVerificationCodeDTO = new ArrayList<VerificationCodeDTO>(resultList.size());
				for (VerificationCodeDO verificationCodeDOTemp:resultList) {
					VerificationCodeDTO verificationCodeDTOTemp = new VerificationCodeDTO();
					BeanUtils.copyProperties(verificationCodeDOTemp,verificationCodeDTOTemp);
					listVerificationCodeDTO.add(verificationCodeDTOTemp);
				}
				resultData.setData(listVerificationCodeDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listAll",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<Long>> listIdsCriteria(VerificationCodeDTO verificationCodeDTO){
		ResultData<List<Long>> resultData = new ResultData<List<Long>>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<Long> resultList = verificationCodeService.listIdsCriteria(verificationCodeDO);
			resultData.setData(resultList);
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listIdsCriteria",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<VerificationCodeDTO>> listByInIds(VerificationCodeDTO verificationCodeDTO){
		ResultData<List<VerificationCodeDTO>> resultData = new ResultData<List<VerificationCodeDTO>>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {ListCriteria.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("listIdsCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			List<VerificationCodeDO> resultList = verificationCodeService.listByInIds(verificationCodeDO);
			if (resultList != null) {
				List<VerificationCodeDTO> listVerificationCodeDTO = new ArrayList<VerificationCodeDTO>(resultList.size());
				for (VerificationCodeDO verificationCodeDOTemp:resultList) {
					VerificationCodeDTO verificationCodeDTOTemp = new VerificationCodeDTO();
					BeanUtils.copyProperties(verificationCodeDOTemp,verificationCodeDTOTemp);
					listVerificationCodeDTO.add(verificationCodeDTOTemp);
				}
				resultData.setData(listVerificationCodeDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"listByInIds",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;	
	}
	
	public ResultData<VerificationCodeDTO> getOneById(Long id) {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			//验证输入参数
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			verificationCodeDO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneById", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			VerificationCodeDO resultVerificationCodeDO = verificationCodeService.getOneById(id);
			if (resultVerificationCodeDO != null) {
				VerificationCodeDTO resultVerificationCodeDTO = new VerificationCodeDTO();
				BeanUtils.copyProperties(resultVerificationCodeDO, resultVerificationCodeDTO);
				resultData.setData(resultVerificationCodeDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"getOneById",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<VerificationCodeDTO> getOneCriteria(VerificationCodeDTO verificationCodeDTO) {
		ResultData<VerificationCodeDTO> resultData = new ResultData<VerificationCodeDTO>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {GetCriteria.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getOneCriteria", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			VerificationCodeDO resultVerificationCodeDO = verificationCodeService.getOneCriteria(verificationCodeDO);
			if (resultVerificationCodeDO != null) {
				VerificationCodeDTO resultVerificationCodeDTO = new VerificationCodeDTO();
				BeanUtils.copyProperties(resultVerificationCodeDO, resultVerificationCodeDTO);
				resultData.setData(resultVerificationCodeDTO);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"getOneCriteria",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}

	public ResultData<List<VerificationCodeDTO>> paginated(VerificationCodeDTO verificationCodeDTO) {
		ResultData<List<VerificationCodeDTO>> resultData = new ResultData<List<VerificationCodeDTO>>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {Paginated.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginated", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<VerificationCodeDO> pageInfo = verificationCodeService.listPaginated(verificationCodeDO);
			if (pageInfo != null) {
				List<VerificationCodeDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<VerificationCodeDTO> listVerificationCodeDTO = new ArrayList<VerificationCodeDTO>(resultList.size());
    				for (VerificationCodeDO verificationCodeDOTemp:resultList) {
    					VerificationCodeDTO verificationCodeDTOTemp = new VerificationCodeDTO();
    					BeanUtils.copyProperties(verificationCodeDOTemp,verificationCodeDTOTemp);
    					listVerificationCodeDTO.add(verificationCodeDTOTemp);
    				}
    				resultData.setData(listVerificationCodeDTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"paginated",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
	
	public ResultData<List<VerificationCodeDTO>> paginatedManual(VerificationCodeDTO verificationCodeDTO) {
		ResultData<List<VerificationCodeDTO>> resultData = new ResultData<List<VerificationCodeDTO>>();
		try {
			VerificationCodeDO verificationCodeDO = new VerificationCodeDO();
			BeanUtils.copyProperties(verificationCodeDTO, verificationCodeDO);
			//验证输入参数
			Class<?> groupCls [] = {PageManual.class};
			String validMsg = super.validator(verificationCodeDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("paginatedManual", verificationCodeDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//自动分页查询
			PageInfo<VerificationCodeDO> pageInfo = verificationCodeService.listPaginatedManual(verificationCodeDO);
			if (pageInfo != null) {
				List<VerificationCodeDO> resultList = pageInfo.getList();
				if (resultList != null) {
					List<VerificationCodeDTO> listVerificationCodeDTO = new ArrayList<VerificationCodeDTO>(resultList.size());
    				for (VerificationCodeDO verificationCodeDOTemp:resultList) {
    					VerificationCodeDTO verificationCodeDTOTemp = new VerificationCodeDTO();
    					BeanUtils.copyProperties(verificationCodeDOTemp,verificationCodeDTOTemp);
    					listVerificationCodeDTO.add(verificationCodeDTOTemp);
    				}
    				resultData.setData(listVerificationCodeDTO);
				}
				//分页数据结果返回
				PageData pageData = new PageData();
				pageData.setPage(pageInfo.getPageNum());
				pageData.setRecords(pageInfo.getTotal());
				pageData.setRows(pageInfo.getPageSize());
				pageData.setTotal(pageInfo.getPages());
				resultData.setPageData(pageData);
			}
			//设置返回码和提示信息
			String promptMessage = super.getMessage(this.getClass(),"paginatedManual",ResultCode.RCODE_SUCCESS, null);
			resultData.setCode(ResultCode.RCODE_SUCCESS);
			resultData.setMessage(promptMessage);
		}
		catch (Exception e) {
			e.printStackTrace();
			resultData.setCode(ResultCode.RCODE_SYSTEM_ERROR);
			resultData.setMessage(e.getMessage());
		}
		return resultData;
	}
}
