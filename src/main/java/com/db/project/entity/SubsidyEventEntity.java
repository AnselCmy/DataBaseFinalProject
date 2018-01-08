package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "SubsidyEvent", schema = "PayrollManagement", catalog = "")
public class SubsidyEventEntity {
    private String seNo;
    private String seName;

    @Id
    @Column(name = "SENo")
    public String getSeNo() {
        return seNo;
    }

    public void setSeNo(String seNo) {
        this.seNo = seNo;
    }

    @Basic
    @Column(name = "SEName")
    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubsidyEventEntity that = (SubsidyEventEntity) o;

        if (seNo != null ? !seNo.equals(that.seNo) : that.seNo != null) return false;
        if (seName != null ? !seName.equals(that.seName) : that.seName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = seNo != null ? seNo.hashCode() : 0;
        result = 31 * result + (seName != null ? seName.hashCode() : 0);
        return result;
    }
}
