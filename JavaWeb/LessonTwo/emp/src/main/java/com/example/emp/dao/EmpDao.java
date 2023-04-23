package com.example.emp.dao;

import com.example.emp.entity.Condition;
import com.example.emp.entity.Emp;
import com.example.emp.entity.PagingInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EmpDao {
    DataSource dataSource = DBCPUtil.getDataSource();
    public List<Map<String, Object>> getAll() {
        //JDBC query select
        QueryRunner runner = new QueryRunner(dataSource);
        List<Map<String, Object>> emps = null;
        try {
            emps = runner.query("SELECT emps.id as id, emps.name, img_url, gender,birth, depts.name dname " +
                    "FROM emps LEFT JOIN depts ON emps.dept_id = depts.id;",new MapListHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return emps;
    }

    public List<Map<String, Object>> search(Condition condition, PagingInfo pagingInfo) throws SQLException {
        String whereClause  = "WHERE 1=1 ";
        List<Object> paramValues = new ArrayList<>();
        if(condition.getDeptId() != 0){
            whereClause += "AND dept_id=? ";
            paramValues.add(condition.getDeptId());
        }

        if(condition.getEname() != null && !"".equals(condition.getEname())){
            whereClause += "AND emps.name=? ";
            paramValues.add(condition.getEname());
        }

        if(condition.getBirth1() != null && !"".equals(condition.getBirth1())
            && condition.getBirth2() != null && "".equals(condition.getBirth2())){
            whereClause += "AND emps.birth WHERE ? and ? ";
            paramValues.add(condition.getBirth1());
            paramValues.add(condition.getBirth2());
        }

        QueryRunner runner = new QueryRunner(dataSource);
        //总共多少行
        Long totalRowSize = runner.query(
                "select count(emps.id) " +
                        "from emps left join depts " +
                        "on emps.dept_id = depts.id " +
                        whereClause, paramValues.toArray(),
                new ScalarHandler<Long>());
//        pagingInfo.setTotalRowSize(totalRowSize);
//        pagingInfo.resetProperites();
        pagingInfo.setProperitesByTotalRowSize(totalRowSize);

        //指定行数据
        List<Map<String, Object>> emps = runner.query(
                "select emps.id,emps.name,img_url,sex,birth,depts.name dname " +
                        "from emps left join depts " +
                        "on emps.dept_id = depts.id " +
                        whereClause + " limit "+pagingInfo.getStartRow()+","+pagingInfo.getRowPerPage(),
                paramValues.toArray(),
                new MapListHandler());return emps;
    }

    public boolean add(Emp emp) {
        QueryRunner runner = new QueryRunner(dataSource);
        int rowEffective = 0;
        try{
            rowEffective = runner.update("INSERT INTO emps(name,img_Url,sex,birth)VALUES (?,?,?,?)",
                    emp.getName(),emp.getImgUrl(),emp.getSex(),emp.getBirth());
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return rowEffective > 0;
    }
}
