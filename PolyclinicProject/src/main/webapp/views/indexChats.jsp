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


<form method="post" action="message">

    Кому:<select name="userReceiver">
    <optgroup label="Доктора">
        <c:forEach var="doctor" items="${doctors}">
            <option value="${doctor.login}"> ${doctor.surname}<br></option>
        </c:forEach>
    </optgroup>
    <c:if test="${patients!=null}">
        <optgroup label="Пациенты">
            <c:forEach var="patient" items="${patients}">
                <option value="${patient.login}"> ${patient.surname}<br></option>
            </c:forEach></optgroup>
    </c:if>

</select>

    <br><br>

    Сообщение:<br>
    <input type="text" name="message"/>
    <br><br>

    <button type="submit">Отправить</button>
    <button type="reset">Очистить</button>
</form>

<c:forEach var="message" items="${listMessages}">
    <td>${message.id_message}</td>
    <td>${message.sender.surname}</td>
    <td>${message.receiver.surname}</td>
    <td>${message.message}</td>
    <td>${message.date_msg.toString().substring(0, 19)}</td>
    <br>
</c:forEach>

<%@include file="footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>

</body>
</html>
