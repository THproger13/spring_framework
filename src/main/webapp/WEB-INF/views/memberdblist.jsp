<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>memberdblist.jsp</h2>
    <table>
    <tr>
        <td>id</td>
        <td>이메일</td>
        <td>비밀번호</td>
    </tr>
    <c:forEach items="${memberList}" var="member">
    <tr>
        <td>
            <a href="/find?id=${member.id}">${member.id}</a>
        </td>
        <td>${member.email}</td>
        <td>${member.password}</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>