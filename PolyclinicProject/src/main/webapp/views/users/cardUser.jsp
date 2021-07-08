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
<c:choose>
    <c:when test="${requestScope.doctor != null}">
        <title>${requestScope.doctor.surname}</title>
    </c:when>
    <c:otherwise>
        <title>${requestScope.patient.surname}</title>
    </c:otherwise>
</c:choose>

</head>
<body>
<%@include file="../../index.jsp" %>


<table border="1">
    <tbody>
    <tr>
<c:choose>
    <c:when test="${requestScope.doctor != null}">

        <td width="15%">${requestScope.doctor.surname}</td>
        <td width="15%">${requestScope.doctor.given_name}</td>
        <td width="15%">${requestScope.doctor.position}</td>
        <td width="15%">${requestScope.doctor.email}</td>
        <td width="15%">${requestScope.doctor.phone}</td>
        <td width="15%">${requestScope.doctor.info}</td>
    </c:when>
    <c:when test="${requestScope.patient != null}">
        <td width="15%">${requestScope.patient.surname}</td>
        <td width="15%">${requestScope.patient.given_name}</td>
        <td width="15%">${requestScope.patient.madical_card}</td>
        <td width="15%">${requestScope.patient.email}</td>
        <td width="15%">${requestScope.patient.phone}</td>
        <td width="15%">${requestScope.patient.info}</td>
    </c:when>
</c:choose>
    </tr>
    </tbody>
</table>

<%@include file="../footer.jsp" %>
</body>
</html>
