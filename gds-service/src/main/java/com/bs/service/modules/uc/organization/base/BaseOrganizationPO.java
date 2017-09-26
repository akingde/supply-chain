package com.bs.service.modules.uc.organization.base;

import com.bs.service.core.entity.Entity;

public abstract class BaseOrganizationPO extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**机构ID-父机构ID：机构树状结构父节点标识**/
	private Long id;
	
	/**父机构ID-**/
	private Long parentId;
	
	/**父机构名称-**/
	private String parentName;
	
	/**机构类型-1：平台方 2：用款方 3：担保方 4：机构个人**/
	private Integer orgType;
	
	/**机构代码-机构代码**/
	private String code;
	
	/**机构名称-机构名称：定义记录机构的名称。**/
	private String name;
	
	/**机构简称-**/
	private String shortName;
	
	/**机构注册名称-**/
	private String registerName;
	
	/**机构电话-机构电话：机构的联系的电话。**/
	private String officePhone;
	
	/**机构传真-机构传真：机构的传真的号码。**/
	private String fax;
	
	/**机构邮政编码-机构邮政编码：机构所在地区的邮政编码。**/
	private String postCode;
	
	/**机构地址-机构地址：机构的具体的地址。**/
	private String address;
	
	/**树形结构机构级别-**/
	private Integer treeLevel;
	
	/**树形结构描述关系-**/
	private String treePath;
	
	/**是否为子结点-1：是 0：否**/
	private Integer isChildNode;
	
	/**删除状态-0：未删除 1：删除**/
	private Integer isDelete;
	
	/**数据版本-**/
	private Long version;
	
	/**创建时间-创建时间：机构创建的时间，以备后来跟踪查询**/
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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getOrgType() {
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public Integer getIsChildNode() {
		return isChildNode;
	}

	public void setIsChildNode(Integer isChildNode) {
		this.isChildNode = isChildNode;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
