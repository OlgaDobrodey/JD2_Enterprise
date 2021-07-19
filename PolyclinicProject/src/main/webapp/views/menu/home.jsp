<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="ru"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HOME</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">

</head>
<body>
<%@include file="../header.jsp" %>

<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="http://localhost:8080/image/home/home1.jpg" class="d-block w-100" height=550px" alt="image1">
            <div class="carousel-caption ">
                <h5>Health Checks</h5>
                <p>Regular health screening can identify risk factors, diagnose disease at an early stage and help you make positive lifestyle changes.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://localhost:8080/image/home/home2.jpg" class="d-block w-100" alt="image2" height="550px" >
            <div class="carousel-caption">
                <h5>The Audiology Clinic</h5>
                <p>The clinic offers detailed hearing assessments that are performed to the highest standards.</p>
            </div>
        </div>
        <div class="carousel-item">
            <img src="http://localhost:8080/image/home/home3.jpg" class="d-block w-100" alt="image3" height="550px">
            <div class="carousel-caption">
                <h5>LASIK Surgery</h5>
                <p>LASIK is a type of laser vision correction. It is the most commonly performed surgery to correct short-sightedness, long-sightedness and astigmatism.</p>

            </div>
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
