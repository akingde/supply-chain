package com.bs.service.modules.mc.shortmessagesent;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.mc.service.IShortMessageSentService;
import com.bs.api.modules.mc.dto.ShortMessageSentDTO;
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;
import com.bs.service.modules.mc.shortmessagesent.base.BaseShortMessageSentApi;

@Service(version = "1.0.0")
public class ShortMessageSentApi extends BaseShortMessageSentApi<ShortMessageSentDTO> implements IShortMessageSentService{
	
	@Override
	public String bizValid(String method, ShortMessageSentDO shortMessageSentDO) {
		return null;
	}
}
