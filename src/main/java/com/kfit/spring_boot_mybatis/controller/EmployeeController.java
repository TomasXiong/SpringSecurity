package com.kfit.spring_boot_mybatis.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.spring_boot_mybatis.base.BaseAction;

/**
 * 测试权限配置
 * 
 * @author 64507
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseAction {
	private static Logger log = Logger.getLogger(EmployeeController.class);
	
	@GetMapping("/greeting")
    public String greeting() {
        return "Hello,World!";
    }

    @GetMapping("/login")
    public String login() {

        return "login sucess";
    }
	

}
