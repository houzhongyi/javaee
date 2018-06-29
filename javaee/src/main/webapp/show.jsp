<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nash
  Date: 2018/6/10
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>印象彼岸</title>
</head>
<body>
<table border="2">
	<h1>SSM项目测试</h1>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
        <c:choose>
            <c:when test="${not empty requestScope.userList}">
                <c:forEach items="${requestScope.userList}" var="user" varStatus="vs">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.age}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="2">无数据</td>
                </tr>
            </c:otherwise>
        </c:choose>
    <tr>
        <td>'${time}'</td>
        <td>系统时间</td>
        <td>${time}</td>
    </tr>
    <input type="text" value="${time}">
</table>
</body>
</html>
