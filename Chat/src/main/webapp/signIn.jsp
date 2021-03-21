<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 21.03.2021
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <title>SignIn</title>
    <meta charset="utf-8">
</head>
<body>

<form action="hello" method="GET">

    <h1>Авторизация</h1>
    <hr>

    Логин<br>
    <input type="text" placeholder="Введите логин" name="login" required><br><br>

    Пароль<br>
    <input type="password" placeholder="Введите пароль" name="psw" required><br><br>

    <hr>
    <button type="submit">Войти</button>

</form>
</body>
</html>