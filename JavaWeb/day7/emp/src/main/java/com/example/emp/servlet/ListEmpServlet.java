package com.example.emp.servlet;

import com.example.emp.entity.Dept;
import com.example.emp.entity.Condition;
import com.example.emp.entity.PagingInfo;
import com.example.emp.service.DeptService;
import com.example.emp.service.EmpService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListEmpServlet", value = "/EmpList")
public class ListEmpServlet extends HttpServlet {
    EmpService empServie = new EmpService();
    DeptService deptService = new DeptService();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //获取员工列表
//        List<Map<String, Object>> emps = empServie.getAll();
//        request.setAttribute("emps",emps);
//        //获取部门列表
//        List<Dept> depts = deptService.getAll();
//        request.setAttribute("depts",depts);
//
//        request.getRequestDispatcher("/Emp.jsp").forward(request,response);//el+jstl todo
        doPost( request,  response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        deptId: 3
//        ename: 云图
//        ebirth1: 2023-03-01
//        ebirth2: 2023-03-24
//        pageNum: 1
        String sDeptId = request.getParameter("deptId");
        int deptId=0;
        try { deptId = Integer.parseInt(sDeptId); }catch (Exception e){ }

        String ename = request.getParameter("ename");  //空字符串

        String sBirth1 = request.getParameter("ebirth1");
        Date birth1=null;
        try {
            if(sBirth1!=null){
                sBirth1.replace('/','-');
            }
            birth1 = dateFormat.parse(sBirth1);
        } catch (Exception e) { }

        String sBirth2 = request.getParameter("ebirth2");
        Date birth2=null;
        try {
            if(sBirth2!=null){
                sBirth2.replace('/','-');
            }
            birth2 = dateFormat.parse(sBirth2);
        } catch (Exception e) {  }

        String sPageNum = request.getParameter("pageNum");
        PagingInfo pagingInfo = new PagingInfo();
        try {
            pagingInfo.setCurrentPageNum(Long.parseLong(sPageNum));
        }catch (Exception e){
            pagingInfo.setCurrentPageNum(1);
        }

        Condition condition = new Condition();
        condition.setDeptId(deptId);
        condition.setEname(ename);
        condition.setBirth1(birth1);
        condition.setBirth2(birth2);

        List<Map<String, Object>> emps = null;//empServie.search(deptId,ename,birth1,birth2);
        try {
            //emps = empServie.search(condition);
            emps = empServie.search(condition,pagingInfo);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }
        request.setAttribute("emps",emps);
        request.setAttribute("pagingInfo",pagingInfo); //el 改造${pagingInfo.totalPageCount}
        //获取部门列表
        List<Dept> depts = deptService.getAll();
        request.setAttribute("depts",depts);

        request.getRequestDispatcher("/Emp.jsp").forward(request,response);
    }
}
