<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-05
  Time: 오전 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<h2>memberSave.jsp</h2>
<form action="/memberSave" method="post">
    이메일: <input class="form-control" type="text" name="memberEmail"> <br>
    비밀번호: <input type="text" name="memberPassword"> <br>
    이름: <input type="text" name="memberName"> <br>
    생년월일: <input type="text" name="memberBirth"> <br>
    전화번호: <input type="text" name="memberMobile"> <br>
    <input type="submit" value="전송">
</form>3
</body>
</html>
