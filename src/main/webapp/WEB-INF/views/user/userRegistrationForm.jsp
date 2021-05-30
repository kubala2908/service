<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 28.05.2021
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user" action="/user/add">
    <br>Login/username: <form:input path="username" />
    <br>Password: <form:input path="password" type="password" />
    <br>Email: <form:input path="email"/>
    <br>First name: <form:input path="firstName"/>
    <br>Last name: <form:input path="lastName"/>
    <br><input type="radio" id="user" name="role" value="ROLE_USER">
    <label for="user">USER</label><br>
    <input type="radio" id="admin" name="role" value="ROLE_ADMIN">
    <label for="admin">ADMIN</label><br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
