<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/16/2021
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Gradle</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">
</form>
</body>
</html>
