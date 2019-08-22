package com.kfit.spring_boot_mybatis.domain;

import java.sql.Timestamp;

public class P2pDonateRate  {
	
	private int id;
	private Integer productCycle; //产品周期
	private double rate; //红包收益率
	private Timestamp createTime; //创建时间
	private Timestamp updateTime; //修改时间
	
	private Timestamp validateBegin; //生效开始时间
	private Timestamp validateEnd; //生效结束时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getValidateBegin() {
		return validateBegin;
	}
	public void setValidateBegin(Timestamp validateBegin) {
		this.validateBegin = validateBegin;
	}
	public Timestamp getValidateEnd() {
		return validateEnd;
	}
	public void setValidateEnd(Timestamp validateEnd) {
		this.validateEnd = validateEnd;
	}
	public Integer getProductCycle() {
		return productCycle;
	}
	public void setProductCycle(Integer productCycle) {
		this.productCycle = productCycle;
	}
	

}
