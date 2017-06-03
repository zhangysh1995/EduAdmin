<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: KellyZhang
  Date: 2017/5/31
  Time: 上午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Me-teacher</title>
</head>
<body>
<form:form method="POST" action="/teacher/change" modelAttribute="teacher">
    <h2>You could change your <b>password</b> or click <a href="/teacher/scores"><b>here</b></a> for managing scores. </h2>
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username" value="${username}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input type="password" path="password" value="${password}"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" value="${name}"  readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="teacherNo">Teacher number</form:label></td>
            <td><form:input path="teacherNo" value="${teacherNo}" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="dept">Department</form:label></td>
            <td><form:input path="dept" value="${dept}"  readonly="true"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Change Info" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
