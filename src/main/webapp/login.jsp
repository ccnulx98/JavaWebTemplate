<%--
  Created by IntelliJ IDEA.
  User: 天罡剑f
  Date: 2021/12/3
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="resources/css/login.css">
    <link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
    <script type="text/javascript">

        //改变验证码事件
        function changeImg(obj){
            obj.src="${pageContext.request.contextPath}/verificationImg?time="+new Date().getTime();
        }

        //提交验证并验证验证码
        function submit(){
            var input = document.getElementsByTagName('input')[0];
            window.location.href="${pageContext.request.contextPath}/checkOutVCode?code="+input.value;
        }
    </script>
</head>
<body>
<div id="login-box">
    <div class="register_text">
        <p>没有账号？</p>
        <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
    </div>
    <h1>login</h1>
    <div class="form">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="item">
                <label for="username"><i class="fa fa-user-circle-o" aria-hidden="true"></i></label>
                <input type="text" name="username" id="username" placeholder="username">
            </div>
            <div class="item">
                <label for="pwd"><i class="fa fa-key" aria-hidden="true"></i></label>
                <input type="password" name="password" id="pwd" placeholder="password">
            </div>
            <div class="verification">
                <label for="verification">验证码</label>
                <input type="text" name="verification" id="verification">
                <img id="codeimg" src="${pageContext.request.contextPath}/verificationImg" onclick="changeImg(this)">
            </div>
            <input type="submit" id="button" value="登录">
        </form>
    </div>
</div>
</body>
</html>