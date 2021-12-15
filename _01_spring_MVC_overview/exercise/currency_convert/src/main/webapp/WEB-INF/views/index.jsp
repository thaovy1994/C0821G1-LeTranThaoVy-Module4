<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Currency Convert</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h1>USD to VNĐ</h1>
<form class="form-control" method="post">
    <h5>USD</h5>
    <div>
        <input type="text" name="usd" style="width: 100px">
    </div>
    <div>
        <button type="submit" name="convert">Convert</button>
    </div>
    <div>
        <c:out value="${vnd}"></c:out>
    </div>
</form>
</body>
</html>
