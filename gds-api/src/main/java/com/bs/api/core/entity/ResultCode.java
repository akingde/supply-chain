package com.bs.api.core.entity;

/**
 * 服务层通用业务返回码
 */
public class ResultCode{

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

	public static final String RCODE_SUCCESS_KEY = "system.prompt.message.10000000";
	public static final String RCODE_PARAM_VALID_KEY = "system.prompt.message.10000001";
	public static final String RCODE_EXECUTE_FAIL_KEY = "system.prompt.message.10000998";
	public static final String RCODE_SYSTEM_ERROR_KEY = "system.prompt.message.10000999";
}