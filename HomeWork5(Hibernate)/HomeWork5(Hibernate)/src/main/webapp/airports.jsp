<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <c:set var="contextPath" value="${pageContext.request.contextPath}/"/>
    <title>Airports</title>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
<%@include file="index.jsp" %>

<main class="container">

    <h1>Список аэропортов с сортировкой по городу</h1>
    <%--<form action="index.jsp">--%>
    <%--    <button type="submit">Назад</button>--%>

    <%--</form>--%>
    <br>
    <table id="customers">
        <thead>
        <tr>

            <th width="10%">${title.getAirport_code()}</th>
            <th width="20%">${title.getAirport_name()}</th>
            <th width="20%">${title.getCity()}</th>
            <th width="30%">${title.getCoordinates()}</th>
            <th width="20%">${title.getTimesone()}</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listAirports}" var="airport">
            <tr>

                <td width="10%">${airport.getAirport_code()}</td>
                <td width="20%">${airport.getAirport_name()}</td>
                <td width="20%">${airport.getCity()}</td>
                <td width="30%">${airport.getCoordinates()}</td>
                <td width="20%">${airport.getTimesone()}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</main>
<footer>
    <hr>
    <p align="center">
        <small>
            <time>04-2021</time>
            © Dobrodey Volha
        </small>

    </p>
</footer>

</body>
</html>
