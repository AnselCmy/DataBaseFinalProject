package com.db.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

public class SubsidyLogEntityPK implements Serializable {
    private String eNo;
    private Date slDate;
    private String seNo;

    @Column(name = "ENo")
    @Id
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Column(name = "SLDate")
    @Id
    public Date getSlDate() {
        return slDate;
    }

    public void setSlDate(Date slDate) {
        this.slDate = slDate;
    }

    @Column(name = "SENo")
    @Id
    public String getSeNo() {
        return seNo;
    }

    public void setSeNo(String seNo) {
        this.seNo = seNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubsidyLogEntityPK that = (SubsidyLogEntityPK) o;

        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (slDate != null ? !slDate.equals(that.slDate) : that.slDate != null) return false;
        if (seNo != null ? !seNo.equals(that.seNo) : that.seNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (slDate != null ? slDate.hashCode() : 0);
        result = 31 * result + (seNo != null ? seNo.hashCode() : 0);
        return result;
    }
}
