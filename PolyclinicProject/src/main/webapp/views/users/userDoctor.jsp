<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Doctor Acount</title>
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
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin"
                                 class="rounded-circle p-1 bg-info" width="110">
                            <div class="mt-3">
                                <h4>${sessionScope.user.surname} ${sessionScope.user.given_name}</h4>
                                <p class="text-info mb-1">${sessionScope.user.role} ${sessionScope.user.position}</p>
                                <p class="text-info mb-1">Medical cart number</p>
                                <p class="text-info mb-1">${sessionScope.user.madical_card}</p>
                                <p><input type="button" class="btn btn-info"
                                          onclick="location.href='${pageContext.request.contextPath}/chat';"
                                          value="Message"/></p>
                            </div>
                        </div>

                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <a class="text-info" aria-current="page"
                                   href="${pageContext.request.contextPath}/${sessionScope.user.login}">My acount</a>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <a class="text-info" aria-current="page"
                                   href="${pageContext.request.contextPath}/${sessionScope.user.login}/medicalCart">Medical
                                    cart</a>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <a class="text-info" aria-current="page"
                                   href="${pageContext.request.contextPath}/newUser">New Patient</a>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <a class="text-info" aria-current="page"
                                   href="${pageContext.request.contextPath}/allPatients">All Patients</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
                <%--    number 2--%>


                <c:choose>

                    <c:when test="${requestScope.history != null}">
                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="text-center">${sessionScope.user.surname} ${sessionScope.user.given_name}
                                                doctort's medical card</h5></div>
                                    </div>
                                    <p><input type="button" class="btn btn-info"
                                              onclick="location.href='${pageContext.request.contextPath}/${sessionScope.user.login}/newNote';"
                                              value="New note"/></p>
                                    <c:if test="${history.size()==0}">
                                        <div class="row">
                                            <div class="col"><br><h4 class="text-center">The medical card is empty</h4>
                                            </div>
                                        </div>
                                    </c:if>
                                    <table class="table table-striped table-info">
                                        <tbody>
                                        <tr>
                                            <th>Patient's full name</th>
                                            <th>Diagnosis</th>
                                            <th>Status</th>
                                        </tr>
                                        <c:forEach var="card" items="${history.keySet()}">


                                            <tr>
                                                <td>${card.patient.surname}</td>
                                                <td><a class="link-dark" href="${pageContext.request.contextPath}/${card.patient.login}/medicalCart/${card.id}">${card.diagnosis}</a></td>
                                                <td>${history.get(card)}</td>

                                            </tr>

                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <h5 class="text-center"> Contacts</h5></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Surname</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.surname}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Given name</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.given_name}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Position</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.position}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Phone</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.phone}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Email</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.email}</p></div>
                                    </div>
                                </div>
                            </div>

                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col"><h5 class="text-center"> Address</h5></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>City</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.addresses.city}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Street</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.addresses.street}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>House</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.addresses.house}</p></div>
                                    </div>
                                    <div class="row">
                                        <div class="col"><h6>Flat</h6></div>
                                        <div class="col"><p class="text-dark">${sessionScope.user.addresses.flat}</p></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${sessionScope.passport != null}">
                                            <div class="row">
                                                <div class="col">
                                                    <h5 class="text-center"> Passport</h5></div>
                                            </div>
                                            <div class="row">
                                                <div class="col"><h6>ID Passport</h6></div>
                                                <div class="col"><p class="text-dark">${passport.id_passport}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Identification</h6></div>
                                                <div class="col"><p class="text-dark">${passport.identification}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Code State</h6></div>
                                                <div class="col"><p class="text-dark">${passport.code_state}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Nationality</h6></div>
                                                <div class="col"><p class="text-dark">${passport.nationality}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Date Birthday</h6></div>
                                                <div class="col"><p class="text-dark">${passport.date_birthday}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Place Birth</h6></div>
                                                <div class="col"><p class="text-dark">${passport.place_birth}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Sex</h6></div>
                                                <div class="col"><p class="text-dark">${passport.sex}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Data Issue</h6></div>
                                                <div class="col"><p class="text-dark">${passport.data_issue}</p></div>
                                            </div>

                                            <div class="row">
                                                <div class="col"><h6>Data Expiry</h6></div>
                                                <div class="col"><p class="text-dark">${passport.data_expiry}</p></div>
                                            </div>


                                        </c:when>
                                        <c:otherwise>
                                            <p>Passport not find</p>
                                        </c:otherwise>
                                    </c:choose>


                                </div>
                            </div>
                        </div>

                    </c:otherwise>
                </c:choose>


                <%--end row three colon--%>
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
