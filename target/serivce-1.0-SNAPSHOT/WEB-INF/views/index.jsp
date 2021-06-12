<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 27.05.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Field Service Management</h1>
<h2>${message}</h2>

<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
<form action="/machine/list" method="get">
    <input value="Machines List" type="submit">
</form>
<form action="/producer/list" method="get">
    <input value="Producer List" type="submit">
</form>
<form action="/client/list" method="get">
    <input value="Client List" type="submit">
</form>
<form action="/ticket/list" method="get">
    <input value="Ticket List" type="submit">
</form>
</body>
</html>
