package com.kfit.spring_boot_mybatis;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * springBoot启动类
 * @author Administrator
 * 2018-03-14
 */
@SpringBootApplication
@EnableCaching//开启redis缓存
@MapperScan("com.kfit.spring_boot_mybatis.mapper")//扫描：该包下相应的class,主要是MyBatis的持久化类.
public class App extends WebMvcConfigurerAdapter  {
	
	/**
     * 利用fastjson替换掉jackson，且解决中文乱码问题
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }

	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
		System.out.println("===========springBoot启动完毕=========");
	}
}
