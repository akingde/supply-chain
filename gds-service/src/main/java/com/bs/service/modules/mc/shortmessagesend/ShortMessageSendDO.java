package com.bs.service.modules.mc.shortmessagesend;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.mc.shortmessagesend.base.BaseShortMessageSendPO;
import com.bs.service.modules.mc.shortmessageprovider.ShortMessageProviderDO;

public class ShortMessageSendDO extends BaseShortMessageSendPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.shortMessageSend.id}",groups = {Id.class}) 
	private Long id;
	
	/**短信提供商存储表**/
	private ShortMessageProviderDO shortMessageProviderDO;


	public ShortMessageSendDO() {
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
