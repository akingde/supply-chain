package com.bs.service.modules.mc.shortmessagesent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.mc.shortmessagesent.base.BaseShortMessageSentService;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;

@Service
@Transactional(readOnly = true)
public class ShortMessageSentService extends BaseShortMessageSentService<ShortMessageSentDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
