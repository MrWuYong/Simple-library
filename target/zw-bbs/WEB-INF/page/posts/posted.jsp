<%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2018/4/25
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>发帖</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" />
    <!--<script type="text/javascript" src="js/base.js"></script>-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/posted.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/ajaxFunces.js" ></script>
</head>
<body>
    <%@include file="/WEB-INF/page/public/header.jsp"%>
    <section>
        <c:if test="${resultMap!=null}">
        <div style="width: 400px;height: 300px;position: absolute;left: 50%;text-align: center;font-size: 24px">
            <p>${resultMap.resultInfo}</p>
            <c:if test="${resultMap.resultType>-1}"><p><a href="posts?id=${id}">确认</a></p></c:if>
            <c:if test="${resultMap.resultType==-1}"><p>确认</p></c:if>
        </div>
        </c:if>
        <div class="postDiv" disabled="di">
            <form method="post" action="posted">
                <div id="left">
                    <h2>新建帖子</h2>
                    <label>选择话题</label>
                    <select name="postTopic">
                        <c:forEach var="topic" items="${topics}">
                        <option selected="selected" value="${topic.id}">${topic.topicName}</option>
                        </c:forEach>
                    </select>
                </div >
                <div id="right">
                    <div><input required="required" type="text" name="heading" maxlength="80" placeholder="请输入发帖标题"/><span>最高80字符</span></div>
                    <div><textarea required="required" name="content" cols="110" rows="28"></textarea></div>
                    <div ><input class="btn btn-default" type="submit" value="发帖"/></div>
                </div>
            </form>
        </div>
    </section>
</body>
</html>
