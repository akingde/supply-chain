package com.bs.service.modules.sc.area;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.IAreaService;
import com.bs.api.modules.sc.dto.AreaDTO;
import com.bs.service.modules.sc.area.AreaDO;
import com.bs.service.modules.sc.area.base.BaseAreaApi;

@Service(version = "1.0.0")
public class AreaApi extends BaseAreaApi<AreaDTO> implements IAreaService{
	
	@Override
	public String bizValid(String method, AreaDO areaDO) {
		return null;
	}
}
