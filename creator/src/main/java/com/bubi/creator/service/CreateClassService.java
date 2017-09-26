package com.bubi.creator.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bubi.creator.entity.Pdm;
import com.bubi.creator.entity.PdmReference;
import com.bubi.creator.entity.PdmTable;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CreateClassService extends BaseCreateService {

	static Logger logger = Logger.getLogger(CreateClassService.class);

//	private ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

	public CreateClassService(){
	}

	/**
	 * 生成dubbo service 相关类和资源文件
	 * @param pdm
	 * @param projectType
	 * @param targetProjectPath
	 */
	public void createDubboService(Pdm pdm,String projectType,String targetProjectPath,Map<String,String> ignoreTables){
		logger.debug("开始进行系统开发文件生成...");
		// 生成器根目录
		String creatorRootPath = System.getProperty("user.dir");
		// 生成模板文件存放目录
		String creatorTemplatePath = null;
		// 目标项目类路径
		String targetProjectClassPath = null;
		// 目标项目资源文件路径
		String targetProjectResourcesPath = null;
		//生成类，资源文件，mybatis 配置文件
		if (projectType.equals("maven")){
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "resources" + File.separator 
					+ "creator" + File.separator
					+ "template" + File.separator 
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "java" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator 
					+ "service";
			targetProjectResourcesPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "resources";
		}
		else{
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "creater" + File.separator
					+ "template" + File.separator
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator 
					+ "service";
			targetProjectResourcesPath = targetProjectPath + File.separator 
					+ "src";
		}
		//忽略的表过滤掉
		ArrayList<PdmTable> tables = pdm.getTables();
		ArrayList<PdmTable> genTables = new ArrayList<PdmTable>();
		if (ignoreTables != null && ignoreTables.size() > 0) {
    		for(PdmTable table:tables){
    			//判断表是否忽略生成
    			String originalCode = table.getOriginalCode() == null?"":table.getOriginalCode();
    			String ignoreTableCode = ignoreTables.get(originalCode);
    			if (ignoreTableCode != null) {
    				logger.debug("数据表["+originalCode+"]不进行开发文件的生成.");
    				continue;
    			}
    			genTables.add(table);
    		}
    		// 生成主配置文件
    		this.createMybatisConfig(creatorTemplatePath,targetProjectResourcesPath,genTables,false);
		}
		else {
			// 生成主配置文件
			this.createMybatisConfig(creatorTemplatePath,targetProjectResourcesPath,tables,false);
		}
		
		//生成dubbo provider配置文件
//		this.createDubboProvicer(creatorTemplatePath,targetProjectResourcesPath,tables,false);
		// 表关系
		ArrayList<PdmReference> references = pdm.getReferences();
		// 生成表相关的配置文件
		for(PdmTable table:tables){
			//判断表是否忽略生成
			String originalCode = table.getOriginalCode() == null?"":table.getOriginalCode();
			String ignoreTableCode = ignoreTables.get(originalCode);
			if (ignoreTableCode != null) {
				continue;
			}
			// 生成基类实体bean
			this.createServicePO(creatorTemplatePath,targetProjectClassPath,table,references);
			// 生成实体 sub bean
			this.createServiceDO(creatorTemplatePath,targetProjectClassPath,table,references,true);
			// 生成实体basedao
			this.createBaseDao(creatorTemplatePath,targetProjectClassPath,table,references);
			// 生成实体 sub dao
			this.createSubDao(creatorTemplatePath,targetProjectClassPath,table,false);
			// 生成实体base mybatis
			this.createBaseMybatis(creatorTemplatePath,targetProjectClassPath,tables,table,references);
			// 生成实体 sub mybatis
			this.createSubMybatis(creatorTemplatePath,targetProjectClassPath,table,references,false);
			// 生成实体 sub service
			this.createBaseService(creatorTemplatePath,targetProjectClassPath,table);
			// 生成实体 sub service
			this.createSubService(creatorTemplatePath,targetProjectClassPath,table,false);
			//生成dubbo base api
			this.createDubboBaseImpl(creatorTemplatePath,targetProjectClassPath,table);
			//生成dubbo api
			this.createDubboImpl(creatorTemplatePath,targetProjectClassPath,table,false);
			// 生成message文件
			this.createServiceMessage(creatorTemplatePath,targetProjectClassPath,table,false);

		}
		logger.debug("系统开发文件生成完成.");
	}
	
	
	/**
	 * 创建restful接口项目
	 * @param pdm
	 * @param projectType
	 * @param targetProjectPath
	 */
	public void createRestfulApi(Pdm pdm,String projectType,String targetProjectPath,Map<String,String> ignoreTables){
		logger.debug("开始进行系统开发文件生成...");
		// 生成器根目录
		String creatorRootPath = System.getProperty("user.dir");
		// 生成模板文件存放目录
		String creatorTemplatePath = null;
		// 目标项目类路径
		String targetProjectClassPath = null;
		// 目标项目资源文件路径
//		String targetProjectResourcesPath = null;
		//生成类，资源文件，mybatis 配置文件
		if (projectType.equals("maven")){
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "resources" + File.separator 
					+ "creator" + File.separator
					+ "template" + File.separator 
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "java" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator 
					+ "rest";
//			targetProjectResourcesPath = targetProjectPath + File.separator 
//					+ "src" + File.separator 
//					+ "main" + File.separator 
//					+ "resources";
		}
		else{
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "creater" + File.separator
					+ "template" + File.separator
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator 
					+ "rest";
//			targetProjectResourcesPath = targetProjectPath + File.separator 
//					+ "src";
		}
		ArrayList<PdmTable> tables = pdm.getTables();
		// 表关系
		ArrayList<PdmReference> references = pdm.getReferences();
		//生成dubbo provider配置文件
//		this.createDubboConsumer(creatorTemplatePath,targetProjectResourcesPath,tables);
		// 生成表相关的配置文件
		for(PdmTable table:tables){
			//判断表是否忽略生成
			String originalCode = table.getOriginalCode() == null?"":table.getOriginalCode();
			String ignoreTableCode = ignoreTables.get(originalCode);
			if (ignoreTableCode != null) {
				logger.debug("数据表["+originalCode+"]不进行开发文件的生成.");
				continue;
			}
			//生成restful vo
			this.createRestfulVO(creatorTemplatePath,targetProjectClassPath,table,references,false);
			// 生成restful api controller
			this.createRestfulApi(creatorTemplatePath,targetProjectClassPath,table,references,false);
			// 生成message文件
			this.createRestfulMessage(creatorTemplatePath,targetProjectClassPath,table,false);

		}
		logger.debug("系统开发文件生成完成.");
	}
	
	/**
	 * 生成dubbo api程序
	 * @param pdm
	 * @param projectType
	 * @param targetProjectPath
	 */
	public void createDubboApi(Pdm pdm,String projectType,String targetProjectPath,Map<String,String> ignoreTables){
		logger.debug("开始进行系统开发文件生成...");
		// 生成器根目录
		String creatorRootPath = System.getProperty("user.dir");
		// 生成模板文件存放目录
		String creatorTemplatePath = null;
		// 目标项目类路径
		String targetProjectClassPath = null;
		//生成类，资源文件，mybatis 配置文件
		if (projectType.equals("maven")){
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "resources" + File.separator 
					+ "creator" + File.separator
					+ "template" + File.separator 
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "main" + File.separator 
					+ "java" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator
					+ "api";
		}
		else{
			creatorTemplatePath = creatorRootPath + File.separator 
					+ "src" + File.separator 
					+ "creator" + File.separator
					+ "template" + File.separator
					+ "class";
			targetProjectClassPath = targetProjectPath + File.separator 
					+ "src" + File.separator 
					+ "com" + File.separator
					+ "bs" + File.separator
					+ "api";
		}
		ArrayList<PdmTable> tables = pdm.getTables();
		// 表关系
		ArrayList<PdmReference> references = pdm.getReferences();
		// 生成表相关的配置文件
		for(PdmTable table:tables){
			//判断表是否忽略生成
			String originalCode = table.getOriginalCode() == null?"":table.getOriginalCode();
			String ignoreTableCode = ignoreTables.get(originalCode);
			if (ignoreTableCode != null) {
				logger.debug("数据表["+originalCode+"]不进行开发文件的生成.");
				continue;
			}
//			// 生成基类实体bean
//			this.createServiceBaseEntity(creatorTemplatePath,targetProjectClassPath,table,references,isForce);
			// 生成实体 sub bean
			this.createServiceDTO(creatorTemplatePath,targetProjectClassPath,table,references,true);
			// 生成base接口
			this.createServiceBaseIf(creatorTemplatePath,targetProjectClassPath,table);
			// 生成base子接口
			this.createServiceIf(creatorTemplatePath,targetProjectClassPath,table,false);

		}
		logger.debug("系统开发文件生成完成.");
	}

	/**
	 * 生成BaseEntity基类
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createServicePO(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table,ArrayList<PdmReference> references){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的PO文件生成.");
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(creatorTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("base-po-entity.ftl",ENCODING);
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = targetProjectClassPath 
						+ File.separator + MODULES 
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + entityName.toLowerCase()
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + PO_CLASS_PREFIX + JAVA;
				File entityFileNameFile = new File(entityFileName);
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表关系
					model.put("references",references);
					// 设置列对象
					model.put("entityPath",entityName.toLowerCase());
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 设置列对象
					model.put("entityPackage",subsEntityPath.toLowerCase() + "." + BASE);
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的PO类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的PO类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的PO类文件生成失败.");
			}
		}
	}

	/**
	 * 生成entity文件
	 * 
	 * @param pdm
	 */
	private void createServiceDTO(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,ArrayList<PdmReference> references,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的DTO文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath + File.separator + MODULES 
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + DTO.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName + DTO_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的DTO文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("api-dto-entity.ftl",ENCODING);
				// 输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 表关系
					model.put("references",references);
					// 设置列对象
					model.put("entityPath",entityName.toLowerCase());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的DTO文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的DTO文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的DTO文件生成失败.");
			}
		}
	}

	/**
	 * 生成服务DO对象
	 * 
	 * @param pdm
	 */
	private void createServiceDO(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,ArrayList<PdmReference> references,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的DO文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath 
						+ File.separator + MODULES 
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName + DO_CLASS_PREFIX + JAVA;
				File classFile = new File(fileName);
				if (!isForce) {
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的DO类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("do-entity.ftl",ENCODING);
				// 输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 表关系
					model.put("references",references);
					// 设置列对象
					model.put("entityPath",entityName.toLowerCase());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的DO类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的DO类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的DO类文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成restful 接口 vo 实体对象
	 * @param creatorTemplatePath
	 * @param targetProjectClassPath
	 * @param table
	 * @param references
	 */
	private void createRestfulVO(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table,ArrayList<PdmReference> references,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的VO文件生成.");
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(creatorTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("restful-vo.ftl",ENCODING);
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = targetProjectClassPath 
						+ File.separator + MODULES 
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + VO;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName  + VO_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的VO类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表关系
					model.put("references",references);
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 设置列对象
					model.put("entityPackage",subsEntityPath.toLowerCase() + "." + BASE);
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的VO类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的VO类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的VO类文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成restful api
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 * @param references
	 */
	private void createRestfulApi(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,ArrayList<PdmReference> references,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的Controller类文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath 
						+ File.separator + MODULES 
						+ File.separator + subsEntityPath.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName + CONTROLLER_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的Controller类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("restful-controller.ftl",ENCODING);
				// 输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 表关系
					model.put("references",references);
					// 设置列对象
					model.put("entityPath",entityName.toLowerCase());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的Controller类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Controller类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Controller类文件生成失败.");
			}
		}
	}
	
	/**
	 * 创建基类DAO
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseDao(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,ArrayList<PdmReference> references){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的BaseDao文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("base-dao.ftl",ENCODING);
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase() 
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + DAO_CLASS_PREFIX + JAVA;
				File entityFileNameFile = new File(entityFileName);
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表关系
					model.put("references",references);
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 设置包路径
					model.put("modules",subsEntityPath.toLowerCase());
					// 实体名称路径
					model.put("entityPath",entityName.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseDao文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseDao文件生成失败.");
			}
		}
	}

	/**
	 * 生成dao文件
	 * 
	 * @param pdm
	 */
	private void createSubDao(String templateAbsolutePath,String customAbsolutePath,PdmTable table,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的SubDAO类文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + "I" + entityName + DAO_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(entityFileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的SubDAO类类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("dao.ftl",ENCODING);
				// 输出文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("modules",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + entityName + JAVA + " 的SubDAO类文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的SubDAO类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的SubDAO类文件生成失败.");
			}
		}
	}

	/**
	 * 生成mybatis 基础配置文件
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 * @param references
	 */
	private void createMybatisConfig(String creatorTemplatePath,String targetProjectResourcesPath,ArrayList<PdmTable> tables,boolean isForce){
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行【mybatis-config.xml】配置文件生成...");
			String daoTemplatePath = creatorTemplatePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("mybatis-config.ftl",ENCODING);
				// bean名称
				targetProjectResourcesPath = targetProjectResourcesPath 
						+ File.separator + MYBATIS;
				File customAbsolutePathFile = new File(targetProjectResourcesPath);
				if(!customAbsolutePathFile.exists()){
					// 生成目录
					customAbsolutePathFile.mkdirs();
				}
				String mybatisFileName = targetProjectResourcesPath + File.separator + "mybatis-config.xml";
				File mybatisFileNameFile = new File(mybatisFileName);
				// 文件存在，删除在生成
				if(mybatisFileNameFile.exists()){
					mybatisFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("tables",tables);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + "【mybatis-config.xml】的Mybatis文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("【mybatis-config.xml】配置文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("【mybatis-config.xml】配置文件生成失败.");
			}
		}
	}

	/**
	 * 进行dubbo provider config 文件生成
	 * @param creatorTemplatePath
	 * @param targetProjectResourcesPath
	 * @param tables
	 */
	@SuppressWarnings("unused")
	private void createDubboProvicer(String creatorTemplatePath,String targetProjectResourcesPath,ArrayList<PdmTable> tables,boolean isForce){
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行【dubbo-provider.xml】配置文件生成...");
			String daoTemplatePath = creatorTemplatePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("dubbo-provider.ftl",ENCODING);
				// bean名称
				targetProjectResourcesPath = targetProjectResourcesPath 
						+ File.separator + DUBBO;
				File customAbsolutePathFile = new File(targetProjectResourcesPath);
				if(!customAbsolutePathFile.exists()){
					// 生成目录
					customAbsolutePathFile.mkdirs();
				}
				String mybatisFileName = targetProjectResourcesPath + File.separator + "dubbo-provider.xml";
				File mybatisFileNameFile = new File(mybatisFileName);
				// 文件存在，删除在生成
				if(mybatisFileNameFile.exists()){
					mybatisFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("tables",tables);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + "【dubbo-provider.xml】的配置文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("【dubbo-provider.xml】配置文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("【dubbo-provider.xml】配置文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成dubbo 客户端调用配置文件
	 * @param creatorTemplatePath
	 * @param targetProjectResourcesPath
	 * @param tables
	 */
	@SuppressWarnings("unused")
	private void createDubboConsumer(String creatorTemplatePath,String targetProjectResourcesPath,ArrayList<PdmTable> tables){
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行【dubbo-consumer.xml】配置文件生成...");
			String daoTemplatePath = creatorTemplatePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("dubbo-consumer.ftl",ENCODING);
				// bean名称
				targetProjectResourcesPath = targetProjectResourcesPath 
						+ File.separator + DUBBO;
				File customAbsolutePathFile = new File(targetProjectResourcesPath);
				if(!customAbsolutePathFile.exists()){
					// 生成目录
					customAbsolutePathFile.mkdirs();
				}
				String mybatisFileName = targetProjectResourcesPath + File.separator + "dubbo-consumer.xml";
				File mybatisFileNameFile = new File(mybatisFileName);
				// 文件存在，删除在生成
				if(mybatisFileNameFile.exists()){
					mybatisFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("tables",tables);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + "【dubbo-consumer.xml】的配置文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("【dubbo-consumer.xml】配置文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("【dubbo-consumer.xml】配置文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成各表字段引用mapper
	 * @param templateAbsolutePath
	 * @param resourcesAbsolutePath
	 * @param tables
	 */
	@SuppressWarnings("unused")
	private void createFieldsMybatis(String templateAbsolutePath,String commonMybatisAbsolutePath,
			PdmTable table,ArrayList<PdmTable> tables,boolean isForce){
		// 表名称(名称结构必须为xx_xxxxxx)
		String tableCode = table.getCode();
		if(tableCode == null){
			return;
		}
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行Mybatis通用字段【common-fields-mapper.xml】配置文件生成...");
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(templateAbsolutePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("common-fields-mapper.ftl",ENCODING);
				// bean名称
				File commonMybatisAbsolutePathFile = new File(commonMybatisAbsolutePath);
				if(!commonMybatisAbsolutePathFile.exists()){
					// 生成目录
					commonMybatisAbsolutePathFile.mkdirs();
				}
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				String commonMybatisFileName = commonMybatisAbsolutePath + File.separator + subsEntityPath.toLowerCase() 
    				+ File.separator + entityName.toLowerCase() 
    				+ File.separator + BASE 
    				+ File.separator + "mysql-common-fields-mapper.xml";
				File entityFileNameFile = new File(commonMybatisFileName);
				//目录不存在创建目录
				File parentFile = entityFileNameFile.getParentFile();
				if (!parentFile.exists()){
					parentFile.mkdirs();
				}
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(commonMybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置dao包路径
					model.put("daoImportPackage",subsEntityPath.toLowerCase() + "." + entityName.toLowerCase() + "." + DAO + ".I" + entityName + DAO_CLASS_PREFIX);
					// 设置table对象
					model.put("tables",tables);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：【common-fields-mapper.xml】的Mybatis通用字段配置文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("Mybatis通用字段配置文件【common-fields-mapper.xml】生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("Mybatis通用字段配置文件【common-fields-mapper.xml】生成失败.");
			}
		}
	}
	
	/**
	 * Mybatis resultmap 通用配置文件
	 * @param templateAbsolutePath
	 * @param resultmapMybatisAbsolutePath
	 * @param tables
	 */
	@SuppressWarnings("unused")
	private void createResultmapMybatis(String templateAbsolutePath,
			String resultmapMybatisAbsolutePath,
			PdmTable table,ArrayList<PdmTable> tables,
			ArrayList<PdmReference> references,boolean isForce){
		// 表名称(名称结构必须为xx_xxxxxx)
		String tableCode = table.getCode();
		if(tableCode == null){
			return;
		}
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行Mybatis通用resultmap【common-resultmaps-mapper.xml】配置文件生成...");
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(templateAbsolutePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("common-resultmaps-mapper.ftl",ENCODING);
				// bean名称
				File resultmapMybatisAbsolutePathFile = new File(resultmapMybatisAbsolutePath);
				if(!resultmapMybatisAbsolutePathFile.exists()){
					// 生成目录
					resultmapMybatisAbsolutePathFile.mkdirs();
				}
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				String resultmapMybatisFileName = resultmapMybatisAbsolutePath 
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase() 
						+ File.separator + BASE 
						+ File.separator + "mysql-common-resultmaps-mapper.xml";
				File entityFileNameFile = new File(resultmapMybatisFileName);
				//目录不存在创建目录
				File parentFile = entityFileNameFile.getParentFile();
				if (!parentFile.exists()){
					parentFile.mkdirs();
				}
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultmapMybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置dao包路径
					model.put("daoImportPackage",subsEntityPath.toLowerCase() + "." 
					+ entityName.toLowerCase() + "." + DAO + ".I" + entityName + DAO_CLASS_PREFIX);
					// 设置table对象
					model.put("tables",tables);
					model.put("references",references);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：【common-resultmaps-mapper.xml】的Mybatis通用resultmap配置文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("Mybatis通用resultmap配置文件【common-resultmaps-mapper.xml】生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("Mybatis通用resultmap配置文件【common-resultmaps-mapper.xml】生成失败.");
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void createConditionsMybatis(String templateAbsolutePath,String conditionMybatisAbsolutePath,
			PdmTable table,ArrayList<PdmTable> tables,ArrayList<PdmReference> references,boolean isForce){
		String tableCode = table.getCode();
		if(tableCode == null){
			return;
		}
		if(tables != null && tables.size() > 0){
			logger.debug("开始进行Mybatis通用条件【common-conditions-mapper.xml】配置文件生成...");
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(templateAbsolutePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("common-conditions-mapper.ftl",ENCODING);
				// bean名称
				File conditionMybatisAbsolutePathFile = new File(conditionMybatisAbsolutePath);
				if(!conditionMybatisAbsolutePathFile.exists()){
					// 生成目录
					conditionMybatisAbsolutePathFile.mkdirs();
				}
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				String conditionMybatisFileName = conditionMybatisAbsolutePath 
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase() 
						+ File.separator + BASE 
						+ File.separator + "mysql-common-conditions-mapper.xml";
				File entityFileNameFile = new File(conditionMybatisFileName);
				//目录不存在创建目录
				File parentFile = entityFileNameFile.getParentFile();
				if (!parentFile.exists()){
					parentFile.mkdirs();
				}
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(conditionMybatisFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置dao包路径
					model.put("daoImportPackage",subsEntityPath.toLowerCase() + "." 
							+ entityName.toLowerCase() + "." + DAO + ".I" + entityName + DAO_CLASS_PREFIX);
					// 设置table对象
					model.put("tables",tables);
					model.put("references",references);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：【common-conditions-mapper.xml】的Mybatis通用条件配置文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug("Mybatis通用条件配置文件【common-conditions-mapper.xml】生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug("Mybatis通用条件配置文件【common-conditions-mapper.xml】生成失败.");
			}
		}
	}

	/**
	 * 生成基础配置文件
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseMybatis(String templateAbsolutePath,String customAbsolutePath,
			ArrayList<PdmTable> tables,PdmTable table,ArrayList<PdmReference> references){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的BaseMybatis文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("base-sql-mapper.ftl",ENCODING);
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath 
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase() 
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE + "-" 
				+ entityName.toLowerCase() + "-sql-mapper.xml";
				File entityFileNameFile = new File(entityFileName);
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 表关系
					model.put("references",references);
					// 设置table对象
					model.put("table",table);
					// 设置tablelist对象
					model.put("tables",tables);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + BASE + "-" + entityName.toLowerCase() + "-sql-mapper" + XML + " 的Mybatis文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseMybatis文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseMybatis文件生成失败.");
			}
		}
	}

	/**
	 * 生成mybatis配置文件
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createSubMybatis(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,ArrayList<PdmReference> references,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的Sub Mybatis文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + entityName.toLowerCase() ;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + "custom-" + entityName.toLowerCase() + "-sql-mapper.xml";
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的Sub Mybatis文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("sql-mapper.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 表关系
					model.put("references",references);
					// 表
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 生成文件
					template.process(model,out);
					logger.debug("生成名称为：" + "custom-" + BASE + "-" + entityName.toLowerCase() + "-sql-mapper" + XML + " 的Mybatis文件.");
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的Sub Mybatis文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的Sub Mybatis文件生成失败.");
			}
		}
	}

	/**
	 * 生成基类service
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createBaseService(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的BaseService文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("base-service.ftl",ENCODING);
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase() 
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath 
						+ File.separator + BASE_CLASS_PREFIX 
						+ entityName + SERVICE_CLASS_PREFIX + JAVA;
				File entityFileNameFile = new File(entityFileName);
				// 文件存在，删除在生成
				if(entityFileNameFile.exists()){
					entityFileNameFile.delete();
				}
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseService文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseService文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成service文件
	 * 
	 * @param pdm
	 */
	private void createSubService(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的SubService类文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName + SERVICE_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的SubService类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("service.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的SubService类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的SubService类文件生成失败.");
			}
		}
	}

	private void createDubboBaseImpl(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的BaseAPI类文件生成...");
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = targetProjectClassPath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase()
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + BASE_CLASS_PREFIX + entityName + API_CLASS_PREFIX + JAVA;
//				File classFile = new File(entityFileName);
//				if(classFile.exists()){
//					logger.debug("名称为：" + entityName + JAVA + " 的子类文件已经存在，不在进行生成.");
//					return;
//				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(creatorTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("dubbo-base-api.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的BaseAPI类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的BaseAPI类文件生成失败.");
			}
		}
	}
	
	private void createDubboImpl(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表的SubAPI类文件生成...");
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = targetProjectClassPath
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + entityName + API_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityName + JAVA + " 的SubAPI类文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(creatorTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("dubbo-api.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体路径名称
					model.put("entityPath",entityName.toLowerCase());
					// 设置实体bean路径
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表的SubAPI类文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表的SubAPI类文件生成失败.");
			}
		}
	}
	/**
	 * 生成消息文件
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createRestfulMessage(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成...");
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = targetProjectClassPath 
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + MESSAGE;
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				// 收字母小写
				String firstChar = entityName.substring(0,1).toLowerCase();
				String entityNameTemp = firstChar + entityName.substring(1,entityName.length());
				String fileName = entityPath + File.separator + entityNameTemp + MESSAGE_LOCAL + PROPERTIES;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityNameTemp + MESSAGE_LOCAL + PROPERTIES + " 的" + MESSAGE_LOCAL + "文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(creatorTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("restful-messages.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),ENCODING));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成失败.");
			}
		}
	}
	/**
	 * 生成国际化文件
	 * 
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createServiceMessage(String templateAbsolutePath,String customAbsolutePath,
			PdmTable table,boolean isForce){
		if(table != null){
			// 表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if(tableCode == null){
				return;
			}
			logger.debug("开始进行" + tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成...");
			String daoTemplatePath = templateAbsolutePath;
			try{
				// 生成实体bean目录
				// 转换成小写
				int index = tableCode.indexOf("_");
				// 截取目录
				String subsEntityPath = tableCode.substring(0,index);
				// bean名称
				String entityName = tableCode.substring(index + 1,tableCode.length());
				// 生成目录
				String entityPath = customAbsolutePath 
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase() 
						+ File.separator + entityName.toLowerCase();
				File entityPathFile = new File(entityPath);
				if(!entityPathFile.exists()){
					// 生成目录
					entityPathFile.mkdirs();
				}
				// 收字母小写
				String firstChar = entityName.substring(0,1).toLowerCase();
				String entityNameTemp = firstChar + entityName.substring(1,entityName.length());
				String fileName = entityPath + File.separator + entityNameTemp + MESSAGE_LOCAL + PROPERTIES;
				if (!isForce) {
    				File classFile = new File(fileName);
    				if(classFile.exists()){
    					logger.debug("名称为：" + entityNameTemp + MESSAGE_LOCAL + PROPERTIES + " 的" + MESSAGE_LOCAL + "文件已经存在，不在进行生成.");
    					return;
    				}
				}
				// freemarker 配置对象
				Configuration config = new Configuration();
				// 模板文件目录
				File file = new File(daoTemplatePath);
				// 加载模板文件
				config.setDirectoryForTemplateLoading(file);
				// 设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				// 加载模板文件
				Template template = config.getTemplate("service-messages.ftl",ENCODING);
				// 生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),ENCODING));
				try{
					// 上文数据存储对象
					Map<String,Object> model = new HashMap<String,Object>();
					// 设置列对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 实体名称
					model.put("entity",entityName);
					// 生成文件
					template.process(model,out);
					if(out != null){
						out.flush();
						out.close();
					}
				}
				catch(TemplateException e){
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成完成.");
			}
			catch(IOException e1){
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表对应的" + MESSAGE_LOCAL + "文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成基类接口
	 * @param creatorTemplatePath
	 * @param targetProjectClassPath
	 * @param table
	 */
	private void createServiceBaseIf(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表对应的Base Sevice Api的接口类文件生成...");
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = targetProjectClassPath 
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + SERVICE
						+ File.separator + BASE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String entityFileName = entityPath + File.separator + "I" + BASE_CLASS_PREFIX + entityName + SERVICE_CLASS_PREFIX + JAVA;
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(creatorTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("api-interface-base-service.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表对应的Base Sevice Api的接口文件[" + entityFileName + "]生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表对应的Base Sevice Api的接口文件生成失败.");
			}
		}
	}
	
	/**
	 * 生成接口类
	 * @param parentProjectRoot
	 * @param subProjectRoot
	 * @param templateAbsolutePath
	 * @param customAbsolutePath
	 * @param table
	 */
	private void createServiceIf(String creatorTemplatePath,String targetProjectClassPath,
			PdmTable table,boolean isForce){
		if (table != null){
			//表名称(名称结构必须为xx_xxxxxx)
			String tableCode = table.getCode();
			if (tableCode == null){
				return ;
			}
			logger.debug("开始进行"+tableCode+"数据库表对应的Sevice Api的子接口类文件生成...");
			try {
				//生成实体bean目录
				//转换成小写
				int index  = tableCode.indexOf("_");
				//截取目录
				String subsEntityPath = tableCode.substring(0, index);
				//bean名称
				String entityName = tableCode.substring(index+1, tableCode.length());
				//生成目录
				String entityPath = targetProjectClassPath 
						+ File.separator + MODULES
						+ File.separator + subsEntityPath.toLowerCase()
						+ File.separator + SERVICE;
				File entityPathFile = new File(entityPath);
				if (!entityPathFile.exists()){
					//生成目录
					entityPathFile.mkdirs();
				}
				String fileName = entityPath + File.separator + "I" + entityName + SERVICE_CLASS_PREFIX + JAVA;
				if (!isForce) {
    				File  classFile = new File(fileName);
    				if (classFile.exists()){
    					logger.debug("名称为：" + "I" + entityName + JAVA + " 的Sevice Api的子接口类文件已经存在，不在进行生成.");
    					return ;
    				}
				}
				//freemarker 配置对象
				Configuration config = new Configuration();
				//模板文件目录
				File file = new File(creatorTemplatePath);
				//加载模板文件
				config.setDirectoryForTemplateLoading(file);
				//设置包装对象
				config.setObjectWrapper(new DefaultObjectWrapper());
				//加载模板文件
				Template template = config.getTemplate("api-interface-service.ftl",ENCODING);
				//生成文件
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")); 
				try { 
					//上文数据存储对象
					Map<String, Object> model = new HashMap<String, Object>();
					// 设置table对象
					model.put("table",table);
					// 设置列对象
					model.put("columns",table.getColumns());
					// 设置业务目录
					model.put("module",subsEntityPath.toLowerCase());
					// 实体名称
					model.put("entity",entityName);
					//生成文件
					template.process(model, out);
					if (out != null){
						out.flush();  
			            out.close(); 
					}
				} catch (TemplateException e) {
					e.printStackTrace();
				}
				logger.debug(tableCode + "数据库表对应的Sevice Api的子接口文件[" + fileName + "]生成完成.");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.debug(tableCode + "数据库表对应的Sevice Api的子接口文件生成失败.");
			}
		}
	}

}