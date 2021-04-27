
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.04.2021
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.it_academy.jd2.core.dto.tool.AllAirports" %>
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
<p>Выбор даты по желанию. Если дата не будет изменена с 01-01-1900, то в выборке она участвовать не будет</p>

<h4> Чтобы получить результат нажмите кнопку "Поиск"</h4>

<form method="post" action="choice">
<%--<form method="get" action="print">--%>


    Дата вылета: <input type="date" name="scheduledDeparture" value="1900-01-01"/>
    Аэропорт отправления:
    <select name="departureAirport" required>
        <c:forEach var="airports" items="${listB}">
          <option value="${airports}">${airports} </option>
           </c:forEach>
    </select>

    Время прилета: <input type="date"  name="scheduledArrival" value="1900-01-01"/>
    Аэропорт прибытия:
    <select name="arrivalAirport" required>
        <c:forEach var="airports" items="${listB}">
            <option value="${airports}">${airports} </option>
        </c:forEach>
    </select>
    <button onclick="myFunction()">Поиск</button>

    <hr>
    <script>
        function myFunction() {
            document.getElementById("scheduledDeparture").defaultValue = "1900-01-01";
            document.getElementById("scheduledArrival").defaultValue = "1900-01-01";
        }
    </script>
</form>

</body>
</html>
