
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
<link href="static/css/navbar.css" rel="stylesheet">

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-xxl">
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/airports">Аэропорты</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/choice">Поиск рейсов</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="${pageContext.request.contextPath}/flight?scheduledDeparture=&departureAirport=Воронеж&scheduledArrival=&arrivalAirport=Москва">Moskov to Voronezh
                            to ROV</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="${pageContext.request.contextPath}/flight?scheduledDeparture=2017-02-03&departureAirport=Воронеж&scheduledArrival=2017-02-03&arrivalAirport=Москва">Moskov to Voronezh
                            on 03.02.2017</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="${pageContext.request.contextPath}/flight?scheduledDeparture=2017-02-03&departureAirport=Воронеж&scheduledArrival=&arrivalAirport=Москва">Moskov to Voronezh one date
                            on 03.02.2017</a>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</header>
