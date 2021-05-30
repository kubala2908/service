<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 30.05.2021
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="client" action="/client/add">
    <br>Name: <form:input path="name" />
    <br>Address/City: <form:input path="address"/>
    <br>TAX ID: <form:input path="taxId"/>
    <br>Notes: <form:input path="notes"/>
    <br>Client in debt: <form:checkbox path="overdraft"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>