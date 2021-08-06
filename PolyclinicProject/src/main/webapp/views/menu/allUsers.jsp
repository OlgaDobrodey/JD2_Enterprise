<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All Users</title>
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
            type: "POST",
            url: "${pageContext.request.contextPath}/users",
            data: JSON.stringify(user),
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/users";
                alert('Success save ');
            },
            error: function (responseData) {
                window.location.href ="${pageContext.request.contextPath}/users";
                alert('Error save');
            }
        });
    }
</script>
<script>
    function deleteUser(id) {
        $.ajax({
            type: "DELETE",
            url: "${pageContext.request.contextPath}/users/" + id,
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = responseData.redirect;
                alert('Success delete');

            },
            error: function (responseData) {
                window.location.href = responseData.redirect;
                alert('Error delete');
            }
        });
    }
</script>
<c:if test="${sessionScope.user.role==Role.ADMIN}">
    <div class="container">
        <h4 class="text-info text-center">CREATE A NEW USER</h4>
        <h6 class="text-danger text-center">${MessageUser}</h6>

        <div class="row">

                <%--            start row three colon, number 1--%>
            <div class="col-lg-4">

                <div class="mb-3">
                    <label for="username" class="form-label">Login</label>
                    <input type="text" name="username" class="form-control" id="username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="password" required>
                </div>

                <div class="mb-3">
                    <label for="surname" class="form-label">Surname</label>
                    <input type="text" name="surname" class="form-control" id="surname" required>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="mb-3">
                    <label for="given_name" class="form-label">Given name</label>
                    <input type="text" name="given_name" class="form-control" id="given_name" required>
                </div>
                <div class="mt-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-select" name="role" id="role" aria-label="Default select example"
                            required>
                        <c:forEach var="r" items="${roleList}">
                            <option value="${r}">${r}<br></option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="mb-3">
                    <label for="position" class="form-label">Position</label>
                    <input type="text" name="position" class="form-control" id="position">
                </div>


            </div>
            <div class="col-lg-4">

                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="tel" name="phone" class="form-control" id="phone"
                           placeholder="(00)123-45-67" pattern="\([\d]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">E-mail</label>
                    <input type="email" name="email" class="form-control" id="email">
                </div>
                <div class="mb-3">
                    <label for="info" class="form-label">INFO</label>
                    <input type="text" name="info" class="form-control" id="info">
                </div>

            </div>

        </div>
        <div>
            <button type="button" class="btn btn-info" onclick="sendUser()"> SAVE</button>
            <br><br></div>

    </div>

</c:if>
<table class="table table-striped table-info">
    <tbody>
    <tr>
        <th> Login</th>
        <th> Name</th>
        <th>ROLE</th>
        <th> E-mail</th>
        <th>Phone</th>
        <th>Position</th>
        <th>Info</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${requestScope.users}"
               var="psp">
        <tr>
            <td>${psp.username}</td>
            <td>
                <a class="link-info"
                   href="${pageContext.request.contextPath}/patient/${psp.username}">${psp.surname} ${psp.given_name}</a>
            </td>
            <td>${psp.role}</td>
            <td>${psp.email}</td>
            <td>${psp.phone}</td>
            <td>${psp.position}</td>
            <td>${psp.info}</td>
            <td>
                <button type="button" class="btn btn-info" onclick="deleteUser('${psp.id}')"> Delete
                </button>
            </td>
            <td>
                <input type="button" class="btn btn-info"
                       onclick="location.href='${pageContext.request.contextPath}/users/${psp.id}';"
                       value="Update"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>


