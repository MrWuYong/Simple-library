<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/25
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看帖子</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/posts.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>

</head>
<body>
    <%@include file="/WEB-INF/page/public/header.jsp"%>
    <section>
        <div class="col-md-6 col-md-offset-3">
            <!--<div><h4>评论</h4></div>-->
            <div >
                <div >
                    <h1 class="text-center">${posts.content.heading}</h1>
                    <div class="row" style="border: 1px solid #999999;">
                        <div class="col-md-2 text-center" style="border-right: 1px solid #999999;"><p><label><a href="viewUser?userName=${posts.user.userName}">${posts.user.userName}</a></label></p></div>
                        <div class="text-justify"><p>${posts.content.content}</p></div>
                    </div>
                </div>
                <c:forEach var="reply" items="${posts.replies}">
                    <div class="row" style="border: 1px solid #999999;">
                        <div class="col-md-2 text-center" style="border-right: 1px solid #999999;"><p><label>${reply.user.userName}</label></p><lable>${reply.floor}</lable></div>
                        <div class="text-justify"><p>${reply.replyContent}</p></div>
                    </div>
                </c:forEach>
            </div>
            <div >
                <p>评论</p>
                <form action="sendReply" method="post" >
                    <input type="hidden" name="postsId" value="${posts.id}"/>
                    <input type="text" name="replyContent" maxlength="80"/>
                    <input type="submit" value="发表评论"/>
                </form>
            </div>
        </div>
    </section>
</body>
</html>
