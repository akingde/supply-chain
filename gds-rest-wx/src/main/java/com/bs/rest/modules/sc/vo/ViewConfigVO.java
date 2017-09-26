package com.bs.rest.modules.sc.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class ViewConfigVO implements Serializable{

	private static final long serialVersionUID = 1L;
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	@NotNull(message = "{NotNull.viewConfig.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**表主键-**/
	private Long tableId;
	/**子表主键-**/
	private String tableIds;
	/**树形表主键-**/
	private Long treeTableId;
	/**权限父代码-**/
	private Long authParentCode;
	/**权限代码-**/
	private Long authCode;
	/**权限名称-**/
	private String authName;
	/**权限上级名称-**/
	private String authParentNames;
	/**权限级别-**/
	private Integer authLevel;
	/**表代码-**/
	private String tableCode;
	/**表名称-**/
	private String tableName;
	/**树形表代码-**/
	private String treeTableCode;
	/**树形表名称-**/
	private String treeTableName;
	/**实体bean名称-**/
	private String entityName;
	/**树形表实体bean名称-**/
	private String treeEntityName;
	/**方法名称-**/
	private String methodName;
	/**视图类型-1：普通列表视图 2：树形列表视图 3：树形页面视图 4：下拉列表视图 5：创建页面视图 6：修改页面视图 7：自定义页面视图 8：无页具体面视图**/
	private Integer viewType;
	/**上级视图目录-**/
	private String viewParentPath;
	/**视图名称-**/
	private String viewName;
	/**视图模板名称-**/
	private String viewTemplateName;
	/**视图模板路径-**/
	private String viewTemplatePath;
	/**视图js模板内容-**/
	private String jsTemplateContent;
	/**视图页面模板内容-**/
	private String pageTemplateContent;
	/**视图表格通用参数-**/
	private String viewGridParam;
	/**是否自适应宽度-**/
	private Integer isShrinktofit;
	/**在上级视图中位置-1：一级菜单 2：二级菜单 3：三级菜单 4：查询功能菜单 5：顶部功能菜单 6：快捷功能菜单**/
	private Integer parentViewPosition;
	/**跳转方法名-**/
	private String jumpMethodName;
	/**数据处理方法名-**/
	private String dataMethodName;
	/**是否带返回功能-0：否 1：是**/
	private Integer isPageBack;
	/**是否配置-1：已配置 0：未配置**/
	private Integer isConfig;
	/**配置时间-**/
	private String configTime;
	/**是否生成-**/
	private Integer isCenerate;
	/**生成时间-**/
	private String generateTime;
	/**数据版本-**/
	private Long version;
	/**创建时间-**/
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

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getTableIds() {
		return tableIds;
	}

	public void setTableIds(String tableIds) {
		this.tableIds = tableIds;
	}

	public Long getTreeTableId() {
		return treeTableId;
	}

	public void setTreeTableId(Long treeTableId) {
		this.treeTableId = treeTableId;
	}

	public Long getAuthParentCode() {
		return authParentCode;
	}

	public void setAuthParentCode(Long authParentCode) {
		this.authParentCode = authParentCode;
	}

	public Long getAuthCode() {
		return authCode;
	}

	public void setAuthCode(Long authCode) {
		this.authCode = authCode;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthParentNames() {
		return authParentNames;
	}

	public void setAuthParentNames(String authParentNames) {
		this.authParentNames = authParentNames;
	}

	public Integer getAuthLevel() {
		return authLevel;
	}

	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTreeTableCode() {
		return treeTableCode;
	}

	public void setTreeTableCode(String treeTableCode) {
		this.treeTableCode = treeTableCode;
	}

	public String getTreeTableName() {
		return treeTableName;
	}

	public void setTreeTableName(String treeTableName) {
		this.treeTableName = treeTableName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getTreeEntityName() {
		return treeEntityName;
	}

	public void setTreeEntityName(String treeEntityName) {
		this.treeEntityName = treeEntityName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Integer getViewType() {
		return viewType;
	}

	public void setViewType(Integer viewType) {
		this.viewType = viewType;
	}

	public String getViewParentPath() {
		return viewParentPath;
	}

	public void setViewParentPath(String viewParentPath) {
		this.viewParentPath = viewParentPath;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewTemplateName() {
		return viewTemplateName;
	}

	public void setViewTemplateName(String viewTemplateName) {
		this.viewTemplateName = viewTemplateName;
	}

	public String getViewTemplatePath() {
		return viewTemplatePath;
	}

	public void setViewTemplatePath(String viewTemplatePath) {
		this.viewTemplatePath = viewTemplatePath;
	}

	public String getJsTemplateContent() {
		return jsTemplateContent;
	}

	public void setJsTemplateContent(String jsTemplateContent) {
		this.jsTemplateContent = jsTemplateContent;
	}

	public String getPageTemplateContent() {
		return pageTemplateContent;
	}

	public void setPageTemplateContent(String pageTemplateContent) {
		this.pageTemplateContent = pageTemplateContent;
	}

	public String getViewGridParam() {
		return viewGridParam;
	}

	public void setViewGridParam(String viewGridParam) {
		this.viewGridParam = viewGridParam;
	}

	public Integer getIsShrinktofit() {
		return isShrinktofit;
	}

	public void setIsShrinktofit(Integer isShrinktofit) {
		this.isShrinktofit = isShrinktofit;
	}

	public Integer getParentViewPosition() {
		return parentViewPosition;
	}

	public void setParentViewPosition(Integer parentViewPosition) {
		this.parentViewPosition = parentViewPosition;
	}

	public String getJumpMethodName() {
		return jumpMethodName;
	}

	public void setJumpMethodName(String jumpMethodName) {
		this.jumpMethodName = jumpMethodName;
	}

	public String getDataMethodName() {
		return dataMethodName;
	}

	public void setDataMethodName(String dataMethodName) {
		this.dataMethodName = dataMethodName;
	}

	public Integer getIsPageBack() {
		return isPageBack;
	}

	public void setIsPageBack(Integer isPageBack) {
		this.isPageBack = isPageBack;
	}

	public Integer getIsConfig() {
		return isConfig;
	}

	public void setIsConfig(Integer isConfig) {
		this.isConfig = isConfig;
	}

	public String getConfigTime() {
		return configTime;
	}

	public void setConfigTime(String configTime) {
		this.configTime = configTime;
	}

	public Integer getIsCenerate() {
		return isCenerate;
	}

	public void setIsCenerate(Integer isCenerate) {
		this.isCenerate = isCenerate;
	}

	public String getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(String generateTime) {
		this.generateTime = generateTime;
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
