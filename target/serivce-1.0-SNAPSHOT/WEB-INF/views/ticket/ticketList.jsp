<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 12.06.2021
  Time: 11:51
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
        <th>Client name</th>
        <th>Machine model</th>
        <th>Address</th>
        <th>Warranty</th>
        <th>Manager</th>
        <th>Technician</th>
    </tr>
    <c:forEach items="${tickets}" var="ticket">
        <tr>
            <td>${ticket.client.name}</td>
            <td>${ticket.machine.model}</td>
            <td>${ticket.machine.address}</td>
            <td>${ticket.warranty}</td>
            <td>${ticket.manager.username}</td>
            <td>${ticket.technician.username}</td>
            <td><form action="/ticket/info/${ticket.id}" method="get">
                <input value="Ticket info" type="submit">
            </form></td>
        </tr>
    </c:forEach>
</table>
<form action="/ticket/add" method="get">
    <input value="Add Ticket" type="submit">
</form>
</body>
</html>
