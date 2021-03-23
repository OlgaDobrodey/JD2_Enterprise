<!DOCTYPE html>
<%@ page import="by.it_academy.jd2.core.dto.DataMessage" %>
<%@ page import="by.it_academy.jd2.core.dto.Message" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="by.it_academy.jd2.core.dto.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <meta charset="utf-8">
</head>
<body>
<%
    response.setContentType("text/html");
    final PrintWriter writer = response.getWriter();
    User userSender = (User) (request.getSession().getAttribute("userSender"));
    if (DataMessage.searchMessageUserLoginAndPsw(userSender.getLogin()).size()!=0){
        writer.write("<p><span style='color: black;'> Получатель"+userSender.getName()+"</p></span>");
    for (Message message : DataMessage.searchMessageUserLoginAndPsw(userSender.getLogin())) {
        writer.write("<p><span style='color: black;'>" + message.toString() + "</p></span>");
    }
    }else
    writer.write("<p><span style='color: black;'> У вас пока нет сообщений!!!</p></span>");

%>

</body>
</html>
