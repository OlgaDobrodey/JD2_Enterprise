<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Поиск рейсов</title>
    </head>
    <body>
        <form method="POST">
            Аэропорт вылета:
            <select name="airport_out">
                <option value="">Не выбрано</option>
                <c:forEach items="${requestScope.airports}"
                                       var="airport">
                    <option value="${airport.code}"

                    <c:choose>
                        <c:when test="${airport.code == requestScope.currentAirportOut}">
                            selected="true"
                        </c:when>
                    </c:choose>

                    >${airport.name}</option>
                </c:forEach>
            </select>

            Аэропорт прилёта:
            <select name="airport_in">
                <option value="">Не выбрано</option>
                <c:forEach items="${requestScope.airports}"
                                       var="airport">
                    <option value="${airport.code}"

                    <c:choose>
                        <c:when test="${airport.code == requestScope.currentAirportIn}">
                            selected="true"
                        </c:when>
                    </c:choose>

                    >${airport.name}</option>

               </c:forEach>
            </select>
            <input type="submit" value="Фильтровать"/>

            <c:choose>
                <c:when test="${requestScope.flying != null }">
                    <table border="1">
                        <tbody>
                            <c:forEach items="${requestScope.flying}"
                                       var="fly">
                                <tr>
                                    <td>${fly.flightNo}</td>
                                    <td>${fly.scheduledDeparture}</td>
                                    <td>${fly.scheduledArrival}</td>
                                    <td>${fly.departureAirport}</td>
                                    <td>${fly.arrivalAirport}</td>
                                    <td>${fly.status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <c:choose>
                        <c:when test="${requestScope.maxCountFlying <= 20 && requestScope.maxCountFlying > 0}">
                            У нас всего одна страница
                        </c:when>
                        <c:when test="${requestScope.maxCountFlying > 20}">
                            <%
                                int maxPage = (int) Math.ceil((long) request.getAttribute("maxCountFlying") / 20.0);
                                int minFirstPage = 1;
                                int countButtonPageAround = 5;
                                int currentPage = (int) request.getAttribute("currentPage");
                                int from = Math.max(currentPage - countButtonPageAround, minFirstPage);
                                int to = Math.min(maxPage, currentPage + countButtonPageAround);
                                for(int i =  from; i <= to; i++) {
                                    out.write("<input type='submit' name='page' value='" + i + "'/>");
                                }
                            %>
                        </c:when>
                        <c:otherwise>
                            Нет данных для отображения
                        </c:otherwise>
                    </c:choose>
                </c:when>
            </c:choose>
        </form>


        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>
    </body>
</html>