<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"--%>
<%--      rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"--%>
<%--      crossorigin="anonymous">--%>

<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">POLYCLINIC</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/Home">HOME</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/AboutUs">ABOUT
                            US</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/Departments">DEPARTMENTS</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/Disease">DISEASE</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/Contact">CONTACT</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/allPassports">Passports</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page"
                           href="${pageContext.request.contextPath}/allAddress">Address</a>
                    </li>

                </ul>
                <ul class="nav justify-content-end" style="margin-right: 50px;">
                    <c:choose>
                        <c:when test="${sessionScope.user == null}">

                            <li class="nav-item">
                                <a class="nav-link"  aria-current="page"
                                   href="${pageContext.request.contextPath}/signIn">Sign In</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" aria-current="page"
                                   href="${pageContext.request.contextPath}/chat">CHAT</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="logUser" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                        ${sessionScope.user.login}
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="logUser">
                                    <li><a class="dropdown-item"
                                           href="${pageContext.request.contextPath}/${sessionScope.user.login}"
                                           methods="get">Acount</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/signIn"
                                           methods="get">Exit</a></li>

                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </ul>

            </div>
        </div>
    </nav>
</header>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--        crossorigin="anonymous"></script>--%>

