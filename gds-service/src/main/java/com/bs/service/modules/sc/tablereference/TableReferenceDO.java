package com.bs.service.modules.sc.tablereference;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.tablereference.base.BaseTableReferencePO;

public class TableReferenceDO extends BaseTableReferencePO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.tableReference.id}",groups = {Id.class}) 
	private Long id;


	public TableReferenceDO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
