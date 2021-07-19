<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.07.2021
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
ADMIN the main man
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin/user';" value="Creat User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Delete User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Update User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/allPatients';" value="All Patients" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/Departments';" value="New Departament" formmethod="get"/></p>
<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
