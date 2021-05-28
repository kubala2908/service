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
    User name: <form:input path="username" />
    Password: <form:input path="password" type="password" />
    <input type="submit" value="Save">
</form:form>
</body>
</html>
