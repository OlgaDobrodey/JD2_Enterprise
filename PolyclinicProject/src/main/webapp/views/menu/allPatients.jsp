<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All Patients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<c:if test="${sessionScope.user.role==Role.ADMIN}">
<div class="container">
    <h4 class="text-info text-center">CREATE A NEW USER</h4>
    <h6 class="text-danger text-center">${MessagePatient}</h6>
    <form name="newPatient" method="post">
        <div class="row">
            <div class="col-lg-4">
                <div class="mb-3">
                    <label for="city" class="form-label">City</label>
                    <input type="text" name="city" class="form-control" id="city" required>
                </div>
                <div class="mb-3">
                    <label for="street" class="form-label">Street</label>
                    <input type="text" name="street" class="form-control" id="street" required>
                </div>
                <div class="mb-3">
                    <label for="house" class="form-label">House</label>
                    <input type="text" name="house" class="form-control" id="house" required>
                </div>
                <div class="mb-3">
                    <label for="flat" class="form-label">Flat</label>
                    <input type="text" name="flat" class="form-control" id="flat" required>
                </div>
                <button type="submit" class="btn btn-info">SAVE</button>
                <br><br></div>
        </div>
    </form>

    </c:if>
<table class="table table-striped table-info">
    <tbody>
    <tr>
        <th> Login</th>
        <th> Name</th>
        <th> E-mail</th>
        <th>Phone</th>
        <th>Madical card number</th>
        <th>Info</th>
    </tr>
    <c:forEach items="${requestScope.patients}"
               var="psp">
        <tr>
            <td>${psp.username}</td>
            <td>
                <a class="link-info"
                   href="${pageContext.request.contextPath}/patient/${psp.username}">${psp.surname} ${psp.given_name}</a>
            </td>
            <td>${psp.email}</td>
            <td>${psp.phone}</td>
            <td>${psp.position}</td>
            <td>${psp.info}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>

</html>