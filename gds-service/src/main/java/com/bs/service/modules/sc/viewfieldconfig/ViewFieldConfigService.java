package com.bs.service.modules.sc.viewfieldconfig;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.viewfieldconfig.base.BaseViewFieldConfigService;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;

@Service
@Transactional(readOnly = true)
public class ViewFieldConfigService extends BaseViewFieldConfigService<ViewFieldConfigDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
