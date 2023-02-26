<%--
  Created by IntelliJ IDEA.
  User: sitv1
  Date: 12.01.2023
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Dodaj produkt</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-product-form.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicons-solid-straight.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Sklep Internetowy</h2>
        </div>
    </div>
    <div id="container">
        <div id="addProductForm">
            <h2>Add Product</h2>
            <form:form action="saveProduct" modelAttribute="product" method="post">
                <table>
                    <tbody>
                        <tr>
                            <td><label>Product name:</label></td>
                            <td><form:input path="name"/></td>
                        </tr>
                        <tr>
                            <td><label>Price:</label></td>
                            <td><form:input path="price"/></td>
                        </tr>
                        <tr>
                            <td><label>Dostępność:</label></td>
                            <td><form:input path="available"/></td>
                        </tr>
                        <tr>
                                <%--                        <td><input type="submit" value="Save" class="add-button"></td>--%>
                            <td><input type="submit" value="Submit" class="add-button"/></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            <div style="clear: both;"></div>
            <p>
                <a href="${pageContext.request.contextPath}/product/list">Back to list</a>
            </p>

        </div>
    </div>

</body>
</html>
