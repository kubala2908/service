<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 28.05.2021
  Time: 16:37
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
<form:form method="post" modelAttribute="machine" action="/machine/add">
    <br>Serial number: <form:input path="serialNumber" />
    <br>Model: <form:input path="model"/>
    <br>Address/City: <form:input path="address"/>
    <br>Notes: <form:input path="notes"/>
    <br>Warranty start date: <form:input path="warrantyStartDate"/>
    <br>Warranty start date: <form:input path="warrantyEndDate"/>
    <select name="idProducer">
        <c:forEach items="${producers}" var="producer">
            <option value="${producer.id}"> ${producer.name}</option>
        </c:forEach>
    </select>
    <select name="idClient">
        <c:forEach items="${clients}" var="client">
            <option value="${client.id}"> ${client.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
