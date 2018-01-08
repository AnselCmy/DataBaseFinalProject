package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "v_CountPayrollByMonth", schema = "PayrollManagement", catalog = "")
@IdClass(VCountPayrollByMonthEntityPK.class)
public class VCountPayrollByMonthEntity {
    private String dNo;
    private String dName;
    private Double payroll;
    private Double max;
    private Double min;
    private Date date;

    @Id
    @Basic
    @Column(name = "DNo")
    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    @Basic
    @Column(name = "DName")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "Payroll")
    public Double getPayroll() {
        return payroll;
    }

    public void setPayroll(Double payroll) {
        this.payroll = payroll;
    }

    @Basic
    @Column(name = "Max")
    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Basic
    @Column(name = "Min")
    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    @Id
    @Basic
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VCountPayrollByMonthEntity that = (VCountPayrollByMonthEntity) o;

        if (dNo != null ? !dNo.equals(that.dNo) : that.dNo != null) return false;
        if (dName != null ? !dName.equals(that.dName) : that.dName != null) return false;
        if (payroll != null ? !payroll.equals(that.payroll) : that.payroll != null) return false;
        if (max != null ? !max.equals(that.max) : that.max != null) return false;
        if (min != null ? !min.equals(that.min) : that.min != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dNo != null ? dNo.hashCode() : 0;
        result = 31 * result + (dName != null ? dName.hashCode() : 0);
        result = 31 * result + (payroll != null ? payroll.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
