package com.kfit.spring_boot_mybatis.service;

import javax.jms.Destination;
import javax.jms.TextMessage;
/**
 * Created by Administrator on 2017/5/3.
 */
public interface ConsumerService {

    TextMessage receive(Destination destination);
}
