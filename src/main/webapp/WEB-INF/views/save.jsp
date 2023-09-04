<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>save.jsp</h2>
    <form action="/reqdb1" method="post">
        studentNumber: <input type="text" name="studentNumber"> <br>
        studentName: <input type="text" name="studentName"> <br>
        studentMajor: <input type="text" name="studentMajor"> <br>
        studentMobile: <input type="text" name="studentMobile"> <br>
        <input type="submit" value="전송">
    </form>

</body>
</html>