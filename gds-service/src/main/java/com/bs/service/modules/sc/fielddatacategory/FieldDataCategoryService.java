package com.bs.service.modules.sc.fielddatacategory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.fielddatacategory.base.BaseFieldDataCategoryService;
import com.bs.service.modules.sc.fielddatacategory.FieldDataCategoryDO;

@Service
@Transactional(readOnly = true)
public class FieldDataCategoryService extends BaseFieldDataCategoryService<FieldDataCategoryDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
