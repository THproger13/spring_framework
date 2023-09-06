<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-05
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>회원 정보 수정.jsp</h2>

<form action="/memberUpdate" method="post">
    이메일: <input class="form-control" type="text" name="memberEmail" > <br>
    비밀번호: <input class="form-control" type="text" name="memberPassword"> <br>
    이름: <input class="form-control" type="text" name="memberName"> <br>
    생년월일: <input class="form-control" type="text" name="memberBirth"> <br>
    전화번호: <input class="form-control" type="text" name="memberMobile"> <br>
    <input type="submit" value="전송">
</form>
<%@include file="component/footer.jsp"%>

</body>
</html>