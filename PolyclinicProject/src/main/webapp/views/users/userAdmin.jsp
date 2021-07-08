<%--
  Created by IntelliJ IDEA.
  User: Olga
  Date: 07.07.2021
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../../index.jsp" %>
ADMIN the main man
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin/user';" value="Creat User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Delete User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports';" value="Update User" /></p>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/allPatients';" value="All Patients" /></p>

<%@include file="../footer.jsp" %>
</body>
</html>
