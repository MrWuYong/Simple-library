<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="head">
    <div>
        <ul class="nav nav-pills">
            <li class="active"><a href="index">首页</a></li>
            <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <li class="">
                        <span>我的</span>
                            <ul class="nav nav-list">
                                <li><a href="userInfo">个人信息</a></li>
                                <li><a href="modify">修改信息</a></li>
                                <li><a href="userPosts?userId=${user.id}">过往发帖</a></li>
                            </ul>
                    </li>
                    <li><a href="logout">退出</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login">登录</a></li>
                    <li><a href="register">注册</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</header>
