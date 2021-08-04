<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>About Us</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<div class="container">

        <div class="text-center"><h4>Information about doctors</h4></div>
        <br>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3  gutters-sm">
            <c:forEach items="${requestScope.doctors}" var="psp">
                <div class="col mb-3">

                    <div class="card">

                        <img src="${psp.link}" alt="${psp.surname}" class="card-img-top">
                        <div class="card-body text-center">
                            <h5 class="card-title text-info ">
                                <a href="${pageContext.request.contextPath}/doctor/${psp.username}">${psp.surname} ${psp.given_name}</a>
                            </h5>
                            <p class="text-secondary mb-1">${psp.position}</p>
                            <p class="text-muted font-size-sm">${psp.email}</p>
                        </div>
                    </div>

                </div>
            </c:forEach>

        </div>
</div>

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


<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
