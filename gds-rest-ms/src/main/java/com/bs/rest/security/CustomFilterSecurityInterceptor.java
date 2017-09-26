package com.bs.rest.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;



@Component
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
	
	private static final AntPathRequestMatcher oauthRequestMatcher = new AntPathRequestMatcher("/oauth/**");
	private static final AntPathRequestMatcher swaggerRequestMatcher = new AntPathRequestMatcher("/swagger-ui.html");
	private static final AntPathRequestMatcher swaggerResRequestMatcher = new AntPathRequestMatcher("/swagger-resources");
	private static final AntPathRequestMatcher faviconRequestMatcher = new AntPathRequestMatcher("/favicon.ico");
	private static final AntPathRequestMatcher webjarsRequestMatcher = new AntPathRequestMatcher("/webjars/**");
	private static final AntPathRequestMatcher configurationRequestMatcher = new AntPathRequestMatcher("/configuration/**");
	private static final AntPathRequestMatcher imagesRequestMatcher = new AntPathRequestMatcher("/images/**");
	private static final AntPathRequestMatcher v2docRequestMatcher = new AntPathRequestMatcher("/v2/**");
	
	@Autowired
	private CustomSecurityMetadataSource securityMetadataSource;

	@Autowired
	@Override
	public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
		super.setAccessDecisionManager(accessDecisionManager);
	}

	@Autowired
	@Override
	public void setAuthenticationManager(AuthenticationManager newManager) {
		super.setAuthenticationManager(newManager);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		setRejectPublicInvocations(true);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);

	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		//非鉴权地址直接跳过
		boolean isOauth = oauthRequestMatcher.matches(fi.getHttpRequest());
		boolean isSwagger = swaggerRequestMatcher.matches(fi.getHttpRequest());
		boolean isSwaggerRes = swaggerResRequestMatcher.matches(fi.getHttpRequest());
		boolean isFavicon = faviconRequestMatcher.matches(fi.getHttpRequest());
		boolean isWebjars = webjarsRequestMatcher.matches(fi.getHttpRequest());
		boolean isConfig = configurationRequestMatcher.matches(fi.getHttpRequest());
		boolean isImage = imagesRequestMatcher.matches(fi.getHttpRequest());
		boolean isV2doc = v2docRequestMatcher.matches(fi.getHttpRequest());
		InterceptorStatusToken token = null;
		if (!isOauth && !isSwagger && !isSwaggerRes && !isFavicon && !isWebjars && !isConfig && !isImage && !isV2doc) {
			 token = super.beforeInvocation(fi);
		}
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		}
		finally {
			super.afterInvocation(token, null);
		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
}