package com.bs.service.modules.sc.tableindex;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.tableindex.base.BaseTableIndexPO;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;

public class TableIndexDO extends BaseTableIndexPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.tableIndex.id}",groups = {Id.class}) 
	private Long id;
	
	/**表结构存储表**/
	private TableColumnDO tableColumnDO;


	public TableIndexDO() {
	}

	public TableColumnDO getTableColumnDO () {
		return tableColumnDO;
	}

	public void setTableColumnDO(TableColumnDO tableColumnDO) {
		this.tableColumnDO = tableColumnDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
