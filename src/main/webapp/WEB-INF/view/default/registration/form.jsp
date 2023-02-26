<%--
  Created by IntelliJ IDEA.
  User: Bartek_Programowanie
  Date: 26.02.2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/registration/style.css">
</head>
<body>
    <div class="page-content">
        <div class="form">
            <h1>Sign up</h1>
            <form:form action="register" modelAttribute="user" method="post">
                <c:if test="${param.error != null}">
                    <div class="form-error">Username is already in use!</div>
                </c:if>
                <div class="form-group">
                    <div class="form-row">
                        <form:input path="firstName" placeholder="First Name" required="true" autofocus="true"/>
                    </div>
                    <div class="form-row">
                        <form:input path="lastName" placeholder="Last Name" required="true" />
                    </div>
                </div>
                <div class="form-row">
                    <form:input path="username" placeholder="Username" required="true"/>
                </div>
                <div class="form-row">
                    <form:password  path="password" placeholder="Password" required="true"/>
                </div>
                <input type="submit" value="Submit" class="submit-button"/>
            </form:form>
        </div>
    </div>

</body>
</html>
