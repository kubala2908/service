<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 29.05.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/info" method="get">
    <input value="HOME" type="submit">
</form>
<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Tax ID</th>
    </tr>
    <c:forEach items="${producers}" var="producer">
        <tr>
            <td>${producer.name}</td>
            <td>${producer.address}</td>
            <td>${producer.taxId}</td>
        </tr>
    </c:forEach>
</table>
<form action="/producer/add" method="get">
    <input value="Add Machine" type="submit">
</form>
</body>
</html>
