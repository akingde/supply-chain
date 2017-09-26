package com.bs.service.modules.sc.fielddatacategory;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.fielddatacategory.base.BaseFieldDataCategoryPO;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;	
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;	
import java.util.ArrayList;

public class FieldDataCategoryDO extends BaseFieldDataCategoryPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.fieldDataCategory.id}",groups = {Id.class}) 
	private Long id;

	
	/**视图字段数据配置信息存储表**/
	private ArrayList<FieldDataConfigDO> fieldDataConfigDOList;
	
	/**视图字段配置信息存储表**/
	private ArrayList<ViewFieldConfigDO> viewFieldConfigDOList;

	public FieldDataCategoryDO() {
	}
	
	public ArrayList<FieldDataConfigDO> getFieldDataConfigDOList () {
		return fieldDataConfigDOList;
	}

	public void setFieldDataConfigDOList(ArrayList<FieldDataConfigDO> fieldDataConfigDOList) {
		this.fieldDataConfigDOList = fieldDataConfigDOList;
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
