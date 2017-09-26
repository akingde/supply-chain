package com.bs.rest.modules.mc;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Reference;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.mc.dto.ShortMessageSendDTO;
import com.bs.api.modules.mc.service.IShortMessageSendService;

import com.bs.rest.modules.mc.vo.ShortMessageSendVO;
import com.bs.rest.core.entity.ReturnData;
import com.bs.rest.core.group.First;
import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Third;
import com.bs.rest.core.group.Fourth;
import com.bs.rest.core.group.Fifth;
import com.bs.rest.core.group.Sixth;
import com.bs.rest.core.group.Seventh;
import com.bs.rest.core.utils.StringUtil;
import com.bs.rest.core.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/shortmessagesend", description = "业务短信发送存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/shortmessagesend")
public class ShortMessageSendController extends BaseController{

	public static Logger logger = Logger.getLogger(ShortMessageSendController.class);

	@Reference(version = "1.0.0")
	private IShortMessageSendService shortMessageSendApi;
	
	@ApiOperation(value = "业务短信发送存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "ShortMessageSend实体", value = "添加你的参数说明")
			@RequestBody ShortMessageSendVO shortMessageSendVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {First.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageSendDTO shortMessageSendDTO = new ShortMessageSendDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageSendVO, shortMessageSendDTO);
			ResultData<ShortMessageSendDTO> resultData = shortMessageSendApi.save(shortMessageSendDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageSendDTO data = resultData.getData();
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

	@ApiOperation(value = "业务短信发送存储表-数据修改")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ReturnData update(
			@ApiParam(name = "ShortMessageSend实体", value = "添加你的参数说明")
			@RequestBody ShortMessageSendVO shortMessageSendVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Second.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageSendDTO shortMessageSendDTO = new ShortMessageSendDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageSendVO, shortMessageSendDTO);
			ResultData<ShortMessageSendDTO> resultData = shortMessageSendApi.updateById(shortMessageSendDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageSendDTO data = resultData.getData();
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

	@ApiOperation(value = "业务短信发送存储表-根据主键Id删除")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "ShortMessageSend主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ShortMessageSendVO shortMessageSendVO = new ShortMessageSendVO();
			shortMessageSendVO.setId(id);
			Class<?> groupCls [] = {Third.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<ShortMessageSendDTO> resultData = shortMessageSendApi.removeById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageSendDTO data = resultData.getData();
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
	
	@ApiOperation(value = "业务短信发送存储表-根据主键Id获取单条数据")
	@RequestMapping(value = "/single/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ShortMessageSend主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ShortMessageSendVO shortMessageSendVO = new ShortMessageSendVO();
			shortMessageSendVO.setId(id);
			Class<?> groupCls [] = {Fourth.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<ShortMessageSendDTO> resultData = shortMessageSendApi.getOneById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageSendDTO data = resultData.getData();
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
	

	@ApiOperation(value = "业务短信发送存储表-动态条件获取单条数据")
	@RequestMapping(value = "/single", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ShortMessageSend实体", value = "添加你的参数说明")
			@RequestBody ShortMessageSendVO shortMessageSendVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Fifth.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageSendDTO shortMessageSendDTO = new ShortMessageSendDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageSendVO, shortMessageSendDTO);
			ResultData<List<ShortMessageSendDTO>> resultData = shortMessageSendApi.listCriteria(shortMessageSendDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageSendDTO> data = resultData.getData();
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

	@ApiOperation(value = "业务短信发送存储表-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "ShortMessageSend实体", value = "添加你的参数说明")
			@RequestBody ShortMessageSendVO shortMessageSendVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Sixth.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageSendDTO shortMessageSendDTO = new ShortMessageSendDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageSendVO, shortMessageSendDTO);
			ResultData<List<ShortMessageSendDTO>> resultData = shortMessageSendApi.listCriteria(shortMessageSendDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageSendDTO> data = resultData.getData();
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

	@ApiOperation(value = "业务短信发送存储表-动态条件分页数剧")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "ShortMessageSend实体", value = "添加你的参数说明")
			@RequestBody ShortMessageSendVO shortMessageSendVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Seventh.class};
			String validMsg = super.validator(shortMessageSendVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageSendDTO shortMessageSendDTO = new ShortMessageSendDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageSendVO, shortMessageSendDTO);
			ResultData<List<ShortMessageSendDTO>> resultData = shortMessageSendApi.paginated(shortMessageSendDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageSendDTO> data = resultData.getData();
				PageData pageData = resultData.getPageData();
				returnData.setCode(code);
				returnData.setMessage(message);
				returnData.setData(data);
				returnData.setPageData(pageData);
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
}
