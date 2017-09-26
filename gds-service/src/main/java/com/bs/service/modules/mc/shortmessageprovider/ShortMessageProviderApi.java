package com.bs.service.modules.mc.shortmessageprovider;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.mc.service.IShortMessageProviderService;
import com.bs.api.modules.mc.dto.ShortMessageProviderDTO;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;
import com.bs.service.modules.mc.shortmessageprovider.base.BaseShortMessageProviderApi;

@Service(version = "1.0.0")
public class ShortMessageProviderApi extends BaseShortMessageProviderApi<ShortMessageProviderDTO> implements IShortMessageProviderService{
	
	@Override
	public String bizValid(String method, ShortMessageProviderDO shortMessageProviderDO) {
		return null;
	}
}
