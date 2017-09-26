package com.bs.service.modules.sc.viewfieldconfig;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IViewFieldConfigService;
import com.bs.api.modules.sc.dto.ViewFieldConfigDTO;
import com.bs.service.modules.sc.viewfieldconfig.ViewFieldConfigDO;
import com.bs.service.modules.sc.viewfieldconfig.base.BaseViewFieldConfigApi;

@Service(version = "1.0.0")
public class ViewFieldConfigApi extends BaseViewFieldConfigApi<ViewFieldConfigDTO> implements IViewFieldConfigService{
	
	@Override
	public String bizValid(String method, ViewFieldConfigDO viewFieldConfigDO) {
		return null;
	}
}
