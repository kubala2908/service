<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 27.05.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Spring Security - Custom UserDetailsService Example</h1>
<h2>${message}</h2>

<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>
