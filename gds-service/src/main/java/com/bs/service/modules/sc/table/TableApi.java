package com.bs.service.modules.sc.table;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.ITableService;
import com.bs.api.modules.sc.dto.TableDTO;
import com.bs.service.modules.sc.table.TableDO;
import com.bs.service.modules.sc.table.base.BaseTableApi;

@Service(version = "1.0.0")
public class TableApi extends BaseTableApi<TableDTO> implements ITableService{
	
	@Override
	public String bizValid(String method, TableDO tableDO) {
		return null;
	}
}
