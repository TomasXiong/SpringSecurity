package com.kfit.spring_boot_mybatis.jms;
 
import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.base.BaseAction;
import com.kfit.spring_boot_mybatis.config.ActivityMqConfig;
 
@Service("consumer")
public class Consumer {
	private static Logger logger  = Logger.getLogger(Consumer.class);
        // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	//@JmsListener(destination = "topicQueue")
	public void receiveQueue(String text) {
		System.out.println("Consumer收到的报文为:"+text);
	}
	
	
	//@JmsListener(destination = ActivityMqConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        logger.info("接收到topic消息：{}"+msg);
    }

    //@JmsListener(destination = ActivityMqConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        logger.info("接收到queue消息：{}"+msg);
    }

}
