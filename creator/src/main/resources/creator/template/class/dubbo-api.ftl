package com.bs.service.modules.${module}.${entityPath};

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.${module}.service.I${entity}Service;
import com.bs.api.modules.${module}.dto.${entity}DTO;
import com.bs.service.modules.${module}.${entityPath}.${entity}DO;
import com.bs.service.modules.${module}.${entityPath}.base.Base${entity}Api;

@Service(version = "1.0.0")
public class ${entity}Api extends Base${entity}Api<${entity}DTO> implements I${entity}Service{
	
	@Override
	public String bizValid(String method, ${entity}DO ${entity?uncap_first}DO) {
		return null;
	}
}
