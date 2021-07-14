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

<table class="table table-striped table-info">
    <tbody>
    <tr>

        <th> Name</th>
        <th> E-mail</th>
        <th>Phone</th>
        <th>Madical card number</th>
        <th>Info</th>
    </tr>
    <c:forEach items="${requestScope.patients}"
               var="psp">
        <tr>
<%--            <td>--%>
<%--                <input type="button"--%>
<%--                       onclick="location.href='${pageContext.request.contextPath}/patient/${psp.login}/card';"--%>
<%--                       value="Medical card"/>--%>
<%--            </td>--%>
            <td>
                <a class="link-info" href="${pageContext.request.contextPath}/patient/${psp.login}">${psp.surname} ${psp.given_name}</a>
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