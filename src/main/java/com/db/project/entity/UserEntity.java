package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "User", schema = "PayrollManagement", catalog = "")
public class UserEntity {
    private String eNo;
    private String uPassword;
    private String uLevel;

    @Id
    @Column(name = "ENo")
    public String geteNo() {
        return eNo;
    }

    public void seteNo(String eNo) {
        this.eNo = eNo;
    }

    @Basic
    @Column(name = "UPassword")
    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Basic
    @Column(name = "ULevel")
    public String getuLevel() {
        return uLevel;
    }

    public void setuLevel(String uLevel) {
        this.uLevel = uLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (eNo != null ? !eNo.equals(that.eNo) : that.eNo != null) return false;
        if (uPassword != null ? !uPassword.equals(that.uPassword) : that.uPassword != null) return false;
        if (uLevel != null ? !uLevel.equals(that.uLevel) : that.uLevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eNo != null ? eNo.hashCode() : 0;
        result = 31 * result + (uPassword != null ? uPassword.hashCode() : 0);
        result = 31 * result + (uLevel != null ? uLevel.hashCode() : 0);
        return result;
    }
}
