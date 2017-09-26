package com.bs.service.modules.mc.verificationcode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.mc.verificationcode.base.BaseVerificationCodeService;
import com.bs.service.modules.mc.verificationcode.VerificationCodeDO;

@Service
@Transactional(readOnly = true)
public class VerificationCodeService extends BaseVerificationCodeService<VerificationCodeDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
