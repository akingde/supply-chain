package com.bs.rest.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			throw new AccessDeniedException("make sure configAttributes have inited!");
		}
		//判断访问权限
		boolean hasRight = check(authentication, configAttributes);
		if (!hasRight) {
			throw new AccessDeniedException("make sure you have right to access this service!");
		}
	}

	/**
	 * 验证用户是否有访问权限
	 * @param authentication
	 * @param configAttributes
	 * @return
	 */
	private boolean check(Authentication authentication,Collection<ConfigAttribute> configAttributes) {
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute configAttribute = ite.next();
			SecurityConfig securityConfig = (SecurityConfig) configAttribute;
			String role = securityConfig.getAttribute();
			//获取用户登录时候，拿到的系统访问权限
			Collection<? extends GrantedAuthority> grantedAuthoritys = authentication.getAuthorities();
			if (grantedAuthoritys == null || grantedAuthoritys.isEmpty()) {
				throw new AccessDeniedException("make sure you have right to access this service!");
			}
			for (GrantedAuthority grantedAuthority : grantedAuthoritys) {
				if (role.equals(grantedAuthority.getAuthority())) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
