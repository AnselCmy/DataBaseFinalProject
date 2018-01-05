package com.db.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class AttendLogEntityPK implements Serializable {
    private String eNo;
    private Date alDate;
    private String aeNo;

    @Column(name = "ENo")
    @Id
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Column(name = "ALDate")
    @Id
    public Date getAlDate() {
        return alDate;
    }

    public void setAlDate(Date alDate) {
        this.alDate = alDate;
    }

    @Column(name = "AENo")
    @Id
    public String getAeNo() {
        return aeNo;
    }

    public void setAeNo(String aeNo) {
        this.aeNo = aeNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendLogEntityPK that = (AttendLogEntityPK) o;

        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (alDate != null ? !alDate.equals(that.alDate) : that.alDate != null) return false;
        if (aeNo != null ? !aeNo.equals(that.aeNo) : that.aeNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (alDate != null ? alDate.hashCode() : 0);
        result = 31 * result + (aeNo != null ? aeNo.hashCode() : 0);
        return result;
    }
}
