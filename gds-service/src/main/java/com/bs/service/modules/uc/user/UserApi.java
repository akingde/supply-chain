package com.bs.service.modules.uc.user;

import org.springframework.beans.BeanUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.UserDTO;
import com.bs.api.modules.uc.service.IUserService;
import com.bs.service.core.group.First;
import com.bs.service.core.utils.StringUtil;
import com.bs.service.modules.uc.user.base.BaseUserApi;

@Service(version = "1.0.0")
public class UserApi extends BaseUserApi<UserDTO> implements IUserService{
	
	@Override
	public String bizValid(String method, UserDO userDO) {
		return null;
	}

	@Override
	public ResultData<UserDTO> getUserByAccount(String account) {
		ResultData<UserDTO> resultData = new ResultData<UserDTO>();
		try {
			//验证输入参数
			UserDO userDO = new UserDO();
			userDO.setAccount(account);
			Class<?> groupCls [] = {First.class};
			String validMsg = super.validator(userDO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validMsg);
				return resultData;
			}
			//调用自定义验证逻辑
			String validResult = this.bizValid("getUserByAccount", userDO);
			if (validResult != null){
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
				resultData.setMessage(validResult);
				return resultData;
			}
			//执行业务
			UserDO resultUserDO = userService.getUserByAccount(account);
			if (resultUserDO != null) {
				UserDTO resultUserDTO = new UserDTO();
				BeanUtils.copyProperties(resultUserDO, resultUserDTO);
				resultData.setData(resultUserDTO);
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"getUserByAccount",ResultCode.RCODE_SUCCESS, null);
				resultData.setCode(ResultCode.RCODE_SUCCESS);
				resultData.setMessage(promptMessage);
			}
			else {
				//设置返回码和提示信息
				String promptMessage = super.getMessage(this.getClass(),"getUserByAccount",ResultCode.RCODE_PARAM_VALID, null);
				resultData.setCode(ResultCode.RCODE_PARAM_VALID);
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
}
