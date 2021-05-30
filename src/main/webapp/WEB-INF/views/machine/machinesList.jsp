<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 29.05.2021
  Time: 10:54
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
        <th>Model</th>
        <th>Serial number</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${machines}" var="machine">
    <tr>
        <td>${machine.model}</td>
        <td>${machine.serialNumber}</td>
        <td>${machine.address}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
