package com.example.emp.servlet;

import com.example.emp.entity.Dept;
import com.example.emp.entity.Emp;
import com.example.emp.service.DeptService;
import com.example.emp.service.EmpService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditEmpServlet", value = "/EditEmp")
public class EditEmpServelet extends HttpServlet{
    EmpService empService = new EmpService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Sid = request.getParameter("id");
        int id  = Integer.parseInt(Sid);

        Emp emp = null;

        try {
            emp = empService.get(id);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }

        if(emp==null){
            request.setAttribute("msg","员工不存在");
            request.getRequestDispatcher("/EmpList").forward(request,response); //el ${msg}
            //request.getRequestDispatcher("/EditDept.jsp").forward(request,response); //el ${msg}
        }else{
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("/EditEmp.jsp").forward(request,response); //el ${dept.name} ....
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

}
