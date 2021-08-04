<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
    <title>All Address</title>
</head>
<body>
<%@include file="../header.jsp" %>
<c:if test="${sessionScope.user.role==Role.ADMIN}">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>
    function sendAddress() {

        var addres = {
            "city": $("#city").val(),
            "street": $("#street").val(),
            "house": $("#house").val(),
            "flat": $("#flat").val(),
        };
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/address/"+$("#user").val(),
            data: JSON.stringify(addres),
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address";
                alert('Success save '+ responseData);
            },
            error: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address";
                alert('Error save'+ responseData);
            }
        });
    }
</script>
<script>
    function deletePassport(id) {
        $.ajax({
            type: "DELETE",
            url: "${pageContext.request.contextPath}/address/" + id,
            contentType: "application/json",
            success: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address";
                alert('Success delete');

            },
            error: function (responseData) {
                window.location.href = "${pageContext.request.contextPath}/address";
                alert('Error delete');
            }
        });
    }
</script>

<div class="container">
    <h4 class="text-info text-center">Create new address</h4>
<%--    <h6 class="text-danger text-center">${MessageAddress}</h6>--%>
<%--    <form name="address" method="post" enctype='application/json'>--%>
        <div class="row">
            <div class="col-lg-4">
                <div class="mb-3">
                    <label for="city" class="form-label">City</label>
                    <input type="text" name="city" class="form-control" id="city" required>
                </div>
                <div class="mb-3">
                    <label for="street" class="form-label">Street</label>
                    <input type="text" name="street" class="form-control" id="street" required>
                </div>
                <div class="mb-3">
                    <label for="house" class="form-label">House</label>
                    <input type="text" name="house" class="form-control" id="house" required>
                </div>
                <div class="mb-3">
                    <label for="flat" class="form-label">Flat</label>
                    <input type="text" name="flat" class="form-control" id="flat" required>
                </div>

            </div>
            <div class="col-lg-4">
                <div class="mb-3">
                    <label for="user" class="form-label">USER</label>
                    <select class="form-select" name="user" id="user" aria-label="Default select example">
                        <c:forEach var="list" items="${userList}">
                            <option value="${list.username}">
                                (${list.username})${list.surname} ${list.given_name}(${list.role})<br></option>
                        </c:forEach>
                    </select></div>
            </div>
            <div class="row">
                <div class="col-ln-4">
                    <button type="button" class="btn btn-info" onclick="sendAddress()"> SAVE</button>
                    <br><br></div>
            </div>
        </div>
<%--    </form>--%>

    </c:if>

    <table class="table table-striped table-info">
        <tbody>
        <tr>
            <th>City</th>
            <th>Street</th>
            <th>House</th>
            <th>Flat</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${requestScope.address}"
                   var="add">
            <tr>
                <td>${add.city}</td>
                <td>${add.street}</td>
                <td>${add.house}</td>
                <td>${add.flat}</td>
                <td>
                    <button type="button" class="btn btn-info" onclick="deletePassport('${add.id}')"> Delete
                    </button>

                </td>
                <td>
                    <input type="button" class="btn btn-info"
                           onclick="location.href='${pageContext.request.contextPath}/address/${add.id}';"
                           value="Update"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <%@include file="../footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
</body>
</html>