<%--
  Created by IntelliJ IDEA.
  User: 32183
  Date: 2023/3/20
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>部门管理</title>
  <link href="css/EditDept.css" rel="stylesheet">
</head>
<body>
<div id="container">
  <h3>编辑部门 <span id="msg"></span></h3>
  <form action="EditDept" method="post">
    <h4>部门名称</h4><input name="dname" value="${dept.name}"><br>
    <h4>部门位置</h4><input name="dlocation" value="${dept.loc}"><br>
    <input type="hidden" name="id" value="${dept.id}">
    <h4></h4><button id="edit"  type="submit"><span>确定</span></button><br>
  </form>
</div>
</body>
</html>
