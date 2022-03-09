<%--
  Created by IntelliJ IDEA.
  User: 天罡剑f
  Date: 2021/12/3
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/register.css">
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
<div id="register">

    <div class="hello">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>

    <div class="mid">
        <form action="${pageContext.request.contextPath}/register" method="post">
            <table>
                <tr>
                    <td><label for="username">用户名</label></td>
                    <td><input type="text" name="username" id="username" placeholder="username"></td>
                </tr>
                <tr>
                    <td><label for="pwd">密码</label></td>
                    <td><input type="password" name="password" id="pwd" placeholder="password"></td>
                </tr>
                <tr>
                    <td><label for="pwd1">确认密码</label></td>
                    <td><input type="password" name="pwd1" id="pwd1" placeholder="password"></td>
                </tr>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="email" name="email" id="email" placeholder="email"></td>
                </tr>
                <tr>
                    <td><label for="name">真实姓名</label></td>
                    <td><input type="text" name="name" id="name" placeholder="real name"></td>
                </tr>
                <tr>
                    <td><label for="age">年龄</label></td>
                    <td><input type="text" name="age" id="age" placeholder="age"></td>
                </tr>
                <tr>
                    <td><label for="qq">qq号</label></td>
                    <td><input type="text" name="qq" id="qq" placeholder="qq号"></td>
                </tr>
                <%--<tr>--%>
                    <%--<td><label for="phone">手机号</label></td>--%>
                    <%--<td><input type="text" name="phone" id="phone" placeholder="phone number"></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><label for="sex">性别</label></td>
                    <td>男    <input type="radio" name="gender" id="sex" value="男">    女    <input type="radio" name="gender" id="sex" value="女"></td>
                </tr>
                <%--<tr>--%>
                    <%--<td><label for="date">日期</label></td>--%>
                    <%--<td><input type="date" name="date" id="date"></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><label for="validate">验证码</label></td>
                    <td>
                        <input type="text" name="validate" id="validate" placeholder="验证码">
                        <img src="${pageContext.request.contextPath}/verificationImg" onclick="changeImg(this)" alt="" id="check_img">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="注册" id="submit" name="submit"></td>
                </tr>
            </table>
        </form>
    </div>

    <div class="right">
        <p>已有账号?</p>
        <a href="${pageContext.request.contextPath}/login.jsp">点击登录</a>
    </div>
</div>

</body>
</html>