package com.bs.rest.core.entity;

import com.bs.api.core.entity.PageData;

public class ReturnData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功返回代码
	 */
	public static final String RCODE_SUCCESS = "10000000";

	/**
	 * 参数错误代码
	 */
	public static final String RCODE_PARAM_VALID = "10000001";

	/**
	 * 业务执行失败代码
	 */
	public static final String RCODE_EXECUTE_FAIL = "10000998";

	/**
	 * 系统异常代码
	 */
	public static final String RCODE_SYSTEM_ERROR = "10000999";
	
	/** 返回结果代码 **/
	private String code;

	/** 返回结果提示信息 **/
	private String message;

	/** 返回结果数据**/
	private Object data;
	
	/**
	 * 分页信息
	 */
	private PageData pageData;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public PageData getPageData() {
		return pageData;
	}

	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
	
	
}
