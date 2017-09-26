package com.bs.rest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {
	public static final String PASSWORD = "password";
	public static final String AUTHORIZATION_CODE = "authorization_code";
	public static final String REFRESH_TOKEN = "refresh_token";
	public static final String IMPLICIT = "implicit";
	public static final String ROLE_CLIENT = "ROLE_CLIENT";
	public static final String ROLE_TRUSTED_CLIENT = "ROLE_TRUSTED_CLIENT";
	public static final String READ = "read";
	public static final String WRITE = "write";
	public static final String TRUST = "trust";
	/**
	 * 应用Id
	 */
	private String clientId;
	
	/**
	 * 应用密码
	 */
	private String secret;
	
	/**
	 * 资源id
	 */
	private String resourceId;
	
	/**
	 * token有效期
	 */
	private Integer accessTokenSeconds;

	/**
	 * token 刷新时间
	 */
	private Integer refreshTokenSeconds;


	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getAccessTokenSeconds() {
		return accessTokenSeconds;
	}

	public void setAccessTokenSeconds(Integer accessTokenSeconds) {
		this.accessTokenSeconds = accessTokenSeconds;
	}

	public Integer getRefreshTokenSeconds() {
		return refreshTokenSeconds;
	}

	public void setRefreshTokenSeconds(Integer refreshTokenSeconds) {
		this.refreshTokenSeconds = refreshTokenSeconds;
	}
}
