package com.bs.rest.modules.uc;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.modules.uc.service.IOrganizationService;
import com.bs.rest.core.controller.BaseController;
import io.swagger.annotations.Api;

@Api(value = "/organization", description = "机构信息表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/organization")
public class OrganizationController extends BaseController{

	public static Logger logger = Logger.getLogger(OrganizationController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IOrganizationService organizationApi;
	
	/**
	* example(开发参考例子)
	@ApiOperation(value = "机构信息表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "Organization实体", value = "添加你的参数说明")
			@RequestBody OrganizationVO organizationVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(organizationVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			OrganizationDTO organizationDTO = new OrganizationDTO();
			//参数赋值
			BeanUtils.copyProperties(organizationVO, organizationDTO);
			ResultData<OrganizationDTO> resultData = organizationApi.xxx(organizationDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				OrganizationDTO data = resultData.getData();
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
