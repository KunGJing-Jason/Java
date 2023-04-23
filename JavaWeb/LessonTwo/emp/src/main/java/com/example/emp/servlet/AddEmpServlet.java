package com.example.emp.servlet;

import com.example.emp.HelloServlet;
import com.example.emp.entity.Dept;
import com.example.emp.entity.Emp;
import com.example.emp.service.DeptService;
import com.example.emp.service.EmpService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@WebServlet(name = "AddEmpServlet",value = "/AddEmp")
@MultipartConfig
public class AddEmpServlet extends HttpServlet{
    DeptService deptService = new DeptService();
    EmpService empService = new EmpService();

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Dept> depts = deptService.getAll();
        request.setAttribute("depts",depts);
        request.getRequestDispatcher("/AddEmp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        String esex = request.getParameter("esex");
        String ebirth = request.getParameter("ebirth");
        String deptId = request.getParameter("dept_id");
        Date birth = null;

        try{
            if(ebirth != null){
                birth = dateFormat.parse(ebirth);
            }
        }catch (Exception e){
        }

        String imgUrl = null;
        Part photoPart = request.getPart("photo");
        if(photoPart.getSize()>0){
            String submittedFileName = photoPart.getSubmittedFileName();
            String webAppDir = this.getServletContext().getRealPath("/");
            imgUrl = "photo/"+ UUID.randomUUID()
                    +submittedFileName.substring(submittedFileName.lastIndexOf("."));
            photoPart.write(webAppDir+imgUrl);
        }

        Long DeptId = null;
        try{
            DeptId = Long.valueOf(deptId);
        }catch(Exception e){

        }



        Emp emp = new Emp();
        emp.setName(ename);
        emp.setSex(esex);
        emp.setBirth(birth);
        emp.setDeptId(DeptId);
        emp.setImgUrl(imgUrl);

        boolean ok = empService.add(emp);
        if(ok){
            request.getRequestDispatcher("/EmpList").forward(request,response);
        }else{
            request.setAttribute("msg","添加员工信息出错");
            request.getRequestDispatcher("/AddEmp.jsp").forward(request,response);
        }



    }
}
