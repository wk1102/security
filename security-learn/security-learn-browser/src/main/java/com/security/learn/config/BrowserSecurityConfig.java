package com.security.learn.config;




import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.security.learn.config.validate.SecurityProperties;

/**
 * security 的适配器
 * 
 * @ClassName Browserser
 * @Description ToDo
 * @Author Administrator
 * @Date 2018/12/2 20:52
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * 注入自定义的 登陆成功后的处理器对象
	 */
	@Autowired
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
	
	/**
	 * 注入自定义的登录失败的处理器对象
	 */
	@Autowired
	private AuthenticationFailureHandler myAuthenticationFailuerHandler;

	/**
	 * 注册security的密码加密的类
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private DataSource  dataSource;
	@Autowired
	private SecurityProperties securityProperties;
	
	/**
	 * 登录认证处理逻辑
	 */
	@Autowired
	private UserDetailsService myUserDetailsServiceImpl;
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		tokenRepository.setCreateTableOnStartup(false);//在数据库里不创建表
		return  tokenRepository;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	/**
	 * 配置浏览器端的配置
	 * 
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.httpBasic()// 弹框形式登录的方式
		http.formLogin()// 表单登录的配置方式
		       // .loginPage("/login.html")  //自定义登录页面
				.successHandler(myAuthenticationSuccessHandler) //使用自定义的登陆成功的处理器
				.failureHandler(myAuthenticationFailuerHandler) //使用自定义的登录失败的处理器
				//配置记住我功能开始
				.and()
				.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBorwser().getRemenmberMeSecond())
				.userDetailsService(myUserDetailsServiceImpl)
				//配置记住我功能结束
				.and().authorizeRequests()// 对请求的授权
				.antMatchers("/code/*").permitAll() //匹配认证器,过滤不需要认证的请求 
				.anyRequest()// 任意请求
				.authenticated();// 必须经过身份认证

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
	}
	
	
	
	
	
	
}
