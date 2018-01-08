package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "v_AttendLog2", schema = "PayrollManagement", catalog = "")
public class VAttendLog2Entity {
    private String eNo;
    private Date alDate;
    private String aeNo;
    private String aeName;
    private double aeMoney;
    
    @Basic
    @Column(name = "ENo")
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Id
    @Basic
    @Column(name = "ALDate")
    public Date getAlDate() {
        return alDate;
    }

    public void setAlDate(Date alDate) {
        this.alDate = alDate;
    }

    @Basic
    @Column(name = "AENo")
    public String getAeNo() {
        return aeNo;
    }

    public void setAeNo(String aeNo) {
        this.aeNo = aeNo;
    }

    @Basic
    @Column(name = "AEName")
    public String getAeName() {
        return aeName;
    }

    public void setAeName(String aeName) {
        this.aeName = aeName;
    }

    @Basic
    @Column(name = "AEMoney")
    public double getAeMoney() {
        return aeMoney;
    }

    public void setAeMoney(double aeMoney) {
        this.aeMoney = aeMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VAttendLog2Entity that = (VAttendLog2Entity) o;

        if (Double.compare(that.aeMoney, aeMoney) != 0) return false;
        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (alDate != null ? !alDate.equals(that.alDate) : that.alDate != null) return false;
        if (aeNo != null ? !aeNo.equals(that.aeNo) : that.aeNo != null) return false;
        if (aeName != null ? !aeName.equals(that.aeName) : that.aeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (alDate != null ? alDate.hashCode() : 0);
        result = 31 * result + (aeNo != null ? aeNo.hashCode() : 0);
        result = 31 * result + (aeName != null ? aeName.hashCode() : 0);
        temp = Double.doubleToLongBits(aeMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
