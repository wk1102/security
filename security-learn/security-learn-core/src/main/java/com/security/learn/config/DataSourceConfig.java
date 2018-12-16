package com.security.learn.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
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
	
	
	
	/**
	 * 启功druid的监控系统
	 * @return
	 */
	@Bean
	public ServletRegistrationBean druidServlet() {
	    ServletRegistrationBean reg = new ServletRegistrationBean();
	    reg.setServlet(new StatViewServlet());//druid默认提供的servlet
	    reg.addUrlMappings("/druid/*");
		reg.addInitParameter("loginUsername", "druidRoot");
		reg.addInitParameter("loginPassword", "druidRoot");
		///reg.addInitParameter("logSlowSql", logSlowSql);
	    return reg;
	}
	
	@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.html,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }
}
