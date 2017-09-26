package com.bs.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pluginxml")
public class PluginXmlConfig {
	
	public static final String PLUGIN_XML_SUFFIX = ".xml";
	public static final String PART_FILE_NAME = "plugin-config";
	
	/**
	 * 功能配置文件路径
	 */
	private String basenames;

	public String getBasenames() {
		return basenames;
	}

	public void setBasenames(String basenames) {
		this.basenames = basenames;
	}
}
