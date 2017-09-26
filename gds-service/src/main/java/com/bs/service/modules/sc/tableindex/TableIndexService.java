package com.bs.service.modules.sc.tableindex;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.tableindex.base.BaseTableIndexService;
import com.bs.service.modules.sc.tableindex.TableIndexDO;

@Service
@Transactional(readOnly = true)
public class TableIndexService extends BaseTableIndexService<TableIndexDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
