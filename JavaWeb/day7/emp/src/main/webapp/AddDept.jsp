<%--
  Created by IntelliJ IDEA.
  User: teacher01
  Date: 2023/3/13
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>部门管理</title>
  <link href="css/AddDept.css" rel="stylesheet" >
  <style>
    #msg{color: red;}
  </style>
</head>
<body>
<div id="container">
  <h3>添加部门</h3>
  <span id="msg">${msg}</span>
  <form action="AddDept" method="post">
    <h4>部门名称</h4><input name="dname"><br>
    <h4>部门位置</h4><input name="dlocation"><br>
    <h4></h4><button id="add" type="submit"><span>确定</span></button><br>
  </form>
</div>
</body>
</html>
