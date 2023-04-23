package com.example.emp.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class DBCPUtil {
    static ComboPooledDataSource ds = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return ds;
    }
}
