<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/5/22
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${OtherUser.userName}的资料</title>
</head>
<body>
    <%@include file="/WEB-INF/page/public/header.jsp"%>
    <p>用户姓名：${OtherUser.userName}</p>
    <p>身份：${OtherUser.role.roleName}</p>
    <p>性别：${OtherUser.sexModel.sex}</p>
    <p>帖子数：${OtherUser.posts.size()}</p>
    <p>评论数：${OtherUser.replies.size()}</p>
</body>
</html>
