<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>list.jsp</h2>
    <table>
    <tr>
        <td>id</td>
        <td>학번</td>
        <td>이름</td>
        <td>학과</td>
        <td>전화번호</td>

    </tr>
    <c:forEach items="${studentDTOList}" var="student">
    <tr>
        <td>
            <a href="<c:url value='/find?id=${student.id}' />">${student.id}</a>
        </td>
        <td>${student.studentNumber}</td>
        <td>${student.studentName}</td>
        <td>${student.studentMajor}</td>
        <td>${student.studentMobile}</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>