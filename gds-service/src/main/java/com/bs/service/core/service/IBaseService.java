package com.bs.service.core.service;

import java.util.List;

public interface IBaseService<T>{
	
	/**系统处理状态只有两种成功和失败，且对应success和fail两个视图**/
	public static String SUCCESS= "success";
	public static String FAIL= "fail";
	
	/**
	 * 保存数据
	 * @param sqlid
	 * @param t
	 */
	public Integer save(T t) throws Exception;
	
	/**
	 * 数据库修改
	 * @param sqlid
	 * @param t
	 */
	public Integer updateById(T t) throws Exception;
	
	/**
	 * 动态条件删除数据
	 * @param sqlid
	 * @param t
	 */
	public Integer removeCriteria(T t) throws Exception;
	
	/**
	 * 根据主键ID删除数据
	 * @param sqlid
	 * @param t
	 */
	public Integer removeById(Long id) throws Exception;
	
	/**
	 * 删除所有数据
	 * @return
	 * @throws Exception
	 */
	public void removeAll() throws Exception;

	/**
	 * 动态条件查询列表
	 * @param sqlid
	 * @param t
	 * @return List
	 */
	public List<T> listCriteria(T t) throws Exception;
	
	/**
	 * 查询所有数据
	 * @param sqlid
	 * @param t
	 * @return List
	 */
	public List<T> listAll() throws Exception;

	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param id
	 * @return
	 */
	public T getOneById(Long id) throws Exception;
	
	/**
	 * 查询单条记录
	 * @param sqlid
	 * @param id
	 * @return
	 */
	public T getOneCriteria(T t) throws Exception;

	/**
	 * 分页查询列表
	 * @param sqlid
	 * @param t
	 * @return list
	 */
	public List<T> listPaginated(T t) throws Exception;
	
	/**
	 * 计算满足条件条数
	 * @param sqlid
	 * @param t
	 */
	public Long countPaginated(T t) throws Exception;
}
  