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
        //EditDept?id=${dept.id}
        String sId = request.getParameter("id");
        int id  = Integer.parseInt(sId);

        Dept dept = null;
        try {
            dept = deptService.get(id);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }

        if(dept==null){
            request.setAttribute("msg","部门不存在");
            request.getRequestDispatcher("/DeptList").forward(request,response); //el ${msg}
            //request.getRequestDispatcher("/EditDept.jsp").forward(request,response); //el ${msg}
        }else{
            request.setAttribute("dept",dept);
            request.getRequestDispatcher("/EditDept.jsp").forward(request,response); //el ${dept.name} ....
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        dname: 生产
//        dlocation: 110
//        id: 4
        String dname = request.getParameter("dname");
        String dlocation = request.getParameter("dlocation");
        String sId = request.getParameter("id");
        int id  = Integer.parseInt(sId);
        Dept dept =new Dept();
        dept.setId(id);
        dept.setName(dname);
        dept.setLoc(dlocation);

        boolean ok = false;
        try {
            ok = deptService.edit(dept);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }

        if(ok){
            request.setAttribute("msg", "编辑成功");
            request.getRequestDispatcher("/DeptList").forward(request,response);
        }else{
            request.setAttribute("msg", "编辑失败");
            request.setAttribute("dept", dept);
            request.getRequestDispatcher("/EditDept.jsp").forward(request,response);
        }


    }
}
