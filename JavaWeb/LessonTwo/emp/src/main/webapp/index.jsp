<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>员工管理系统</title>
    <link href="css/index.css" rel="stylesheet">
</head>
<body>
<div id="container">
    <header>
        员工管理系统
        <span id="loginSpan" style="display:inline"
              onclick='document.getElementById("fun").src="Login.html";'>
            <img src="img/login16.png" alt="登录icon"> 登录
        </span>

        <span id="loginedSpan" style="right:90px;display:inline;">
            <span id="loginName">欢迎，超管</span>
            <ul id="menu">
                <li onclick='document.getElementById("fun").src="Register.html";' >注册管理员</li>
                <li onclick='document.getElementById("fun").src="ChgPwd.html";'>修改密码</li>
                <li onclick="location.href='Index.html'">
                    <img src="img/logout16.png" alt="退出icon"> 退出</li>
            </ul>
        </span>
    </header>
    <div id="body">
        <aside>
            <a href="ListDept" target="fun">部门管理</a><br>
            <a href="ListEmp" target="fun">员工管理</a><br>
        </aside>
        <div id="content">
            <iframe id="fun" name="fun" height="640" width="900" frameborder="0" src="Welcome.html" >
            </iframe>
        </div>
    </div>
    <footer>Copyright © 2022 - 版权所有
    </footer>
</div>
</body>
</html>