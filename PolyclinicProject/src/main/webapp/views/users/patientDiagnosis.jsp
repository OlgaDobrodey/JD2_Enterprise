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
    <title>Patient's diagnosis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp"%>

<h3 class="text-center"> Patient: ${requestScope.userPatient.surname}  ${requestScope.userPatient.given_name}</h3>
<h5> Diagnosis: ${requestScope.medical_card.diagnosis}</h5>
<h5 >Doctor: ${requestScope.medical_card.doctor.surname} ${requestScope.medical_card.doctor.given_name}</h5>
<table  class="table table-striped table-info">
    <tbody>
    <tr>
        <th class="text-center">Date</th>
        <th class="text-center">Prescription</th>
        <th class="text-center">Status</th>
    </tr>
    <c:forEach items="${requestScope.diagnosis}"
               var="list">
        <tr>
            <td>${list.date}</td>
            <td>${list.prescription}</td>
            <td class="text-center" >${list.status}</td>

        </tr>
    </c:forEach>

    <p><input type="button" class="btn btn-info"
              onclick="location.href='${pageContext.request.contextPath}/${sessionScope.user.username}/medicalCart';"
              value="Medical card"/></p>
    </tbody>
</table>


<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
