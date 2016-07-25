<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 15/07/16
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Login Form</title>
</head>
<body>

<div class="container">
    <div class="wrapper">
        <form action="" method="post" name="Login_Form" class="form-signin">
            <h3 class="form-signin-heading">Welcome Back! Login to web app here.</h3>
            <hr class="colorgraph">
            <br>

            <form:form method="post" modelAttribute="user">
                <p>Name: <form:input path="username"/></p>
                <p><form:errors path="username" cssClass="error"/></p>
                <p>Password: <form:input path="password"/></p>
                <p><form:errors path="password" cssClass="error"/></p>
                <input type="submit" value="Login"/>
            </form:form>
            <div style="color:red">${error}</div>

        </form>
    </div>
</div>

</body>
</html>
