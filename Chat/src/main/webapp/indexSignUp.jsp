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
   <title>SignUp</title>
   <meta charset="utf-8">
 </head>
 <body>
<p> <%= getFormattedDate() %></p>
<form method="get" action="hello" >

    <h1>Зарегистрироваться</h1>
    <p>Пожалуйста, заполните эту форму, чтобы создать учетную запись.</p>
    <hr>

    Логин<br>
    <input type="text" placeholder="Введите логин" name="login" required><br><br>

    Пароль<br>
    <input type="password" placeholder="Введите пароль" name="psw" required><br><br>

     ФИО<br>
     <input type="text" placeholder="Введите ФИО" name="name" required><br><br>

     Дата рождения<br>
     <input type="date" name="birthday" required><br><br>
    <hr>
     <button type="submit" >Зарегистрироваться</button>

 </form>
 </body>
</html>