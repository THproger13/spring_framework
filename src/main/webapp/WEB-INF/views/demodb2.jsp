<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>demodb2.jsp</h2>
    <table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
    </tr>
    <c:forEach items="${demoList}" var="demo">

    <tr>
        <td>
            <a href="/find?id=${demo.id} ">
        </td>
        <td>${demo.name}</td>
        <td>${demo.age}</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>