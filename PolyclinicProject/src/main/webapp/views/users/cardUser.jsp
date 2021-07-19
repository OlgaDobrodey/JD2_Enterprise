<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role"%>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.userCard.surname} ${requestScope.userCard.given_name}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="container">
    <div class="main-body">
        <div class="row">
            <%--            start row three colon, number 1--%>
            <div class="col-lg-4">

                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="${userCard.link}" alt="${userCard.surname}"
                                 class="rounded-circle p-1 bg-info" width="110">
                            <div class="mt-3">
                                <h4>${userCard.surname} ${userCard.given_name}</h4>
                                <p class="text-info mb-1">${userCard.role}</p>
<%--                                <p class="text-info mb-1">Medical cart number ${userCard.madical_card}</p>--%>
                                <p class="text-info mb-1">Position ${userCard.position}</p>

                                <%--                                <p><input type="button" class="btn btn-info"--%>
                                <%--                                          onclick="location.href='${pageContext.request.contextPath}/chat';"--%>
                                <%--                                          value="Message"/></p>--%>
                            </div>

                </div>
            </div>
            <div class="col-lg-8">

                        <div class="row">
                            <div class="col">
                                <h5>Contact</h5></div>
                        </div>
                        <div class="row">
                            <table class="table table-striped table-info">
                                <tbody>
                                <tr>
                                    <th>Phone</th>
                                    <td>${userCard.phone}</td>

                                </tr>
                                <tr>
                                    <th>Email</th>
                                    <td>${userCard.email}</td>

                                </tr>
                                </tbody></table>
                        </div>
                        <div class="row">
                            <div class="col"><h5>Address</h5></div>
                        </div>
                        <div class="row">
                            <table class="table table-striped table-info">
                                <tbody>
                                <tr>
                                    <th>City</th>
                                    <td>${requestScope.userCard.addresses.city}</td>

                                </tr>
                                <tr>
                                    <th>Street</th>
                                    <td>${requestScope.userCard.addresses.street}</td>

                                </tr>
                                <tr>
                                    <th>House</th>
                                    <td>${requestScope.userCard.addresses.house}</td>

                                </tr>
                                <tr>
                                    <th>Flat</th>
                                    <td>${requestScope.userCard.addresses.flat}</td>

                                </tr>
                                </tbody></table>

                        </div>

            </div>
        </div>
        <div class="row">
            <div class="col">
<c:if test="${requestScope.doctor==null}">
                <div class="row">
                    <div class="col">
                        <h4>Passport</h4></div>
                </div>
                <div class="row">

                    <table class="table table-striped table-info">
                        <tbody>
                        <tr>
                            <th>ID Passport</th>
                            <td>${requestScope.passport.id_passport}</td>
                            <th>Identification</th>
                            <td>${requestScope.passport.identification}</td>
                        </tr>
                        <tr>
                            <th>Code State</th>
                            <td>${requestScope.passport.code_state}</td>
                            <th>Nationality</th>
                            <td>${requestScope.passport.nationality}</td>
                        </tr>
                        <tr>
                            <th>Date Birthday</th>
                            <td>${requestScope.passport.date_birthday}</td>
                            <th>Place Birthday</th>
                            <td>${requestScope.passport.place_birth}</td>
                        </tr>
                        <tr>
                            <th>Date Issue</th>
                            <td>${requestScope.passport.data_issue}</td>
                            <th>Date Expiry</th>
                            <td>${requestScope.passport.data_expiry}</td>
                        </tr>
                        <tr>
                            <th>Sex</th>
                            <td>${requestScope.passport.sex}</td>
                            <th></th>
                            <td></td>
                        </tr>
                        </tbody></table>

                </div>

</c:if>
            </div>
        </div>
<c:if test="${requestScope.doctor==null}">

        <div class="row">
            <div class="col">
                <div class="row">
                            <div class="col">
                                <h5 class="text-center">${userCard.surname} ${userCard.given_name}'s medical card</h5><br>
                            </div>
                        </div>
                        <c:if test="${history.size()==0}">
                            <div class="row">
                                <div class="col"><br><h4 class="text-center">The medical card is empty</h4>
                                </div>
                            </div>
                        </c:if>
                        <c:forEach var="card" items="${history.keySet()}">
                            <div class="row">
                                <div class="col"><h6>Doctor:</h6></div>
                                <div class="col"><h6>${card.doctor.surname} ${card.doctor.given_name}</h6></div>
                                <div class="col"><h6>Patient:</h6></div>
                                <div class="col"><h6>${card.patient.surname} ${card.patient.surname}</h6></div>
                                <div class="col"><h6>Diagnosis:</h6></div>
                                <div class="col"><h6>${card.diagnosis}</h6></div>
                            </div>
                            <br>
                            <table class="table table-striped table-info">
                                <tbody>
                                <tr>
                                    <th>Data</th>
                                    <th>Prescription</th>
                                    <th>Status</th>
                                </tr>
                                <c:forEach var="diagnosis" items="${history.get(card)}">
                                    <tr>
                                        <td>${diagnosis.date}</td>
                                        <td>${diagnosis.prescription}</td>
                                        <td>${diagnosis.status}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:forEach>

                    </div>
        </div></c:if>
        <div class="row">
            <div class="col">

                <h6>${requestScope.userCard.info}</h6>
            </div>
        </div>
            </div>
        </div>




<style type="text/css">
    body {
        background: #f7f7ff;
        margin-top: 20px;
    }

    .card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 0 solid transparent;
        border-radius: .25rem;
        margin-bottom: 1.5rem;
        box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<%@include file="../footer.jsp" %>
</body>
</html>
