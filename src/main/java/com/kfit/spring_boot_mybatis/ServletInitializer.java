package com.kfit.spring_boot_mybatis;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @author Administrator
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

}
