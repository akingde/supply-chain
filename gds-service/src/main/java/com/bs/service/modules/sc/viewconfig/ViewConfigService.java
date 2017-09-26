package com.bs.service.modules.sc.viewconfig;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.viewconfig.base.BaseViewConfigService;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;

@Service
@Transactional(readOnly = true)
public class ViewConfigService extends BaseViewConfigService<ViewConfigDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
