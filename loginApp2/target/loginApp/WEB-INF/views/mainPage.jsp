<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 20/07/16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Main Page</title>
</head>
<body>

<div class="jumbotron">
    <div class="container">
        <div class="center-block">
            <h1>${user.username}</h1>
            <p>Welcome ${user.username}, to this awesome new user app!</p>
        </div>
    </div>
</div>

<div class="container">
    <div class="center-block">
        <form:form action="mainPage/addUser/newUser" method="post" modelAttribute="newUser">
            <p><label for="username">Username:</label><form:input path="username" id="username"/>
                <label for="pwd">Password:</label><form:input path="password" id="pwd"/>
                <label for="email">Email:</label><form:input path="email" id="email"/></p>
            <input type="submit" class="btn btn-success" value="Add">
            <button type="reset" class="btn btn-warning">Reset</button>
        </form:form>
    </div>
</div>

<div class="container">

    <h2>User list</h2>
    <p>Edit or delete users:</p>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>e-mail</th>
            <th>Edit</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty userList}">
        <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.value.username}</td>
            <td>${user.value.email}</td>

            <td>
                <form action="editUser/${user.value.username}" method="get">
                    <input type="submit" class="btn btn-info" value="Edit">
                </form>
            </td>

            <td>
                <form action="mainPage/deleteUser/${user.value.username}" method="post">
                    <input type="submit" class="btn btn-danger" value="Remove">
                </form>
            </td>
        </tr>
        </c:forEach>
        </c:if>
    </table>

</div>

<div class="container">
    <div class="center-block">
        <form action="mainPage/logout" method="post">
            <input type="submit" class="btn btn-primary" value="Logout">
        </form>
    </div>
</div>

</body>
</html>
