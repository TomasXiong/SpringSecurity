package com.kfit.spring_boot_mybatis.domain;

import java.io.Serializable;

public class Resource implements Serializable {
    private Long id;

    private String url;

    private String roles;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }
    
    
    public String[] getRolesArray() {
    	String rolesArray[] = roles.split(",");
    	return rolesArray;
    }
}