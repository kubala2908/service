<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 04.06.2021
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="ticketDto" action="/ticket/add">
    <br>Description: <form:input path="description" />
    <br>Warranty: <form:checkbox path="warranty"/>
    <br>Machine:
    <select name="idMachine">
        <c:forEach items="${machines}" var="machine">
            <option value="${machine.id}"> ${machine.serialNumber}</option>
        </c:forEach>
    </select>
    <br>Client:
    <select name="idClient">
        <c:forEach items="${clients}" var="client">
            <option value="${client.id}"> ${client.name}</option>
        </c:forEach>
    </select>
    <br>Manager:
    <select name="idManager">
        <c:forEach items="${users}" var="manager">
            <option value="${manager.id}"> ${manager.username}</option>
        </c:forEach>
    </select>
    <br>Technician:
    <select name="idTechnician">
        <c:forEach items="${users}" var="technician">
            <option value="${technician.id}"> ${technician.username}</option>
        </c:forEach>
    </select>
    <br><input type="submit" value="Save">
</form:form>
</body>
</html>
