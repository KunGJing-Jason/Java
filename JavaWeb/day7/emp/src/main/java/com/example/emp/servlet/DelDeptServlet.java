package com.example.emp.servlet;

import com.example.emp.entity.Dept;
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
        // /DelDept?id=8         请求方法: GET
//        String sId = request.getParameter("id");
//        int id = -1;
//        try {
//            id = Integer.parseInt(sId);
//        }catch (Exception ex){
//        }
//        if(id==-1){
//            request.setAttribute("msg","删除部门输入有错");
//            request.getRequestDispatcher("/DeptList").forward(request,response);
//        }
        String sId = request.getParameter("id");
        int id  = Integer.parseInt(sId);
        boolean ok=deptService.del(id);
//        if(ok){
//            request.getRequestDispatcher("/DeptList").forward(request,response);
//        }else{
//            request.setAttribute("msg","删除失败");
//            request.getRequestDispatcher("/DeptList").forward(request,response);
//        }
        if(!ok){
            request.setAttribute("msg","删除失败");
        }
        request.getRequestDispatcher("/DeptList").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
