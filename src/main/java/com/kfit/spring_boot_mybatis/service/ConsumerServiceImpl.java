package com.kfit.spring_boot_mybatis.service;

import com.kfit.spring_boot_mybatis.service.ConsumerService;

import javax.jms.Destination;
import javax.jms.TextMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;

/**
 * Created by Administrator on 2017/5/3.
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Override
    public TextMessage receive(Destination destination){
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        try{
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return textMessage;
    }
}

