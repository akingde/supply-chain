package com.bs.api.core.entity;

import java.io.Serializable;

/**
 * 服务层结果集对象
 */
public class ResultData<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 系统操作状态码 **/
	private String code;

	/** 系统操作提示信息 **/
	private String message;

	/** 通用对象 **/
	private T data;
	
	/**
	 * 分页信息
	 */
	private PageData pageData;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public PageData getPageData() {
		return pageData;
	}

	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
}