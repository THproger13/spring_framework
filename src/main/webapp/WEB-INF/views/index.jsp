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
<%--    <link rel="stylesheet" href="/resourses/css/main.css">--%>
</head>
<body>
<%--<%@include file="component/header.jsp"%>--%>
<%--<%@include file="component/nav.jsp"%>--%>

<h2>시작페이지</h2>
<a href="/board/save">글 작성</a><br>

<a href="/board/list">글 목록</a><br>


<%--로그인 이메일 : ${sessionScope.loginEmail}--%>
<%--model에 담은 이메일 : ${email} <br>--%>


<%--<%@include file="component/footer.jsp"%>--%>

</body>
</html>