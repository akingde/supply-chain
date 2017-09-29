package com.bs.api.modules.sc.dto.base;

import com.bs.api.core.entity.Entity;

public abstract class BaseFieldDataCategoryDTO extends Entity {

	private static final long serialVersionUID = 1L;

	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	
	/**分类名称-**/
	private String cateName;
	
	/**分类代码-**/
	private String cateCode;
	
	/**创建时间-**/
	private String createTime;
	
	/**修改时间-**/
	private String modifyTime;
	
	public BaseFieldDataCategoryDTO() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
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
}
