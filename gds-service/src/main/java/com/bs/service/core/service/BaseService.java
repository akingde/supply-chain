package com.bs.service.core.service;

import java.util.Iterator;
import java.util.Locale;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.bs.service.core.utils.StringUtil;

public abstract class BaseService{

	public static Logger logger = Logger.getLogger(BaseService.class);

	
	@Autowired
	private ResourceBundleMessageSource resourceBundleMessageSource;
	
	@Autowired
	private Validator validator;
	
	/**
	 * 输入参数验证
	 * @param validObj
	 * @param groupsCls
	 * @return
	 */
	public String validator(Object validObj,Class<?> groupsCls[]) {
		try{
		Iterator<ConstraintViolation<Object>> iterator = validator.validate(validObj,groupsCls).iterator();
    		while(iterator.hasNext()) {
    			ConstraintViolation<Object> constraintViolation = iterator.next();
    			return constraintViolation.getMessage();
    		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	/**
	 * 获取国家化文件配置的提示信息
	 * @param key
	 * @param replaceMsg
	 * @return
	 */
	public String getMessage(String key,String replaceMsg[]) {
		String returnMsg = null;
		try {
			returnMsg = resourceBundleMessageSource.getMessage(key, replaceMsg, Locale.CHINESE);
		}
		catch(Exception e) {
			returnMsg = key;
			System.out.println("get message error:" + e.getMessage());
		}
		return returnMsg;
	}
	
	/**
	 * 获取国家化文件配置的提示信息
	 * @param key
	 * @param replaceMsg
	 * @return
	 */
	public String getMessage(String key,String replaceMsg[],Locale locale) {
		String returnMsg = null;
		try {
			returnMsg = resourceBundleMessageSource.getMessage(key, replaceMsg,locale);
		}
		catch(Exception e) {
			returnMsg = key;
			System.out.println("get message error:" + e.getMessage());
		}
		return returnMsg;
	}
	
	/**
	 * 获取自己提示信息
	 * @param cls
	 * @param method
	 * @param code
	 * @return
	 */
	public String getMessage(Class<Object> cls,String method,String code) {
		String returnMsg = null;
		String key = null;
		try {
			key = StringUtil.toLowerCaseFirstOne(cls.getSimpleName()) + "." + method + "." + code;
			returnMsg = resourceBundleMessageSource.getMessage(key, null, Locale.CHINESE);
		}
		catch(Exception e) {
			returnMsg = key;
			System.out.println("get message error:" + e.getMessage());
		}
		return returnMsg;
	}
}
