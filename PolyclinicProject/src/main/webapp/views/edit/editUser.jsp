<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role" %>
<%@ page import="by.it_academy.jd2.core.model.people.Passport" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Address</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function sendUser() {

        var user = {
            "username": $("#username").val(),
            "password": $("#password").val(),
            "surname": $("#surname").val(),
            "given_name": $("#given_name").val(),
            "role": $("#role").val(),
            "position": $("#position").val(),
            "phone": $("#phone").val(),
            "email": $("#email").val(),
            "info": $("#info").val(),
        };
        $.ajax({
            type: "PATCH",
            url: "${pageContext.request.contextPath}/users/${user.id}",
            data: JSON.stringify(user),
            contentType: "application/json",
            success: function (responseData) {
                window.location.href ="${pageContext.request.contextPath}/users";
                alert('Success save ');
            },
            error: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/users";
                alert('Error save');
            }
        });
    }
</script>

<div class="container">
    <h4 class="text-info text-center">Update user</h4>

    <div class="row">

        <%--            start row three colon, number 1--%>
        <div class="col-lg-4">

            <div class="mb-3">
                <label for="username" class="form-label">Login</label>
                <input type="text" name="username" class="form-control" id="username"
                       value="${user.username}" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="password"
                       value="${user.password}" required>
            </div>

            <div class="mb-3">
                <label for="surname" class="form-label">Surname</label>
                <input type="text" name="surname" class="form-control" id="surname"
                       value="${user.surname}" required>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="mb-3">
                <label for="given_name" class="form-label">Given name</label>
                <input type="text" name="given_name" class="form-control" id="given_name"
                       value="${user.given_name}" required>
            </div>
            <div class="mt-3">
                <label for="role" class="form-label">Role</label>
                <select class="form-select" name="role" id="role" aria-label="Default select example"
                        required>
                    <option value="${user.role}">${user.role} </option>
                    <c:forEach var="r" items="${roleList}">
                        <option value="${r}">${r}<br></option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div class="mb-3">
                <label for="position" class="form-label">Position</label>
                <input type="text" name="position" class="form-control" id="position"
                       value="${user.position}">
            </div>


        </div>
        <div class="col-lg-4">

            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="tel" name="phone" class="form-control" id="phone"
                       placeholder="(00)123-45-67" pattern="\([\d]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}"
                       value="${user.phone}" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" name="email" class="form-control" id="email"
                       value="${user.email}">
            </div>
            <div class="mb-3">
                <label for="info" class="form-label">INFO</label>
                <input type="text" name="info" class="form-control" id="info"
                       value="${user.info}">
            </div>

        </div>

    </div>
    <div>
        <button type="button" class="btn btn-info" onclick="sendUser()"> UPDATE</button>
        <br><br></div>
    <%--    </form>--%>
    <%@include file="../footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>

</html>

