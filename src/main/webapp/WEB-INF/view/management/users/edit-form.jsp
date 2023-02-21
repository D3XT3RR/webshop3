<%--
  Created by IntelliJ IDEA.
  User: sitv1
  Date: 20.02.2023
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<div id="wrapper">
  <div id="header">
    <h2>Sklep Internetowy</h2>
    <h3>Rejestracja użytkownika</h3>
  </div>
</div>
<div id="container">
  <div id="editUserForm">
    <form:form action="update" modelAttribute="user" method="post">
      <form:hidden path="id"/>
      <table>
        <tbody>
        <tr>
          <td><form:label path="firstName">First Name:</form:label></td>
          <td><form:input path="firstName"/></td>
        </tr>
        <tr>
          <td><form:label path="lastName">Last Name:</form:label></td>
          <td><form:input path="lastName"/></td>
        </tr>
        <tr>
          <td><form:label path="username">Username:</form:label></td>
          <td><form:input path="username"/></td>
        </tr>
        <tr>
          <td><form:label path="password"/>Password:</td>
          <td><form:password path="password"/></td>
        </tr>
        <tr>
          <td><form:label path="enabled">Enabled:</form:label></td>
          <td class="radio-buttons">
            <div class="radio-button"><form:radiobutton path="enabled" value="1" label="yes" /></div>
            <div class="radio-button"><form:radiobutton path="enabled" value="0" label="no" /></div>
            <form:hidden path="role.id"/>
          </td>

        </tr>
        <tr>
          <td><form:label path="role">Role:</form:label></td>
          <td class="radio-buttons">
            <div class="radio-button"><form:radiobutton path="role.authority" value="ROLE_ADMIN" label="admin" /></div>
            <div class="radio-button"><form:radiobutton path="role.authority" value="ROLE_USER" label="user"  /></div>
          </td>
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
      <a href="${pageContext.request.contextPath}/manage/user/list">Back to list</a>
    </p>

  </div>
</div>

</body>
</html>
