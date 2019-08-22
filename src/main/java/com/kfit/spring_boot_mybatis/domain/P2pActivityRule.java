package com.kfit.spring_boot_mybatis.domain;

import java.sql.Timestamp;

/**
 * P2pActivityRule entity. @author MyEclipse Persistence Tools
 */

public class P2pActivityRule implements java.io.Serializable {

    // Fields

    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     * 
     * @since Ver 1.1
     */

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer typeId; // 0:全部产品;1:优选产品;2:理财产品

    private Integer activityId; // 活动ID

    private String ruleCycle; // 限制期限(逗号分隔)无限制则空

    private Double moneyMin; // 最小投资金额,无限制则0

    private Double prize; // 奖励(加息|代金|体验金)

    private Timestamp createTime;// 创建时间

    private Timestamp beginTime; // 开始时间

    private Timestamp endTime; // 截止时间

    private Integer status; // 0：失效;1：生效

    private Integer validDay; // 有效天数，0：以结束时间end_time

    private Integer activeStep;// 激活步骤0:无须激活;1:实名;2:充值;3:投资

    private P2pActivity activity; // 活动类型[1:送加息券,2:送代金券，3:送体验金]
    
    private String remark;

    public Integer getId() {
        return id;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getRuleCycle() {
        return ruleCycle;
    }

    public void setRuleCycle(String ruleCycle) {
        this.ruleCycle = ruleCycle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getValidDay() {
        return validDay;
    }

    public void setValidDay(Integer validDay) {
        this.validDay = validDay;
    }

    public Double getMoneyMin() {
        return moneyMin;
    }

    public void setMoneyMin(Double moneyMin) {
        this.moneyMin = moneyMin;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public P2pActivity getActivity() {
        return activity;
    }

    public void setActivity(P2pActivity activity) {
        this.activity = activity;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getActiveStep() {
        return activeStep;
    }

    public void setActiveStep(Integer activeStep) {
        this.activeStep = activeStep;
    }

}