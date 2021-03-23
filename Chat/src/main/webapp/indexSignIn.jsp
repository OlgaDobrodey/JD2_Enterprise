<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>SignIn</title>
    <meta charset="utf-8">
</head>
<body>

<form action="servletSignIn" method="get">
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
