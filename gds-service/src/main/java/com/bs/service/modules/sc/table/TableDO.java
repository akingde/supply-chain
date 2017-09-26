package com.bs.service.modules.sc.table;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.table.base.BaseTablePO;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;	
import java.util.ArrayList;

public class TableDO extends BaseTablePO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.table.id}",groups = {Id.class}) 
	private Long id;

	
	/**表结构存储表**/
	private ArrayList<TableColumnDO> tableColumnDOList;

	public TableDO() {
	}
	
	public ArrayList<TableColumnDO> getTableColumnDOList () {
		return tableColumnDOList;
	}

	public void setTableColumnDOList(ArrayList<TableColumnDO> tableColumnDOList) {
		this.tableColumnDOList = tableColumnDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
