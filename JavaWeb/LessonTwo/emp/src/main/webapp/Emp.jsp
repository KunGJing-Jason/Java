<%--
  Created by IntelliJ IDEA.
  User: 32183
  Date: 2023/3/20
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>员工管理</title>
  <link href="css/Emp.css" rel="stylesheet">
  <script>
    function del(id){
      if(confirm('确认删除？')) {
        window.location.href = "Emp.html";
      }
    }
  </script>
</head>
<body>
<div id="container" style="position: relative;">
  <h3>员工管理</h3>
  <button id="addBtn" onclick="location.href='AddEmp.html'">增加</button>
  <form action="ListEmp" id="searchDiv" method="post">
    部门<select class="searchCondition" name="deptId" >
    <option value="0">不予限制</option>
    <c:forEach items="${depts}" var="dept">
      <option value="${dept.id}" ${dept.id == param.deptId ?"selected":""}>${dept.name}</option>
    </c:forEach>
<%--    <option value="2"  >人事部</option>--%>
<%--    <option value="3"  >研发部</option>--%>

  </select>
    姓名<input class="searchCondition" type="text" name="ename" value="${param.ename}">
    生日区间 <input class="birthInput" type="date" name="ebirth1" value="${param.ebirth1}">
    <input class="birthInput" type="date" name="ebirth2" value="${param.ebirth2}">
    <input type="hidden" id="inputPageNum" name="pageNum" value="1">
    <button id="btnSearch" type="submit">查询</button>
  </form>

  <table>
    <tr><td>#</td><th>姓名</th><th>照片</th><th>性别</th><th>生日</th><th>部门</th><th>编辑</th><th>删除</th></tr>
    <c:forEach items="${emps}" var="emp" varStatus="row">
      <tr><td>${emp.id}</td><td>${emp.name}</td><td><img src=${emp.img_url}></td>
        <td>${emp.gender}</td>
        <td><fmt:parseDate value="${emp.birth}" var="birth" pattern="yyyy-MM-dd" type="date"/>
          <fmt:formatDate value="${birth}" pattern="yyyy年MM月dd日"  type="date"/></td>
        <td>${emp.dname}</td>
        <td><a href="EditEmp.html">编辑</a></td>
        <td><a href="javascript:del(1);">删除</a></td></tr>
    </c:forEach>
  </table>
  <input id="pager">
    当前 ${pagingInfo.currentPageNum} 页, 总 ${pagingInfo.totalPageCount} 页, 共 ${pagingInfo.totalRowSize} 条记录<br>
    <a herf="#" onclick="goPage(1);return false;">首页</a>
    <a herf="#" onclick="goPage(${pagingInfo.prePageNum});return false;">上一页</a>
    <a herf="#" onclick="goPage(${pagingInfo.nextPageNum});return false;">下一页</a>
    <a herf="#" onclick="goPage(${pagingInfo.totalPageCount});return false;">尾页</a>
    <input title="输入页码，按回车自动跳转"
           name="nowpage" id="nowpage" type="text" size="2" value="${pagingInfo.currentPageNum}"
           onkeypress="if(event.keyCode==13){goPage(document.getElementByID('nowPage').value);return false; }">
    <script>
      function goPage(pageNumValue){
        //页码置入隐藏元素inputPageNum的value中，提交
        let inputPageNum=document.getElementById("inputPageNum")
        inputPageNum.setAttribute('value',pageNumValue);
        document.getElementById("searchDiv").submit();
      }
    </script>
  </div>
</div>
</body>
</html>
