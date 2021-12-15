<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/15/2021
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Simple Dictionary</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form method="post">
    <input type="text" name="word" placeholder="Enter English word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  <div>
    <c:out value="${result}"></c:out>
  </div>
  </body>
</html>
