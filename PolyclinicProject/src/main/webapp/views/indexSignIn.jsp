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

    <form  class="form-signin" method="POST" action="/PolyclinicProject-0.0/login">

        <h3>Please sign in</h3>
        <br>
        <label for="username">Login</label><br>
        <input type="text" name="username" class="form-control input-block" placeholder="Input login" id="username"
               required>

        <label for="password">Password</label><br>
        <input type="password" name="password" class="form-control input-block"  id="password"
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
