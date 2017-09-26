package com.bs.service.modules.sc.tablereference;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.modules.sc.tablereference.base.BaseTableReferenceService;
import com.bs.service.modules.sc.tablereference.TableReferenceDO;

@Service
@Transactional(readOnly = true)
public class TableReferenceService extends BaseTableReferenceService<TableReferenceDO> {

	@Override
	public void afterPropertiesSet() throws Exception {
		
	}
}
