package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "AttendEvent", schema = "PayrollManagement", catalog = "")
public class AttendEventEntity {
    private String aeNo;
    private String aeName;
    private double aeMoney;

    @Id
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

        AttendEventEntity that = (AttendEventEntity) o;

        if (Double.compare(that.aeMoney, aeMoney) != 0) return false;
        if (aeNo != null ? !aeNo.equals(that.aeNo) : that.aeNo != null) return false;
        if (aeName != null ? !aeName.equals(that.aeName) : that.aeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = aeNo != null ? aeNo.hashCode() : 0;
        result = 31 * result + (aeName != null ? aeName.hashCode() : 0);
        temp = Double.doubleToLongBits(aeMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
