<%--
  Created by IntelliJ IDEA.
  User: 37529
  Date: 07.08.2023
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validator</title>
</head>
<body>
<form action="/validator" method="post">
  <input type="text" name="num1" placeholder="Number 1">
  <input type="text" name="num2" placeholder="Number 2">
  <input type="text" name="operator" placeholder="Operator">
  <button>Submit</button>
</form>
<h3>${result}</h3>
<h3>${message}</h3>
</body>
</html>
