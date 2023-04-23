package com.example.emp.service;

import com.example.emp.dao.EmpDao;
import com.example.emp.entity.Condition;
import com.example.emp.entity.Emp;
import com.example.emp.entity.PagingInfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EmpService {
    EmpDao empDao = new EmpDao();

    public List<Map<String, Object>> getAll(){

        return empDao.getAll();
    }

    public List<Map<String, Object>> search(Condition condition, PagingInfo pagingInfo) throws SQLException {
        return empDao.search(condition,pagingInfo);
    }

    public boolean add(Emp emp) {
        return empDao.add(emp);
    }
}
