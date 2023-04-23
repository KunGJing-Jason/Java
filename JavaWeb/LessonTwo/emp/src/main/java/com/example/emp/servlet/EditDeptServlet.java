package com.example.emp.servlet;

import com.example.emp.entity.Dept;
import com.example.emp.service.DeptService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditDeptServlet", value = "/EditDept")
public class EditDeptServlet extends HttpServlet {
    DeptService deptService = new DeptService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sId = request.getParameter("id");
        int id = Integer.parseInt(sId);

        Dept dept = null;

        try {
            dept = deptService.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(dept == null){
            request.setAttribute("msg","部门不存在");
            request.getRequestDispatcher("/DeptList").forward(request,response);
        }else{
            request.setAttribute("dept",dept);
            request.getRequestDispatcher("/EditDept.jsp").forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sId = request.getParameter("id");
        String name = request.getParameter("dname");
        String loc = request.getParameter("dlocation");
        int id = Integer.parseInt(sId);

        Dept dept = new Dept();
        dept.setId(id);
        dept.setName(name);
        dept.setLoc(loc);

        boolean ok = false;
        try {
            ok = deptService.edit(dept);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(ok){
            request.setAttribute("msg","编辑成功");
            request.getRequestDispatcher("/DeptList").forward(request,response);
        }else{
            request.setAttribute("msg","编辑失败");
            request.setAttribute("dept",dept);
            request.getRequestDispatcher("/EditDept.jsp").forward(request,response);
        }



    }
}
