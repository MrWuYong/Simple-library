<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/23
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" />
    <!--<script type="text/javascript" src="js/base.js"></script>-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css">
</head>
<body>
<%@include file="/WEB-INF/page/public/header.jsp"%>
<section>
    <div class="formDiv">
    <c:if test="${typeMap!=null}">
        <p style="text-align: center;position: absolute;color: #c9302c">${typeMap.resultInfo}</p>
        <c:if test="${typeMap.resultType>=0}">
            <p style="text-align: center;position: absolute;"><a href="login">点击跳转到登录页面</a></p>
        </c:if>
    </c:if>
    <c:if test="${typeMap.resultType<0 || typeMap ==null}">
        <form method="post" action="register">
            <div><p>已有账户？<a href="login">登录</a></p></div>
            <div><label>用户名：</label><input type="text" name="userCode" id="userCode" placeholder="用户名" /><span></span></div>
            <div><label>真实姓名：</label><input type="text" name="userName" id="userName" placeholder="真实姓名"/><span></span></div>
            <div><label>密码：</label><input type="password" name="password" id="password" placeholder="密码"/><span></span></div>
            <div><label>确认密码：</label><input type="password" name="repassword" id="repassword" placeholder="再次输入密码"/><span></span></div>
            <div><label></label><input type="submit"  id="submit" value="注册"/></div>
        </form>
    </c:if>
    </div>
</section>
</body>
</html>
