package com.example.emp.servlet;

import com.example.emp.service.DeptService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DelDeptServlet", value = "/DelDept")
public class DelDeptServlet extends HttpServlet {
    DeptService deptService = new DeptService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = -1;
        try {
            id = Integer.parseInt(sid);
        }
        catch (Exception e){

        }
        if(id == -1){
            request.setAttribute("msg","部门ID输入有误");
            request.getRequestDispatcher("/ListDept").forward(request,response);
        }

        boolean isOK = deptService.del(id);

        if(isOK){
            request.getRequestDispatcher("/ListDept").forward(request,response);
        }else{
            request.setAttribute("msg","删除失败");
            request.getRequestDispatcher("/ListDept").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
