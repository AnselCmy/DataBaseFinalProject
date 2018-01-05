package com.db.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "PositionLevel", schema = "PayrollManagement", catalog = "")
public class PositionLevelEntity {
    private String posNo;
    private String posName;
    private double posPayroll;

    @Id
    @Column(name = "PosNo")
    public String getPosNo() {
        return posNo;
    }

    public void setPosNo(String posNo) {
        this.posNo = posNo;
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
    @Column(name = "PosPayroll")
    public double getPosPayroll() {
        return posPayroll;
    }

    public void setPosPayroll(double posPayroll) {
        this.posPayroll = posPayroll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionLevelEntity that = (PositionLevelEntity) o;

        if (Double.compare(that.posPayroll, posPayroll) != 0) return false;
        if (posNo != null ? !posNo.equals(that.posNo) : that.posNo != null) return false;
        if (posName != null ? !posName.equals(that.posName) : that.posName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = posNo != null ? posNo.hashCode() : 0;
        result = 31 * result + (posName != null ? posName.hashCode() : 0);
        temp = Double.doubleToLongBits(posPayroll);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
