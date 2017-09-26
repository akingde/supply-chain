package com.bs.service.modules.sc.fielddataconfig;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.fielddataconfig.base.BaseFieldDataConfigPO;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;

public class FieldDataConfigDO extends BaseFieldDataConfigPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.fieldDataConfig.id}",groups = {Id.class}) 
	private Long id;
	
	/**视图字段数据分类信息存储表**/
	private FieldDataCategoryDO fieldDataCategoryDO;


	public FieldDataConfigDO() {
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
