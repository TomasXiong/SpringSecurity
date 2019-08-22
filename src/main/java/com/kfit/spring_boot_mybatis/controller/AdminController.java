package com.kfit.spring_boot_mybatis.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.spring_boot_mybatis.base.BaseAction;

/**
 * 测试消息发送
 * 
 * @author 64507
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseAction {
	private static Logger log = Logger.getLogger(AdminController.class);
	
	@GetMapping("/greeting")
    public String greeting() {
        return "Hello,World!";
    }

    @GetMapping("/login")
    public String login() {

        return "login sucess";
    }

	

}
