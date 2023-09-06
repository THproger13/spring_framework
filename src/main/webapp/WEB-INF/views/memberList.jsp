<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-05
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        table {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="component/header.jsp" %>
<%@include file="component/nav.jsp" %>
<div class="container">
    <div id="member-list">
        <table class="table table-bordered">

    <tr>
        <td>id</td>
        <td>이메일</td>
        <td>비밀번호</td>
        <td>회원이름</td>
        <td>생년월일</td>
        <td>전화번호</td>
        <td>조회</td>
        <td>삭제</td>

    </tr>
    <c:forEach items="${memberDTOList}" var="member">
        <tr>
            <td>
                ${member.id}
            </td>
            <td>    ${member.memberEmail}</td>
            <td>    ${member.memberPassword}</td>
            <td>    ${member.memberName}</td>
            <td>    ${member.memberBirth}</td>
            <td>    ${member.memberMobile}</td>

        </tr>
    </c:forEach>
</body>
</html>