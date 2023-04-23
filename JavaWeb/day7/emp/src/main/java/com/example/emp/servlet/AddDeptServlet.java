package com.example.emp.servlet;

import com.example.emp.service.DeptService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddDeptServlet", value = "/AddDept")
public class AddDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dname = request.getParameter("dname");
        String dlocation = request.getParameter("dlocation");
        boolean ok=new DeptService().add(dname,dlocation);
        if(ok){
            request.getRequestDispatcher("/DeptList").forward(request,response);
        }else{
            request.setAttribute("msg","添加部门信息出错"); //jsp:  ${msg}
            request.getRequestDispatcher("/AddDept.jsp").forward(request,response);
        }

    }
}
