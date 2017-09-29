package com.bs.rest.modules.${module};

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.modules.${module}.service.I${entity}Service;
import com.bs.rest.core.controller.BaseController;
import io.swagger.annotations.Api;

@Api(value = "/${entity?lower_case}", description = "${table.comment}接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/${entity?lower_case}")
public class ${entity}Controller extends BaseController{

	public static Logger logger = Logger.getLogger(${entity}Controller.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private I${entity}Service ${entity?uncap_first}Api;
	
	/**
	* example(开发参考例子)
	@ApiOperation(value = "${table.comment}-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "${entity}实体", value = "添加你的参数说明")
			@RequestBody ${entity}VO ${entity?uncap_first}VO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(${entity?uncap_first}VO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			${entity}DTO ${entity?uncap_first}DTO = new ${entity}DTO();
			//参数赋值
			BeanUtils.copyProperties(${entity?uncap_first}VO, ${entity?uncap_first}DTO);
			ResultData<${entity}DTO> resultData = ${entity?uncap_first}Api.xxx(${entity?uncap_first}DTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				${entity}DTO data = resultData.getData();
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
