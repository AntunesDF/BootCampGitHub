<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 22/07/16
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Edit user</title>
</head>
<body>

<div class="jumbotron">
    <div class="container">
        <div class="center-block">
            <h1>${editUser.username}</h1>
        </div>
    </div>
</div>

<div class="container">
    <div class="center-block">
        <form:form action="editUser/edit" method="post" modelAttribute="newUser">
            <p><label for="username">Username:</label><form:input path="username" id="username"/>
                <label for="pwd">Password:</label><form:input path="password" id="pwd"/>
                <label for="email">Email:</label><form:input path="email" id="email"/></p>
            <input type="submit" class="btn btn-success" value="Edit">
            <button type="reset" class="btn btn-warning">Reset</button>
        </form:form>
    </div>
</div>

<div class="container">
    <div class="center-block">
        <form action="editUser/back" method="post">
            <input type="submit" class="btn btn-primary" value="Back">
        </form>
    </div>
</div>

</body>
</html>
