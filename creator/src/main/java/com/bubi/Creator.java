package com.bubi;

import java.util.HashMap;
import java.util.Map;

import com.bubi.creator.entity.Pdm;
import com.bubi.creator.service.CreateFactory;
import com.bubi.creator.service.ParserPdmService;

public class Creator{
	
	/**
	 * 生成器主函数
	 * @param arg
	 */
	
	public static void main(String[] args) {
		try {
			//解析pdm数据库设计文件
			Pdm pdm = new ParserPdmService().pdmParser("maven","C:/work/bubi-workspace/creator","mysql-bs-abs-1.0.pdm");
			//生成建库脚本，并创建数据库
			CreateFactory.getCreateDatabaseInstance().createDatebase(pdm);
			//生成dubbo api应用、生成dubbo service应用、restful api 应用,isForce：是否强制生成自定义文件
			Map<String,String> ignoreTables = new HashMap<String,String>();
			ignoreTables.put("table-code","table-code");
//			CreateFactory.getCreaterClassInstance().createDubboApi(pdm,"maven","C:/work/bubi-workspace/bubi-api",ignoreTables);
//			CreateFactory.getCreaterClassInstance().createDubboService(pdm,"maven","C:/work/bubi-workspace/bubi-service",ignoreTables);
//			CreateFactory.getCreaterClassInstance().createRestfulApi(pdm,"maven","C:/work/bubi-workspace/bubi-if",ignoreTables);
			CreateFactory.getCreaterClassInstance().createDubboApi(pdm,"maven","C:/work/bubi-workspace/test-api",ignoreTables);
			CreateFactory.getCreaterClassInstance().createDubboService(pdm,"maven","C:/work/bubi-workspace/test-service",ignoreTables);
			CreateFactory.getCreaterClassInstance().createRestfulApi(pdm,"maven","C:/work/bubi-workspace/test-if",ignoreTables);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 