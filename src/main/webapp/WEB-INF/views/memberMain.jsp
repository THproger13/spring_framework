
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resourses/css/main.css">

</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>메인 페이지</h2>
//세션의 값을 꺼낼때는 sessionScope를 사용한다.

로그인 이메일 : ${sessionScope.loginEmail}
model에 담은 이메일 : ${email} <br>

<!--로그인 계정이 admin인 경우에만 회원 목록 링크가 보임-->
<c:if test="${sessionScope.loginEmail == 'admin1'}">
    <a href="/membersList">회원목록</a>
</c:if>

<a href="/logout">로그아웃</a><br>
<a href="/memberUpdate">회원 정보 수정</a><br>
<a href="/">index로 이동 </a>

<%@include file="component/footer.jsp"%>

</body>
</html>