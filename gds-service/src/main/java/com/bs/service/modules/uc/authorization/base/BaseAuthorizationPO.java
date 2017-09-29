package com.bs.service.modules.uc.authorization.base;

import com.bs.service.core.entity.Entity;

public abstract class BaseAuthorizationPO extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**权限ID-**/
	private Long id;
	
	/**视图主键Id-**/
	private Long viewConfigId;
	
	/**父权限ID-父权限代码，编码也为数字，格式同上（code）。**/
	private Long parentId;
	
	/**权限代码-**/
	private Long code;
	
	/**父权限代码-父权限代码，编码也为数字，格式同上（code）。**/
	private Long parentCode;
	
	/**父权限名称-父权限名称**/
	private String parentName;
	
	/**树形结构权限级别-此权限是否有效。1：有效 0：无效**/
	private Integer treeLevel;
	
	/**树形结构描述关系-树形结构描述关系**/
	private String treePath;
	
	/**权限名称-权限名称，用2-6个汉字进行规整描述，以方便在页面显示。**/
	private String name;
	
	/**通配符路径-树形结构描述关系**/
	private String wildcardPath;
	
	/**模型名称-**/
	private String modelName;
	
	/**实体bean名称-**/
	private String entityName;
	
	/**方法名称-**/
	private String methodName;
	
	/**视图类型-**/
	private String viewType;
	
	/**视图名称-视图名称**/
	private String viewName;
	
	/**访问路径-**/
	private String urlPath;
	
	/**页面模板名称-只有二级功能指定有效**/
	private String templateName;
	
	/**模型文件名称-**/
	private String modelFileName;
	
	/**菜单类型-**/
	private String menuType;
	
	/**是否子节点-0：否 1：是**/
	private String isChildNode;
	
	/**使用图标路径-功能使用图片**/
	private String iconPath;
	
	/**权限类型-1：非授权权限 0：授权权限**/
	private Integer authType;
	
	/**系统参数-权限描述**/
	private String params;
	
	/**数据版本-**/
	private Long version;
	
	/**创建时间-创建时间：角色的创建时间，为以后进行跟踪查询。**/
	private String createTime;
	
	/**修改时间-**/
	private String modifyTime;
	
	/**备注-机构描述：机构相关信息的说明或者描述。**/
	private String comment;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getViewConfigId() {
		return viewConfigId;
	}

	public void setViewConfigId(Long viewConfigId) {
		this.viewConfigId = viewConfigId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getParentCode() {
		return parentCode;
	}

	public void setParentCode(Long parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Integer getTreeLevel() {
		return treeLevel;
	}

	public void setTreeLevel(Integer treeLevel) {
		this.treeLevel = treeLevel;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWildcardPath() {
		return wildcardPath;
	}

	public void setWildcardPath(String wildcardPath) {
		this.wildcardPath = wildcardPath;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getModelFileName() {
		return modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getIsChildNode() {
		return isChildNode;
	}

	public void setIsChildNode(String isChildNode) {
		this.isChildNode = isChildNode;
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public Integer getAuthType() {
		return authType;
	}

	public void setAuthType(Integer authType) {
		this.authType = authType;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
