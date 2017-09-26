package com.bs.service.modules.sc.tablereference;

import com.alibaba.dubbo.config.annotation.Service;

import com.bs.api.modules.sc.service.ITableReferenceService;
import com.bs.api.modules.sc.dto.TableReferenceDTO;
import com.bs.service.modules.sc.tablereference.TableReferenceDO;
import com.bs.service.modules.sc.tablereference.base.BaseTableReferenceApi;

@Service(version = "1.0.0")
public class TableReferenceApi extends BaseTableReferenceApi<TableReferenceDTO> implements ITableReferenceService{
	
	@Override
	public String bizValid(String method, TableReferenceDO tableReferenceDO) {
		return null;
	}
}
