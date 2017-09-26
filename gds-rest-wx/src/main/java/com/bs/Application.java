package com.bs;

import java.util.ArrayList;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bs.rest.config.MessageSourceConfig;

@SpringBootApplication
public class Application {

	@Autowired
	private MessageSourceConfig messageSourceConfig;

	private ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public ResourceBundleMessageSource getMessageSource() throws Exception {
		String basenames = messageSourceConfig.getBasenames();
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		ArrayList<String> resourceList = new ArrayList<String>();
		resourceList.add("globalMessages");
		Resource[] resources = resolver.getResources(basenames + "*" + MessageSourceConfig.PROPERTIES_SUFFIX);
		for (Resource resource : resources) {
			String sourcePath = resource.getURI().toString();
			int startIndex = sourcePath.indexOf(MessageSourceConfig.CLASS);
			int endIndex = sourcePath.indexOf(MessageSourceConfig.PART_FILE_NAME);
			if (startIndex >= 0 && endIndex >= 0) {
				sourcePath = sourcePath.substring(startIndex + MessageSourceConfig.CLASS.length() + 1, endIndex + MessageSourceConfig.PART_FILE_NAME.length());
				resourceList.add(sourcePath);
			}
		}
		rbms.setBasenames(resourceList.toArray(new String[resourceList.size()]));
		// rbms.setBasenames("validationMessages");
		return rbms;
	}

	@Bean
	public Validator getValidator() throws Exception {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(getMessageSource());
		return validator;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}