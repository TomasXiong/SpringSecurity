package com.kfit.spring_boot_mybatis.service;

import javax.jms.Destination;


/**
 * Created by Administrator on 2017/5/3.
 */
public interface ProducerService {

    void sendMessage(Destination destination,final String msg);

    void sendMessage(final String msg);
}

