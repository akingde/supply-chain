package com.bs.rest.modules.sc;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.modules.sc.service.ITableColumnService;
import com.bs.rest.core.controller.BaseController;
import io.swagger.annotations.Api;

@Api(value = "/tablecolumn", description = "表结构存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/tablecolumn")
public class TableColumnController extends BaseController{

	public static Logger logger = Logger.getLogger(TableColumnController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private ITableColumnService tableColumnApi;
	
	/**
	* example(开发参考例子)
	@ApiOperation(value = "表结构存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "TableColumn实体", value = "添加你的参数说明")
			@RequestBody TableColumnVO tableColumnVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(tableColumnVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			TableColumnDTO tableColumnDTO = new TableColumnDTO();
			//参数赋值
			BeanUtils.copyProperties(tableColumnVO, tableColumnDTO);
			ResultData<TableColumnDTO> resultData = tableColumnApi.xxx(tableColumnDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				TableColumnDTO data = resultData.getData();
				returnData.setCode(code);
				returnData.setMessage(message);
				returnData.setData(data);
				return returnData;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			returnData.setCode(ReturnData.RCODE_SYSTEM_ERROR);
			returnData.setMessage(e.getMessage());
			return returnData;
		}
		return returnData;
	}
	**/
}
