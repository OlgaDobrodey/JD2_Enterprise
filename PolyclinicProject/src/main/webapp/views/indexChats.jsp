<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Chat</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>

<%@include file="header.jsp" %>
<div class="container">
    <div class="main-body">

        <form method="post" action="message">
            <div class="row">
                <div class="col-4">

                    Send:<select class="form-select" name="userReceiver">
                    <optgroup label="Doctors">
                        <c:forEach var="doctor" items="${doctors}">
                            <c:if test="${doctor.username!=sessionScope.user.username}">
                                <option value="${doctor.username}"> ${doctor.surname}<br></option>
                            </c:if>
                        </c:forEach>
                    </optgroup>
                    <c:if test="${patients!=null}">
                        <optgroup label="Patients">
                            <c:forEach var="patient" items="${patients}">
                                <c:if test="${patient.username!=sessionScope.user.username}">
                                    <option value="${patient.username}"> ${patient.surname}<br></option>
                                </c:if>
                            </c:forEach></optgroup>
                    </c:if>
                </select>
                    <br><br>
                    Сообщение:<br>
                    <div>
                        <input type="text" class="form-control" name="message" placeholder="Enter text here..."/></div>
                    <br><button class="btn btn-info" type="submit">Send</button>
                    <button class="btn btn-info" type="reset">Сlear</button>
                </div>
                <div class="col-8">
                    <c:if test="${listMessages!=null}">
                    <table  class="table" >
<%--                        //table-striped table-info"--%>
                        <tbody>
                        <tr class="text-info">
                            <th width="25%" class="text-info">Date</th>
                            <th width="20%">Sender</th>
                            <th width="20%">Receiver</th>
                            <th width="35%">Message</th>
                        </tr>
                        <c:forEach var="message" items="${listMessages}">
                            <tr>
                                <td>${message.date_msg.toString().substring(0, 19)}</td>
                                <td>${message.sender.surname} ${message.sender.given_name}</td>
                                <td>${message.receiver.surname} ${message.receiver.given_name}</td>
                                <td>${message.message}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table></c:if>

                       </div>
            </div>
        </form>
    </div>
</div>


<%@include file="footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>
