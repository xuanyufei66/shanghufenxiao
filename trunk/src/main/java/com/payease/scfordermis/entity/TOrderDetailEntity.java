package com.payease.scfordermis.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @Author : zhangwen
 * @Data : 2018/1/10
 * @Description :
 */
@Entity
@Table(name = "t_order_detail")
public class TOrderDetailEntity {
    private long id;
    private long fOrderId;
    private long fTranOrderDetailId;
    private Date fCreatetime;
    private int fProductNum;
    private BigDecimal tProductPrice;
    private long fCompanyId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "f_order_id", nullable = false)
    public long getfOrderId() {
        return fOrderId;
    }

    public void setfOrderId(long fOrderId) {
        this.fOrderId = fOrderId;
    }

    @Basic
    @Column(name = "f_tran_order_detail_id", nullable = false)
    public long getfTranOrderDetailId() {
        return fTranOrderDetailId;
    }

    public void setfTranOrderDetailId(long fTranOrderDetailId) {
        this.fTranOrderDetailId = fTranOrderDetailId;
    }

    @Basic
    @Column(name = "f_createtime", nullable = false)
    public Date getfCreatetime() {
        return fCreatetime;
    }

    public void setfCreatetime(Date fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    @Basic
    @Column(name = "f_product_num", nullable = false)
    public int getfProductNum() {
        return fProductNum;
    }

    public void setfProductNum(int fProductNum) {
        this.fProductNum = fProductNum;
    }

    @Basic
    @Column(name = "t_product_price", nullable = false, precision = 2)
    public BigDecimal gettProductPrice() {
        return tProductPrice;
    }

    public void settProductPrice(BigDecimal tProductPrice) {
        this.tProductPrice = tProductPrice;
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
        TOrderDetailEntity that = (TOrderDetailEntity) o;
        return id == that.id &&
                fOrderId == that.fOrderId &&
                fTranOrderDetailId == that.fTranOrderDetailId &&
                fProductNum == that.fProductNum &&
                fCompanyId == that.fCompanyId &&
                Objects.equals(fCreatetime, that.fCreatetime) &&
                Objects.equals(tProductPrice, that.tProductPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fOrderId, fTranOrderDetailId, fCreatetime, fProductNum, tProductPrice, fCompanyId);
    }
}
