<%@ page import="org.academiadecodigo.bootcamp.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <% User user = (User) request.getAttribute("user"); %>
    </head>

    <body>
        <h2>Hello <%= user.getName()%> !</h2>
    </body>
</html>
