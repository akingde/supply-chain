package com.bs.service.modules.sc.dictionary;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.dictionary.base.BaseDictionaryService;
import com.bs.service.modules.sc.dictionary.DictionaryDO;

@Service
@Transactional(readOnly = true)
public class DictionaryService extends BaseDictionaryService<DictionaryDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
