<!DOCTYPE html>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="by.it_academy.jd2.core.dto.DataStorageUsers" %>
<%@ page import="by.it_academy.jd2.core.dto.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <meta charset="utf-8">
</head>
<body>
<%User userSender = (User) (request.getSession().getAttribute("userSender"));%>
Привет, <%=userSender.getName()%> !<br>
ТЫ можешь
<form action="message" method="get" >
    <button type="submit">Отправить сообщение</button><br><br>
</form>
<form action="chats" >
    <button type="submit">Посмотреть сообщения</button><br><br>
</form>
<form action="index.jsp" >
    <button type="submit">Выйти</button><br><br>
</form>
</body>
</html>

