package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "Department", schema = "PayrollManagement", catalog = "")
public class DepartmentEntity {
    private String dNo;
    private String dName;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (dNo != null ? !dNo.equals(that.dNo) : that.dNo != null) return false;
        if (dName != null ? !dName.equals(that.dName) : that.dName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dNo != null ? dNo.hashCode() : 0;
        result = 31 * result + (dName != null ? dName.hashCode() : 0);
        return result;
    }
}
