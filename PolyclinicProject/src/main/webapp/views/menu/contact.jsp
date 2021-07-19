<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 08.07.2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<%@include file="../header.jsp" %>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container bootstrap snippets bootdeys">
    <div class="row text-center">
        <div class="col-sm-6">
            <div class="contact-detail-box">
                <i class="fa fa-th fa-3x text-info"></i>
                <h4>Get In Touch</h4>
                <abbr title="Phone">Phone:</abbr> (123) 456-7890
                E-mail: <a href="mailto:email@email.com" class="text-muted">email@email.com</a>
            </div>
        </div><!-- end col -->

        <div class="col-sm-6">
            <div class="contact-detail-box">
                <i class="fa fa-map-marker fa-3x text-info"></i>
                <h4>Our Location</h4>

                <address>
                    LODE Medical Center
                    prasp. Niezaliežnasci 58,
                    Minsk 220089
                </address>
            </div>
        </div><!-- end col -->

    <!-- end col -->

    </div>
    <!-- end row -->


    <div class="row">
        <div class="col">
            <div class="contact-map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d9400.180112853597!2d27.583530346467544!3d53.913175753095565!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46dbcfa6fdb49e2b%3A0x6818f5760b5629ee!2sLODE%20Medical%20Center!5e0!3m2!1sen!2sby!4v1626438819158!5m2!1sen!2sby" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" style="width: 100%; height: 360px;"></iframe>
            </div>
        </div><!-- end col --> <!-- end row -->

    </div></div>

<%@include file="../footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
