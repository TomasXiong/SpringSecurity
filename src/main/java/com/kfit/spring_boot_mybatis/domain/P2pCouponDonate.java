package com.kfit.spring_boot_mybatis.domain;

import java.sql.Timestamp;


/**
 * 优惠劵
 * 
 * 类描述： 创建人：xiexin10 创建时间：2016年3月9日 下午6:31:11 修改人：xiexin10 修改时间：2016年3月9日
 * 下午6:31:11 修改备注：
 * 
 * @version
 * 
 */
public class P2pCouponDonate implements java.io.Serializable {

    // Fields

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId; // 用户id用户id

    private Integer typeId; // 类型[1:加息券,2:代金券,3:体验金]
    
    private Integer ruleId;  //规则id
    


	private String mobile ; //客户手机号
    
    private String staffMobile; //理财师手机号

    private String name; // 优惠券名称

    private String desc; // 优惠券描述

    private Integer status; // 状态[0:未使用,1:已使用,2:已过期，3:待激活]

    private Double money; // 抵用金额(元)

    private Integer productId; // 指定产品ID[0:任何产品]

    private String createTime; //

    private Timestamp updateTime; //

    private String expireTime; // 到期时间

    private Integer activeStep; // 激活步骤0:全部;1:实名;2:充值;3:投资

    private Integer activeDays;// 激活天数

    private Integer activeTime;// 激活时间
    
    private String custName;


    // Constructors

    public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	/** default constructor */
    public P2pCouponDonate() {
    }

    /** minimal constructor */
    public P2pCouponDonate(Integer id, Integer userId, Integer status, Double money, Integer productId, String createTime) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.money = money;
        this.productId = productId;
        this.createTime = createTime;
    }

    /** full constructor */
    public P2pCouponDonate(Integer id, Integer userId, String name, String desc, Integer status, Double money,
            Integer productId, String createTime, Timestamp updateTime, String expireTime) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.money = money;
        this.productId = productId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expireTime = expireTime;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getActiveStep() {
        return activeStep;
    }

    public void setActiveStep(Integer activeStep) {
        this.activeStep = activeStep;
    }

    public Integer getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(Integer activeDays) {
        this.activeDays = activeDays;
    }

    public Integer getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }
    
    public Integer getRuleId() {
		return ruleId;
	}

	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStaffMobile() {
		return staffMobile;
	}

	public void setStaffMobile(String staffMobile) {
		this.staffMobile = staffMobile;
	}

}