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
          <th >Id passport</th>
          <th >Identification</th>
          <th>Code state</th>
          <th >Nationality</th>
          <th>Date birthday</th>
          <th >Sex</th>
          <th >Data issue</th>
          <th>Data expiry</th>
          <th >Place birth</th>
      </tr>
<c:forEach items="${requestScope.passports}"
           var="passport">
    <tr>
        <td >${passport.id_passport}</td>
        <td >${passport.identification}</td>
        <td>${passport.code_state}</td>
        <td >${passport.nationality}</td>
        <td>${passport.date_birthday}</td>
        <td >${passport.sex}</td>
        <td >${passport.data_issue}</td>
        <td>${passport.data_expiry}</td>
        <td >${passport.place_birth}</td>
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