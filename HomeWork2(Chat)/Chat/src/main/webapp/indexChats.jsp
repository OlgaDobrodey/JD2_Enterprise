<!DOCTYPE html>

<%@ page import="by.it_academy.jd2.core.view.User" %>
<%@ page import="by.it_academy.jd2.core.tool.DataMessage" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Chat</title>
    <meta charset="utf-8">
</head>
<body>

<% User userSender = (User) request.getSession().getAttribute("userSender");%>
<p><span style='color: red;'> Получатель <%=userSender.getName()%> </span></p>

<%out.write(DataMessage.printMessasgeUserLogin(userSender));%>

<br><br>
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
<form action="index.jsp">
    <button type="submit">Выйти из приложения</button>
    <br><br>
</form>
<hr>

</body>
</html>
