package com.bs.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import com.bs.rest.config.SecurityConfig;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private SecurityConfig securityConfig;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		String resourceId = securityConfig.getResourceId();
		resources.resourceId(resourceId).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
			.antMatchers("/*")
		  	.and().authorizeRequests().antMatchers("/oauth/token",
					"/images/**",
					"/configuration/ui/**",
					"/configuration/security/**",
					"/configuration**",
		  			"/swagger-resources",
		  			"/swagger-ui.html",
		  			"/webjars/**",
		  			"/v2/api-docs/**").permitAll()
			.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}