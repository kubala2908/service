<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 04.06.2021
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>ID: ${ticket.id}
<br>Description: ${ticket.description}
<br>Warranty: ${ticket.warranty}
<br>Distance: ${ticket.distance/1000} km
<br>Client: ${ticket.client.name}
<br>Machine: ${ticket.machine.producer.name} ${ticket.machine.model}
<br>Manager: ${ticket.manager.firstName} ${ticket.manager.lastName}
<br>Technician: ${ticket.technician.firstName} ${ticket.technician.lastName}
</body>
</html>
