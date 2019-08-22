package com.kfit.spring_boot_mybatis.filter;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Administrator on 2017/5/3.
 */
@Deprecated
public class QueueMessageListener2 implements MessageListener {
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("topicMessageListener1监听到了文本消息：\t"
                    + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
