package com.bs.service.modules.sc.dictionarycategory;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IDictionaryCategoryService;
import com.bs.api.modules.sc.dto.DictionaryCategoryDTO;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;
import com.bs.service.modules.sc.dictionarycategory.base.BaseDictionaryCategoryApi;

@Service(version = "1.0.0")
public class DictionaryCategoryApi extends BaseDictionaryCategoryApi<DictionaryCategoryDTO> implements IDictionaryCategoryService{
	
	@Override
	public String bizValid(String method, DictionaryCategoryDO dictionaryCategoryDO) {
		return null;
	}
}
