package com.kfit.spring_boot_mybatis.activeMq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sender {

	public static void main(String[] args) {

		// ConnectionFactory是连接工厂，JMS用它创建连接
		ConnectionFactory connectionFactory;

		// Connection JMS客户端到JMS provider的连接
		Connection connection = null;

		// Session 一个发送或者接收消息的线程
		Session session;

		// Destination 消息发送目的地，消息发送给谁接收
		Destination destination;

		// MessageProducer 消息发送者
		MessageProducer messageProducer;

		// 构造ConnectionFactory 实例对象，此处采用ActiveMQ的实现jar
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

		try {
			// 构造工厂得到连接对象
			connection = connectionFactory.createConnection();

			// 启动
			connection.start();

			// 获取操作连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);//第一个参数表示事务，第二个表示收到消息确认模式

			// 创建一个Queue，名称为FirstQueue
			destination = session.createQueue("FirstQueue");

			// 得到消息生产者【发送者】
			messageProducer = session.createProducer(destination);

			// 设置不持久化，根据实际情况而定
			messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);

			// 创建一个消息对象
			TextMessage message = session.createTextMessage();

			// 把我们的消息写入msg对象中
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in)); 

			for(int i=0;i<100;i++) {
				System.out.println("输入信息内容，Enter Msg:");
				String s = b.readLine();
				if (s.equals("end"))
					break;
				message.setText(s);
				// 发送消息
				messageProducer.send(message);
				System.out.println("Message successfully sent.");
			}
			System.out.println("===========输入信息结束==================");

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != connection) {
					connection.close();
				}
			} catch (Throwable ignore) {
			}
		}
	}
}
