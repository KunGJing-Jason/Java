package com.example.emp.servlet;

import com.example.emp.entity.Dept;
import com.example.emp.entity.Emp;
import com.example.emp.service.DeptService;
import com.example.emp.service.EmpService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AddEmpServlet", value = "/AddEmp")
@MultipartConfig
public class AddEmpServlet extends HttpServlet {
    DeptService deptService = new DeptService();
    EmpService empService =new EmpService();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示
        //获取部门列表
        List<Dept> depts = deptService.getAll();
        request.setAttribute("depts",depts);
        request.getRequestDispatcher("/AddEmp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //插入db
        String ename = request.getParameter("name");
        String esex = request.getParameter("esex");
        String ebirth = request.getParameter("ebirth");
        Date birth=null;
        try {
            if(ebirth!=null){
                ebirth.replace('/','-');
            }
            birth = dateFormat.parse(ebirth);
        } catch (Exception e) { }
        String dept_id = request.getParameter("dept_id");
        Long deptId = null;
        try{ deptId= Long.valueOf(dept_id);}catch (Exception e){}

        String imgUrl = null;
        Part photoPart = request.getPart("photo");
        if(photoPart.getSize()>0) {
            String submittedFileName = photoPart.getSubmittedFileName();
            //photoPart.write("C:\\Users\\teacher01\\Desktop\\day7\\emp\\src\\main\\webapp\\photo\\"+submittedFileName);
            //C:\Users\teacher01\Desktop\day7\emp\target\emp-1.0-SNAPSHOT\photo
            String webAppDir = this.getServletContext().getRealPath("/");
            imgUrl = "photo/"   // my.i.jpg
                    + UUID.randomUUID()+ submittedFileName.substring(submittedFileName.lastIndexOf("."));
            photoPart.write(webAppDir+ imgUrl);
        }
        //service dao -->servlet ->Emp.jsp
        Emp emp = new Emp();
        emp.setName(ename);
        emp.setSex(esex);
        emp.setBirth(birth);
        emp.setDeptId(deptId);
        emp.setImgUrl(imgUrl);
        boolean ok = false;
        try {
            ok = empService.add(emp);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }
        if(ok){
            request.getRequestDispatcher("/EmpList").forward(request,response);
        }else{
            request.setAttribute("msg","添加员工信息出错"); //jsp:  ${msg}
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("/AddEmp.jsp").forward(request,response);
        }


        System.out.println("");


    }
}
