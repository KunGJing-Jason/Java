package com.example.emp.entity;

import java.util.Date;

public class Condition {
    Integer deptId;
    String ename;
    Date birth1;
    Date birth2;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getBirth1() {
        return birth1;
    }

    public void setBirth1(Date birth1) {
        this.birth1 = birth1;
    }

    public Date getBirth2() {
        return birth2;
    }

    public void setBirth2(Date birth2) {
        this.birth2 = birth2;
    }
}
