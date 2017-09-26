package com.bs.service.modules.uc.authorization;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.service.core.resource.MultipleLoadPluginConfigXml;
import com.bs.service.modules.uc.authorization.base.BaseAuthorizationService;

@Service
@Transactional(readOnly = true)
public class AuthorizationService extends BaseAuthorizationService<AuthorizationDO> {

	@Autowired
	private MultipleLoadPluginConfigXml multipleLoadPluginConfigXml;
	
	@Override
	public void afterPropertiesSet() throws Exception{
		//获取初始化的xml配置文件
		String pluginNameArr[] = multipleLoadPluginConfigXml.getPluginNames();
		for(String path:pluginNameArr){
			if(path != null){
				try{
					File xmlFile = new File(path);
					if (!xmlFile.exists()) {
						continue;
					}
					File parentFile = xmlFile.getParentFile();
					// 临时文件目录
					String parentPath = parentFile.getPath() + File.separator + "tmp";
					// 若临时文件目录不存在，则创建目录
					File tmpFilePath = new File(parentPath);
					if(!tmpFilePath.exists()){
						tmpFilePath.mkdirs();
					}
					// 插件文件名称
					String pluginFileName = xmlFile.getName();
					// 替换后的临时文件前缀
//					String tmpFileName = pluginFileName.replaceAll(".xml","");
					String tmpFileName = pluginFileName + "_" + xmlFile.lastModified() + ".tmp";
					// 临时文件名称
					String pluginFile = parentPath + File.separator + tmpFileName;
					File tmpFile = new File(pluginFile);
					logger.debug("验证名称为[" + pluginFile + "]的临时文件是否存在.");
					// 判断临时文件是否存在
					if (tmpFile.exists()){
    					// 若不存在则创建或代表文件已经被修改
    					// 被修改的文件要进行重新加载
    					logger.debug("开始解析名称为[" + path + "]的文件,并解析内容入库.");
    					try {
    						this.parserXml(path);
    						tmpFile.createNewFile();
    					}
    					catch(Exception e) {
    						if (tmpFile.exists()) {
    							tmpFile.delete();
    						}
    					}
    					File files[] = tmpFilePath.listFiles();
    					if(files != null){
    						for(File fileTemp:files){
    							String fileTempName = fileTemp.getName();
    							int index = fileTempName.indexOf(pluginFileName);
    							if(index >= 0 && !fileTempName.equals(tmpFileName)){
    								fileTemp.delete();
    							}
    						}
    					}
					}
				}
				catch(Exception e){
					e.printStackTrace();
					logger.debug("开始解析名称为[" + path + "]的文件为找到或解析失败.");
					System.exit(0);
				}
			}
		}
	}

	/**
	 * dom4j 解析xml 文件
	 * @param fileName
	 * @throws Exception
	 */
	private void parserXml(String pfile) throws Exception{
		try{
			SAXReader saxReader = new SAXReader();
			// 把文件读入到文档
			Document document = saxReader.read(pfile);
			// 获取文档根节点
			Element node = document.getRootElement();
			// 递归计数器
			int index = 1;
			// 树形结构描述关系
			String relationPath = ",0,";
			if(node != null){
				String nodeName = node.getName();
				// 系统权限信息
				AuthorizationDO authorization = new AuthorizationDO();
				// 代码
				String code = this.getNodeAttrValue(node,"code");
				if(code != null){
					authorization.setCode(Long.parseLong(code));
				}

				relationPath += code + ",";
				// 中文名称
				String name = this.getNodeAttrValue(node,"name");
				if(name != null){
					authorization.setName(name);
				}
				// 权限类型 开发可见权限，上线可见权限
				String type = this.getNodeAttrValue(node,"auth-type");
				if(type != null){
					authorization.setAuthType(Integer.parseInt(type));
				}
				else{
					authorization.setAuthType(0);
				}
				// 菜单类型 目前分top和shortcut两类
				String menuType = this.getNodeAttrValue(node,"menu-type");
				if(menuType != null){
					authorization.setMenuType(menuType);
				}
				// 设置调用方法名称（service层方法）
				String methodName = this.getNodeAttrValue(node,"method-name");
				if(methodName != null && !methodName.equals("")){
					authorization.setMethodName(methodName);
				}
				else{
					authorization.setMethodName(nodeName);
				}
				// restful 风格的通配符路径
				String wildcardPath = this.getNodeAttrValue(node,"wildcard-path");
				if(wildcardPath != null && !wildcardPath.equals("")){
					authorization.setWildcardPath(wildcardPath);
				}
				// 设置调用方法名称（service层方法）
				String modelFileName = this.getNodeAttrValue(node,"model-file-name");
				if(modelFileName != null){
					authorization.setModelFileName(modelFileName);
				}
				// 设置模型名称（表名称）
				String modelName = this.getNodeAttrValue(node,"model-name");
				if(modelName != null){
					authorization.setModelName(modelName);
					// 解析对应实体bean名称
					int idx = modelName.indexOf("_");
					if(idx > -1){
						String modelNameSuffix = modelName.substring(idx + 1,modelName.length());
						String firstChar = modelNameSuffix.substring(0,1);
						String lastChar = modelNameSuffix.substring(1,modelNameSuffix.length());
						String entityName = firstChar + lastChar;
						authorization.setEntityName(entityName);
					}
				}
				// 设置模型名称,开发者自定义模板（一旦设置此值，系统不在调用默认的模板）
				String templateName = this.getNodeAttrValue(node,"template-name");
				if(templateName != null){
					authorization.setTemplateName(templateName);
				}
				authorization.setParentCode(0l);
				// 树形结构描述关系
				authorization.setTreePath(relationPath);
				// 设置级别
				authorization.setTreeLevel(index);
				authorization.setViewName(nodeName);
				if(node.elementIterator().hasNext()){
					authorization.setIsChildNode("0");
				}
				else{
					authorization.setIsChildNode("1");
				}
				try{
					Long parentId = 0l;
					AuthorizationDO authorizationTemp = authorizationDao.getOneByCode(code);
					if(authorizationTemp != null){
						parentId = authorizationTemp.getId();
						authorization.setId(authorizationTemp.getId());
						authorization.setParentId(0l);
						authorizationDao.updateById(authorization);
					}
					else{
						authorization.setParentId(0l);
						int rval = authorizationDao.save(authorization);
						if(rval > 0){
							parentId = authorization.getGeneratedKey();
						}
					}
					this.recursionParser(nodeName,nodeName,parentId,code,name,code,relationPath,++index,node);
				}
				catch(Exception e){
					e.printStackTrace();
				}

			}
		}
		catch(DocumentException e){
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 递归方式解析
	 * 
	 * @param ele
	 */
	@SuppressWarnings({"unchecked"})
	private int recursionParser(String parentController,String parentNodeName,Long parentId,String parentCode,String parentName,String parentOrder,String codeRelation,int index,Element ele){
		int childCount = 0;
		for(Iterator<Element> iterator = ele.elementIterator();iterator.hasNext();){
			Element node = iterator.next();
			String nodeName = node.getName();
			String tempParentNodeName = null;
			String tempController = null;
			String tempOrderBy = null;
			if(parentNodeName == null || "".equals(parentNodeName)){
				tempParentNodeName = nodeName;
			}
			else{
				if(index > 3){
					tempParentNodeName = parentNodeName + "_" + nodeName;
				}
				else{
					tempParentNodeName = parentNodeName + "/" + nodeName;
				}
			}
			// 系统权限信息
			AuthorizationDO authorization = new AuthorizationDO();
			authorization.setParentCode(Long.parseLong(parentCode));
			authorization.setParentName(parentName);
			authorization.setViewName(tempParentNodeName);
			// 设置权限代码
			String code = this.getNodeAttrValue(node,"code");
			if(code != null){
				authorization.setCode(Long.parseLong(code));
			}
			// 中文名称
			String name = this.getNodeAttrValue(node,"name");
			if(name != null){
				authorization.setName(name);
			}
			// 权限类型 开发可见权限，上线可见权限
			String type = this.getNodeAttrValue(node,"auth-type");
			if(type != null){
				authorization.setAuthType(Integer.parseInt(type));
			}
			else{
				authorization.setAuthType(0);
			}
			// 菜单类型 目前分top和shortcut两类
			String menuType = this.getNodeAttrValue(node,"menu-type");
			if(menuType != null){
				authorization.setMenuType(menuType);
			}
			// 设置调用方法名称（service层方法）
			String methodName = this.getNodeAttrValue(node,"method-name");
			if(methodName != null && !methodName.equals("")){
				authorization.setMethodName(methodName);
			}
			else{
				authorization.setMethodName(nodeName);
			}
			// 设置调用方法名称（service层方法）
			String modelFileName = this.getNodeAttrValue(node,"model-file-name");
			if(modelFileName != null){
				authorization.setModelFileName(modelFileName);
			}
			// 设置模型名称（表名称）
			String modelName = this.getNodeAttrValue(node,"model-name");
			if(modelName != null){
				authorization.setModelName(modelName);
				// 解析对应实体bean名称
				int idx = modelName.indexOf("_");
				if(idx > -1){
					String modelNameSuffix = modelName.substring(idx + 1,modelName.length());
					String firstChar = modelNameSuffix.substring(0,1).toLowerCase();
					String lastChar = modelNameSuffix.substring(1,modelNameSuffix.length());
					String entityName = firstChar + lastChar;
					authorization.setEntityName(entityName);
				}
			}
			// 设置模型名称,开发者自定义模板（一旦设置此值，系统不在调用默认的模板）
			String templateName = this.getNodeAttrValue(node,"template-name");
			if(templateName != null){
				authorization.setTemplateName(templateName);
			}
			// 树形结构描述关系
			String tempCodeRelation = codeRelation + code + ",";
			authorization.setTreePath(tempCodeRelation);
			// 设置级别
			authorization.setTreeLevel(index);
			if(node.elementIterator().hasNext()){
				authorization.setIsChildNode("0");
			}
			else{
				authorization.setIsChildNode("1");
			}
			try{
				Long parentIdTemp = 0l;
				AuthorizationDO authorizationTemp = authorizationDao.getOneByCode(code);
				if(authorizationTemp != null){
					parentIdTemp = authorizationTemp.getId();
					authorization.setId(authorizationTemp.getId());
					authorization.setParentId(parentId);
					authorizationDao.updateById(authorization);
				}
				else{
					authorization.setParentId(parentId);
					int rval = authorizationDao.save(authorization);
					if(rval > 0){
						parentIdTemp = authorization.getGeneratedKey();
					}
				}
				this.recursionParser(tempController,tempParentNodeName,parentIdTemp,code,name,tempOrderBy,tempCodeRelation,index + 1,node);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			childCount++;
		}
		return childCount;
	}

	/**
	 * 根据属性名称获取值
	 * 
	 * @param node
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getNodeAttrValue(Element node,String name){
		String rval = null;
		if(node.attributes() != null && node.attributes().size() > 0){
			for(Iterator subiterator = node.attributeIterator();subiterator.hasNext();){
				Attribute item = (Attribute)subiterator.next();
				String attrName = item.getName();
				String attrValue = item.getValue();
				if(attrName != null && attrName.equals(name)){
					if("true".equals(attrValue.trim())){
						attrValue = "1";
					}
					else if("false".equals(attrValue.trim())){
						attrValue = "0";
					}
					rval = attrValue;
				}
			}
		}
		return rval;
	}
	
	/**
	 * 根绝角色id查询权限列表
	 * @param authorizationDO
	 * @return
	 */
	public List<AuthorizationDO> listAuthByRoleIds(AuthorizationDO authorizationDO){
		return super.authorizationDao.listAuthByRoleIds(authorizationDO);
	}
}
