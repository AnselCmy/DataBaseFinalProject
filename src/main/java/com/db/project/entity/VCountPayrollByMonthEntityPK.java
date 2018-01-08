package com.db.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class VCountPayrollByMonthEntityPK implements Serializable {
    private String dNo;
    private Date date;

    @Column(name = "DNo")
    @Id
    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    @Column(name = "Date")
    @Id
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

        VCountPayrollByMonthEntityPK that = (VCountPayrollByMonthEntityPK) o;

        if (dNo != null ? !dNo.equals(that.dNo) : that.dNo != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dNo != null ? dNo.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
