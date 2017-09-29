package com.bs.rest.modules.sc;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.modules.sc.service.IViewFieldConfigService;
import com.bs.rest.core.controller.BaseController;
import io.swagger.annotations.Api;

@Api(value = "/viewfieldconfig", description = "视图字段配置信息存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/viewfieldconfig")
public class ViewFieldConfigController extends BaseController{

	public static Logger logger = Logger.getLogger(ViewFieldConfigController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IViewFieldConfigService viewFieldConfigApi;
	
	/**
	* example(开发参考例子)
	@ApiOperation(value = "视图字段配置信息存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "ViewFieldConfig实体", value = "添加你的参数说明")
			@RequestBody ViewFieldConfigVO viewFieldConfigVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(viewFieldConfigVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ViewFieldConfigDTO viewFieldConfigDTO = new ViewFieldConfigDTO();
			//参数赋值
			BeanUtils.copyProperties(viewFieldConfigVO, viewFieldConfigDTO);
			ResultData<ViewFieldConfigDTO> resultData = viewFieldConfigApi.xxx(viewFieldConfigDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ViewFieldConfigDTO data = resultData.getData();
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
