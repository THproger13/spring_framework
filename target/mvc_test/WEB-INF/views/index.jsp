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
        <link rel="stylesheet" href="/resourses/css/main.css">
    </head>
    <body>
    <%@include file="component/header.jsp"%>
    <%@include file="component/nav.jsp"%>

    <h2>시작페이지</h2>
    <a href="/memberSave">회원 가입 링크이동</a><br>

    <a href="/memberList">회원 목록 링크이동</a><br>

    <a href="/memberLogin">로그인 링크이동</a>

    로그인 이메일 : ${sessionScope.loginEmail}
    model에 담은 이메일 : ${email} <br>

    <a href="/ajax">ajax 알아보기</a>

    <%@include file="component/footer.jsp"%>

    </body>
    </html>
