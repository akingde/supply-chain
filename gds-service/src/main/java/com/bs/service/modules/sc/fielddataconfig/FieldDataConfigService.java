package com.bs.service.modules.sc.fielddataconfig;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.fielddataconfig.base.BaseFieldDataConfigService;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;

@Service
@Transactional(readOnly = true)
public class FieldDataConfigService extends BaseFieldDataConfigService<FieldDataConfigDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
