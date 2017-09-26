package com.bs.service.modules.sc.area;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.area.base.BaseAreaService;
import com.bs.service.modules.sc.area.AreaDO;

@Service
@Transactional(readOnly = true)
public class AreaService extends BaseAreaService<AreaDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
