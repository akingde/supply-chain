package com.bs.service.modules.mc.verificationcode;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.mc.service.IVerificationCodeService;
import com.bs.api.modules.mc.dto.VerificationCodeDTO;
import com.bs.service.modules.mc.verificationcode.VerificationCodeDO;
import com.bs.service.modules.mc.verificationcode.base.BaseVerificationCodeApi;

@Service(version = "1.0.0")
public class VerificationCodeApi extends BaseVerificationCodeApi<VerificationCodeDTO> implements IVerificationCodeService{
	
	@Override
	public String bizValid(String method, VerificationCodeDO verificationCodeDO) {
		return null;
	}
}
