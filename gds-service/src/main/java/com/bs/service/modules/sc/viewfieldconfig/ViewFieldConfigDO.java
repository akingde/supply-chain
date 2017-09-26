package com.bs.service.modules.sc.viewfieldconfig;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.viewfieldconfig.base.BaseViewFieldConfigPO;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;

public class ViewFieldConfigDO extends BaseViewFieldConfigPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.viewFieldConfig.id}",groups = {Id.class}) 
	private Long id;
	
	/**视图配置信息存储表**/
	private ViewConfigDO viewConfigDO;
	
	/**表结构存储表**/
	private TableColumnDO tableColumnDO;
	
	/**视图字段数据分类信息存储表**/
	private FieldDataCategoryDO fieldDataCategoryDO;


	public ViewFieldConfigDO() {
	}

	public ViewConfigDO getViewConfigDO () {
		return viewConfigDO;
	}

	public void setViewConfigDO(ViewConfigDO viewConfigDO) {
		this.viewConfigDO = viewConfigDO;
	}

	public TableColumnDO getTableColumnDO () {
		return tableColumnDO;
	}

	public void setTableColumnDO(TableColumnDO tableColumnDO) {
		this.tableColumnDO = tableColumnDO;
	}

	public FieldDataCategoryDO getFieldDataCategoryDO () {
		return fieldDataCategoryDO;
	}

	public void setFieldDataCategoryDO(FieldDataCategoryDO fieldDataCategoryDO) {
		this.fieldDataCategoryDO = fieldDataCategoryDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
