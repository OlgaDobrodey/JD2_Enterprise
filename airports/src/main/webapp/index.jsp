<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Главная страница сервера</title>
    </head>
    <body>
        <p>Ты можешь:</p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Просмотреть аэропорты" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/filters';" value="Просмотреть полёты" /></p>
    </body>
</html>