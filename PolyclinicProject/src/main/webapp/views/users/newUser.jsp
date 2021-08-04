<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>New User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="container">
    <div class="main-body">
        <form action="newUser" method="post" required>
            <br><h4 class="text-info text-center">CREATE A NEW USER</h4><br>
            <c:if test="${errorLogin!=null}">
                <br><h4 class="text-danger text-center">Wrong login or password</h4><br>
            </c:if>
            <div class="row">

                <%--            start row three colon, number 1--%>
                <div class="col-lg-4">

                    <div class="d-flex flex-column align-items-center text-center">
                        <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin"
                             class="rounded-circle p-1 bg-info" width="110"></div>
                        <div class="mb-3"><br>
                            <label for="username" class="form-label">Login</label>
                            <input type="text" name="username" class="form-control" id="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" name="password" class="form-control" id="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="surname" class="form-label">Surname</label>
                            <input type="text" name="surname" class="form-control" id="surname" required>
                        </div>
                        <div class="mb-3">
                            <label for="given_name" class="form-label">Given name</label>
                            <input type="text" name="given_name" class="form-control" id="given_name" required>
                        </div>
                        <div class="mt-3">
                            <label for="role" class="form-label">Role</label>
                            <select class="form-select" name="role" id="role" aria-label="Default select example"
                                    required>
                                <c:forEach var="r" items="${roleList}">
                                    <option value="${r}">${r}<br></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="position" class="form-label">Position</label>
                            <input type="text" name="position" class="form-control" id="position">
                        </div>


                </div>
                <div class="col-lg-8">

                    <div class="row">
                        <div class="col">
                            <h5>Contact</h5></div>
                    </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone</label>
                            <input type="tel" name="phone" class="form-control" id="phone"
                                   placeholder="(00)123-45-67" pattern="\([\d]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">E-mail</label>
                            <input type="email" name="email" class="form-control" id="email">
                        </div>

                        <div class="row">
                            <div class="col"><h5>Address</h5></div>
                        </div>

                            <div class="mb-3">
                                <label for="city" class="form-label">City</label>
                                <input type="text" name="city" class="form-control" id="city"  required>
                            </div>
                            <div class="mb-3">
                                <label for="street" class="form-label">Street</label>
                                <input type="text" name="street" class="form-control" id="street"  required>
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

                    </div>

                <div class="row">
                    <div class="col">

                        <div class="row">
                            <div class="col">
                                <h4>Passport</h4></div>
                        </div>
<c:if test="${errorPassport!=null}">
    <br><h4 class="text-danger text-center">This passport already exists</h4><br>
</c:if>
                            <div class="mb-3">
                                <label for="id_passport" class="form-label">ID Passport</label>
                                <input type="text" name="id_passport" class="form-control" id="id_passport"
                                       placeholder="BM1234567" pattern="[A-Z]{2}\d{7}" required>
                            </div>

                                <div class="mb-3">
                                    <label for="identification" class="form-label">Identification</label>
                                    <input type="text" name="identification" class="form-control" id="identification"
                                           placeholder="BM1234567d5e66" pattern="[A-Z0-9]{14}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="code_state" class="form-label">Code State</label>
                                    <input type="text" name="code_state" class="form-control" id="code_state"
                                           placeholder="DDD" pattern="[A-Z]{3}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="nationality" class="form-label">Nationality</label>
                                    <input type="text" name="nationality" class="form-control" id="nationality" required>
                                </div>
                                <div class="mb-3">
                                    <label for="date_birthday" class="form-label">Date Birthday</label>
                                    <input type="date" name="date_birthday" class="form-control" id="date_birthday" required>
                                </div>
                                <div class="mb-3">
                                    <label for="place_birth" class="form-label">Place Birthday</label>
                                    <input type="text" name="place_birth" class="form-control" id="place_birth" required>
                                </div>
                                <div class="mb-3">
                                    <label for="data_issue" class="form-label">Date Issue</label>
                                    <input type="date" name="data_issue" class="form-control" id="data_issue" required>
                                </div>
                                <div class="mb-3">
                                    <label for="data_expiry" class="form-label">Date Expiry</label>
                                    <input type="date" name="data_expiry" class="form-control" id="data_expiry" required>
                                </div>

                            <div class="mb-3">
                                <label for="sex" class="form-label">SEX</label>
                                <select class="form-select" name="sex" id="sex" aria-label="Default select example" >
                                    <c:forEach var="s" items="${sexList}">
                                        <option value="${s}">${s}<br></option>
                                    </c:forEach>
                                </select></div>
                        <div class="mb-3">
                            <label for="info" class="form-label">INFO</label>
                            <input type="text" name="info" class="form-control" id="info" >
                        </div>
                        </div>
                    </div>

                <button type="submit" class="btn btn-info">SAVE</button>

        </form>
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
