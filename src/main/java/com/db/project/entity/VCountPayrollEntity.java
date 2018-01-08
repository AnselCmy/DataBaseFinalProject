package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "v_CountPayroll", schema = "PayrollManagement", catalog = "")
public class VCountPayrollEntity {
    private String dNo;
    private String dName;
    private Double payroll;
    private Double max;
    private Double min;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VCountPayrollEntity that = (VCountPayrollEntity) o;

        if (dNo != null ? !dNo.equals(that.dNo) : that.dNo != null) return false;
        if (dName != null ? !dName.equals(that.dName) : that.dName != null) return false;
        if (payroll != null ? !payroll.equals(that.payroll) : that.payroll != null) return false;
        if (max != null ? !max.equals(that.max) : that.max != null) return false;
        if (min != null ? !min.equals(that.min) : that.min != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dNo != null ? dNo.hashCode() : 0;
        result = 31 * result + (dName != null ? dName.hashCode() : 0);
        result = 31 * result + (payroll != null ? payroll.hashCode() : 0);
        result = 31 * result + (max != null ? max.hashCode() : 0);
        result = 31 * result + (min != null ? min.hashCode() : 0);
        return result;
    }
}
