<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>req5.jsp</h2>
    controller에서 담아온 StudyDTOList 값 출력 <br>

    <c:forEach items="${studyList}" var="study">
        ${study.p1}, ${study.p2}, ${study.p3}<br>
    </c:forEach>

</body>
</html>