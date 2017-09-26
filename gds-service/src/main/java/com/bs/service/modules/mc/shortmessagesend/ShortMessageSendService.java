package com.bs.service.modules.mc.shortmessagesend;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.mc.shortmessagesend.base.BaseShortMessageSendService;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;

@Service
@Transactional(readOnly = true)
public class ShortMessageSendService extends BaseShortMessageSendService<ShortMessageSendDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
