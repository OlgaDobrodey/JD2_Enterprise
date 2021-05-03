<!DOCTYPE html>


<%@ page import="by.it_academy.jd2.core.dto.view.Flights" %>
<%@ page import="java.util.List" %>
<%@ page import="by.it_academy.jd2.core.utils.Constants" %>
<%@ page import="by.it_academy.jd2.core.dto.tool.api.AllFlightsInt" %>
<%@ page import="by.it_academy.jd2.data.DaoFactory" %>
<%@ page import="static by.it_academy.jd2.data.DataConnectionName.HIBERNATE" %>
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
<body>
<%@include file="index.jsp" %>

<main class="container">
<h1>Список рейсов</h1>
<table id="customers">
    <body>

    <p>Параметры поиска:</p>
    <tr>

        <th>Город отправления </th>
        <th>${departureAirport}</th>
        <th>Город прилета   </th>
        <th>${arrivalAirport}</th>

    </tr>
    </body>
</table>
<br>
<p><input  type="button" onclick="location.href='${pageContext.request.contextPath}/choice';" value="Назад"; method="get" /></p>
<br>
<hr>




    <%

        String departureAirport = (String) request.getSession().getAttribute(Constants.DEP_AIRPORT);
        String arrivalAirport = (String) request.getSession().getAttribute(Constants.ARR_AIRPORT);
        Flights title = (Flights) request.getSession().getAttribute("title");
        Integer pageNumber = (Integer) request.getAttribute("page");
    %>


    <c:if test="${sizelist!=0}">
        <h4>Страница <%=pageNumber%> из <c:out value="${sizelist}"/>
        </h4>
    </c:if>


    <%
        AllFlightsInt allFlightsInt = DaoFactory.getInstanceFlights(HIBERNATE);
        List<Flights> list = allFlightsInt.getChoiceFlightsNoDateWithPage(departureAirport, arrivalAirport, pageNumber);

    %>
    <%
        if (list.size() == 0) {
            out.write(" <p>Рейсов с заданными параметрами не найдено</p>");
        } else {
            out.write("  <table id=\"customers\"\">\n" +
                    "             <thead>\n" +
                    "            <tr>");
            out.write("<th width=\"20%\">" + title.getFlight_no() + "</th>");
            out.write("<th width=\"20%\">" + title.getStatus() + "</th>");
            out.write("<th width=\"20%\">" + title.getScheduled_departure() + "</th>");
            out.write("<th width=\"20%\">" + title.getScheduled_arrival() + "</th>");
            out.write("<th width=\"20%\">" + title.getDeparture_airport() + "</th>");
            out.write("<th width=\"20%\">" + title.getArrival_airport() + "</th></tr> </thead>");

            for (Flights fly : list) {
                out.write("  <tbody><tr>\n" +
                        "<td width=\"20%\">" + fly.getFlight_no() + "</td>");
                out.write("<td width=\"20%\">" + fly.getStatus() + "</td>");
                out.write("<td width=\"20%\">" + fly.getScheduled_departure() + "</td>");
                out.write("<td width=\"20%\">" + fly.getScheduled_arrival() + "</td>");
                out.write("<td width=\"20%\">" + fly.getDeparture_airport() + "</td>");
                out.write("<td width=\"20%\">" + fly.getArrival_airport() + "</td></tr><tbody>");

            }
            out.write("</table>");
        }
    %>


<br>

<br>
<c:if test="${sizelist!=0}">
    <form action="flight" method="post">

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