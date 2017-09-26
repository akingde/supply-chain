package com.bs.service.modules.mc.shortmessagesend;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.mc.service.IShortMessageSendService;
import com.bs.api.modules.mc.dto.ShortMessageSendDTO;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;
import com.bs.service.modules.mc.shortmessagesend.base.BaseShortMessageSendApi;

@Service(version = "1.0.0")
public class ShortMessageSendApi extends BaseShortMessageSendApi<ShortMessageSendDTO> implements IShortMessageSendService{
	
	@Override
	public String bizValid(String method, ShortMessageSendDO shortMessageSendDO) {
		return null;
	}
}
