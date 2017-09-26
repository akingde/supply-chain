package com.bs.service.modules.sc.dictionary;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IDictionaryService;
import com.bs.api.modules.sc.dto.DictionaryDTO;
import com.bs.service.modules.sc.dictionary.DictionaryDO;
import com.bs.service.modules.sc.dictionary.base.BaseDictionaryApi;

@Service(version = "1.0.0")
public class DictionaryApi extends BaseDictionaryApi<DictionaryDTO> implements IDictionaryService{
	
	@Override
	public String bizValid(String method, DictionaryDO dictionaryDO) {
		return null;
	}
}
