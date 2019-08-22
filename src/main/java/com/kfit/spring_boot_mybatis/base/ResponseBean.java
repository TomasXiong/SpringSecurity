package com.kfit.spring_boot_mybatis.base;

/**
 * 服务器返回客户端的bean
 * @author 64507
 *
 */
public class ResponseBean {
	
	private int code;
	private String msg;
	private String status;
	
	public ResponseBean(int code,String msg,String status) {
		this.code = code;
		this.msg = msg;
		this.status = status;
	}
	
	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
