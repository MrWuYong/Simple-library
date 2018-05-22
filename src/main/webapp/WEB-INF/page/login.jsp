<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/21
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html >
<html>
<head>
    <title>用户登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" />
    <!--<script type="text/javascript" src="js/base.js"></script>-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css">
</head>
<body>
    <header></header>
    <div class="formDiv">
        <form method="post" action="login">
            <div><p>没有账号？<a href="register">注册</a></p></div>
                <div class="error"><label></label>${exception.message}</div>
            <div><label for="userCode">用户名</label><input name="userCode" id="userCode" type="text" placeholder="输入用户名"/></div>
            <div><label for="password">密码</label><input name="password" id="password" type="password" placeholder="输入密码"/></div>
            <div><label></label><input id="submit" type="submit" value="登录"></div>
        </form>
    </div>
</body>
</html>
