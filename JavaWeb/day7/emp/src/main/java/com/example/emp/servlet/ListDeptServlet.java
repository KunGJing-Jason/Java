package com.example.emp.servlet;

import com.example.emp.entity.Dept;
import com.example.emp.service.DeptService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeptListServlet", value = "/DeptList")
public class ListDeptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> depts = new DeptService().getAll();
        request.setAttribute("depts",depts);//request.getAttribute("depts") //${depts}
        request.getRequestDispatcher("/Dept.jsp").forward(request,response);//el+jstl
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
