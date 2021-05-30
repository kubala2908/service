<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 30.05.2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Tax ID</th>
    </tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.name}</td>
            <td>${client.address}</td>
            <td>${client.taxId}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>