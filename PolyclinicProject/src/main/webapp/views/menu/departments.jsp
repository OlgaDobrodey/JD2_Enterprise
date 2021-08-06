<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="by.it_academy.jd2.core.model.people.Role" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Departments</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>

<div class="container">

        <div class="text-center"><h4 class="text-info">Information about department</h4></div>
        <br>
<c:if test="${departmentSearch!=null}">
    <div class="text-center"><h5 class="text-info">${departmentSearch.nameArticle}</h5></div>
    <div class="row">
        <div class="col-lg-4">
            <img src="${departmentSearch.linkImage}" alt="${departmentSearch.nameArticle}"  width="350px" >
        </div>
        <div class="col-lg-8">
            <h5 class="text-info">${departmentSearch.titlePage}</h5>
            <p>${departmentSearch.longText}</p><br>
        </div>
    </div>
</c:if>
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3  gutters-sm">
            <c:forEach items="${requestScope.department}" var="dpt">
                <div class="col mb-3">

                    <div class="card">

                        <img src="${dpt.linkImage}" alt="${dpt.nameArticle}" class="card-img-top">
                        <div class="card-body text-center text-info">
                            <h5 class="card-title text-info ">
                                <a href="${pageContext.request.contextPath}/departments/${dpt.idDepartments}">${dpt.nameArticle}</a>
                            </h5>
                            <p class="text-secondary mb-1">${dpt.shotText}</p>

                        </div>
                    </div>

                </div>
            </c:forEach>

        </div>
        <c:if test="${sessionScope.user.role==Role.ADMIN}">
            <h4>Create new department</h4>
            <form name="departments" method="post">
                <div class="row">

                    <div class="col-lg-4">

                        <div class="mb-3"><br>
                            <label for="nameArticle" class="form-label">Name Departement</label>
                            <input type="text" name="nameArticle" class="form-control" id="nameArticle" required>
                        </div>
                        <div class="mb-3">
                            <label for="shotText" class="form-label">Shot Text</label>
                            <input type="text" name="shotText" class="form-control" id="shotText" required>
                        </div>
                        <div class="mb-3">
                            <label for="titlePage" class="form-label">Title Page</label>
                            <input type="text" name="titlePage" class="form-control" id="titlePage" required>
                        </div>
                        <div class="mb-3">
                            <label for="longText" class="form-label">Long Text</label>
                            <input type="text" name="longText" class="form-control" id="longText" required>
                        </div>

                        <div class="mb-3">
                            <label for="linkImage" class="form-label">Link Image</label>
                            <input type="text" name="linkImage" class="form-control" id="linkImage">
                        </div>


                    </div>
                </div>
                <button type="submit" class="btn btn-info">SAVE</button>
            </form>


        </c:if>
    </div>

<%@include file="../footer.jsp" %>
<style type="text/css">


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
</body>
</html>
