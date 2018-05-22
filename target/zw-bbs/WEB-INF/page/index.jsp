<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/21
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <%--<header class="head">
        <div>
            <ul class="nav nav-pills">
                <li class="active"><a href="#">首页</a></li>
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <li>
                            <div id="user"><span>我的</span>
                                <ul class="nav nav-list bs-docs-sidenav affix">
                                    <li><a href="userInfo">个人信息</a></li>
                                    <li><a href="modify">修改信息</a></li>
                                    <li><a href="">过往发帖</a></li>
                                </ul>
                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="login">登录</a></li>
                        <li><a href="register">注册</a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="#">论坛</a></li>
            </ul>
        </div>
    </header>--%>
    <%@include file="/WEB-INF/page/public/header.jsp"%>
    <section >

        <div class="container-fluid" style="width: 1000px;">
            <div class="row-fluid">
                <div class="span3 bs-docs-sidebar">
                    <ul id="topics" class="nav nav-list bs-docs-sidenav affix">
                        <li ><a href="index">综合</a></li>
                        <c:forEach var="topic" items="${list}"><li><a href="index?id=${topic.id}">${topic.topicName}</a></li></c:forEach>
                    </ul>
                </div>
                <div class="span10" style="background-color: #fff1e3; height: 10000px;margin-left: 10%;">
                    <div class="btn btn-default" style="position: relative;float: right;left: 82px;"><label for="posted"><a id="posted" href="posted" style="text-decoration: none;">我要发贴</a></label></div>
                    <c:forEach var="post"  items="${pageInfo.list}">
                        <div class="posts"><a href="posts?id=${post.id}">
                            <div><p><label>${post.topic.topicName}</label>${post.content.heading}</p></div>
                            <div><p>${post.content.content}</p></div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
    <footer>

    </footer>
</body>
</html>
