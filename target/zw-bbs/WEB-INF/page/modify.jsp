<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/25
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>更新信息</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" />
        <!--<script type="text/javascript" src="js/base.js"></script>-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/ajaxFunces.js" ></script>
</head>
<body>
<%@include file="/WEB-INF/page/public/header.jsp"%>
    <section>
        <div class="formDiv" style="height: 700px">
            <form method="post" action="modify">
                <div ><p>不修改了？<a href="userInfo">查看信息</a></p></div>
                <div hidden="hidden"><input type="hidden" name="id" id="id" value="${user.id}" /></div>
                <div><label>用户名：</label><input type="text" name="userName" id="userName" value="${user.userName}"/></div>
                <div><label>性别</label>
                    <c:forEach var="i" items="${sexes}" varStatus="index">
                    <label for="${index.index}">${i.sex}</label><input type="radio" id="${index.index}" name="sex" <c:if test="${user.sex==i.id}">checked="checked"</c:if> value="${i.id}" />
                    </c:forEach>
                </div>
                <div><label>旧密码：</label><input type="password" name="oldPassword" id="oldPwd"/></div>
                <div><label>修改密码：</label><input type="password" name="password" id="password"/></div>
                <div><label>确认密码：</label><input type="password" name="rePassword" id="rePassword"/></div>
                <div><label></label><input type="submit" value="更新"/></div>
            </form>
        </div>
    </section>
</body>
</html>
