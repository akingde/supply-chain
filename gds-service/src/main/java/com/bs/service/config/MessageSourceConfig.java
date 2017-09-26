package com.bs.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "messages")
public class MessageSourceConfig {
	
	public static final String PROPERTIES_SUFFIX = ".properties";
	public static final String CLASS = "classes";
	public static final String PART_FILE_NAME = "Messages";
	/**
	 * 国家化文件，存放的扫描路径
	 */
	private String basenames;

	public String getBasenames() {
		return basenames;
	}

	public void setBasenames(String basenames) {
		this.basenames = basenames;
	}
	
	
}
