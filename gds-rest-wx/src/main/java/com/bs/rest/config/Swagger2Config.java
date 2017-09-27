package com.bs.rest.config;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com.bs.rest.modules" })
public class Swagger2Config extends WebMvcConfigurationSupport {

	// @Bean
	// public Docket createRestApi() {
	// return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
	// .apis(RequestHandlerSelectors.basePackage("com.bs.rest.modules")).paths(PathSelectors.any())
	// .build();
	// }
	// private ApiInfo apiInfo() {
	// return new ApiInfoBuilder()
	// .title("布比核心业务系统微服务 RESTful API 接口")
	// .description("更多布比信息请关注：http://www.bubi.cn")
	// .termsOfServiceUrl("http://localhost:8081/swagger-ui.html")
	// .version("1.0")
	// .build();
	// }
	@Value("${security.userOauth.clientId}")
	private String authClientId;

	@Value("${security.userOauth.clientSecret}")
	private String authClientSecret;

	@Value("${security.userOauth.type}")
	private String type;

	@Value("${security.userOauth.authorizationUrl}")
	private String authorizationUrl;

	@Value("${security.userOauth.tokenUrl}")
	private String tokenUrl;

	@Value("${security.userOauth.tokenName}")
	private String tokenName;

	@Value("${security.userOauth.scope.code}")
	private String scopeCode;

	@Value("${security.userOauth.scope.desc}")
	private String scopeDesc;

	@Value("${app.key}")
	private String appKey;

	@Value("${app.name}")
	private String appName;

	@Value("${app.desc}")
	private String appDesc;

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.termsOfServiceUrl}")
	private String termsOfServiceUrl;

	@Value("${app.contact.name}")
	private String contactName;

	@Value("${app.contact.url}")
	private String contactUrl;

	@Value("${app.contact.email}")
	private String contactEmail;

	@Value("${app.license}")
	private String license;

	@Value("${app.licenseUrl}")
	private String licenseUrl;

	/**
	 * Api分组，可以定义多个组
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("bubi")
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false).forCodeGeneration(true)
				.pathMapping("/").select()
				.apis(RequestHandlerSelectors.basePackage("com.bs.rest.modules"))
				.build().securitySchemes(newArrayList(oauth()))
				.securityContexts(newArrayList(securityContext()))
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(appName, appDesc, appVersion, termsOfServiceUrl, new Contact(contactName, contactUrl, contactEmail), license, licenseUrl);
		return apiInfo;
	}

	@Bean
	SecurityScheme apiKey() {
		return new ApiKey(appName, appKey, "header");
	}

	@Bean
	SecurityContext securityContext() {
		AuthorizationScope[] scopes = new AuthorizationScope[] { new AuthorizationScope(scopeCode, scopeDesc) };
		SecurityReference securityReference = SecurityReference.builder().reference(type).scopes(scopes).build();
		return SecurityContext.builder().securityReferences(newArrayList(securityReference)).forPaths(ant("/api/**")).build();
	}

	@Bean
	SecurityScheme oauth() {
		return new OAuthBuilder().name(type).grantTypes(grantTypes()).scopes(scopes()).build();
	}

	List<AuthorizationScope> scopes() {
		return newArrayList(new AuthorizationScope(scopeCode, scopeDesc));
	}

	List<GrantType> grantTypes() {
		List<GrantType> grants = newArrayList(new AuthorizationCodeGrant(new TokenRequestEndpoint(authorizationUrl, authClientId, authClientSecret), new TokenEndpoint(tokenUrl, tokenName)));
		return grants;
	}

	@Bean
	public SecurityConfiguration securityInfo() {
		return new SecurityConfiguration(authClientId, authClientSecret, scopeCode, appKey, appKey, ApiKeyVehicle.HEADER, "", ",");
	}
}
