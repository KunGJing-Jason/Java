<%--
  Created by IntelliJ IDEA.
  User: teacher01
  Date: 2023/3/6
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>部门管理</title>
  <link href="css/Dept.css" rel="stylesheet" >
  <script>
    function del(id){
      if(confirm('确认删除？')) {
        //window.location.href = "Dept.html";
        window.location.href = "DelDept?id="+id;
      }
    }
  </script>
</head>
<body>
<div id="container" >
  <h3>部门管理</h3>
  ${msg}
  <button id="addBtn" onclick="location.href='AddDept.jsp'">增加</button>
  <table>
    <tr><td>#</td><th>名称</th><th>位置</th><th>编辑</th><th>删除</th></tr>
    <c:forEach items="${depts}" var="dept" varStatus="row" >
      <tr><td>${row.count}</td><td>${dept.name}</td><td>${dept.loc}</td>
        <td><a href="EditDept?id=${dept.id}">编辑</a></td>
        <td><a href="javascript:del(${dept.id});">删除</a></td></tr>
    </c:forEach>


<%--    <tr><td>1</td><td>销售部</td><td>1101</td>--%>
<%--      <td><a href="EditDept.html">编辑</a></td>--%>
<%--      <td><a href="javascript:del(1);">删除</a></td></tr>--%>
<%--    <tr><td>2</td><td>人事部</td><td>1102</td>--%>
<%--      <td><a href="EditDept.html">编辑</a></td>--%>
<%--      <td><a href="javascript:del(2);">删除</a></td></tr>--%>
<%--    <tr><td>3</td><td>研发部</td><td>1103</td>--%>
<%--      <td><a href="EditDept.html">编辑</a></td>--%>
<%--      <td><a href="javascript:del(3);">删除</a></td></tr>--%>
  </table>
</div>


</body>
</html>