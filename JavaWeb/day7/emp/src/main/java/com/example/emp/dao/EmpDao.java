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
import java.util.List;
import java.util.Map;

public class EmpDao {
    DataSource dataSource = DBCPUtil.getDataSource();

    public List<Map<String, Object>> getAll() {
        QueryRunner runner= new QueryRunner(dataSource);
        List<Map<String, Object>> emps = null;
        try {
            emps = runner.query(
                    "select emps.id,emps.name,img_url,sex,birth,depts.name dname " +
                            "from emps left join depts " +
                            "on emps.dept_id = depts.id",
                    new MapListHandler());
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }
        return emps;
    }

    public List<Map<String, Object>> search(Condition condition, PagingInfo pagingInfo) throws SQLException {
        //拼接查询条件，即Where子句
        String whereClause="where 1=1 ";
        List<Object> paramValues=new ArrayList<>();
        if(condition.getDeptId()!=0){
            whereClause += "and dept_id=? ";
            paramValues.add(condition.getDeptId());
        }
        if(condition.getEname()!=null && !"".equals(condition.getEname())){
            whereClause += "and emps.name like ? ";
            paramValues.add("%"+condition.getEname()+"%");
        }
        if(    condition.getBirth1()!=null && !"".equals(condition.getBirth1())
            && condition.getBirth2()!=null && !"".equals(condition.getBirth2())
        ){
            whereClause += "and birth between ? and ? ";
            paramValues.add(condition.getBirth1());
            paramValues.add(condition.getBirth2());
        }

        QueryRunner runner= new QueryRunner(dataSource);
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
                        whereClause
                        + " order by emps.id desc "
                        + " limit "+pagingInfo.getStartRow()+","+pagingInfo.getRowPerPage(),
                        paramValues.toArray(),
                new MapListHandler());
        return emps;
    }

    public boolean add(Emp emp) throws SQLException {
        QueryRunner runner= new QueryRunner(dataSource);
        int row = runner.update("INSERT INTO emps(name,img_url,sex,birth,dept_id) VALUES (?,?,?,?,?)",
                emp.getName(),emp.getImgUrl(),emp.getSex(),emp.getBirth(),emp.getDeptId());
        return  row>0;
    }

    public Emp get() {
1
    }
}
