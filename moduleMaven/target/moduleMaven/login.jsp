<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/8/13
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="findNameAndPassword" method="post">
    <table>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="name">/td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="reset" value="清空"></td>
        </tr>
    </table>
</form>
</body>
</html>
