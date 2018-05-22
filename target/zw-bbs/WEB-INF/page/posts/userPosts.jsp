<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/26
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${user.userName}的发帖详情页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
    <style>
        tr{
            margin:10px auto ;
        }
    </style>
</head>
<body>

<section>
    <%@include file="/WEB-INF/page/public/header.jsp"%>
    <section>
        <div class="container">
            <div>
                <label>Cells: </label><input id="cells" type="text" placeholder="Cells" value="5">
                <label>Rows: </label><input id="rows" type="text" placeholder="Rows" value="100">
                <button id="build" class="btn btn-default">Build</button>
            </div>
            <table id="table">
                <thead>
                <tr>
                    <th >标题</th>
                    <th>内容</th>
                    <th>发帖时间</th>
                    <th>进行操作</th>
                </tr>
                <c:forEach items="${postsList}" var="posts">
                <tr>
                    <td><a>${posts.content.heading}</a></td>
                    <td class="tab-content" style="overflow: hidden">${posts.content.content}</td>
                    <td>${posts.createDate}</td>
                    <td>
                        <a href="posts?id=${posts.id}">查看/</a>
                        <c:if test="${posts.userId == user.id }"><a href="deletePosts/${posts.id}/${posts.contentId}"> 删除此帖</a></c:if>
                    </td>
                </tr>
                </c:forEach>
                </thead>
            </table>
        </div>
    </section>
</section>
</body>
</html>
