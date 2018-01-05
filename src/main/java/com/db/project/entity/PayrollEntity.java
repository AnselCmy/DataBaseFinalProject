package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Payroll", schema = "PayrollManagement", catalog = "")
@IdClass(PayrollEntityPK.class)
public class PayrollEntity {
    private String eNo;
    private Date pDate;
    private double pPayroll;

    @Id
    @Column(name = "ENo")
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Id
    @Column(name = "PDate")
    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    @Basic
    @Column(name = "PPayroll")
    public double getpPayroll() {
        return pPayroll;
    }

    public void setpPayroll(double pPayroll) {
        this.pPayroll = pPayroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayrollEntity that = (PayrollEntity) o;

        if (Double.compare(that.pPayroll, pPayroll) != 0) return false;
        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (pDate != null ? !pDate.equals(that.pDate) : that.pDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (pDate != null ? pDate.hashCode() : 0);
        temp = Double.doubleToLongBits(pPayroll);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
