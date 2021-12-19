<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>List email</h1>
<a href="/create">Create</a>
<p style="color: blue">${msg}</p>
<table border="1" style="width: 500px">
    <tr>
        <th>No</th>
        <th>Language</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
    </tr>
<c:forEach var="emailObj" items="${email}" varStatus="loop">
    <tr>
        <td><c:out value="${loop.count}"/></td>
        <td><c:out value="${emailObj.language}"/></td>
        <td><c:out value="${emailObj.size}"/></td>
        <td><c:out value="${emailObj.spams}"/></td>
        <td><c:out value="${emailObj.sign}"/></td>
</c:forEach>
</table>
</body>
</html>
