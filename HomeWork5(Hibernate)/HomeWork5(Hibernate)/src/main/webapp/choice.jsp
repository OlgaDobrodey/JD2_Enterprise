
<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Choice</title>
    <link rel="stylesheet" href="static/css/style.css">

</head>
<body class="d-flex flex-column h-100">
<%@include file="index.jsp"%>

<main class="container">

<p><img src="img/1068.jpg" alt="самолет" width="200"></p>
<h4>Аэропорт отправления и прибытия выбрать обязательно.</h4>
<p>Выбор любой из дат по желанию. </p>



<form method="get" action="flight">

    <h4>Отправление</h4>
    <label for="dateDep">Дата и время вылета:</label>
    <input type="date" id="dateDep" name="scheduledDeparture"/>

    <label for="countryDep">Аэропорт отправления:</label>
    <select id="countryDep" name="departureAirport" required>
        <c:forEach var="airports" items="${listNameAirports}">
            <option value="${airports}">${airports}</option>
        </c:forEach>
    </select>

    <h4>Прибытие</h4>
    <label for="dateArr">Дата и время вылета:</label>
    <input type="date" id="dateArr" name="scheduledArrival"/>

    <label for="countryArr">Аэропорт отправления:</label>
    <select id="countryArr" name="arrivalAirport"  required>
        <c:forEach var="airports" items="${listNameAirports}">
            <option value="${airports}">${airports}</option>
        </c:forEach>
    </select>
    <br>
    <p> Чтобы получить результат нажмите кнопку "Поиск"</p>
    <input type="submit" value="Поиск">

</form>
<br>
<br>
<br>
</main>
<footer>
    <hr>
    <p align="center">
        <small>
            <time>04-2021</time> © Dobrodey Volha
        </small>

    </p>
</footer>
</body>
</html>
