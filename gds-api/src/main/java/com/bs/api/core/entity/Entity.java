package com.bs.api.core.entity;

import java.io.Serializable;
import java.util.List;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 5574468630643899188L;

	/** 
	 * 表示请求页码（当前页）的参数名称 
	 */
	private Integer page;
	/** 
	 * 表示请求记录数的参数名称
	 */
	private Integer rows;
	/** 
	 * 表示分页起始数的参数名称 
	 */
	private Integer start;
	/** 
	 * 表示分页偏移量
	 */
	private Integer offset;
	
	/**
	 * 主键Id数组
	 */
	private List<Long> ids;
	
	/** 
	 * sql语句排序参数（降序）
	 */
	private List<Long> dorder;
	/** 
	 * sql语句排序参数（升序）
	 */
	private List<Long> aorder;
	/** 
	 * sql语句分组参数
	 */
	private List<Long> sgroup;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public List<Long> getDorder() {
		return dorder;
	}

	public void setDorder(List<Long> dorder) {
		this.dorder = dorder;
	}

	public List<Long> getAorder() {
		return aorder;
	}

	public void setAorder(List<Long> aorder) {
		this.aorder = aorder;
	}

	public List<Long> getSgroup() {
		return sgroup;
	}

	public void setSgroup(List<Long> sgroup) {
		this.sgroup = sgroup;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
}
