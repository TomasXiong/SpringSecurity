package com.kfit.spring_boot_mybatis.controller;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.spring_boot_mybatis.base.BaseAction;
import com.kfit.spring_boot_mybatis.jms.Producer;

/**
 * 测试消息发送
 * 
 * @author 64507
 *
 */
@RestController // (该注解自动返回json格式)
@RequestMapping(value = "/user")
public class ActiveMqController extends BaseAction {
	private static Logger log = Logger.getLogger(ActiveMqController.class);

	@Autowired
	private Producer jmsProducer;
	@Autowired
	private Topic topic;
	@Autowired
	private Queue queue;

	@RequestMapping("/getMsg")
	public void testJms() {
		for (int i = 0; i < 10; i++) {
			jmsProducer.sendMessage(queue, "queue,world!" + i);
			jmsProducer.sendMessage(topic, "topic,world!" + i);
		}
	}

}
