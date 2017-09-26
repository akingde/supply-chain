package com.bs.rest.modules.sc.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class DictionaryVO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	@NotNull(message = "{NotNull.dictionary.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**字典分类主键ID-字典分类主键ID**/
	private Long categoryId;
	/**参数名称-名称**/
	private String name;
	/**参数KEY-编码**/
	private String code;
	/**参数VALUE-值**/
	private String value;
	/**数据版本-**/
	private Long version;
	/**删除状态-0：未删除 1：删除**/
	private Integer isDelete;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
