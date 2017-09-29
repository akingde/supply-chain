package com.bs.rest.modules.sc.vo;

import com.bs.rest.core.entity.Entity;
import javax.validation.constraints.NotNull;

import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Fourth;

public class ViewFieldConfigVO extends Entity{

	private static final long serialVersionUID = 1L;
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	@NotNull(message = "{NotNull.viewFieldConfig.id}",groups = {Second.class,Fourth.class})
	private Long id;
	/**视图主键Id-**/
	private Long viewId;
	/**权限主键Id-**/
	private Long authId;
	/**表主键-**/
	private Long tableId;
	/**表字段主键Id-**/
	private Long columnId;
	/**字典数据分类主键Id-**/
	private Long dataCategoryId;
	/**权限代码-**/
	private Long authCode;
	/**权限名称-**/
	private String authName;
	/**表代码-**/
	private String tableCode;
	/**表名称-**/
	private String tableName;
	/**实体bean名称-**/
	private String entityName;
	/**索引名称-**/
	private String fieldIndex;
	/**字段代码-**/
	private String fieldCode;
	/**字段名称-**/
	private String fieldName;
	/**显示名称-**/
	private String fieldLabel;
	/**字段类型-1：主模型表字段 2：子模型表字段 3：自定义字段**/
	private Integer fieldType;
	/**展示方式-1：input文本框 2：select下拉选择框 3：redio单选按钮 4：checkbox复选按钮 5：textarea大文本 6：hidden隐藏域 7：text 存文本 8：editor编辑器 9：datatime 日期 10：upload 上传控件**/
	private Integer fieldShowType;
	/**是否冻结-**/
	private Integer fieldFrozen;
	/**字段宽度-**/
	private String fieldWidth;
	/**排列位子-**/
	private Integer fieldAlign;
	/**时间格式-**/
	private String fieldDatefmt;
	/**字段转义-**/
	private Integer fieldFormatter;
	/**字段转义代码-**/
	private String fieldFormatterCode;
	/**字段隐藏-**/
	private Integer fieldHidden;
	/**指定ID字段-**/
	private String fieldKey;
	/**字段是否排序-**/
	private Integer fieldSortable;
	/**字段显示排序-**/
	private Integer fieldSort;
	/**字段json-**/
	private String fieldJson;
	/**是否为消息提示字段-**/
	private Integer isPromptField;
	/**是否是树形列表字段-**/
	private Integer isTreeListField;
	/**查询类型-1：多条件查询 2：组合查询**/
	private Integer searchType;
	/**查询分组-1：多条件查询 2：组合查询**/
	private Integer searchGroup;
	/**查询运算符号-1：= 2：!= 3：> 4：< 5：>= 6：<= 7：like 8：not like 9：in 10：not in**/
	private Integer searchOperator;
	/**组合查询字段展示方式-1：输入框(input) 2：下拉选择(select) 3：日期(date) 4：日期区间(daterange) 5：复选框(checkbox)**/
	private Integer searchFieldShowType;
	/**查询正则表达式-**/
	private String searchRegular;
	/**是否添加-**/
	private Integer isAdd;
	/**添加时间-**/
	private String addTime;
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

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

	public Long getDataCategoryId() {
		return dataCategoryId;
	}

	public void setDataCategoryId(Long dataCategoryId) {
		this.dataCategoryId = dataCategoryId;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(String fieldIndex) {
		this.fieldIndex = fieldIndex;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldLabel() {
		return fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public Integer getFieldType() {
		return fieldType;
	}

	public void setFieldType(Integer fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getFieldShowType() {
		return fieldShowType;
	}

	public void setFieldShowType(Integer fieldShowType) {
		this.fieldShowType = fieldShowType;
	}

	public Integer getFieldFrozen() {
		return fieldFrozen;
	}

	public void setFieldFrozen(Integer fieldFrozen) {
		this.fieldFrozen = fieldFrozen;
	}

	public String getFieldWidth() {
		return fieldWidth;
	}

	public void setFieldWidth(String fieldWidth) {
		this.fieldWidth = fieldWidth;
	}

	public Integer getFieldAlign() {
		return fieldAlign;
	}

	public void setFieldAlign(Integer fieldAlign) {
		this.fieldAlign = fieldAlign;
	}

	public String getFieldDatefmt() {
		return fieldDatefmt;
	}

	public void setFieldDatefmt(String fieldDatefmt) {
		this.fieldDatefmt = fieldDatefmt;
	}

	public Integer getFieldFormatter() {
		return fieldFormatter;
	}

	public void setFieldFormatter(Integer fieldFormatter) {
		this.fieldFormatter = fieldFormatter;
	}

	public String getFieldFormatterCode() {
		return fieldFormatterCode;
	}

	public void setFieldFormatterCode(String fieldFormatterCode) {
		this.fieldFormatterCode = fieldFormatterCode;
	}

	public Integer getFieldHidden() {
		return fieldHidden;
	}

	public void setFieldHidden(Integer fieldHidden) {
		this.fieldHidden = fieldHidden;
	}

	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	public Integer getFieldSortable() {
		return fieldSortable;
	}

	public void setFieldSortable(Integer fieldSortable) {
		this.fieldSortable = fieldSortable;
	}

	public Integer getFieldSort() {
		return fieldSort;
	}

	public void setFieldSort(Integer fieldSort) {
		this.fieldSort = fieldSort;
	}

	public String getFieldJson() {
		return fieldJson;
	}

	public void setFieldJson(String fieldJson) {
		this.fieldJson = fieldJson;
	}

	public Integer getIsPromptField() {
		return isPromptField;
	}

	public void setIsPromptField(Integer isPromptField) {
		this.isPromptField = isPromptField;
	}

	public Integer getIsTreeListField() {
		return isTreeListField;
	}

	public void setIsTreeListField(Integer isTreeListField) {
		this.isTreeListField = isTreeListField;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public Integer getSearchGroup() {
		return searchGroup;
	}

	public void setSearchGroup(Integer searchGroup) {
		this.searchGroup = searchGroup;
	}

	public Integer getSearchOperator() {
		return searchOperator;
	}

	public void setSearchOperator(Integer searchOperator) {
		this.searchOperator = searchOperator;
	}

	public Integer getSearchFieldShowType() {
		return searchFieldShowType;
	}

	public void setSearchFieldShowType(Integer searchFieldShowType) {
		this.searchFieldShowType = searchFieldShowType;
	}

	public String getSearchRegular() {
		return searchRegular;
	}

	public void setSearchRegular(String searchRegular) {
		this.searchRegular = searchRegular;
	}

	public Integer getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(Integer isAdd) {
		this.isAdd = isAdd;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
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
