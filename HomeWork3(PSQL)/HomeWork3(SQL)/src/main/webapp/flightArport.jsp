<!DOCTYPE html>

<%@ page import="by.it_academy.jd2.core.dto.tool.AllFlights" %>
<%@ page import="by.it_academy.jd2.core.dto.view.Flights" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="by.it_academy.jd2.data.ConnectionBase" %>
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

<%--    <%--%>
<%--        Connection conn = (Connection) request.getSession().getAttribute("conn");--%>
<%--        String departureAirport = (String) request.getSession().getAttribute("departureAirport");--%>
<%--        String arrivalAirport = (String) request.getSession().getAttribute("arrivalAirport");--%>
<%--        Flights title = (Flights) request.getSession().getAttribute("title");--%>
<%--        Integer pageNumber = (Integer) request.getSession().getAttribute("page");--%>


<%--    %>--%>
    <%

     Connection conn = new ConnectionBase().getConnection();
     String departureAirport = (String) request.getSession().getAttribute("departureAirport");
     String arrivalAirport = (String) request.getSession().getAttribute("arrivalAirport");
     Flights title = (Flights) request.getSession().getAttribute("title");
    Integer pageNumber = (Integer) request.getAttribute("page");
    %>



    <c:if test="${size.list!=0}">
        <h4>Страница <%=pageNumber%> из <c:out value="${sizelist}"/>
        </h4>
    </c:if>
    <c:if test="${size.list==0}">
        <h4>Страница 1
        </h4>
    </c:if>

    <%
        List<Flights> list = AllFlights.getChoiceFlightsNoDateWithPage(conn, departureAirport, arrivalAirport, pageNumber);
        conn.close();
    %>
    <%
        if (list.size() == 0) {
            out.write(" <p>Рейсов с заданными параметрами не найдено</p>");
        } else {
            out.write("  <table border=\"2\">\n" +
                    "            <body>\n" +
                    "            <tr>");
            out.write("<td width=\"20%\">" + title.getFlight_no() + "</td>");
            out.write("<td width=\"20%\">" + title.getStatus() + "</td>");
            out.write("<td width=\"20%\">" + title.getScheduled_departure() + "</td>");
            out.write("<td width=\"20%\">" + title.getScheduled_arrival() + "</td>");
            out.write("<td width=\"20%\">" + title.getDeparture_airport() + "</td>");
            out.write("<td width=\"20%\">" + title.getArrival_airport() + "</td></tr>");

            for (Flights fly : list) {
                out.write("  <tr>\n" +
                        "<td width=\"20%\">" + fly.getFlight_no() + "</td>");
                out.write("<td width=\"20%\">" + fly.getStatus() + "</td>");
                out.write("<td width=\"20%\">" + fly.getScheduled_departure() + "</td>");
                out.write("<td width=\"20%\">" + fly.getScheduled_arrival() + "</td>");
                out.write("<td width=\"20%\">" + fly.getDeparture_airport() + "</td>");
                out.write("<td width=\"20%\">" + fly.getArrival_airport() + "</td></tr>");

            }
            out.write("</body></table>");
        }
    %>

</form>
<br>

<br>
<c:if test="${sizelist!=0}">
    <form action="flight" method="get">

        <select name="page" required>
            <c:forEach var="fly" begin="1" end="${sizelist}">
                <option value="${fly}">${fly} </option>
            </c:forEach>
        </select>
        <button type="submit">
            cтраницa
        </button>


    </form>

</c:if>

<br>
<hr>

</body>
</html>