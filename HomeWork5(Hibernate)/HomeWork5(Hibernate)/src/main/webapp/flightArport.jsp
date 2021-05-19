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

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .pagination {
            display: inline-block;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;

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

            <th>Город отправления</th>
            <td>${departureAirport}</td>
            <th>Город прилета</th>
            <td>${arrivalAirport}</td>

        </tr>
        </body>
    </table>

    <%

        String departureAirport = (String) request.getSession().getAttribute(Constants.DEP_AIRPORT);
        String arrivalAirport = (String) request.getSession().getAttribute(Constants.ARR_AIRPORT);
        Flights title = (Flights) request.getSession().getAttribute("title");
        Integer pageNumber = (Integer) request.getAttribute("page");
    %>

    <br>
    <c:if test="${sizelist!=0}">
        <h4>Страница <%=pageNumber%> из <c:out value="${sizelist}"/>
        </h4>
    </c:if>
    <br>


    <%
        AllFlightsInt allFlightsInt = DaoFactory.getInstanceFlights(HIBERNATE);
        List<Flights> list = allFlightsInt.getChoiceFlightsNoDateWithPage(departureAirport, arrivalAirport, pageNumber);

    %>
    <%
        if (list.size() == 0) {
            out.write(" <p>Рейсов с заданными параметрами не найдено</p>");
        } else {
    %>
    <table id="customers">
        <thead>
        <tr>
            <th><%=title.getFlight_no()%>
            </th>
            <th><%=title.getStatus()%>
            </th>
            <th><%=title.getScheduled_departure()%>
            </th>
            <th><%=title.getScheduled_arrival()%>
            </th>
            <th><%=title.getDeparture_airport()%>
            </th>
            <th><%=title.getArrival_airport() %>
            </th>

        </tr>
        </thead>
        <%}%>


        <tbody>
            <%
                for (Flights fly : list) {%>
        <tr>

            <td><%=fly.getFlight_no()%>
            </td>
            <td><%=fly.getStatus()%>
            </td>
            <td><%=fly.getScheduled_departure()%>
            </td>
            <td><%=fly.getScheduled_arrival()%>
            </td>
            <td><%=fly.getDeparture_airport()%>
            </td>
            <td><%=fly.getArrival_airport() %>
            </td>

        </tr>
            <% }%>
        <tbody>
    </table>


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


        <div class="pagination">
            <c:if test="${(page>1)}">
            <a href="${pageContext.request.contextPath}/flight?scheduledDeparture=&departureAirport=<%=departureAirport%>&scheduledArrival=&arrivalAirport=<%=arrivalAirport%>&page=<%=(pageNumber-1)%>">❮</a>
            </c:if>
            <c:if test="${(page<sizelist)}">
            <a href="${pageContext.request.contextPath}/flight?scheduledDeparture=&departureAirport=<%=departureAirport%>&scheduledArrival=&arrivalAirport=<%=arrivalAirport%>&page=<%=(pageNumber+1)%>">❯</a>
            </c:if>
        </div>


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
            <time>04-2021</time>
            © Dobrodey Volha
        </small>

    </p>

</footer>
</body>
</html>