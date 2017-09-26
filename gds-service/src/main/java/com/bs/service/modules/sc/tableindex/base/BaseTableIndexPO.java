package com.bs.service.modules.sc.tableindex.base;

import com.bs.service.core.entity.Entity;

public abstract class BaseTableIndexPO extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	
	/**字段信息表主键-**/
	private Long columnId;
	
	/**数据库对象ID-**/
	private String objectId;
	
	/**表代码-**/
	private String code;
	
	/**表名称-**/
	private String name;
	
	/**PDM创建时间-**/
	private Long creationDate;
	
	/**PDM修改时间-**/
	private Long modificationDate;
	
	/**数据版本-**/
	private Long version;
	
	/**创建时间-创建时间：角色的创建时间，为以后进行跟踪查询。**/
	private String createTime;
	
	/**修改时间-**/
	private String modifyTime;
	
	/**备注-机构描述：机构相关信息的说明或者描述。**/
	private String comment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}

	public Long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Long modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
