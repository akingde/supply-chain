package com.bs.service.modules.sc.tableindex;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.ITableIndexService;
import com.bs.api.modules.sc.dto.TableIndexDTO;
import com.bs.service.modules.sc.tableindex.TableIndexDO;
import com.bs.service.modules.sc.tableindex.base.BaseTableIndexApi;

@Service(version = "1.0.0")
public class TableIndexApi extends BaseTableIndexApi<TableIndexDTO> implements ITableIndexService{
	
	@Override
	public String bizValid(String method, TableIndexDO tableIndexDO) {
		return null;
	}
}
