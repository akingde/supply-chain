package com.bubi.creator.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class MySqlSessionFactory {

	private static String resource = "classpath:creator/mybatis/mybatis-config.xml";
	private static ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	private static SqlSessionFactory sqlSessionFactory = null;
	static Logger logger = Logger.getLogger(MySqlSessionFactory.class);

	private MySqlSessionFactory() {
	}

	/**
	 * mybatis sqlSession 工厂类单例模式
	 * @return
	 */
	public static SqlSessionFactory getInstance() {
		if (sqlSessionFactory == null) {
			logger.debug("开始加载  mybatis-config.xml 数据库配置文件.");
			try {
				Resource resources = resolver.getResource(resource);
				InputStream inputStream = resources.getInputStream();
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				logger.debug("mybatis-config.xml 数据库配置文件加载成功.");
			}
			catch (IOException e) {
				logger.debug("mybatis-config.xml 数据库配置文件加载失败.");
				e.printStackTrace();
				System.exit(0);
			}
		}
		return sqlSessionFactory;
	}
}
