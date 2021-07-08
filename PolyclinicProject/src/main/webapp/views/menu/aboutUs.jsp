<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>About Us</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="../../index.jsp" %>
<div class="container">
    <div class="main-body">
<div class = "text-center">
    <h1>ABOUT the Medical Clinic</h1><br>
</div>
        <div class="text-center"><h4>Information about doctors</h4></div><br>

        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3  gutters-sm">
            <c:forEach items="${requestScope.doctors}" var="user">
                <div class="col mb-3">
                    <div class="card">
                        <img src="https://via.placeholder.com/340x120/87CEFA/000000" alt="Cover" class="card-img-top">
                        <div class="card-body text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png"
                                 style="width:100px;margin-top:-65px" alt="User"
                                 class="img-fluid img-thumbnail rounded-circle border-0 mb-3">
                            <h5 class="card-title"><a
                                    href="${pageContext.request.contextPath}/doctor/${user.login}">${user.surname} ${user.given_name}</a></h5>
                            <p class="text-secondary mb-1">${user.position}</p>
                            <p class="text-muted font-size-sm">${user.email}</p>
                        </div>
                            <%--                        <div class="card-footer">--%>
                            <%--                            <button class="btn btn-light btn-sm bg-white has-icon btn-block" type="button"><i class="material-icons">add</i>Follow</button>--%>
                            <%--                            <button class="btn btn-light btn-sm bg-white has-icon ml-2" type="button"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-message-circle"><path d="M21 11.5a8.38 8.38 0 0 1-.9 3.8 8.5 8.5 0 0 1-7.6 4.7 8.38 8.38 0 0 1-3.8-.9L3 21l1.9-5.7a8.38 8.38 0 0 1-.9-3.8 8.5 8.5 0 0 1 4.7-7.6 8.38 8.38 0 0 1 3.8-.9h.5a8.48 8.48 0 0 1 8 8v.5z"></path></svg></button>--%>
                            <%--                        </div>--%>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>

<style type="text/css">
    body {
        margin-top: 20px;
        color: #1a202c;
        text-align: left;
        background-color: #e2e8f0;
    }

    .main-body {
        padding: 15px;
    }

    .card {
        box-shadow: 0 1px 3px 0 rgba(0, 0, 0, .1), 0 1px 2px 0 rgba(0, 0, 0, .06);
    }

    .card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 0 solid rgba(0, 0, 0, .125);
        border-radius: .25rem;
    }

    .card-body {
        flex: 1 1 auto;
        min-height: 1px;
        padding: 1rem;
    }

    /*.card-footer:last-child {*/
    /*    border-radius: 0 0 .25rem .25rem;*/
    /*}*/

    /*.card-footer, .card-header {*/
    /*    display: flex;*/
    /*    align-items: center;*/
    /*}*/

    /*.card-footer {*/
    /*    padding: .5rem 1rem;*/
    /*    background-color: #fff;*/
    /*    border-top: 0 solid rgba(0, 0, 0, .125);*/
    /*}*/


</style>

<script type="text/javascript">
    <%@include file="../footer.jsp" %>
</script>
<%@include file="../footer.jsp" %>
</body>
</html>
