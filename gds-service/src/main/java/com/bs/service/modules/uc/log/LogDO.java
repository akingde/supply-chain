package com.bs.service.modules.uc.log;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.uc.log.base.BaseLogPO;

public class LogDO extends BaseLogPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.log.id}",groups = {Id.class}) 
	private Long id;


	public LogDO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
