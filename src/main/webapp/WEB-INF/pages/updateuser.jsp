<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 23.05.2020
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>

<h3>${user.toString()}</h3><br>

<form action="/user-update" method="post">
    <input type="hidden" name="id"  value="${param.id}">
    <input type="text" name="firstName"  value="${param.name}" required>
    <input type="text" name="lastName"  value="${param.last_name}" required>
    <input type="text" name="email"  value="${param.email}" required>
    <input type="submit" value="Update">
</form>

</body>
</html>
