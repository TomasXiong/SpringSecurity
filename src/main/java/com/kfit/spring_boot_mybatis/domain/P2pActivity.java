package com.kfit.spring_boot_mybatis.domain;

import java.sql.Timestamp;

/**
 * P2P活动 zjixiang
 */

public class P2pActivity implements java.io.Serializable {

    // Fields

    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     * 
     * @since Ver 1.1
     */

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title; // 活动标题

    private String desc; // 活动描述

    private Timestamp beginTime; // 开始时间

    private Timestamp endTime; // 截止时间

    private Integer typeId; // 活动类型[1:送加息券,2:送代金券，3:送体验金]

    private Integer isRepeat; // 是否重复参加[0:唯一,1:可重复]

    private Integer triggerId; // 触发条件[0:注册,1:投资]

    private String remark; // 活动备注

    private Timestamp createTime; // 创建时间

    private String imgPath;// 图片路径

    private String imgUrl;// 图片链接

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Integer getIsRepeat() {
        return isRepeat;
    }

    public void setIsRepeat(Integer isRepeat) {
        this.isRepeat = isRepeat;
    }

    public Integer getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(Integer triggerId) {
        this.triggerId = triggerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}