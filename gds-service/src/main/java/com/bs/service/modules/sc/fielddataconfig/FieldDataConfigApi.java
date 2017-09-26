package com.bs.service.modules.sc.fielddataconfig;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IFieldDataConfigService;
import com.bs.api.modules.sc.dto.FieldDataConfigDTO;
import com.bs.service.modules.sc.fielddataconfig.FieldDataConfigDO;
import com.bs.service.modules.sc.fielddataconfig.base.BaseFieldDataConfigApi;

@Service(version = "1.0.0")
public class FieldDataConfigApi extends BaseFieldDataConfigApi<FieldDataConfigDTO> implements IFieldDataConfigService{
	
	@Override
	public String bizValid(String method, FieldDataConfigDO fieldDataConfigDO) {
		return null;
	}
}
