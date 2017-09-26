package com.bs.service.modules.sc.tablecolumn;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.tablecolumn.base.BaseTableColumnPO;
import com.bs.service.modules.sc.table.TableDO;
import com.bs.service.modules.sc.tableindex.TableIndexDO;	
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;	
import java.util.ArrayList;

public class TableColumnDO extends BaseTableColumnPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.tableColumn.id}",groups = {Id.class}) 
	private Long id;
	
	/**表信息存储表**/
	private TableDO tableDO;

	
	/**表索引信息存储表**/
	private ArrayList<TableIndexDO> tableIndexDOList;
	
	/**视图字段配置信息存储表**/
	private ArrayList<ViewFieldConfigDO> viewFieldConfigDOList;

	public TableColumnDO() {
	}

	public TableDO getTableDO () {
		return tableDO;
	}

	public void setTableDO(TableDO tableDO) {
		this.tableDO = tableDO;
	}
	
	public ArrayList<TableIndexDO> getTableIndexDOList () {
		return tableIndexDOList;
	}

	public void setTableIndexDOList(ArrayList<TableIndexDO> tableIndexDOList) {
		this.tableIndexDOList = tableIndexDOList;
	}	
	
	public ArrayList<ViewFieldConfigDO> getViewFieldConfigDOList () {
		return viewFieldConfigDOList;
	}

	public void setViewFieldConfigDOList(ArrayList<ViewFieldConfigDO> viewFieldConfigDOList) {
		this.viewFieldConfigDOList = viewFieldConfigDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
