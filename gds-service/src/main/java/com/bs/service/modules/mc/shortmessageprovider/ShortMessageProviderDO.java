package com.bs.service.modules.mc.shortmessageprovider;

import javax.validation.constraints.NotNull;

import com.bs.service.core.group.Id;

import com.bs.service.modules.mc.shortmessageprovider.base.BaseShortMessageProviderPO;
import com.bs.service.modules.mc.shortmessagesend.ShortMessageSendDO;	
import com.bs.service.modules.mc.shortmessagesent.ShortMessageSentDO;	
import java.util.ArrayList;

public class ShortMessageProviderDO extends BaseShortMessageProviderPO {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "{NotNull.shortMessageProvider.id}",groups = {Id.class}) 
	private Long id;

	
	/**业务短信发送存储表**/
	private ArrayList<ShortMessageSendDO> shortMessageSendDOList;
	
	/**业务短信发送存储表**/
	private ArrayList<ShortMessageSentDO> shortMessageSentDOList;

	public ShortMessageProviderDO() {
	}
	
	public ArrayList<ShortMessageSendDO> getShortMessageSendDOList () {
		return shortMessageSendDOList;
	}

	public void setShortMessageSendDOList(ArrayList<ShortMessageSendDO> shortMessageSendDOList) {
		this.shortMessageSendDOList = shortMessageSendDOList;
	}	
	
	public ArrayList<ShortMessageSentDO> getShortMessageSentDOList () {
		return shortMessageSentDOList;
	}

	public void setShortMessageSentDOList(ArrayList<ShortMessageSentDO> shortMessageSentDOList) {
		this.shortMessageSentDOList = shortMessageSentDOList;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
