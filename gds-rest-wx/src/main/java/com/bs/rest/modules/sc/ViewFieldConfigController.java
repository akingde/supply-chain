package com.bs.rest.modules.sc;
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
import com.bs.api.modules.sc.dto.ViewFieldConfigDTO;
import com.bs.api.modules.sc.service.IViewFieldConfigService;

import com.bs.rest.modules.sc.vo.ViewFieldConfigVO;
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

@Api(value = "/viewfieldconfig", description = "视图字段配置信息存储表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/viewfieldconfig")
public class ViewFieldConfigController extends BaseController{

	public static Logger logger = Logger.getLogger(ViewFieldConfigController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IViewFieldConfigService viewFieldConfigApi;
	
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
			Class<?> groupCls [] = {First.class};
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
			ResultData<ViewFieldConfigDTO> resultData = viewFieldConfigApi.save(viewFieldConfigDTO);
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

	@ApiOperation(value = "视图字段配置信息存储表-数据修改")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ReturnData update(
			@ApiParam(name = "ViewFieldConfig实体", value = "添加你的参数说明")
			@RequestBody ViewFieldConfigVO viewFieldConfigVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Second.class};
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
			ResultData<ViewFieldConfigDTO> resultData = viewFieldConfigApi.updateById(viewFieldConfigDTO);
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

	@ApiOperation(value = "视图字段配置信息存储表-根据主键Id删除")
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData remove(
			@ApiParam(name = "ViewFieldConfig主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ViewFieldConfigVO viewFieldConfigVO = new ViewFieldConfigVO();
			viewFieldConfigVO.setId(id);
			Class<?> groupCls [] = {Third.class};
			String validMsg = super.validator(viewFieldConfigVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<Long> resultData = viewFieldConfigApi.removeById(id);
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
	
	@ApiOperation(value = "视图字段配置信息存储表-根据主键Id获取单条数据")
	@RequestMapping(value = "/single/{id}", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ViewFieldConfig主键ID", value = "添加你的参数说明")
			@PathVariable("id") Long id,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			ViewFieldConfigVO viewFieldConfigVO = new ViewFieldConfigVO();
			viewFieldConfigVO.setId(id);
			Class<?> groupCls [] = {Fourth.class};
			String validMsg = super.validator(viewFieldConfigVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			ResultData<ViewFieldConfigDTO> resultData = viewFieldConfigApi.getOneById(id);
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
	

	@ApiOperation(value = "视图字段配置信息存储表-动态条件获取单条数据")
	@RequestMapping(value = "/single", method = RequestMethod.POST)
	public @ResponseBody ReturnData single(
			@ApiParam(name = "ViewFieldConfig实体", value = "添加你的参数说明")
			@RequestBody ViewFieldConfigVO viewFieldConfigVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Fifth.class};
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
			ResultData<List<ViewFieldConfigDTO>> resultData = viewFieldConfigApi.listCriteria(viewFieldConfigDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ViewFieldConfigDTO> data = resultData.getData();
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

	@ApiOperation(value = "视图字段配置信息存储表-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "ViewFieldConfig实体", value = "添加你的参数说明")
			@RequestBody ViewFieldConfigVO viewFieldConfigVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Sixth.class};
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
			ResultData<List<ViewFieldConfigDTO>> resultData = viewFieldConfigApi.listCriteria(viewFieldConfigDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ViewFieldConfigDTO> data = resultData.getData();
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

	@ApiOperation(value = "视图字段配置信息存储表-动态条件分页数剧")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "ViewFieldConfig实体", value = "添加你的参数说明")
			@RequestBody ViewFieldConfigVO viewFieldConfigVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Seventh.class};
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
			ResultData<List<ViewFieldConfigDTO>> resultData = viewFieldConfigApi.paginated(viewFieldConfigDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<ViewFieldConfigDTO> data = resultData.getData();
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
