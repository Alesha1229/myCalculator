<%--
  Created by IntelliJ IDEA.
  User: simonpirko
  Date: 2.08.23
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>document.querySelector('body').onload = function f1() {
    var a = document.getElementById('num2')
    document.getElementById('num1').type = (a.value === 'sin' || a.value === 'cos' || a.value === 'abs' || a.value === 'floor') ? 'hidden' : 'text';

}
</script>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <input type="text" name="num1" placeholder="Number 1">
    <input type="text" name="num2" placeholder="Number 2">
    <input type="text" name="type" placeholder="Type">
    <button>Submit</button>
</form>
<h3>${result}</h3>
<h3>${message}</h3>
</body>
</html>
