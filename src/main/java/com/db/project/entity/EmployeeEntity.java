package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Employee", schema = "PayrollManagement", catalog = "")
public class EmployeeEntity {
    private String eNo;
    private String eId;
    private String eName;
    private int eAge;
    private String eSex;
    private Date eEntryDate;
    private String dNo;
    private String posNo;

    @Id
    @Column(name = "ENo")
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Basic
    @Column(name = "EId")
    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "EName")
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "EAge")
    public int geteAge() {
        return eAge;
    }

    public void seteAge(int eAge) {
        this.eAge = eAge;
    }

    @Basic
    @Column(name = "ESex")
    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    @Basic
    @Column(name = "EEntryDate")
    public Date geteEntryDate() {
        return eEntryDate;
    }

    public void seteEntryDate(Date eEntryDate) {
        this.eEntryDate = eEntryDate;
    }

    @Basic
    @Column(name = "DNo")
    public String getdNo() {
        return dNo;
    }

    public void setdNo(String dNo) {
        this.dNo = dNo;
    }

    @Basic
    @Column(name = "PosNo")
    public String getPosNo() {
        return posNo;
    }

    public void setPosNo(String posNo) {
        this.posNo = posNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (eAge != that.eAge) return false;
        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (eName != null ? !eName.equals(that.eName) : that.eName != null) return false;
        if (eSex != null ? !eSex.equals(that.eSex) : that.eSex != null) return false;
        if (eEntryDate != null ? !eEntryDate.equals(that.eEntryDate) : that.eEntryDate != null) return false;
        if (dNo != null ? !dNo.equals(that.dNo) : that.dNo != null) return false;
        if (posNo != null ? !posNo.equals(that.posNo) : that.posNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (eName != null ? eName.hashCode() : 0);
        result = 31 * result + eAge;
        result = 31 * result + (eSex != null ? eSex.hashCode() : 0);
        result = 31 * result + (eEntryDate != null ? eEntryDate.hashCode() : 0);
        result = 31 * result + (dNo != null ? dNo.hashCode() : 0);
        result = 31 * result + (posNo != null ? posNo.hashCode() : 0);
        return result;
    }
}
