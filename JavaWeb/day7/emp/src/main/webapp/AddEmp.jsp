<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teacher01
  Date: 2023/4/10
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>员工管理</title>
  <link href="css/AddEmp.css" rel="stylesheet" >
  <script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="container">
  <h3>添加员工</h3>
  <form action="AddEmp" method="post" enctype="multipart/form-data">
    <div id="leftContent">
      <h4>姓名</h4><input name="name"  ><br>
      <h4>性别</h4><input name="esex" type="radio" value="男" checked>男
      <input name="esex" type="radio" value="女">女<br>
      <h4>生日</h4><input name="ebirth" type="date"  ><br>
      <h4>部门</h4><select name="dept_id">
      <option value="0">请选择</option>
      <c:forEach items="${depts}" var="dept">
        <option value="${dept.id}" ${dept.id==param.deptId?"selected":''} > ${dept.name} </option>
      </c:forEach>
    </select><br>
      <h4></h4><button id="add" type="submit"><span>确定</span></button><br>
    </div>
    <div id="rightContent">
      <img id="photoImg" src="img/addPhoto.png"><br>
      <input id="photo" name="photo" type="file">
      <script>
        $("#photo").change(function(){ //预览照片
          $("#photoImg").attr("src",URL.createObjectURL($(this)[0].files[0]));
        });
      </script>
    </div>
  </form>
</div>
</body>
