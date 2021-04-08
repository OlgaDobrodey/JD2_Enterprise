<!DOCTYPE html>
<%@ page import="by.it_academy.jd2.core.dto.AllAirports" %>
<%@ page import="by.it_academy.jd2.core.dto.Airports" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Airports</title>
</head>
<body>
<h1>Список аэропортов с сортировкой по городу</h1>
<table border="2">
<body>
<form action="airports" method="post">
    <tr>

        <td width="10%">${title.getAirport_code()}</td>
        <td width="20%">${title.getAirport_name()}</td>
        <td width="20%">${title.getCity()}</td>
        <td width="30%">${title.getCoordinates()}</td>
        <td width="20%">${title.getTimesone()}</td>

    </tr>

    <c:forEach items="${AllAirports.getAllAirports()}"
               var="airports">
        <tr>

            <td width="10%">${airports.getAirport_code()}</td>
            <td width="20%">${airports.getAirport_name()}</td>
            <td width="20%">${airports.getCity()}</td>
            <td width="30%">${airports.getCoordinates()}</td>
            <td width="20%">${airports.getTimesone()}</td>

        </tr>
    </c:forEach>
    </form>
    </body>
    </table>
    </body>
    </html>
