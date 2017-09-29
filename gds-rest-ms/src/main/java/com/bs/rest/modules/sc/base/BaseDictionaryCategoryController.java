package com.bs.rest.modules.sc.base;
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
import com.bs.api.modules.sc.dto.DictionaryCategoryDTO;
import com.bs.api.modules.sc.service.IDictionaryCategoryService;

import com.bs.rest.modules.sc.vo.DictionaryCategoryVO;
import com.bs.rest.core.entity.ReturnData;
import com.bs.rest.core.group.Id;
import com.bs.rest.core.group.Update;
import com.bs.rest.core.group.Remove;
import com.bs.rest.core.group.Save;
import com.bs.rest.core.group.Detail;
import com.bs.rest.core.group.PageList;
import com.bs.rest.core.utils.StringUtil;
import com.bs.rest.core.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/dictionarycategory", description = "系统配置-字典分类信息存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/dictionarycategory")
public class BaseDictionaryCategoryController extends BaseController{

	public static Logger logger = Logger.getLogger(BaseDictionaryCategoryController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IDictionaryCategoryService dictionaryCategoryApi;
	
	@ApiOperation(value = "系统配置-字典分类信息存储表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "DictionaryCategory实体", value = "存储数据")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<DictionaryCategoryDTO> resultData = dictionaryCategoryApi.save(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				DictionaryCategoryDTO data = resultData.getData();
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

	@ApiOperation(value = "系统配置-字典分类信息存储表-数据修改")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ReturnData update(
			@ApiParam(name = "DictionaryCategory实体", value = "根据主键Id修改数据，id不能为空！")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Update.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<DictionaryCategoryDTO> resultData = dictionaryCategoryApi.updateById(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				DictionaryCategoryDTO data = resultData.getData();
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

	@ApiOperation(value = "系统配置-字典分类信息存储表-根据主键Id删除")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "DictionaryCategory主键ID", value = "根绝主键id删除一条数据")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			DictionaryCategoryVO dictionaryCategoryVO = new DictionaryCategoryVO();
			dictionaryCategoryVO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<Long> resultData = dictionaryCategoryApi.removeById(id);
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
	
	@ApiOperation(value = "系统配置-字典分类信息存储表-动态条件获取单条数据")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "DictionaryCategory实体", value = "动态条件删除删除一条数据（包括根绝主键Id进行删除）")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Remove.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<List<DictionaryCategoryDTO>> resultData = dictionaryCategoryApi.listCriteria(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<DictionaryCategoryDTO> data = resultData.getData();
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
	
	@ApiOperation(value = "系统配置-字典分类信息存储表-根据主键Id获取单条数据")
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData detail(
			@ApiParam(name = "DictionaryCategory主键ID", value = "根据主键Id查询一条数据明细")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			DictionaryCategoryVO dictionaryCategoryVO = new DictionaryCategoryVO();
			dictionaryCategoryVO.setId(id);
			Class<?> groupCls [] = {Id.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<DictionaryCategoryDTO> resultData = dictionaryCategoryApi.getOneById(id);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				DictionaryCategoryDTO data = resultData.getData();
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
	

	@ApiOperation(value = "系统配置-字典分类信息存储表-动态条件获取单条数据")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody ReturnData detail(
			@ApiParam(name = "DictionaryCategory实体", value = "动态条件查询一条数据明细（包括根绝主键Id进行查询）")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Detail.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<List<DictionaryCategoryDTO>> resultData = dictionaryCategoryApi.listCriteria(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<DictionaryCategoryDTO> data = resultData.getData();
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

	@ApiOperation(value = "系统配置-字典分类信息存储表-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "DictionaryCategory实体", value = "动态条件查询列表数据")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {List.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<List<DictionaryCategoryDTO>> resultData = dictionaryCategoryApi.listCriteria(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<DictionaryCategoryDTO> data = resultData.getData();
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

	@ApiOperation(value = "系统配置-字典分类信息存储表-动态条件分页列表")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "DictionaryCategory实体", value = "动态条件进行分页列表查询，当前页[page]，每页数量[rows]，为必传数据")
			@RequestBody DictionaryCategoryVO dictionaryCategoryVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {PageList.class};
			String validMsg = super.validator(dictionaryCategoryVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			DictionaryCategoryDTO dictionaryCategoryDTO = new DictionaryCategoryDTO();
			//参数赋值
			BeanUtils.copyProperties(dictionaryCategoryVO, dictionaryCategoryDTO);
			ResultData<List<DictionaryCategoryDTO>> resultData = dictionaryCategoryApi.paginated(dictionaryCategoryDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<DictionaryCategoryDTO> data = resultData.getData();
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
