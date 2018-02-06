package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author : zhangwen
 * @Data : 2018/1/18
 * @Description : 客户消息
 */

@Entity
@Table(name = "t_consumer_msg")
public class TConsumerMsgEntity {


    //主键ID
    private long fId;
    //客户id
    private long fConsumerId;
    //公司id
    private long fCompanyId;
    //消息标题
    private String fMsgTitle;
    //消息简介
    private String fMsgDesc;
    //消息内容
    private String fMsgContent;
    //消息类型 order:订单消息
    private String fMsgType;
    //外链id 若为订单消息类型，则对应订单表主键id
    private long fLinkId;
    //消息状态 read：已读 unread:未读
    private String fMsgStatus;
    //消息备注 若为订单类型 则存储订单状态
    // forcheck-待订单审核
    // forpick-待提货
    // completed-已完成
    // cancelled-已作废
    private String fRemark;
    //创建时间
    private Date fCreateTime;

    @Id
    @Column(name = "f_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    @Basic
    @Column(name = "f_consumer_id", nullable = false)
    public long getfConsumerId() {
        return fConsumerId;
    }

    public void setfConsumerId(long fConsumerId) {
        this.fConsumerId = fConsumerId;
    }

    @Basic
    @Column(name = "f_company_id", nullable = false)
    public long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    @Basic
    @Column(name = "f_msg_title", nullable = false, length = 20)
    public String getfMsgTitle() {
        return fMsgTitle;
    }

    public void setfMsgTitle(String fMsgTitle) {
        this.fMsgTitle = fMsgTitle;
    }

    @Basic
    @Column(name = "f_msg_desc", nullable = false, length = 100)
    public String getfMsgDesc() {
        return fMsgDesc;
    }

    public void setfMsgDesc(String fMsgDesc) {
        this.fMsgDesc = fMsgDesc;
    }

    @Basic
    @Column(name = "f_msg_content", length = 1000)
    public String getfMsgContent() {
        return fMsgContent;
    }

    public void setfMsgContent(String fMsgContent) {
        this.fMsgContent = fMsgContent;
    }

    @Basic
    @Column(name = "f_msg_type", nullable = false, length = 20)
    public String getfMsgType() {
        return fMsgType;
    }

    public void setfMsgType(String fMsgType) {
        this.fMsgType = fMsgType;
    }

    @Basic
    @Column(name = "f_link_id", nullable = false)
    public long getfLinkId() {
        return fLinkId;
    }

    public void setfLinkId(long fLinkId) {
        this.fLinkId = fLinkId;
    }

    @Basic
    @Column(name = "f_msg_status", nullable = false, length = 10)
    public String getfMsgStatus() {
        return fMsgStatus;
    }

    public void setfMsgStatus(String fMsgStatus) {
        this.fMsgStatus = fMsgStatus;
    }

    @Basic
    @Column(name = "f_remark", nullable = false, length = 100)
    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark;
    }

    @Basic
    @Column(name = "f_create_time", nullable = false)
    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }
}
