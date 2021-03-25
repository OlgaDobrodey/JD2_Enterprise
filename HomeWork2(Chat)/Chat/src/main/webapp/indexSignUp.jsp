<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${Boolean.parseBoolean(invalidUserLogin)}">
    <h4><span style='color: red;'>Пользователь с таким логином уже существует!<br>
        Попробуйте снова!
    </span></h4>
</c:if>
<%request.setAttribute("invalidUserLogin", false);%>
<html>

<head>
    <title>SignUp</title>
    <meta charset="utf-8">
</head>
<body>

<form method="post" action="signUp">
    <h1>Зарегистрироваться</h1>
    <p>Пожалуйста, заполните эту форму, чтобы создать учетную запись.</p>
    <hr>

    Логин<br>
    <input type="text" placeholder="Введите логин" name="login" required><br><br>

    Пароль<br>
    <input type="password" placeholder="Введите пароль" name="psw" required><br><br>

    ФИО<br>
    <input type="text" placeholder="Введите ФИО" name="name" required><br><br>

    Дата рождения<br>
    <input type="date" name="birthday" required><br><br>
    <hr>
    <button type="submit">Зарегистрироваться</button><br><br>

</form>
<form action="signIn" method="get">
    <hr>
    Если уже зарегистрированы <br><br>
    <button type="submit">Авторизация</button>
    <br><br>
</form>
</body>
</html>