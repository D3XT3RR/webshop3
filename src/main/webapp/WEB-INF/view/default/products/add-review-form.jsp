<%--
  Created by IntelliJ IDEA.
  User: sitv1
  Date: 26.02.2023
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Review</title>
</head>
<body>
    <form:form action="addReview" modelAttribute="review" method="post">
        <form:hidden path="product.id"/>
        <form:select path="rate" required="true">
            <form:option value="1" label="1"/>
            <form:option value="2" label="2"/>
            <form:option value="3" label="3"/>
            <form:option value="4" label="4"/>
            <form:option value="5" label="5" />
        </form:select>
        <form:input path="text" placeholder="Comment" required="true" autofocus="true"/>

        <input type="submit" value="submit">

    </form:form>

</body>
</html>
