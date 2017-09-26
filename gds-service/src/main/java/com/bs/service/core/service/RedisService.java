package com.bs.service.core.service;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService<T> {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Resource(name = "stringRedisTemplate")
	ValueOperations<String, String> valueOperationString;

	@Autowired
	RedisTemplate<String, T> redisTemplate;

	@Resource(name = "redisTemplate")
	ValueOperations<String, T> valueOperationsObject;

	/**
	 * 根据指定key获取字符串数据
	 * @param key
	 * @return
	 */
	public String getStringData(String key) {
		return valueOperationString.get(key);
	}

	/**
	 * 存储字符串数据
	 * @param key
	 * @param val
	 */
	public void setStringData(String key, String value) {
		valueOperationString.set(key, value);
	}
	
	/**
	 * 存储字符串数据，并设置失效时间和时间类型
	 * @param key
	 * @param value
	 * @param timeout
	 * @param timeUnit
	 */
	public void setStringData(String key, String value,long timeout,TimeUnit timeUnit) {
		valueOperationString.set(key, value, timeout, timeUnit);
	}	

	/**根绝key值，删除对应的数据
	 * 删除指定key
	 * @param key
	 */
	public void removeByKey(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 根据指定o获取Object
	 * @param o
	 * @return
	 */
	public T getObjectData(Object objectKey) {
		return valueOperationsObject.get(objectKey);
	}

	/**
	 * 设置obj缓存
	 * @param o1
	 * @param o2
	 */
	public void setObjectData(String objectKey, T objectValue) {
		valueOperationsObject.set(objectKey, objectValue);
	}

	/**
	 * 删除Obj缓存
	 * @param o
	 */
	public void deleteByObject(String objectKey) {
		redisTemplate.delete(objectKey);
	}
}
