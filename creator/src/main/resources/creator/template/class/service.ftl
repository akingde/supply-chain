package com.bs.service.modules.${module}.${entityPath};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.${module}.${entityPath}.base.Base${entity}Service;
import com.bs.service.modules.${module}.${entityPath}.${entity}DO;

@Service
@Transactional(readOnly = true)
public class ${entity}Service extends Base${entity}Service<${entity}DO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
