package com.bs.service.modules.uc.log;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.uc.log.base.BaseLogService;
import com.bs.service.modules.uc.log.LogDO;

@Service
@Transactional(readOnly = true)
public class LogService extends BaseLogService<LogDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
