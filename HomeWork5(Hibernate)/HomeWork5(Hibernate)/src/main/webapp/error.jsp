<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Error</title>
    <style>
        input[type=submit] {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }

    </style>
</head>
<body>

<h1>Alas, something went wrong! But we have to deal with this! Without tears!</h1>


<p>don't be alarmed, here are the tips</p>
<% String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();%>
<p>Type: <%= exception%>
</p>
<p>Message: <%= message %>
</p>
<%-- <%   StackTraceElement[] stackTrace = pageContext.getException().getStackTrace();--%>
<%--    out.write("<p>");--%>
<%--    for (StackTraceElement element : stackTrace) {--%>
<%--        out.write(element.getFileName().toUpperCase()+"     "+element.getFileName()+"    "+element.getLineNumber()+"<br>");--%>
<%--    }--%>
<%--    out.write("<p>");--%>

<%--%>--%>
<p><input type="submit" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Назад" ;
          method="get"/></p>
</body>
</html>
