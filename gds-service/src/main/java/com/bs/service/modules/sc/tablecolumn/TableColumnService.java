package com.bs.service.modules.sc.tablecolumn;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.tablecolumn.base.BaseTableColumnService;
import com.bs.service.modules.sc.tablecolumn.TableColumnDO;

@Service
@Transactional(readOnly = true)
public class TableColumnService extends BaseTableColumnService<TableColumnDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
