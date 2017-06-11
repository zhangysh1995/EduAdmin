<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: KellyZhang
  Date: 2017/5/31
  Time: 上午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Title</title>
        </head>
        <body>
        <form:form method="POST" action="/loginAction.do">
            <table>
                <tr>
                    <td><label>Username</label></td>
                    <td><input name="username" type="text" class="text"></td>
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input name="password" type="password" class="text"></td>
                </tr>
                <tr>
                    <td><label>Your role</label></td>
                    <td>
                        <select name="role">
                            <option value="student">Student</option>
                            <option value="teacher">Teacher</option>
                            <option value="admin">Administrator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <input type="submit" value="Login" />
                    <input type="reset"  value="Reset" />
            </tr>
        </table>

    </form:form>

</body>
</html>
