package com.bs.api.core.entity;

public class PageData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前页数
	 */
	private Integer page;
	
	/**
	 * 总页数
	 */
	private Integer total;
	
	/**
	 * 每页记录数
	 */
	private Integer rows;
	
	/**
	 * 总记录数
	 */
	private Long records;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Long getRecords() {
		return records;
	}

	public void setRecords(Long records) {
		this.records = records;
	}
}
