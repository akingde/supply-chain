package com.bs.rest.modules.uc.base;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Reference;

import com.bs.api.core.entity.PageData;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.UserRoleRelationDTO;
import com.bs.api.modules.uc.service.IUserRoleRelationService;

import com.bs.rest.modules.uc.vo.UserRoleRelationVO;
import com.bs.rest.core.entity.ReturnData;
import com.bs.rest.core.group.Save;
import com.bs.rest.core.group.Detail;
import com.bs.rest.core.group.PageList;
import com.bs.rest.core.utils.StringUtil;
import com.bs.rest.core.controller.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/userrolerelation", description = "用户角色关系映射表接口")
@RestController
@EnableAutoConfiguration
@RequestMapping(value="/userrolerelation")
public class BaseUserRoleRelationController extends BaseController{

	public static Logger logger = Logger.getLogger(BaseUserRoleRelationController.class);

	@Reference(version = "1.0.0",timeout=50000,retries=5)
	private IUserRoleRelationService userRoleRelationApi;
	
	@ApiOperation(value = "用户角色关系映射表-数据添加(保存)")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ReturnData save(
			@ApiParam(name = "UserRoleRelation实体", value = "存储数据")
			@RequestBody UserRoleRelationVO userRoleRelationVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Save.class};
			String validMsg = super.validator(userRoleRelationVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			UserRoleRelationDTO userRoleRelationDTO = new UserRoleRelationDTO();
			//参数赋值
			BeanUtils.copyProperties(userRoleRelationVO, userRoleRelationDTO);
			ResultData<UserRoleRelationDTO> resultData = userRoleRelationApi.save(userRoleRelationDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				UserRoleRelationDTO data = resultData.getData();
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


	@ApiOperation(value = "用户角色关系映射表-动态条件获取单条数据")
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody ReturnData detail(
			@ApiParam(name = "UserRoleRelation实体", value = "动态条件查询一条数据明细（包括根绝主键Id进行查询）")
			@RequestBody UserRoleRelationVO userRoleRelationVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {Detail.class};
			String validMsg = super.validator(userRoleRelationVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			UserRoleRelationDTO userRoleRelationDTO = new UserRoleRelationDTO();
			//参数赋值
			BeanUtils.copyProperties(userRoleRelationVO, userRoleRelationDTO);
			ResultData<List<UserRoleRelationDTO>> resultData = userRoleRelationApi.listCriteria(userRoleRelationDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<UserRoleRelationDTO> data = resultData.getData();
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

	@ApiOperation(value = "用户角色关系映射表-动态条件列表数据")
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody ReturnData list(
			@ApiParam(name = "UserRoleRelation实体", value = "动态条件查询列表数据")
			@RequestBody UserRoleRelationVO userRoleRelationVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {List.class};
			String validMsg = super.validator(userRoleRelationVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			UserRoleRelationDTO userRoleRelationDTO = new UserRoleRelationDTO();
			//参数赋值
			BeanUtils.copyProperties(userRoleRelationVO, userRoleRelationDTO);
			ResultData<List<UserRoleRelationDTO>> resultData = userRoleRelationApi.listCriteria(userRoleRelationDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<UserRoleRelationDTO> data = resultData.getData();
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

	@ApiOperation(value = "用户角色关系映射表-动态条件分页列表")
	@RequestMapping(value = "/paginate", method = RequestMethod.POST)
	public @ResponseBody ReturnData paginate(
			@ApiParam(name = "UserRoleRelation实体", value = "动态条件进行分页列表查询，当前页[page]，每页数量[rows]，为必传数据")
			@RequestBody UserRoleRelationVO userRoleRelationVO,
			HttpServletRequest request, 
			HttpServletResponse response) {
		ReturnData returnData = new ReturnData();
		try {
			//验证参数合法性
			Class<?> groupCls [] = {PageList.class};
			String validMsg = super.validator(userRoleRelationVO, groupCls);
			if (!StringUtil.isEmpty(validMsg)) {
				returnData.setCode(ReturnData.RCODE_PARAM_VALID);
				returnData.setMessage(validMsg);
				return returnData;
			}
			//调用dubbo 业务
			UserRoleRelationDTO userRoleRelationDTO = new UserRoleRelationDTO();
			//参数赋值
			BeanUtils.copyProperties(userRoleRelationVO, userRoleRelationDTO);
			ResultData<List<UserRoleRelationDTO>> resultData = userRoleRelationApi.paginated(userRoleRelationDTO);
			if (resultData != null) {
				String code = resultData.getCode();
				String message = resultData.getMessage();
				List<UserRoleRelationDTO> data = resultData.getData();
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
