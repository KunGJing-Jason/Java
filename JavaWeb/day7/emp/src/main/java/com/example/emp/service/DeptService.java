package com.example.emp.service;

import com.example.emp.dao.DeptDao;
import com.example.emp.entity.Dept;

import java.sql.SQLException;
import java.util.List;

public class DeptService {
    DeptDao deptDao = new DeptDao();
    public List<Dept> getAll() {
       //return new DeptDao().getAll();
        return deptDao.getAll();
    }

    public boolean add(String dname, String dlocation) {
        //return new DeptDao().add(dname,dlocation);
        return deptDao.add(dname,dlocation);
    }

    public boolean del(int id) {
        return deptDao.del(id);
    }

    public Dept get(int id) throws SQLException {
        return deptDao.get(id);
    }

    public boolean edit(Dept dept) throws SQLException {
        return deptDao.edit(dept);
    }
}
