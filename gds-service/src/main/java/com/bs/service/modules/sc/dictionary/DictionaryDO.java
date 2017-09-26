package com.bs.service.modules.sc.dictionary;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.dictionary.base.BaseDictionaryPO;
import com.bs.service.modules.sc.dictionarycategory.DictionaryCategoryDO;

public class DictionaryDO extends BaseDictionaryPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.dictionary.id}",groups = {Id.class}) 
	private Long id;
	
	/**系统配置-字典分类信息存储表**/
	private DictionaryCategoryDO dictionaryCategoryDO;


	public DictionaryDO() {
	}

	public DictionaryCategoryDO getDictionaryCategoryDO () {
		return dictionaryCategoryDO;
	}

	public void setDictionaryCategoryDO(DictionaryCategoryDO dictionaryCategoryDO) {
		this.dictionaryCategoryDO = dictionaryCategoryDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
