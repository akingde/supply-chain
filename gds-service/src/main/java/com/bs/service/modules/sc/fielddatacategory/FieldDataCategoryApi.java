package com.bs.service.modules.sc.fielddatacategory;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IFieldDataCategoryService;
import com.bs.api.modules.sc.dto.FieldDataCategoryDTO;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;
import com.bs.service.modules.sc.fielddatacategory.base.BaseFieldDataCategoryApi;

@Service(version = "1.0.0")
public class FieldDataCategoryApi extends BaseFieldDataCategoryApi<FieldDataCategoryDTO> implements IFieldDataCategoryService{
	
	@Override
	public String bizValid(String method, FieldDataCategoryDO fieldDataCategoryDO) {
		return null;
	}
}
