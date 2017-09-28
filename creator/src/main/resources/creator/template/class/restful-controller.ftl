package com.bs.rest.modules.${module};
<#assign idIsExist="false"/>
<#list columns as column>
<#assign property="result"/>
<#if column.code?lower_case == 'id' >
	<#assign property="id"/>
	<#assign idIsExist="true"/>
</#if>
</#list>
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
<#if idIsExist == 'true'>
import org.springframework.web.bind.annotation.PathVariable;
</#if>

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Reference;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.${module}.dto.${entity}DTO;
import com.bs.api.modules.${module}.service.I${entity}Service;

import com.bs.rest.modules.${module}.vo.${entity}VO;
import com.bs.rest.core.entity.ReturnData;
import com.bs.rest.core.group.First;
<#if idIsExist == 'true'>
import com.bs.rest.core.group.Second;
import com.bs.rest.core.group.Third;
import com.bs.rest.core.group.Fourth;
</#if>
import com.bs.rest.core.group.Fifth;
import com.bs.rest.core.group.Sixth;
import com.bs.rest.core.group.Seventh;
import com.bs.rest.core.utils.StringUtil;
import com.bs.rest.core.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/${entity?lower_case}", description = "${table.comment}接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/${entity?lower_case}")
public class ${entity}Controller extends BaseController{

	public static Logger logger = Logger.getLogger(${entity}Controller.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private I${entity}Service ${entity?uncap_first}Api;
	
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
			Class<?> groupCls [] = {First.class};
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
			ResultData<${entity}DTO> resultData = ${entity?uncap_first}Api.save(${entity?uncap_first}DTO);
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

	<#if idIsExist == 'true'>
	@ApiOperation(value = "${table.comment}-数据修改")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ReturnData update(
			@ApiParam(name = "${entity}实体", value = "添加你的参数说明")
			@RequestBody ${entity}VO ${entity?uncap_first}VO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Second.class};
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
			ResultData<${entity}DTO> resultData = ${entity?uncap_first}Api.updateById(${entity?uncap_first}DTO);
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

	@ApiOperation(value = "${table.comment}-根据主键Id删除")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "${entity}主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			${entity}VO ${entity?uncap_first}VO = new ${entity}VO();
			${entity?uncap_first}VO.setId(id);
			Class<?> groupCls [] = {Third.class};
			String validMsg = super.validator(${entity?uncap_first}VO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<Long> resultData = ${entity?uncap_first}Api.removeById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				Long data = resultData.getData();
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
	
	@ApiOperation(value = "${table.comment}-根据主键Id获取单条数据")
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData detail(
			@ApiParam(name = "${entity}主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			${entity}VO ${entity?uncap_first}VO = new ${entity}VO();
			${entity?uncap_first}VO.setId(id);
			Class<?> groupCls [] = {Fourth.class};
			String validMsg = super.validator(${entity?uncap_first}VO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<${entity}DTO> resultData = ${entity?uncap_first}Api.getOneById(id);
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
	
	</#if>

	@ApiOperation(value = "${table.comment}-动态条件获取单条数据")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody ReturnData detail(
			@ApiParam(name = "${entity}实体", value = "添加你的参数说明")
			@RequestBody ${entity}VO ${entity?uncap_first}VO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Fifth.class};
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
			ResultData<List<${entity}DTO>> resultData = ${entity?uncap_first}Api.listCriteria(${entity?uncap_first}DTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<${entity}DTO> data = resultData.getData();
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

	@ApiOperation(value = "${table.comment}-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "${entity}实体", value = "添加你的参数说明")
			@RequestBody ${entity}VO ${entity?uncap_first}VO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Sixth.class};
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
			ResultData<List<${entity}DTO>> resultData = ${entity?uncap_first}Api.listCriteria(${entity?uncap_first}DTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<${entity}DTO> data = resultData.getData();
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

	@ApiOperation(value = "${table.comment}-动态条件分页数剧")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "${entity}实体", value = "添加你的参数说明")
			@RequestBody ${entity}VO ${entity?uncap_first}VO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Seventh.class};
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
			ResultData<List<${entity}DTO>> resultData = ${entity?uncap_first}Api.paginated(${entity?uncap_first}DTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<${entity}DTO> data = resultData.getData();
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
