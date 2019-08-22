package com.kfit.spring_boot_mybatis.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.spring_boot_mybatis.annotation.LogAnnotation;
import com.kfit.spring_boot_mybatis.base.BaseAction;
import com.kfit.spring_boot_mybatis.domain.Demo;
import com.kfit.spring_boot_mybatis.jms.Consumer;
import com.kfit.spring_boot_mybatis.jms.Producer;
import com.kfit.spring_boot_mybatis.service.DemoService;
import com.kfit.spring_boot_mybatis.utils.RedisUtil;

@RestController  //(该注解自动返回json格式)
public class DemoController extends BaseAction{
	private static Logger log  = Logger.getLogger(DemoController.class);
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	RedisUtil redisUtil;
	
	@Autowired
	private Consumer consumer;
	
	@Autowired
	private Producer producer;
	
	@LogAnnotation(logRecord="操作记录")
	@RequestMapping("/save")
	public int save(){
		for(int i =0;i<10;i++) {
			Demo demo = new Demo();
			demo.setDemoName("tt"+i);
			demo.setDemoCode("00"+i);
			demoService.save(demo);
		}
		
		return 1;
	}
	
	
	/**
	 * 测试redis缓存
	 */
	@RequestMapping("/getCache")
	//@Cacheable(value="redisCache")
	public Object getCache(){
		log.info("/getCache获取缓存数据=====");
		return redisUtil.get("test1");
	}
	
	@RequestMapping("/setCache")
	public void setCache(){
		log.info("/setCache设置缓存数据=====");
		redisUtil.set("test1", "text_xmm");
	}
	
}
