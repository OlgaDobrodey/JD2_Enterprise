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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
    <title>SignUp</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta charset="utf-8">
</head>
<body class="text-center">
<%@include file="../index.jsp" %>
<main class="container">
    <br>
    <form method="post" action="signUp">
        <h3>Please sign up</h3>
        <p>Пожалуйста, заполните эту форму, чтобы создать учетную запись.</p>
        <br>
        <label for="username">Login</label>
        <input type="text" class="form-control input-block" name="username" placeholder="Input login" id="username" required>
        <br>
        <label for="password">Password</label>
        <input type="password" id="password" class="form-control input-block" placeholder="Input password" name="psw"
               required>
        <br>
        <label for="name">Name</label>
        <input type="text" id="name" class="form-control input-block" placeholder="Input name" name="name" required>
        <br><label for="date">Birthday</label>
        <input type="date" id="date" class="form-control input-block" name="birthday" required>
        <br>
        <br>
        <button type="submit" class="btn btn-secondary">Sign Up</button>
        <br>

    </form>
    <form action="signInDoctor" method="get">
        <p>You have account </p>
        <input type="submit" class="btn btn-secondary" value="Sign In">

    </form>
</main>
<<%@include file="footer.jsp" %>
</body>
</html>