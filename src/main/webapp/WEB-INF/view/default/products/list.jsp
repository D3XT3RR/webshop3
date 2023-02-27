<%--
  Created by IntelliJ IDEA.
  User: sitv1
  Date: 12.01.2023
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Sklep internetowy</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="/resources/css/uicons-solid-straight.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Sklep internetowy</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <menu>
                <input type="button" value="add product"
                       onclick="window.location.href='addProduct'; return false"
                       class="add-button"/>
                <form:form action="/logout}"
                           method="POST">
                    <input type="submit" value="Logout" class="logout-button"/>
                </form:form>
            </menu>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Available</th>
                    <th>Review</th>
                    <th>Review</th>
                </tr>
                <c:forEach var="tempProduct" items="${productList}">

                    <c:url var="updateLink" value="/product/updateProduct">
                        <c:param name="productId" value="${tempProduct.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/product/deleteProduct">
                        <c:param name="productId" value="${tempProduct.id}"/>
                    </c:url>
                    <c:url var="addReviewLink" value="/product/addReview">
                        <c:param name="productId" value="${tempProduct.id}"/>
                    </c:url>
                    <c:url var="reviewLink" value="/product/reviews">
                        <c:param name="productId" value="${tempProduct.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempProduct.name}</td>
                        <td>${tempProduct.price}</td>
                        <td>
                            ${tempProduct.available ?
                            '<i class="fi fi-ss-check"></i>' : '<i class="fi fi-ss-cross"></i>'}</td>
                        <td><a href="${addReviewLink}">Add Review</a> </td>
                        <td>
                            <a href="${reviewLink}">
                                ${tempProduct.avgReviewRate == 0.0 ? 'no ratings yet' : tempProduct.avgReviewRate}
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
