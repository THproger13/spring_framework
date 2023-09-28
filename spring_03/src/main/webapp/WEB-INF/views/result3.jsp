<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>result3.jsp</h1>
    controller 에서 담아온 DemoDTOList 값 출력 <br>
    <c:forEach items = "${demoList}" var ="demo">
        ${demo.param1}, ${demo.param2} <br>
    </c:forEach>

</body>
</html>