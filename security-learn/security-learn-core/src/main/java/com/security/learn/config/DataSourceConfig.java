package com.security.learn.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 数据源的配置类
 * @author issuser
 *
 */
@Configuration
public class DataSourceConfig {
   @ConfigurationProperties(prefix = "spring.datasource")
   @Bean
   public DataSource druid () {
	   return new DruidDataSource();
   }
}
