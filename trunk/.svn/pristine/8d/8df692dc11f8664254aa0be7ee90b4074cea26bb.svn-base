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
@Table(name = "t_product_info")
public class TProductInfoEntity {
    private long fId;
    private String fName;
    private String fCode;
    private long fCategoryIdOne;
    private long fCategoryIdTwo;
    private Integer fSort;
    private String fIsUnits;
    private Long fUnitId;
    private String fSearchKey;
    private String fStatus;
    private String fDesp;
    private Date fCreateTime;
    private Date fUpdateTime;
    private Long fOperate;
    private long fCompanyId;
    private String fSearchCondition;
    private String fPicList;

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
    @Column(name = "f_code", nullable = true, length = 20)
    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    @Basic
    @Column(name = "f_category_id_one", nullable = false)
    public long getfCategoryIdOne() {
        return fCategoryIdOne;
    }

    public void setfCategoryIdOne(long fCategoryIdOne) {
        this.fCategoryIdOne = fCategoryIdOne;
    }

    @Basic
    @Column(name = "f_category_id_two", nullable = false)
    public long getfCategoryIdTwo() {
        return fCategoryIdTwo;
    }

    public void setfCategoryIdTwo(long fCategoryIdTwo) {
        this.fCategoryIdTwo = fCategoryIdTwo;
    }

    @Basic
    @Column(name = "f_sort", nullable = true)
    public Integer getfSort() {
        return fSort;
    }

    public void setfSort(Integer fSort) {
        this.fSort = fSort;
    }

    @Basic
    @Column(name = "f_is_units", nullable = false, length = 10)
    public String getfIsUnits() {
        return fIsUnits;
    }

    public void setfIsUnits(String fIsUnits) {
        this.fIsUnits = fIsUnits;
    }

    @Basic
    @Column(name = "f_unit_id", nullable = true)
    public Long getfUnitId() {
        return fUnitId;
    }

    public void setfUnitId(Long fUnitId) {
        this.fUnitId = fUnitId;
    }

    @Basic
    @Column(name = "f_search_key", nullable = true, length = 20)
    public String getfSearchKey() {
        return fSearchKey;
    }

    public void setfSearchKey(String fSearchKey) {
        this.fSearchKey = fSearchKey;
    }

    @Basic
    @Column(name = "f_status", nullable = false, length = 10)
    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    @Basic
    @Column(name = "f_desp", nullable = false, length = 5000)
    public String getfDesp() {
        return fDesp;
    }

    public void setfDesp(String fDesp) {
        this.fDesp = fDesp;
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

    @Basic
    @Column(name = "f_search_condition", nullable = false, length = 300)
    public String getfSearchCondition() {
        return fSearchCondition;
    }

    public void setfSearchCondition(String fSearchCondition) {
        this.fSearchCondition = fSearchCondition;
    }

    @Basic
    @Column(name = "f_pic_list", nullable = true, length = 1000)
    public String getfPicList() {
        return fPicList;
    }

    public void setfPicList(String fPicList) {
        this.fPicList = fPicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TProductInfoEntity that = (TProductInfoEntity) o;
        return fId == that.fId &&
                fCategoryIdOne == that.fCategoryIdOne &&
                fCategoryIdTwo == that.fCategoryIdTwo &&
                fSort == that.fSort &&
                fCompanyId == that.fCompanyId &&
                Objects.equals(fName, that.fName) &&
                Objects.equals(fCode, that.fCode) &&
                Objects.equals(fIsUnits, that.fIsUnits) &&
                Objects.equals(fUnitId, that.fUnitId) &&
                Objects.equals(fSearchKey, that.fSearchKey) &&
                Objects.equals(fStatus, that.fStatus) &&
                Objects.equals(fDesp, that.fDesp) &&
                Objects.equals(fCreateTime, that.fCreateTime) &&
                Objects.equals(fUpdateTime, that.fUpdateTime) &&
                Objects.equals(fOperate, that.fOperate) &&
                Objects.equals(fSearchCondition, that.fSearchCondition) &&
                Objects.equals(fPicList, that.fPicList);
    }

    @Override
    public String toString() {
        return "111";
    }

    @Override
    public int hashCode() {

        return Objects.hash(fId, fName, fCode, fCategoryIdOne, fCategoryIdTwo, fSort, fIsUnits, fUnitId, fSearchKey, fStatus, fDesp, fCreateTime, fUpdateTime, fOperate, fCompanyId, fSearchCondition, fPicList);
    }
}
