package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@Entity
@Table(name = "t_unit_info")
public class TUnitInfoEntity {
    private long fId;
    private String fName;
    private Date fCreateTime;
    private Date fUpdateTime;
    private Long fOperate;
    private long fCompanyId;

    @Id
    @Column(name = "f_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    @Basic
    @Column(name = "f_name", nullable = false, length = 20)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "f_create_time", nullable = false)
    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    @Basic
    @Column(name = "f_update_time", nullable = true)
    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    @Basic
    @Column(name = "f_operate", nullable = true)
    public Long getfOperate() {
        return fOperate;
    }

    public void setfOperate(Long fOperate) {
        this.fOperate = fOperate;
    }

    @Basic
    @Column(name = "f_company_id", nullable = false)
    public long getfCompanyId() {
        return fCompanyId;
    }

    public void setfCompanyId(long fCompanyId) {
        this.fCompanyId = fCompanyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TUnitInfoEntity that = (TUnitInfoEntity) o;
        return fId == that.fId &&
                fCompanyId == that.fCompanyId &&
                Objects.equals(fName, that.fName) &&
                Objects.equals(fCreateTime, that.fCreateTime) &&
                Objects.equals(fUpdateTime, that.fUpdateTime) &&
                Objects.equals(fOperate, that.fOperate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fId, fName, fCreateTime, fUpdateTime, fOperate, fCompanyId);
    }
}
