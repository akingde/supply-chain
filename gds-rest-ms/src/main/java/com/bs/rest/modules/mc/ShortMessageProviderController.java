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
import com.bs.api.modules.mc.dto.ShortMessageProviderDTO;
import com.bs.api.modules.mc.service.IShortMessageProviderService;

import com.bs.rest.modules.mc.vo.ShortMessageProviderVO;
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

@Api(value = "/shortmessageprovider", description = "短信提供商存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/shortmessageprovider")
public class ShortMessageProviderController extends BaseController{

	public static Logger logger = Logger.getLogger(ShortMessageProviderController.class);

	@Reference(version = "1.0.0")
	private IShortMessageProviderService shortMessageProviderApi;
	
	@ApiOperation(value = "短信提供商存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "ShortMessageProvider实体", value = "添加你的参数说明")
			@RequestBody ShortMessageProviderVO shortMessageProviderVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {First.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageProviderDTO shortMessageProviderDTO = new ShortMessageProviderDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageProviderVO, shortMessageProviderDTO);
			ResultData<ShortMessageProviderDTO> resultData = shortMessageProviderApi.save(shortMessageProviderDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageProviderDTO data = resultData.getData();
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

	@ApiOperation(value = "短信提供商存储表-数据修改")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ReturnData update(
			@ApiParam(name = "ShortMessageProvider实体", value = "添加你的参数说明")
			@RequestBody ShortMessageProviderVO shortMessageProviderVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Second.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageProviderDTO shortMessageProviderDTO = new ShortMessageProviderDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageProviderVO, shortMessageProviderDTO);
			ResultData<ShortMessageProviderDTO> resultData = shortMessageProviderApi.updateById(shortMessageProviderDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageProviderDTO data = resultData.getData();
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

	@ApiOperation(value = "短信提供商存储表-根据主键Id删除")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "ShortMessageProvider主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ShortMessageProviderVO shortMessageProviderVO = new ShortMessageProviderVO();
			shortMessageProviderVO.setId(id);
			Class<?> groupCls [] = {Third.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<ShortMessageProviderDTO> resultData = shortMessageProviderApi.removeById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageProviderDTO data = resultData.getData();
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
	
	@ApiOperation(value = "短信提供商存储表-根据主键Id获取单条数据")
	@RequestMapping(value = "/single/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ShortMessageProvider主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ShortMessageProviderVO shortMessageProviderVO = new ShortMessageProviderVO();
			shortMessageProviderVO.setId(id);
			Class<?> groupCls [] = {Fourth.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<ShortMessageProviderDTO> resultData = shortMessageProviderApi.getOneById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				ShortMessageProviderDTO data = resultData.getData();
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
	

	@ApiOperation(value = "短信提供商存储表-动态条件获取单条数据")
	@RequestMapping(value = "/single", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ShortMessageProvider实体", value = "添加你的参数说明")
			@RequestBody ShortMessageProviderVO shortMessageProviderVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Fifth.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageProviderDTO shortMessageProviderDTO = new ShortMessageProviderDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageProviderVO, shortMessageProviderDTO);
			ResultData<List<ShortMessageProviderDTO>> resultData = shortMessageProviderApi.listCriteria(shortMessageProviderDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageProviderDTO> data = resultData.getData();
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

	@ApiOperation(value = "短信提供商存储表-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "ShortMessageProvider实体", value = "添加你的参数说明")
			@RequestBody ShortMessageProviderVO shortMessageProviderVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Sixth.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageProviderDTO shortMessageProviderDTO = new ShortMessageProviderDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageProviderVO, shortMessageProviderDTO);
			ResultData<List<ShortMessageProviderDTO>> resultData = shortMessageProviderApi.listCriteria(shortMessageProviderDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageProviderDTO> data = resultData.getData();
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

	@ApiOperation(value = "短信提供商存储表-动态条件分页数剧")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "ShortMessageProvider实体", value = "添加你的参数说明")
			@RequestBody ShortMessageProviderVO shortMessageProviderVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Seventh.class};
			String validMsg = super.validator(shortMessageProviderVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ShortMessageProviderDTO shortMessageProviderDTO = new ShortMessageProviderDTO();
			//参数赋值
			BeanUtils.copyProperties(shortMessageProviderVO, shortMessageProviderDTO);
			ResultData<List<ShortMessageProviderDTO>> resultData = shortMessageProviderApi.paginated(shortMessageProviderDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ShortMessageProviderDTO> data = resultData.getData();
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
