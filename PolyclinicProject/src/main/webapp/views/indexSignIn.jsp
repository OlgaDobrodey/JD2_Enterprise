<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>SignIn</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
</head>

<body class="text-center">
<%@include file="../index.jsp" %>

<main class="container">
    <br>

    <c:if test="${Boolean.parseBoolean(invalidUserLogin)}">
        <h4><span style='color: red;'>Не верный логин или пароль<br>
           Авторизация не выполнена, попробуйте снова!
        </span></h4>
    </c:if>
    <%request.setAttribute("invalidUserLogin", false);%>


    <form action="signIn" method="post" required>

        <h3>Please sign in</h3>
        <br>
        <label for="login">Login</label><br>
        <input type="text" name="login" class="form-control input-block" placeholder="Input login" id="login"
               required>

        <label for="psw">Password</label><br>
        <input type="password" name="psw" class="form-control input-block" placeholder="
medical card number" id="psw"
               required>
        <br>
        <input type="submit" class="btn btn-secondary" value="Sign In">
        <br>
    </form>

</main>
<%@include file="footer.jsp" %>
</body>
</html>
