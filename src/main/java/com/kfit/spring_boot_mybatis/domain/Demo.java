package com.kfit.spring_boot_mybatis.domain;

import java.io.Serializable;

public class Demo implements Serializable {
    private Integer id;

    private String demoCode;

    private String demoName;

    private Byte enabledFlag;

    private Long test;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemoCode() {
        return demoCode;
    }

    public void setDemoCode(String demoCode) {
        this.demoCode = demoCode == null ? null : demoCode.trim();
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName == null ? null : demoName.trim();
    }

    public Byte getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Byte enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Long getTest() {
        return test;
    }

    public void setTest(Long test) {
        this.test = test;
    }
}