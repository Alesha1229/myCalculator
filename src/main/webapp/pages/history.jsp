<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 2.08.23
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<ul>
    <c:forEach items="${requestScope.items}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

</body>
</html>
