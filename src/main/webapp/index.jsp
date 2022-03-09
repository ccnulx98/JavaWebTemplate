<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax_jq</title>
</head>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/firstTest">点击</a>
<h1>当前在线人数${pageContext.servletContext.getAttribute("OnlineCount")}</h1>
</body>
</html>
