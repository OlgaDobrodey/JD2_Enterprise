<%@ page import="by.it_academy.jd2.core.Constants" %>
<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Message</title>
    <meta charset="utf-8">
</head>
<body>
<%
    if (request.getSession().getAttribute("send") != null) {
        if ((Boolean) request.getSession().getAttribute("send")) {
            out.println("<p><span style='color: red;'>Cообщение отправленно!</span></p>");
        }
        request.getSession().setAttribute("send", null);
    }
%>
<p>Отправить сообщение</p>
<hr>

<form method="POST" action="message" >

    Кому:<select name="userReceiver">
    <c:forEach var="a" items="${setUsers}">
        <option value="${a}"> ${a}<br></option>
    </c:forEach>
</select>

    <br><br>

    Сообщение:<br>
    <input type="text" name="message"/>
    <br><br>

    <button type="submit">Отправить</button>
    <button type="reset">Очистить</button>
</form>
<form action="menu" method="get">
    <hr>
    <br>
    <button type="submit">Выход в меню</button>
    <br><br>
</form>
<form action="signIn">
    <button type="submit">Выйти из приложения</button>
    <br><br>
</form>
</body>
</html>
