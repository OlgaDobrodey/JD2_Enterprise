<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>SignIn</title>
    <meta charset="utf-8">
</head>
<body>
<c:if test="${Boolean.parseBoolean(invalidUserLogin)}">
    <h4><span style='color: red;'>Не верный логин или пароль<br>
       Авторизация не выполнена, попробуйте снова!
    </span></h4>
</c:if>
<%request.setAttribute("invalidUserLogin", false);%>


<form action="signIn" method="post" required >

    <h1>Авторизация</h1>
    <hr>
    Логин<br>
    <input type="text" placeholder="Введите логин" name="login" required><br><br>
    Пароль<br>
    <input type="password" placeholder="Введите пароль" name="psw" required><br><br>
    <hr>
    <button type="submit">Войти</button><br><br>

</form>
<form action="signUp" method="get">
    <hr>
    Еще не зарегистрированы <br><br>
    <button type="submit">Регистрация</button>

</form>
</body>
</html>
