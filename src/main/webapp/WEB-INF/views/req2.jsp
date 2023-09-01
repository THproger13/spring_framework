
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>req2.jsp</h1>
    controller 에서 담아온 DemoDTOList 값 출력<br>

    <c:forEach items="${demoList}" var = "demo">
        ${demo} <br>
        ${demo.name} <br>
        ${demo.age} <br>
    </c:forEach >

</body>
</html>