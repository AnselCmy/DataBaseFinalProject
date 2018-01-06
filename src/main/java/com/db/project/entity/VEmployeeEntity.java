package com.db.project.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "v_Employee", schema = "PayrollManagement", catalog = "")
public class VEmployeeEntity {
    private String eNo;
    private String eId;
    private String eName;
    private String eSex;
    private Date eEntryDate;
    private String dName;
    private String posName;
    private String eTel;
    private Double eAge;

    @Id
    @Basic
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
    @Column(name = "DName")
    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Basic
    @Column(name = "PosName")
    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    @Basic
    @Column(name = "ETel")
    public String geteTel() {
        return eTel;
    }

    public void seteTel(String eTel) {
        this.eTel = eTel;
    }

    @Basic
    @Column(name = "EAge")
    public Double geteAge() {
        return eAge;
    }

    public void seteAge(Double eAge) {
        this.eAge = eAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VEmployeeEntity that = (VEmployeeEntity) o;

        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (eName != null ? !eName.equals(that.eName) : that.eName != null) return false;
        if (eSex != null ? !eSex.equals(that.eSex) : that.eSex != null) return false;
        if (eEntryDate != null ? !eEntryDate.equals(that.eEntryDate) : that.eEntryDate != null) return false;
        if (dName != null ? !dName.equals(that.dName) : that.dName != null) return false;
        if (posName != null ? !posName.equals(that.posName) : that.posName != null) return false;
        if (eTel != null ? !eTel.equals(that.eTel) : that.eTel != null) return false;
        if (eAge != null ? !eAge.equals(that.eAge) : that.eAge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (eName != null ? eName.hashCode() : 0);
        result = 31 * result + (eSex != null ? eSex.hashCode() : 0);
        result = 31 * result + (eEntryDate != null ? eEntryDate.hashCode() : 0);
        result = 31 * result + (dName != null ? dName.hashCode() : 0);
        result = 31 * result + (posName != null ? posName.hashCode() : 0);
        result = 31 * result + (eTel != null ? eTel.hashCode() : 0);
        result = 31 * result + (eAge != null ? eAge.hashCode() : 0);
        return result;
    }
}
