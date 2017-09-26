package com.bs.service.modules.sc.dictionarycategory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.dictionarycategory.base.BaseDictionaryCategoryService;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;

@Service
@Transactional(readOnly = true)
public class DictionaryCategoryService extends BaseDictionaryCategoryService<DictionaryCategoryDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
