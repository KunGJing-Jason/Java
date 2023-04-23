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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.lang.*;

@WebServlet(name = "ListEmpServlet", value = "/ListEmp")
public class ListEmpServlet extends HttpServlet {
    EmpService empService = new EmpService();
    DeptService deptService = new DeptService();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> emps = empService.getAll();
        request.setAttribute("emps",emps);//request.getAttribute("depts")

        List<Dept> depts = deptService.getAll();
        request.setAttribute("depts",depts);

        request.getRequestDispatcher("/Emp.jsp").forward(request,response);// el + jstl
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptId = request.getParameter("deptId");
        int deptid = -1;
        try{
            deptid = Integer.parseInt(deptId);
        }catch (Exception e){

        }

        String ename = request.getParameter("ename");
        String sebirth1 = request.getParameter("ebirth1");
        String sebirth2 = request.getParameter("ebirth2");
        Date ebirth1 = null;
        Date ebirth2 = null;

        try{
            if(sebirth1 != null){
                sebirth1.replace('/','-');
            }
            ebirth1 = dateFormat.parse(sebirth1);
        }catch(Exception e){

        }

        try{
            if(sebirth2 != null){
                sebirth2.replace('/','-');
            }
            ebirth2 = dateFormat.parse(sebirth2);
        }catch(Exception e){

        }

        String sPageNum = request.getParameter("pageNum");
        PagingInfo pagingInfo = new PagingInfo();
        try {
            pagingInfo.setCurrentPageNum(Long.parseLong(sPageNum));
        }catch (Exception e){
            pagingInfo.setCurrentPageNum(1);
        }


        Condition condition = new Condition();
        condition.setDeptId(deptid);
        condition.setEname(ename);
        condition.setBirth1(ebirth1);
        condition.setBirth2(ebirth2);
        List<Map<String,Object>> emps = null;

        try {
            emps = empService.search(condition,pagingInfo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("pagingInfo",pagingInfo); //el 改造${pagingInfo.totalPageCount}
        request.setAttribute("emps",emps);

        List<Dept> depts = deptService.getAll();
        request.setAttribute("depts",depts);

        request.getRequestDispatcher("/Emp.jsp").forward(request,response);
    }
}
