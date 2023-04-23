package com.example.emp.dao;

import com.example.emp.entity.Dept;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class DeptDao {
    DataSource dataSource = DBCPUtil.getDataSource();
    public List<Dept> getAll() {
        //jdbc query select
        //DataSource dataSource = DBCPUtil.getDataSource();
//        try {
//            System.out.println(dataSource.getConnection());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        QueryRunner runner= new QueryRunner(dataSource);
        List<Dept> depts = null;
        try {
            depts = runner.query("SELECT id,name,loc FROM depts",
                    new BeanListHandler<>(Dept.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return depts;
    }

    public boolean add(String dname, String dlocation) {
        QueryRunner runner= new QueryRunner(dataSource);
        int row = 0;
        try {
            row = runner.update("insert into depts(name,loc) values(?,?)",dname,dlocation);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
        return  row>0;
    }

    public boolean del(int id) {
        QueryRunner runner= new QueryRunner(dataSource);
        int row = 0;
        try {
            row = runner.update("delete from depts where id=?",id);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
        return  row>0;
    }

    public Dept get(int id) throws SQLException {
        QueryRunner runner= new QueryRunner(dataSource);
        return runner.query("SELECT id,name,loc FROM depts where id=?",id,
                new BeanHandler<>(Dept.class));
    }

    public boolean edit(Dept dept) throws SQLException {
        QueryRunner runner= new QueryRunner(dataSource);
        int row  = runner.update("update depts set name=?,loc=? where id=?",
                dept.getName(),dept.getLoc(),dept.getId());
        return  row>0;
    }
}
