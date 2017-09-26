package com.bs.service.modules.sc.dictionarycategory;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.sc.dictionarycategory.base.BaseDictionaryCategoryPO;
import com.bs.service.modules.sc.dictionary.DictionaryDO;	
import java.util.ArrayList;

public class DictionaryCategoryDO extends BaseDictionaryCategoryPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.dictionaryCategory.id}",groups = {Id.class}) 
	private Long id;

	
	/**字典信息存储表**/
	private ArrayList<DictionaryDO> dictionaryDOList;

	public DictionaryCategoryDO() {
	}
	
	public ArrayList<DictionaryDO> getDictionaryDOList () {
		return dictionaryDOList;
	}

	public void setDictionaryDOList(ArrayList<DictionaryDO> dictionaryDOList) {
		this.dictionaryDOList = dictionaryDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
