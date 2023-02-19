<%--
  Created by IntelliJ IDEA.
  User: Bartek_Programowanie
  Date: 02.02.2023
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>List of Users</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicons-solid-straight.css">
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
            <input type="button" value="add user"
                   onclick="window.location.href='add'; return false"
                   class="add-button"/>
            <form:form action="/logout"
                       method="POST">
                <input type="submit" value="Logout" class="logout-button"/>
            </form:form>
        </menu>
        <table>
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>username</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="tempUser" items="${userList}">

                <c:url var="updateLink" value="/manage/user/update">
                    <c:param name="userId" value="${tempUser.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/manage/user/delete">
                    <c:param name="userId" value="${tempUser.id}"/>
                </c:url>

                <tr>
                    <td>${tempUser.firstName}</td>
                    <td>${tempUser.lastName}</td>
                    <td>${tempUser.username}</td>
                    <td>
                        <a href="${updateLink}" class="action-button update-button">
                            <i class="fi fi-ss-pencil"></i>
                        </a>
                        <a href="${deleteLink}" class="action-button delete-button">
                            <i class="fi fi-ss-trash"></i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>



</body>
</html>
