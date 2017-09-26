package com.bs.service.modules.mc.shortmessagesent;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.mc.shortmessagesent.base.BaseShortMessageSentPO;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;

public class ShortMessageSentDO extends BaseShortMessageSentPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.shortMessageSent.id}",groups = {Id.class}) 
	private Long id;
	
	/**短信提供商存储表**/
	private ShortMessageProviderDO shortMessageProviderDO;


	public ShortMessageSentDO() {
	}

	public ShortMessageProviderDO getShortMessageProviderDO () {
		return shortMessageProviderDO;
	}

	public void setShortMessageProviderDO(ShortMessageProviderDO shortMessageProviderDO) {
		this.shortMessageProviderDO = shortMessageProviderDO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
