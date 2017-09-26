package com.bubi.creator.service;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.bubi.creator.dao.impl.TableDao;


public class QueryService  extends BaseCreateService{
	
	static Logger logger = Logger.getLogger(QueryService.class);
	/**表信息操作Dao**/
	private TableDao tableDao;
	/**表字段信息操作Dao**/
	public QueryService(){
		tableDao = new TableDao();
	}
	
	public void handleAreaData(){
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("table","SC_Area");
		List<HashMap<String,Object>> listMap  = tableDao.selectList("select_data",paramMap);
		for (HashMap<String,Object> resultMap:listMap){
			System.out.println(resultMap.get("name"));
		}
	}
	
}