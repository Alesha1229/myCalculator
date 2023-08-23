<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 2.08.23
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<c:if test="${sessionScope.currentUser != null}">
    <h1>Hello ${sessionScope.currentUser.name}</h1>
    <br>
    <a href="/validator">Validator</a>
    <a href="/calculator">Calculator</a>
    <a href="/history">History</a>
    <a href="/logout">Logout</a>
</c:if>

<c:if test="${sessionScope.currentUser == null}">
    <h1>Hello Guest</h1>
    <br>
    <a href="/registration">Registration</a>
    <a href="/login">Login</a>
</c:if>

</body>
</html>
