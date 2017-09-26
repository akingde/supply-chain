package com.bs.service.modules.mc.shortmessageprovider;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.mc.shortmessageprovider.base.BaseShortMessageProviderService;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;

@Service
@Transactional(readOnly = true)
public class ShortMessageProviderService extends BaseShortMessageProviderService<ShortMessageProviderDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
