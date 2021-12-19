<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/create" method="post" modelAttribute="email">
<p>Languages:</p>
<form:select path="language">
    <form:options items="${language}"></form:options>
</form:select>
<p>Page size:</p>
<form:select path="size">
    <form:options items="${size}"></form:options>
</form:select>
<p>Spams filter:</p>
    <%--    <form:radiobuttons path="spams" items="${spams}"></form:radiobuttons>--%>
    <form:checkboxes path="spams" items="${spams}"></form:checkboxes>
<p>Signature:</p>
    <%--thay thuộc tính name = path--%>
    <%--<form: input path="sign"/>--%>
<button type="submit">Update</button>
<button type="
</form:form>
</body>
</html>
