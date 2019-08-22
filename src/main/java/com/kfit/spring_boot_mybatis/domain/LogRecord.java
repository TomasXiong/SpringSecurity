package com.kfit.spring_boot_mybatis.domain;

import java.io.Serializable;

public class LogRecord implements Serializable {
    private Integer id;

    private String requestMethod;

    private String requestTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime == null ? null : requestTime.trim();
    }
}