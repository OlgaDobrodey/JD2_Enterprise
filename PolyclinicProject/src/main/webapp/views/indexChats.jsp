<!DOCTYPE html>

<%@ page import="by.it_academy.jd2.core.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chat</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body class="text-center">

<% User userSender = (User) request.getSession().getAttribute("userSender");%>
<p><span style='color: red;'> Получатель <%=userSender.getName()%> </span></p>

<hr>
<c:forEach var="a" items="${printMSG}">
<p>${a}<p>
    </c:forEach>
    <br>
<hr>
<form action="message" method="get">
    <button type="submit">Отправить сообщение</button>
    <br><br>
</form>
<form action="menu" method="get">
    <br>
    <button type="submit">Выход в меню</button>
    <br><br>
</form>
<form action="signIn">

    <button type="submit">Выйти из приложения</button>
    <br><br>
</form>
<hr>

</body>
</html>
