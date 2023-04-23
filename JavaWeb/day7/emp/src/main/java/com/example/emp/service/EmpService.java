package com.example.emp.service;

import com.example.emp.dao.EmpDao;
import com.example.emp.entity.Condition;
import com.example.emp.entity.Emp;
import com.example.emp.entity.PagingInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmpService {
    EmpDao empDao = new EmpDao();
    public List<Map<String, Object>> getAll() {
        return empDao.getAll();
    }

    public List<Map<String, Object>> search(Condition condition, PagingInfo pagingInfo) throws SQLException {
        return empDao.search(condition,pagingInfo);
    }

    public boolean add(Emp emp) throws SQLException {
        return empDao.add(emp);
    }

    public Emp get(int id) {
        return  empDao.get();
    }
}
