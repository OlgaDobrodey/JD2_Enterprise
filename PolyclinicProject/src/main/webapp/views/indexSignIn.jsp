<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>SignIn</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>

<body class="text-center">
<%@include file="header.jsp" %>

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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
