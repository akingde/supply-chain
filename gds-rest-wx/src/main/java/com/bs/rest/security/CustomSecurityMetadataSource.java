package com.bs.rest.security;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bs.api.core.entity.ResultCode;
import com.bs.api.core.entity.ResultData;
import com.bs.api.modules.uc.dto.AuthorizationDTO;
import com.bs.api.modules.uc.service.IAuthorizationService;
import com.bs.api.modules.uc.service.IRoleService;
import com.bs.rest.core.utils.StringUtil;

@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	/**
	 * 正常权限资源映射集合
	 */
	private static Map<String, ConfigAttribute> configAttributeMap = null;
	/**
	 * 通配符资源权限映射集合
	 */
	private static Map<String, ConfigAttribute> configAttributeWildcardMap = null;
	

	@Reference(version = "1.0.0")
	private IAuthorizationService authorizationApi;
	
	@Reference(version = "1.0.0")
	private IRoleService roleApi;
	
	/**
	 * 加载角色权限信息
	 */
	private void loadAuthorization() {
		// 查找到所有角色信息
		ResultData<List<AuthorizationDTO>> resultData = authorizationApi.listAll();
		if (resultData != null) {
			String rcode = resultData.getCode();
			if (rcode != null && rcode.equals(ResultCode.RCODE_SUCCESS)) {
				configAttributeMap =  new HashMap<String,ConfigAttribute>();
				//获取掉权限信息进行实例化对象
				List<AuthorizationDTO> authorizations = resultData.getData();
				for (AuthorizationDTO authorizationDTO:authorizations) {
					String entityName = authorizationDTO.getEntityName();
					String methodName = authorizationDTO.getMethodName();
					Long authCode = authorizationDTO.getCode();
					//任何一个为空都不是合法的权限信息
					if (entityName == null || methodName == null || authCode == null) {
						continue;
					}
					entityName = entityName.toLowerCase();
					methodName = methodName.toLowerCase();
					ConfigAttribute configAttribute = new SecurityConfig(String.valueOf(authCode));
					//请求的url地址
					String urlKey = "/" + entityName + "/" + methodName;
					//map中是否存在，如果不存在加入到map中
					ConfigAttribute configAttributeTemp =  configAttributeMap.get(urlKey);
					if (configAttributeTemp == null) {
						configAttributeMap.put(urlKey, configAttribute);
					}
					//通配符处理
					String wildcardPath = authorizationDTO.getWildcardPath();
					if (wildcardPath != null && wildcardPath.equals("")) {
						if (configAttributeWildcardMap == null) {
							configAttributeWildcardMap = new HashMap<String,ConfigAttribute>();
						}
						int index = wildcardPath.indexOf("/");
						if (index < 0) {
							urlKey += "/" + wildcardPath;
						}
						else {
							urlKey += wildcardPath;
						}
						//如果通配符url不存在，则存储新的通配规则到map对象
						ConfigAttribute configAttributeWildcardTemp = configAttributeWildcardMap.get(urlKey);
						if (configAttributeTemp == null) {
							configAttributeWildcardMap.put(urlKey, configAttributeWildcardTemp);
						}
					}
				}
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		if (configAttributeMap == null || configAttributeMap.size() == 0) {
			loadAuthorization();
		}
		Collection<ConfigAttribute> configAttributes = new HashSet<ConfigAttribute>();
		FilterInvocation filterInvocation = (FilterInvocation) object;
		String requestUrl = filterInvocation.getRequestUrl();
		if (requestUrl != null) {
			 int index = requestUrl.indexOf("?");
			 if (index >= 0) {
				 requestUrl = requestUrl.substring(0, index);
			 }
			 //验证普通url权限映射关系
			 ConfigAttribute configAttribute = configAttributeMap.get(requestUrl);
			 if (configAttribute != null) {
				 configAttributes.add(configAttribute);
				 return configAttributes;
			 }
			 else {
				 //验证通配符地址
				 if (configAttributeWildcardMap != null) {
					 for(Map.Entry<String, ConfigAttribute> entry:configAttributeWildcardMap.entrySet()){  
			            String key = entry.getKey();  
			            ConfigAttribute value = entry.getValue(); 
			            boolean matchResult = StringUtil.wildcardStarMatch(key, requestUrl);
			            if (matchResult) {
			            	configAttributes.add(value);
			            	return configAttributes;
			            }
			        }  
				 }
			 }
		}
		if (configAttributes.isEmpty()) {
			throw new AccessDeniedException("unauthorized access！");
		}
		return configAttributes;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
