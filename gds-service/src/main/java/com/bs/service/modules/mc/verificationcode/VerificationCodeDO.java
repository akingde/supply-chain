package com.bs.service.modules.mc.verificationcode;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.mc.verificationcode.base.BaseVerificationCodePO;

public class VerificationCodeDO extends BaseVerificationCodePO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.verificationCode.id}",groups = {Id.class}) 
	private Long id;


	public VerificationCodeDO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
