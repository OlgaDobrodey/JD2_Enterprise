<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.04.2021
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.it_academy.jd2.core.dto.AllFlights" %>
<%@ page import="by.it_academy.jd2.core.dto.Flights" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
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
            <td>${scheduledDeparture}</td>
        </c:if>
        <c:if test="${scheduledDeparture.equals('1900-01-01')}">
            <td>Параметр на задан</td>
        </c:if>

        <td>${departureAirport}</td>
        <c:if test="${!scheduledArrival.equals('1900-01-01')}">
            <td>${scheduledArrival}</td>
        </c:if>
        <c:if test="${scheduledArrival.equals('1900-01-01')}">
            <td>Параметр на задан</td>
        </c:if>

        <td>${arrivalAirport}</td>

    </tr>
    </body>
</table>
<br><br>
<hr>
<%--<% HttpSession session1 = request.getSession();--%>
<%--Connection conn = (Connection) session1.getAttribute("conn");--%>
<%--String departureAirport=(String) session1.getAttribute("departureAirport");--%>
<%--String arrivalAirport=(String)session1.getAttribute("arrivalAirport");--%>
<%--LocalDate scheduledDeparture=(LocalDate)session1.getAttribute("scheduledDeparture");--%>
<%--LocalDate scheduledArrival=(LocalDate)session1.getAttribute("scheduledArrival");--%>
<%--List<Flights> choiceFlights = AllFlights.getChoiceFlights(conn,departureAirport,arrivalAirport,scheduledDeparture,scheduledArrival);--%>

<form method="post" action="flight">

    <c:if test="${list.size()==0}">
        <p>Рейсов с заданными параметрами не найдено</p>
    </c:if>
    <c:if test="${list.size()>0}">
        <table border="2">
            <body>
            <tr>
                <td>${title.getFlight_no()}</td>
                <td>${title.getStatus()}</td>
                <td>${title.getScheduled_departure()}</td>
                <td>${title.getScheduled_arrival()}</td>
                <td>${title.getDeparture_airport()}</td>
                <td>${title.getArrival_airport()}</td>
            </tr>
            <c:forEach items="${list}"
                       var="fly">

                <tr>
                    <td>${fly.getFlight_no()}</td>
                    <td>${fly.getStatus()}</td>
                    <td>${fly.getScheduled_departure()}</td>
                    <td>${fly.getScheduled_arrival()}</td>
                    <td>${fly.getDeparture_airport()}</td>
                    <td>${fly.getArrival_airport()}</td>
                </tr>

            </c:forEach>
            </body>
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
