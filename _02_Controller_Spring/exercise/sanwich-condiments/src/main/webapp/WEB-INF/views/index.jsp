<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/17/2021
  Time: 5:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sanwich Condiments</title>
</head>
<body>
<h1>Spiced with Sandwick</h1>
<c:forEach items='${requestScope["condiment"]}' var="choise">
    <h2 style="color: red">${choise}</h2>
</c:forEach>
</body>
</html>
