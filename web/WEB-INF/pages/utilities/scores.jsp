<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KellyZhang
  Date: 2017/6/3
  Time: 下午5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Scores-${studentNo}</title>
</head>
<body>
<h2>Here are your scores.</h2>>
    <table>
        <tr>
            <td>CourseNumber   </td>
            <%--<td>Course Name </td>--%>
            <td>Score </td>
        </tr>
    <c:forEach var="score" items="${scores}">
        <tr>
            <td><c:out value="${score.getCourseNo()}" /></td>
            <%--<td>${score.getCourseName()}</td>--%>
            <td><c:out value="${score.getScore()}" /></td>>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
