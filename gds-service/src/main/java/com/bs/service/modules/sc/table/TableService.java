package com.bs.service.modules.sc.table;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.table.base.BaseTableService;
import com.bs.service.modules.sc.table.TableDO;

@Service
@Transactional(readOnly = true)
public class TableService extends BaseTableService<TableDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
