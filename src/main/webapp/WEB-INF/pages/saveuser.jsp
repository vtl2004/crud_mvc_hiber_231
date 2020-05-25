<%--
  Created by IntelliJ IDEA.
  User: krvro
  Date: 23.05.2020
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save User</title>
</head>
<body>
<form action="user-save" method="post">
    <input type="text" name="firstName" placeholder="Name" required>
    <input type="text" name="lastName" placeholder="Last Name" required>
    <input type="text" name="email" placeholder="email" required>
    <input type="submit" value="submit">
</form>

</body>
</html>
