<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import=" by.it_academy.jd2.core.model.medical.Status" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>New note</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<main class="container">

    <form action="newNote" method="post" required>
        <br><h4 class="text-info text-center">CREATE A NEW DIAGNOSIS</h4>
        <p><input type="button" class="btn btn-info"
                  onclick="location.href='${pageContext.request.contextPath}/${sessionScope.user.username}/medicalCart';"
                  value="Back Medical Card"/></p>
        <div class="mb-3">
            <label for="doctor" class="form-label">Doctor</label>
            <select class="form-select" name="doctor" id="doctor" aria-label="Default select example">
                <c:forEach var="doc" items="${doctors}">
                    <option value="${doc.username}"> ${doc.surname} ${doc.given_name}<br></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="patient" class="form-label">Patient</label>
            <select class="form-select" name="patient" id="patient" aria-label="Default select example">
                <c:forEach var="pat" items="${patients}">
                    <option value="${pat.username}"> ${pat.surname} ${pat.given_name}<br></option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="diagnosis" class="form-label">Diagnosis</label>
            <input type="text" name="diagnosis" class="form-control" id="diagnosis">
        </div>
        <div class="mb-3">
            <label for="prescription" class="form-label">Prescription</label>
            <input type="text" name="prescription" class="form-control" id="prescription">
        </div>
        <div class="mb-3">
            <label for="status" class="form-label">Status</label>
            <select class="form-select" name="status" id="status" aria-label="Default select example">
                <option value="${Status.POSITIV}">${Status.POSITIV}</option>
                <option value="${Status.NEGATIV}">${Status.NEGATIV}</option>
            </select>
        </div>
        <button type="submit" class="btn btn-info">SAVE</button>
    </form>
    <c:if test="${cardSave!=null}">
        <table class="table table-striped table-info">
            <tbody>
            <tr>
                <th>ID</th>
                <td>${cardSave.id}</td>
                <th>Doctor</th>
                <td>${cardSave.doctor.surname} ${cardSave.doctor.given_name}</td>
                <th>Patient</th>
                <td>${cardSave.patient.surname} ${cardSave.patient.given_name}</td>
                <th>Diagnosis</th>
                <td>${cardSave.diagnosis}</td>
            </tr>
            <br>
            </tbody>
        </table>
    </c:if>
    <c:if test="${diagnosisSave!=null}">
        <table class="table table-striped table-info">
            <tbody>
            <tr>
                <th>Date</th>
                <th>Prescription</th>
                <th>Status</th>
            </tr>
            <tr>
                <td>${diagnosisSave.date}</td>
                <td>${diagnosisSave.prescription}</td>
                <td>${diagnosisSave.status}</td>
            </tr>

            </tbody>
        </table>
    </c:if>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<%@include file="../footer.jsp" %>
</body>
</html>
