package com.bs.rest.modules.sc.vo;

import com.bs.rest.core.entity.Entity;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class AreaVO extends Entity{

	private static final long serialVersionUID = 1L;
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	@NotNull(message = "{NotNull.area.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**父地区代码-**/
	private String parentCode;
	/**地区代码-**/
	private String code;
	/**地区名称-**/
	private String name;
	/**地区拼写-用于确定分表表名称**/
	private String spelling;
	/**树形结构机构级别-**/
	private Integer treeLevel;
	/**树形结构描述关系-**/
	private String treePath;
	/**是否为子结点-1：是 0：否**/
	private Integer isChildNode;
	/**地区类型-1：国家 2：省份 3：城市 4：区县**/
	private Integer areaType;
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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
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

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
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

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
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
