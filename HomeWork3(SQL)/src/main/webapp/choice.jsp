
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.04.2021
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.it_academy.jd2.core.dto.AllAirports" %>
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
<h4>Необходимо заполнить все фильтры и нажать кнопку "Поиск"</h4>

<form method="post" action="choice">

    Дата вылета: <input type="date" name="scheduledDeparture" required/>
    Аэропорт отправления:
    <select name="departureAirport" required>
        <c:forEach var="airports" items="${AllAirports.getAllAirports()}">
          <option value="${airports.getAirport_code()}">${airports.getCity()} (${airports.getAirport_code()}) </option>
           </c:forEach>
    </select>

    Время прилета: <input type="date"  name="scheduledArrival" required />
    Аэропорт прибытия:
    <select name="arrivalAirport" required>
        <c:forEach var="airports" items="${AllAirports.getAllAirports()}">
            <option value="${airports.getAirport_code()}">${airports.getCity()} (${airports.getAirport_code()})  </option>
        </c:forEach>
    </select>
    <input type="submit" value="Поиск">
    <hr>

</form>
<p>
</p>
</body>
</html>
