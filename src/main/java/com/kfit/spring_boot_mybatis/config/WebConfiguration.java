package com.kfit.spring_boot_mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
* @author pengchao
* @create 2017-09-13
* @desc 初始化Bean、添加自定义拦截器等
*/
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
    /**
     * 跨域
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
    	System.out.println("======================跨域设置================");
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	System.out.println("+++++++++++++++跨域请求设置++++++++++++++++");
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }



}