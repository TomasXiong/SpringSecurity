		package com.kfit.spring_boot_mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.kfit.spring_boot_mybatis.service.MyUserService;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private MyUserService myUserService; //用户自定义的查询客户信息方法
	
	@Autowired
	private BackDoorAuthenticationProvider backDoorAuthenticationProvider; //后门验证
	
	@Autowired
	private MySecurityMetadataSource mySecurityMetadataSource;
	
	@Autowired
	private MyAccessDecisionManager myAccessDecisionManager;
	
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
	
/*	@Bean
    public DaoAuthenticationProvider getAuthenticationManagerBuilder() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserService); //自定义的用户和角色数据提供者
        authenticationProvider.setPasswordEncoder(passwordEncoder()); //设置密码加密对象

		return authenticationProvider;
    }*/
	
	/**
	 * 主要配置身份证来源，也就是用户及角色
	 */
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService)
          //      .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
        
		//基于内存使用鉴权
        /* auth.inMemoryAuthentication()
        .withUser("admin").password("123456").roles("ADMIN")
        .and()
        .withUser("employee").password("123456").roles("EMPLOYEE");*/
        
        //基于数据库
        //auth.authenticationProvider(getAuthenticationManagerBuilder());//入参.AuthenticationManagerBuilder 设置身份认证提供者
		
		
		 // 使用自定义登录身份认证组件
        //auth.authenticationProvider(new JwtAuthenticationProvider(userDetailService));
		
		auth.authenticationProvider(backDoorAuthenticationProvider);//将后门设置加入验证
		
		
		//通过数据库验证
		//DaoAuthenticationProvider继承AbstractUserDetailsAuthenticationProvider，AbstractUserDetailsAuthenticationProvider实现AuthenticationProvider接口
        auth.userDetailsService(myUserService).passwordEncoder(new BCryptPasswordEncoder());
        
    }
	
  
    /**
     * 主要配置路径，也就是资源的访问权限(是否需要认证，需要什么角色等)
     */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()//限定签名成功的请求
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
		             @Override
		             public <O extends FilterSecurityInterceptor> O postProcess(O object) {
		                 object.setSecurityMetadataSource(mySecurityMetadataSource);
		                 object.setAccessDecisionManager(myAccessDecisionManager);
		                 return object;
		             }
		         })
				.and()
		
		  .formLogin().loginPage("/login_p").loginProcessingUrl("/login").permitAll()
          //1.自定义参数名称，与login.html中的参数对应
          .usernameParameter("myusername").passwordParameter("mypassword")
          .and()
          .logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
          .and()
          .csrf().disable()
          .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
		
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
	}
}