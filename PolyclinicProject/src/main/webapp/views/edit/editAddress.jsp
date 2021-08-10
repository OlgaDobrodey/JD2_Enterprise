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
    <title>Edit Address</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function sendAddress() {

        var address = {
            "city": $("#city").val(),
            "street": $("#street").val(),
            "house": $("#house").val(),
            "flat": $("#flat").val(),
        };
        $.ajax({
            type: "PUT",
            url: "${pageContext.request.contextPath}/address/" +${address.id},
            data: JSON.stringify(address),
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address";
                alert("COOL");
            },
            error: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address",
                    alert('Error update');
            },
        });
    }
</script>


<div class="container">
    <h4 class="text-info text-center">Update new address</h4>

    <div class="row">
        <div class="col-lg-4">
            <div class="mb-3">
                <label for="city" class="form-label">City</label>
                <input type="text" name="city" class="form-control" id="city"
                       value="${address.city}" required>
            </div>
            <div class="mb-3">
                <label for="street" class="form-label">Street</label>
                <input type="text" name="street" class="form-control" id="street"
                       value="${address.street}" required>
            </div>
            <div class="mb-3">
                <label for="house" class="form-label">House</label>
                <input type="text" name="house" class="form-control" id="house"
                       value="${address.house}" required>
            </div>
            <div class="mb-3">
                <label for="flat" class="form-label">Flat</label>
                <input type="text" name="flat" class="form-control" id="flat"
                       value="${address.flat}" required>
            </div>

        </div>
        <div class="row">
            <div class="col-ln-4">
                <button type="button" class="btn btn-info" onclick="sendAddress()"> SAVE</button>
                <br><br></div>
        </div>
    </div>
        <%--    </form>--%>




    <%@include file="../footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>

</html>
