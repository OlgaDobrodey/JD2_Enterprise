<%@ page import="by.it_academy.jd2.serves.NameView" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Proga</title>
    <meta charset="utf-8">
</head>
<body>
<%--<%=(String) request.getSession().getAttribute("list")%><br>--%>

<c:if test="${list.size()==0}">
    <c:out value="z c.lf gjgfk"/>
</c:if>

<c:if test="${list!=null}">
    <c:forEach var="a" items="${list}">

        ${a}<br>
    </c:forEach>
</c:if>
</body>
</html>
