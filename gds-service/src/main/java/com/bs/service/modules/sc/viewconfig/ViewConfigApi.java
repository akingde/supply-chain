package com.bs.service.modules.sc.viewconfig;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IViewConfigService;
import com.bs.api.modules.sc.dto.ViewConfigDTO;
import com.bs.service.modules.sc.viewconfig.ViewConfigDO;
import com.bs.service.modules.sc.viewconfig.base.BaseViewConfigApi;

@Service(version = "1.0.0")
public class ViewConfigApi extends BaseViewConfigApi<ViewConfigDTO> implements IViewConfigService{
	
	@Override
	public String bizValid(String method, ViewConfigDO viewConfigDO) {
		return null;
	}
}
