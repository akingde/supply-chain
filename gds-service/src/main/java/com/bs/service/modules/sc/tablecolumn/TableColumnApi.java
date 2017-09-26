package com.bs.service.modules.sc.tablecolumn;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.ITableColumnService;
import com.bs.api.modules.sc.dto.TableColumnDTO;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;
import com.bs.service.modules.sc.tablecolumn.base.BaseTableColumnApi;

@Service(version = "1.0.0")
public class TableColumnApi extends BaseTableColumnApi<TableColumnDTO> implements ITableColumnService{
	
	@Override
	public String bizValid(String method, TableColumnDO tableColumnDO) {
		return null;
	}
}
