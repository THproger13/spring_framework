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
    <style>
        body {
            background-image: url('https://www.freecodecamp.org/news/content/images/size/w2000/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    </style>
    <title>Member Board Project</title>
    <%--    <link rel="stylesheet" href="/resourses/css/main.css">--%>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>

<h2>HomePage</h2>

<%--<a href="/member/save">Sign Up</a><br>--%>

<%--<a href="/member/login">Sign In</a><br>--%>

<%--<a href="/board/list">Contents List</a><br>--%>

<%--<a href="/member/sample">Create Sampledata</a>--%>

<%--로그인 이메일 : ${sessionScope.loginEmail}--%>
<%--model에 담은 이메일 : ${email} <br>--%>

<%@include file="component/footer.jsp"%>

</body>
</html>