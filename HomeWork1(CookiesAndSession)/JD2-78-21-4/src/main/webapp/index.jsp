<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<%!
String getFormattedDate(){
    SimpleDateFormat sdf =new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return sdf.format(new Date());
}
%>

<html>
 <head>
   <title>!DOCTYPE</title>
   <meta charset="utf-8">
 </head>
 <body>
<p> <%= getFormattedDate() %></p>
<form action="hello" method="GET">
First Name: <input type="text" name="firstName"/>
Last Name: <input type="text" name="lastName"/>
<input type="submit" value="Нажми меня"/>
</form>
 </body>
</html>