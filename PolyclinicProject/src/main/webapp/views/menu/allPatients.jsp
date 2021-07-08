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
</head>
<body>
<%@include file="../../index.jsp" %>


    <table border="1">
        <tbody>
        <c:forEach items="${requestScope.patients}"
                   var="user">
        <tr>
            <td width="20%">
                <a href="${pageContext.request.contextPath}/patient/${user.login}">${user.surname} ${user.given_name}</a>
            </td>
            <td width="20%">${user.email}</td>
            <td width="20%">${user.phone}</td>
            <td width="20%">${user.madical_card}</td>
            <td width="20%">${user.info}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>



<%@include file="../footer.jsp" %>
</body>

</html>