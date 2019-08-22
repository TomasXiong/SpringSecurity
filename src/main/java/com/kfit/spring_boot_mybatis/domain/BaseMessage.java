package com.kfit.spring_boot_mybatis.domain;

import com.kfit.spring_boot_mybatis.utils.FinalUtils;

public class BaseMessage {
	
	private String code = FinalUtils.APP_PARAMS_R_FAILED;  //默认失败
	private String message = FinalUtils.APP_PARAMS_INFO_FAILED;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
