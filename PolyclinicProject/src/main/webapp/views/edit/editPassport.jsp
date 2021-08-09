<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role" %>
<%@ page import="by.it_academy.jd2.core.model.people.Passport" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edit Passport</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function sendPassport() {

        var passport = {
            "id_passport": $("#id_passport").val(),
            "identification": $("#identification").val(),
            "code_state": $("#code_state").val(),
            "nationality": $("#nationality").val(),
             "date_birthday": $("#date_birthday").val(),
            "sex": $("#sex").val(),
            "data_issue": $("#data_issue").val(),
            "data_expiry": $("#data_expiry").val(),
            "place_birth": $("#place_birth").val(),
            "users": $("#user").val(),

        };
        $.ajax({
            type: "PATCH",
            url: "${pageContext.request.contextPath}/passports/" +${passport.id},
            data: JSON.stringify(passport),
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/passports";
                alert(responseData.responseText);
            },
            error: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/passports",
                    alert(responseData.responseText);
            },
        });
    }
</script>

<c:if test="${sessionScope.user.role==Role.ADMIN}">
<div class="container">
    <h4 class="text-info text-center">Update new passport</h4>
    <h6 class="text-danger text-center">${MessagePassport}</h6>

    <div class="row">
        <div class="col-lg-4">
            <div class="mb-3">
                <label for="id_passport" class="form-label">ID Passport</label>
                <input type="text" name="id_passport" class="form-control" id="id_passport"
                       placeholder="BM1234567" pattern="[A-Z]{2}\d{7}"
                       value="${passport.id_passport}" required>
            </div>

            <div class="mb-3">
                <label for="identification" class="form-label">Identification</label>
                <input type="text" name="identification" class="form-control" id="identification"
                       placeholder="BM1234567d5e66" pattern="[A-Z0-9]{14}"
                       value="${passport.identification}" required>
            </div>
            <div class="mb-3">
                <label for="code_state" class="form-label">Code State</label>
                <input type="text" name="code_state" class="form-control" id="code_state"
                       placeholder="DDD" pattern="[A-Z]{3}"
                       value="${passport.code_state}"
                       required>
            </div>
            <div class="mb-3">
                <label for="nationality" class="form-label">Nationality</label>
                <input type="text" name="nationality" class="form-control" id="nationality"
                       value="${passport.nationality}"
                       required>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="mb-3">
                <label for="date_birthday" class="form-label">Date Birthday</label>
                <input type="date" name="date_birthday" class="form-control" id="date_birthday"
                       value="${passport.date_birthday}"
                       required>
            </div>
            <div class="mb-3">
                <label for="place_birth" class="form-label">Place Birthday</label>
                <input type="text" name="place_birth" class="form-control" id="place_birth"
                       value="${passport.place_birth}"
                       required>
            </div>
            <div class="mb-3">
                <label for="data_issue" class="form-label">Date Issue</label>
                <input type="date" name="data_issue" class="form-control" id="data_issue"
                       value="${passport.data_issue}"
                       required>
            </div>
            <div class="mb-3">
                <label for="data_expiry" class="form-label">Date Expiry</label>
                <input type="date" name="data_expiry" class="form-control" id="data_expiry"
                       value="${passport.data_expiry}"
                       required>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="mb-3">
                <label for="sex" class="form-label">SEX</label>
                <select class="form-select" name="sex" id="sex" aria-label="Default select example">
                    <option value="${passport.sex}">${passport.sex}</option>
                    <c:forEach var="s" items="${sexList}">
                        <option value="${s}">${s}<br></option>
                    </c:forEach>
                </select></div>
            <div class="mb-3">
                <label for="user" class="form-label">USER</label>
                <select class="form-select" name="user" id="user" aria-label="Default select example">
                    <option value="${passport.users.username}">${passport.users.surname} ${passport.users.given_name}(${passport.users.role})</option>
                    <c:forEach var="list" items="${userList}">
                        <option value="${list.username}">
                            (${list.username})${list.surname} ${list.given_name}(${list.role})<br></option>
                    </c:forEach>
                </select></div>

        </div>
    </div>
    <button type="button" class="btn btn-info" onclick="sendPassport()"> Update</button>
    <br><br>
        <%--        onclick="sendPassport()--%>
        <%--    </form>--%>

    </c:if>


    <%@include file="../footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>

</html>
