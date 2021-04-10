<!DOCTYPE html>

<%@ page import="by.it_academy.jd2.core.dto.AllFlights" %>
<%@ page import="by.it_academy.jd2.core.dto.Flights" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h1>Список рейсов</h1>
<table border="1">
    <body>

    <p>Параметры поиска:</p>
    <tr>

        <td>Аэропорт отправления</td>
        <td>${departureAirport}</td>
        <td>Аэропорт прилета</td>
        <td>${arrivalAirport}</td>

    </tr>
    </body>
</table>
<form method="get" action="choice">

    <button type="submit">Назад</button>
    <br>
</form>
<br>
<hr>


<form method="post" action="flight">

    <%
        Connection conn = (Connection) request.getSession().getAttribute("conn");
        String departureAirport = (String) request.getSession().getAttribute("departureAirport");
        String arrivalAirport = (String) request.getSession().getAttribute("arrivalAirport");

        final Flights title = (Flights) request.getSession().getAttribute("title");
        Integer pageNumber = (Integer) request.getSession().getAttribute("page");


    %>
    <h4>Страница <%=pageNumber%> из <c:out value="${sizelist}"/>
    </h4>
    <%
        List<Flights> list = AllFlights.getChoiceFlightsNoDateWithPage(conn, departureAirport, arrivalAirport, pageNumber);

    %>
    <%
        if (list.size() == 0) {
            out.write(" <p>Рейсов с заданными параметрами не найдено</p>");
        } else {
            out.write("  <table border=\"2\">\n" +
                    "            <body>\n" +
                    "            <tr>");
            out.write("<td>" + title.getFlight_no() + "</td>");
            out.write("<td>" + title.getStatus() + "</td>");
            out.write("<td>" + title.getScheduled_departure() + "</td>");
            out.write("<td>" + title.getScheduled_arrival() + "</td>");
            out.write("<td>" + title.getDeparture_airport() + "</td>");
            out.write("<td>" + title.getArrival_airport() + "</td></tr>");

            for (Flights fly : list) {
                out.write("  <tr>\n" +
                        "<td>" + fly.getFlight_no() + "</td>");
                out.write("<td>" + fly.getStatus() + "</td>");
                out.write("<td>" + fly.getScheduled_departure() + "</td>");
                out.write("<td>" + fly.getScheduled_arrival() + "</td>");
                out.write("<td>" + fly.getDeparture_airport() + "</td>");
                out.write("<td>" + fly.getArrival_airport() + "</td></tr>");

            }
            out.write("</body></table>");
        }
    %>

</form>
<br>
<c:if test="${page!=1}">
    <form action="flight" method="post">
        <button type="submit">
            Предыдущая №<%=pageNumber - 1%>
        </button>
        <br>
    </form>
</c:if>

<br>
<c:if test="${page<sizelist}">
<form action="flight" method="get">
    <button type="submit">
             Следующая страницa №<%=pageNumber + 1%>
    </button>
    <br>
</form>
</c:if>

<br>
<hr>

</body>
</html>