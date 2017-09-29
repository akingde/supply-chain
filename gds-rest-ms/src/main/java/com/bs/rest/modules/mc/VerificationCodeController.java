package com.bs.rest.modules.mc;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.modules.mc.service.IVerificationCodeService;
import com.bs.rest.core.controller.BaseController;
import io.swagger.annotations.Api;

@Api(value = "/verificationcode", description = "客户短信验证码存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/verificationcode")
public class VerificationCodeController extends BaseController{

	public static Logger logger = Logger.getLogger(VerificationCodeController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IVerificationCodeService verificationCodeApi;
	
	/**
	* example(开发参考例子)
	@ApiOperation(value = "客户短信验证码存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "VerificationCode实体", value = "添加你的参数说明")
			@RequestBody VerificationCodeVO verificationCodeVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(verificationCodeVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			VerificationCodeDTO verificationCodeDTO = new VerificationCodeDTO();
			//参数赋值
			BeanUtils.copyProperties(verificationCodeVO, verificationCodeDTO);
			ResultData<VerificationCodeDTO> resultData = verificationCodeApi.xxx(verificationCodeDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				VerificationCodeDTO data = resultData.getData();
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
