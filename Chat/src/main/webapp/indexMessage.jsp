
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="jakarta.servlet.*"%>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <title>Message</title>
    <meta charset="utf-8">
</head>
<body>
<%if(request.getSession().getAttribute("send")!=null){
    if((Boolean) request.getSession().getAttribute("send")){
    out.println("<p><span style='color: red;'>Cообщение отправленно!</span></p>");
}request.getSession().setAttribute("send",false);}
%>
<p>Отправить сообщение</p>

<form method="POST" action="message" type="get">

        Кому:<br>
        <input type="text" name="userReceiver">
    <br>

        Сообщение:<br>
        <input type="text" name="message" />
    <br><br>

    <button type="submit">Отправить</button>
    <button type="reset">Очистить</button>
</form>
<form action="menu" method="get">
    <br><button type="submit">Выход</button>
</form>
</body>
</html>
