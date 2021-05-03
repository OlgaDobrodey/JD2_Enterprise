
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
</head>
<body>

<h4><span style='color: red;'>Форма выбора рейса!</span></h4>
<p><img src="img/1068.jpg" alt="самолет" width="200"></p>
<h4>Аэропорт отправления и прибытия выбрать обязательно.</h4>
<p>Выбор любой из дат по желанию. </p>

<h4> Чтобы получить результат нажмите кнопку "Поиск"</h4>

<form method="post" action="choice">


    Дата вылета: <input type="date" name="scheduledDeparture"/>
    Аэропорт отправления:
    <select name="departureAirport" required>
        <c:forEach var="airports" items="${listNameAirports}">
            <option value="${airports}">${airports}</option>
        </c:forEach>
    </select>

    Время прилета: <input type="date"  name="scheduledArrival" />

    Аэропорт прибытия:
    <select name="arrivalAirport" required>
        <c:forEach var="airports" items="${listNameAirports}">
            <option value="${airports}">${airports} </option>
        </c:forEach>
    </select>
    <button >Поиск</button>

</form>
<br>
<br>
<br>
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
