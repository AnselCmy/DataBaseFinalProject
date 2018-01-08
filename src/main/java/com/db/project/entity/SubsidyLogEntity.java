package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SubsidyLog", schema = "PayrollManagement", catalog = "")
@IdClass(SubsidyLogEntityPK.class)
public class SubsidyLogEntity {
    private String eNo;
    private Date slDate;
    private double slMoney;
    private String seNo;
    private String slComment;

    @Id
    @Column(name = "ENo")
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Id
    @Column(name = "SLDate")
    public Date getSlDate() {
        return slDate;
    }

    public void setSlDate(Date slDate) {
        this.slDate = slDate;
    }

    @Basic
    @Column(name = "SLMoney")
    public double getSlMoney() {
        return slMoney;
    }

    public void setSlMoney(double slMoney) {
        this.slMoney = slMoney;
    }

    @Id
    @Column(name = "SENo")
    public String getSeNo() {
        return seNo;
    }

    public void setSeNo(String seNo) {
        this.seNo = seNo;
    }

    @Basic
    @Column(name = "SLComment")
    public String getSlComment() {
        return slComment;
    }

    public void setSlComment(String slComment) {
        this.slComment = slComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubsidyLogEntity that = (SubsidyLogEntity) o;

        if (Double.compare(that.slMoney, slMoney) != 0) return false;
        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (slDate != null ? !slDate.equals(that.slDate) : that.slDate != null) return false;
        if (seNo != null ? !seNo.equals(that.seNo) : that.seNo != null) return false;
        if (slComment != null ? !slComment.equals(that.slComment) : that.slComment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (slDate != null ? slDate.hashCode() : 0);
        temp = Double.doubleToLongBits(slMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (seNo != null ? seNo.hashCode() : 0);
        result = 31 * result + (slComment != null ? slComment.hashCode() : 0);
        return result;
    }
}
