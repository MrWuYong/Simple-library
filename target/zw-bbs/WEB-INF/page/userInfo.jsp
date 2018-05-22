<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/24
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>个人信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" />
    <!--<script type="text/javascript" src="js/base.js"></script>-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css">
</head>
<body>
<%@include file="/WEB-INF/page/public/header.jsp"%>
    <section>
        <c:if test="${typeMap!=null}">
            <p style="position: relative;top: 10px" ></p>
        </c:if>
        <div class="formDiv">
            <div ><p>更改个人信息？<a href="modify">修改信息</a></p></div>
            <div hidden="hidden"><input type="hidden" name="id" id="id" value="${user.id}" /></div>
            <div><label>账号：</label><input type="text" name="userCode" id="userCode" value="${user.userCode}"/></div>
            <div><label>用户名：</label><input type="text" name="userName" id="userName" value="${user.userName}"/></div>
            <div><label>身份:</label><input type="text" name="userName" id="userRole" value="${user.role.roleName}"/></div>
            <div><label>性别：</label><input type="text" name="sex" id="sex" value="${user.sexModel.sex}"/></div>
            <div><label>创建日期：</label><input type="text" name="date" id="date" value=" ${user.createDate}"/></div>
        </div>
    </section>
    <script type="text/javascript">
        $(function () {
            $("input").attr("disabled","disabled");
            $(".formDiv").click(function () {
                $("section>p").hide();
            })
        });
        
    </script>
</body>
</html>
