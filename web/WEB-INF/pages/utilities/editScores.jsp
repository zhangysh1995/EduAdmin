<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: KellyZhang
  Date: 2017/6/3
  Time: 下午5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scores-management</title>
</head>
<body>
<h2>You could add student scores here. </h2>
<form:form method="POST" action="/teacher/addScore" modelAttribute="score">
<table>
    <tr>
        <td><form:label path="studentNo">Student Number</form:label></td>
        <td><form:input path="studentNo"/></td>
    </tr>
    <tr>
        <td><form:label path="courseNo">Course Number</form:label></td>
        <td><form:input path="courseNo"/></td>
    </tr>
    <tr>
        <td><form:label path="score">Score</form:label></td>
        <td><form:input path="score"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit" /></td>
    </tr>
</table>
</form:form>
<table>
    <tr>
        <td>Student Number    </td>
        <td>Course Number    </td>
        <td>Score</td>
    </tr>

    <c:forEach var="row" items="${rows}">
        <tr>
            <td><c:out value="${row.getStudentNo()}" /></td>
            <td><c:out value="${row.getCourseNo()}" /></td>
            <td><c:out value="${row.getScore()}" /></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
