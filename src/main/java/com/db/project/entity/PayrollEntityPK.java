package com.db.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class PayrollEntityPK implements Serializable {
    private String eNo;
    private Date pDate;

    @Column(name = "ENo")
    @Id
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Column(name = "PDate")
    @Id
    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayrollEntityPK that = (PayrollEntityPK) o;

        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (pDate != null ? !pDate.equals(that.pDate) : that.pDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (pDate != null ? pDate.hashCode() : 0);
        return result;
    }
}
