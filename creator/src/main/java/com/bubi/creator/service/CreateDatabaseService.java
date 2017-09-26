package com.bubi.creator.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bubi.creator.dao.impl.ColumnDao;
import com.bubi.creator.dao.impl.TableDao;
import com.bubi.creator.entity.Pdm;
import com.bubi.creator.entity.PdmIndex;
import com.bubi.creator.entity.PdmKey;
import com.bubi.creator.entity.PdmReference;
import com.bubi.creator.entity.PdmReferenceJoin;
import com.bubi.creator.entity.PdmTable;
import com.bubi.creator.entity.PdmTableColumn;

public class CreateDatabaseService extends BaseCreateService {

	static Logger logger = Logger.getLogger(CreateDatabaseService.class);
	/** 表信息操作Dao **/
	private TableDao tableDao;
	/** 表字段信息操作Dao **/
	private ColumnDao columnDao;
	private String specialTableArr[] = { "SC_Table", "SC_TableColumn", "SC_TableIndex", "SC_TableReference" };

	public CreateDatabaseService() {
		tableDao = new TableDao();
		columnDao = new ColumnDao();
	}

	/**
	 * 创建数据库
	 * @param pdm
	 */
	public void createDatebase(Pdm pdm) {
		// 创建数据库
		this.createTables(pdm);
		// 创建关系
		this.createReferences(pdm);
		// 创建索引
		this.createIndex(pdm);
		// 更新数据库
		this.updateDatabase(pdm);
	}

	/**
	 * 生成建标脚本
	 * @param pdm
	 */
	private void createTables(Pdm pdm) {
		if (pdm == null) {
			return;
		}
		logger.debug("/*********************************************************/");
		logger.debug("/*************************创建数据库*************************/");
		logger.debug("/*********************************************************/");
		ArrayList<PdmTable> tables = pdm.getTables();
		logger.debug("开始生成数据脚本,并创建数据库表......");
		for (PdmTable tableTemp : tables) {
			if (tableTemp != null) {
				StringBuffer sqlScript = new StringBuffer();
				logger.debug("/*********************************************************/");
				logger.debug("生成表名称为:" + tableTemp.getName() + "的脚本");
				sqlScript.append("CREATE TABLE ").append("`" + tableTemp.getOriginalCode() + "`").append(" ( ").append("\n");
				ArrayList<PdmTableColumn> columns = tableTemp.getColumns();
				for (int c = 0; c < columns.size(); c++) {
					PdmTableColumn columnTemp = columns.get(c);
					if (columnTemp != null) {
						Integer length = columnTemp.getLength() == null?0:columnTemp.getLength();
						String lowValue = columnTemp.getLowValue();
						String highValue = columnTemp.getHighValue();
						String columnDataType = columnTemp.getDataType();
						String dtype = columnDataType;
						if (length > 0) {
							dtype = columnDataType + "(" + length + ")";
						}
						else if (lowValue != null && !lowValue.equals("") && highValue != null && !highValue.equals("")) {
							dtype = columnDataType + "(" + length + "," + highValue + ")";
						}
						sqlScript.append("`" + columnTemp.getOriginalCode() + "`");
						sqlScript.append(" " + dtype);

						// 是否为空
						if (columnTemp.getMandatory() != null && columnTemp.getMandatory() == 1) {
							sqlScript.append(" NOT NULL");
						}
						else {
							String defval = columnTemp.getDefaultValue();
							if (defval != null && !defval.equals("")) {
								sqlScript.append(" DEFAULT " + defval);
							}
//							else {
//								sqlScript.append(" DEFAULT NULL");
//							}
						}
						// 是否为自增
						if (columnTemp.getIdentity() != null && columnTemp.getIdentity() == 1) {
							sqlScript.append(" AUTO_INCREMENT");
						}
						if (columnTemp.getComment() != null && !columnTemp.getComment().equals("")) {
							sqlScript.append(" COMMENT '" + columnTemp.getComment() + "'");
						}
						// 是否为最后一个字段
						if (c == (columns.size() - 1)) {
							ArrayList<PdmKey> keys = tableTemp.getKeys();
							// 判断是否有主键
							if (keys != null && keys.size() > 0) {
								// 生成主键和唯一键
								String pkeys = "", ukeys = "";
								for (PdmKey key : keys) {
									ArrayList<PdmTableColumn> keyColumns = key.getColumns();
									// 判断扩展属性是否存在
									String extendedAttributesText = key.getExtendedAttributesText();
									if (extendedAttributesText.toLowerCase().indexOf("unique") < 0) {
										for (PdmTableColumn column : keyColumns) {
											if (pkeys.equals("")) {
												pkeys = column.getOriginalCode();
											}
											else {
												pkeys += "," + column.getOriginalCode();
											}
										}
									}
									else {
										if (extendedAttributesText.toLowerCase().indexOf("unique") >= 0) {
											for (PdmTableColumn column : keyColumns) {
												if (ukeys.equals("")) {
													ukeys += "unique key AK_" + key.getOriginalCode() + " (" + column.getOriginalCode() + ")";
												}
												else {
													ukeys += ",\nunique key AK_" + key.getOriginalCode() + " (" + column.getOriginalCode() + ")";
												}
											}
										}
									}
								}
								if (!pkeys.equals("")) {
									sqlScript.append(",").append("\n");
									sqlScript.append("primary key (" + pkeys + ")");
								}
								if (!ukeys.equals("")) {
									sqlScript.append(",").append("\n");
									sqlScript.append(ukeys);
								}
								else {
									sqlScript.append("\n");
								}
								sqlScript.append(");");
							}
							else {
								sqlScript.append(");");
							}
						}
						else {
							sqlScript.append(",").append("\n");
						}
					}
				}
				System.out.println("生成表脚本为:" + sqlScript.toString());
				logger.debug("表名称为:" + tableTemp.getName() + "的脚本生成完成.");
				logger.debug("判断表名称为:" + tableTemp.getOriginalCode() + "的数据表是否存在");
				// 判断数据库表是否存在
				boolean boo = tableDao.getTable(tableTemp.getOriginalCode());
				if (!boo) {
					logger.debug("名称为:" + tableTemp.getOriginalCode() + "的数据库表不存在");
					// 如果表不存在，创建表
					tableDao.createTable(tableTemp.getOriginalCode(), sqlScript.toString());
				}
				else {
					logger.debug("名称为:" + tableTemp.getOriginalCode() + "的数据库表已经存在");
				}
				logger.debug("/*********************************************************/");
			}

		}
		logger.debug("数据库创建完成.");
	}

	/**
	 * 创建数据库表关系
	 * @param pdm
	 */
	private void createReferences(Pdm pdm) {
		if (pdm == null) {
			return;
		}
		logger.debug("/*********************************************************/");
		logger.debug("/***********************创建数据库表关系************************/");
		logger.debug("/*********************************************************/");
		logger.debug("开始进行数据库表关系创建......");
		logger.debug("开始生成数据表关系脚本,并创建数据库表关系......");
		// 获取所有关系数据
		ArrayList<PdmReference> referenceList = pdm.getReferences();
		for (PdmReference reference : referenceList) {
			if (reference != null) {
				// 关系脚本存贮对象
				StringBuffer referenceSqlScript = new StringBuffer();
				// 关系代码
				String referenceCode = reference.getCode();
				// 子表
				String childTableCode = reference.getChildTable().getCode();
				// 主表
				String parentTableCode = reference.getParentTable().getCode();
				referenceSqlScript.append(" alter table ").append(childTableCode).append(" add constraint ").append(" FK_" + referenceCode).append(" foreign key ");
				// 关系字段数组
				ArrayList<PdmReferenceJoin> referenceJoinList = reference.getJoins();
				String childTableColumns = null;
				String parentTableColumns = null;
				for (PdmReferenceJoin referenceJoin : referenceJoinList) {
					String childTableColumn = referenceJoin.getChildTableColumn().getCode();
					if (childTableColumns == null) {
						childTableColumns = childTableColumn;
					}
					else {
						childTableColumns += "," + childTableColumn;
					}
					String parentTableColumn = referenceJoin.getParentTableColumn().getCode();
					if (parentTableColumns == null) {
						parentTableColumns = parentTableColumn;
					}
					else {
						parentTableColumns += "," + parentTableColumn;
					}
				}
				referenceSqlScript.append(" (" + childTableColumns + ") ").append(" references ").append(parentTableCode).append(" (" + parentTableColumns + ") ")
						.append(" on delete restrict on update restrict;");
				System.out.println(referenceSqlScript.toString());
				// 创建表关系
				tableDao.createTableReference(childTableCode, referenceCode, referenceSqlScript.toString());
			}
		}
		logger.debug("数据库表关系创建完成");
	}

	/**
	 * 创建索引
	 * @param pdm
	 */
	private void createIndex(Pdm pdm) {
		if (pdm == null) {
			return;
		}
		logger.debug("/*********************************************************/");
		logger.debug("/***********************创建数据库索引************************/");
		logger.debug("/*********************************************************/");
		logger.debug("开始进行数据库表索引创建......");
		ArrayList<PdmTable> tables = pdm.getTables();
		for (PdmTable tableTemp : tables) {
			if (tableTemp != null) {
				// 表名称
				String tableName = tableTemp.getCode();
				ArrayList<PdmIndex> indexs = tableTemp.getIndexs();
				for (PdmIndex index : indexs) {
					// 索引脚本存储对象
					StringBuffer indexSqlScript = new StringBuffer();
					// 索引名称代码
					String indexCode = index.getCode();
					indexSqlScript.append(" create index ").append(indexCode).append(" on ").append(tableTemp.getCode());
					// 索引字段名称
					ArrayList<PdmTableColumn> columns = index.getColumns();
					String indexColumns = null;
					for (PdmTableColumn column : columns) {
						String columnCode = column.getCode();
						if (indexColumns == null) {
							indexColumns = columnCode;
						}
						else {
							indexColumns += "," + columnCode;
						}
					}
					indexSqlScript.append(" {" + indexColumns + "}; ");
					// 创建表索引
					tableDao.createTableIndex(tableName, indexCode, indexSqlScript.toString());
				}
			}
		}
		logger.debug("数据库索引创建完成");
	}

	/**
	 * 更新数据库
	 * @param pdm
	 */
	private void updateDatabase(Pdm pdm) {
		if (pdm == null) {
			return;
		}
		logger.debug("/*********************************************************/");
		logger.debug("/************************更新数据库**************************/");
		logger.debug("/*********************************************************/");
		logger.debug("开始进行数据库更新......");
		ArrayList<PdmTable> tables = pdm.getTables();
		for (PdmTable table : tables) {
			String tableCode = table.getOriginalCode();
			// 如果是系统特殊表（不记录表结构的信息表）不进行判断处理
			for (String specialtableCode : specialTableArr) {
				if (specialtableCode != null && !specialtableCode.equals(tableCode)) {
					break;
				}
			}
			String tableModificationDate = table.getModificationDate();
			// 根据objectid 查询表信息,进行数据库表信息的更新
			PdmTable tableOne = tableDao.selectOne("table.select_one_by_objid", table);
			// 如果表结构记录不存在直接添加
			if (tableOne == null) {
				// 记录表结构信息
				tableDao.insert("table.insert", table);
			}
			PdmTable tableTemp = tableDao.selectOne("table.select_one_by_objid", table);
			if (tableTemp != null) {
				String tableModificationDateTemp = tableTemp.getModificationDate();
				// 不相等，表结构有修改
				if (!tableModificationDate.equals(tableModificationDateTemp)) {
					logger.debug("数据库表：" + tableCode + " 结构有修改.");
					try {
						boolean isUpdate = false;
    					String tableCodeTemp = tableTemp.getCode();
    					if (!tableCode.equals(tableCodeTemp)) {
    						logger.debug("数据库表名称有修改，开始进行更新.");
    						String alterTableSql = "ALTER  TABLE " + tableCodeTemp + " RENAME TO " + tableCode + ";";
    						// 更新表信息
    						isUpdate = tableDao.alterTable(tableCodeTemp, alterTableSql);
    					}
    					if (isUpdate) {
        					table.setId(tableTemp.getId());
        					// 更新表结构信息
        					tableDao.update("table.update", table);
    					}
					}
					catch(Exception e) {
						e.printStackTrace();
						logger.debug("数据库表：" + tableCode + " 结构修改失败："+e.getMessage());
					}
				}
				else {
					logger.debug("数据库表：" + tableCode + " 结构无修改.");
				}
				//查询表所有字段信息,进行无用字段的删除
				PdmTableColumn paramColumn = new PdmTableColumn();
				paramColumn.setTableId(tableTemp.getId());
				List<PdmTableColumn> columnsDB = columnDao.selectList("column.select_list_by_tid", paramColumn);
				for (PdmTableColumn pdmTableColumn:columnsDB) {
					String columnCode = pdmTableColumn.getCode();
					String objectId = pdmTableColumn.getObjectId();
					boolean isEqual = false;
					// 根据objectid 查询表字段信息,进行数据库表字段信息的更新
					ArrayList<PdmTableColumn> columns = table.getColumns();
					for (PdmTableColumn column : columns) {
						String objectCmpId = column.getObjectId();
						//比较是否有同样objid的数据表字段，比对字段是否存在
						//如果不存在，则删除该表字段
						if (objectId != null && objectCmpId != null && objectCmpId.equals(objectId)) {
							isEqual = true;
							break;
						}
					}
					//如果不存在，该字段从数据库表中删除，仅限开发环境
					if (!isEqual) {
						String dropSql = "alter table " + tableCode + " drop column " + columnCode;
						boolean isSucc = tableDao.alterTable(tableCode, dropSql);
						if (isSucc) {
							columnDao.deleteById("column.delete_by_id", pdmTableColumn);
						}
					}
				}
				// 根据objectid 查询表字段信息,进行数据库表字段信息的更新
				ArrayList<PdmTableColumn> columns = table.getColumns();
				for (PdmTableColumn column : columns) {
					String columnCode = column.getOriginalCode();
					String columnDataType = column.getDataType();
					Integer length = column.getLength() == null?0:column.getLength();
					String lowValue = column.getLowValue();
					String highValue = column.getHighValue();
					String columnModificationDate = column.getModificationDate();
					column.setTableId(tableTemp.getId());// null
					PdmTableColumn columnOne = columnDao.selectOne("column.select_one_by_objid", column);
					if (columnOne == null) {
						// 更新表结构信息
						columnDao.insert("column.insert", column);
					}
					PdmTableColumn columnTemp = columnDao.selectOne("column.select_one_by_objid", column);
					if (columnTemp != null) {
						String columnModificationDateTemp = columnTemp.getModificationDate();
						String columnCodeTemp = columnTemp.getCode();
						String columnDataTypeTemp = column.getDataType();
						// 不相等，表示字段有修改
						if (!columnModificationDate.equals(columnModificationDateTemp)) {
							logger.debug("数据库表：" + tableCode + " 结构有修改.");
							try {
								boolean isColumn = false ,isDataType = false;
								String dtype = columnDataType;
								if (length > 0) {
									dtype = columnDataType + "(" + length + ")";
								}
								else if (lowValue != null && !lowValue.equals("") && highValue != null && !highValue.equals("")) {
									dtype = columnDataType + "(" + length + "," + highValue + ")";
								}
								// 如果不等，更改字段名称
								if (!columnCode.equals(columnCodeTemp)) {
									logger.debug("名称为：" + tableCode + " 的数据库表的" + columnCodeTemp + "字段名称有修改.");
									String alterTableSql = "ALTER  TABLE " + tableCode + " CHANGE " + columnCodeTemp + " " + columnCode + " " + dtype + ";";
									// 更新表信息
									isColumn = tableDao.alterTable(tableCode, alterTableSql);
								}
								// 如果不等，更新字段类型
								if (!columnDataType.equals(columnDataTypeTemp)) {
									logger.debug("名称为：" + tableCode + " 的数据库表的" + columnCodeTemp + "字段类型有修改.");
									String alterTableSql = "ALTER  TABLE " + tableCode + " MODIFY " + columnCodeTemp + " " + dtype + ";";
									// 更新表信息
									isDataType = tableDao.alterTable(tableCode, alterTableSql);
								}
								if (isColumn || isDataType) {
    								column.setId(columnTemp.getId());
    								// 更新表结构信息
    								columnDao.update("column.update", column);
								}
							}
							catch(Exception e) {
								e.printStackTrace();
								logger.debug("名称为：" + tableCode + " 的数据库表的字段类型有修改失败:" + e.getMessage());
							}
						}
						// 判断表字段是否存在，若字段不存在添加字段
						boolean boo = columnDao.getColumn(tableCode, columnCode);
						if (!boo) {
							logger.debug("名称为：" + tableCode + " 的数据库表，新增名称为：" + columnCode + "字段.");
							String alterTableSql = "ALTER  TABLE " + tableCode + " ADD " + columnCode + " " + columnDataType;
							// 是否为空
							if (column.getMandatory() != null && column.getMandatory() == 1) {
								alterTableSql += " NOT NULL";
							}
							else {
								String defaulValue = column.getDefaultValue();
								if (defaulValue != null && !defaulValue.equals("")) {
									alterTableSql += " DEFAULT " + defaulValue;
								}
							}
							// 是否为自增
							if (column.getIdentity() != null && column.getIdentity() == 1) {
								alterTableSql += " AUTO_INCREMENT";
							}
							// 增加注释
							if (column.getComment() != null && !column.getComment().equals("")) {
								alterTableSql += " COMMENT '" + column.getComment() + "'";
							}
							alterTableSql += ";";
							// 更新表信息
							tableDao.alterTable(tableCode, alterTableSql);
						}
						else {
							logger.debug("数据库表：" + tableCode + " 结构无修改.");
						}
					}
				}
			}
		}
		logger.debug("数据库更新完成");
	}
}
