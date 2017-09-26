package com.bs.service.modules.sc.area;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.area.base.BaseAreaPO;

public class AreaDO extends BaseAreaPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.area.id}",groups = {Id.class}) 
	private Long id;


	public AreaDO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
