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
    <title>Flight</title>
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

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }

        button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@include file="index.jsp" %>

<main class="container">

    <h1>Список рейсов</h1>
    <table id="customers">
        <body>

        <p>Параметры поиска:</p>
        <tr>
            <th>Дата вылета</th>
            <th>Город вылета</th>
            <th>Дата прилета</th>
            <th>Город прилета</th>
        </tr>
        <tr>
            <c:if test="${!CheckString.isNullOrEmptyOrBlank(scheduledDeparture)}">
                <td width="20%">${scheduledDeparture}</td>
            </c:if>
            <td width="20%">${departureAirport}</td>
            <c:if test="${!CheckString.isNullOrEmptyOrBlank(scheduledArrival)}">
                <td width="20%">${scheduledArrival}</td>
            </c:if>
            <td width="20%">${arrivalAirport}</td>

        </tr>
        </body>
    </table>
    <br><br>
    <hr>

    <c:if test="${list.size()==0}">
        <p>Рейсов с заданными параметрами не найдено</p>
    </c:if>
    <c:if test="${list.size()>0}">
        <table id="customers">
            <thead>

            <tr>
                <th width="20%">Номер рейса/ ${title.getFlight_no()}</th>
                <th width="20%">Статус рейса/ ${title.getStatus()}</th>
                <th width="20%">Дата вылета/ ${title.getScheduled_departure()}</th>
                <th width="20%">Дата прилета/ ${title.getScheduled_arrival()}</th>
                <th width="20%">(Аэропорт)Город вылета/ ${title.getDeparture_airport()}</th>
                <th width="20%">(Аэропорт)Город Прилета/ ${title.getArrival_airport()}</th>
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


    <br>

    <form method="get" action="choice">

        <button class="button" type="submit">Назад</button>
        <br><br>
    </form>
    <br>
    <br>
    <br>
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
