<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.04.2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Список рейсов</h1>
<table border="2">
    <body>

    <p>Параметры поиска:</p>
    <tr>
        <c:if test="${!scheduledDeparture.equals('1900-01-01')}">
            <td width="20%">${scheduledDeparture}</td>
        </c:if>
        <c:if test="${scheduledDeparture.equals('1900-01-01')}">
            <td width="20%">Параметр на задан</td>
        </c:if>

        <td width="20%">${departureAirport}</td>
        <c:if test="${!scheduledArrival.equals('1900-01-01')}">
            <td width="20%">${scheduledArrival}</td>
        </c:if>
        <c:if test="${scheduledArrival.equals('1900-01-01')}">
            <td width="20%">Параметр на задан</td>
        </c:if>

        <td width="20%">${arrivalAirport}</td>

    </tr>
    </body>
</table>
<br><br>
<hr>

<form method="post" action="flight">

    <c:if test="${list.size()==0}">
        <p>Рейсов с заданными параметрами не найдено</p>
    </c:if>
    <c:if test="${list.size()>0}">
        <table border="2">
            <thead>
            <tr>
                <th width="20%">${title.getFlight_no()}</th>
                <th width="20%">${title.getStatus()}</th>
                <th width="20%">${title.getScheduled_departure()}</th>
                <th width="20%">${title.getScheduled_arrival()}</th>
                <th width="20%">${title.getDeparture_airport()}</th>
                <th width="20%">${title.getArrival_airport()}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}"
                       var="fly">

                <tr>
                    <td width="20%">${fly.getFlight_no()}</td>
                    <td width="20%">${fly.getStatus()}</td>
                    <td width="20%">${fly.getScheduled_departure()}</td>
                    <td width="20%">${fly.getScheduled_arrival()}</td>
                    <td width="20%">${fly.getDeparture_airport()}</td>
                    <td width="20%">${fly.getArrival_airport()}</td>
                </tr>

            </c:forEach>
            </tbody>
        </table>
    </c:if>

</form>

<br>
<hr>
<form method="get" action="choice">

    <button type="submit">Назад</button>
    <br><br>
</form>
</body>
</html>
