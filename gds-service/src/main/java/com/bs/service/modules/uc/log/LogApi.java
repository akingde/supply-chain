package com.bs.service.modules.uc.log;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.uc.service.ILogService;
import com.bs.api.modules.uc.dto.LogDTO;
import com.bs.service.modules.uc.log.LogDO;
import com.bs.service.modules.uc.log.base.BaseLogApi;

@Service(version = "1.0.0")
public class LogApi extends BaseLogApi<LogDTO> implements ILogService{
	
	@Override
	public String bizValid(String method, LogDO logDO) {
		return null;
	}
}
