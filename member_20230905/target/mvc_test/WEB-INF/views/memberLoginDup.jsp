<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>로그인 페이지</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>로그인 페이지</h2>

<form class = "dropdown-item-text" action="/memberLogin" method="post">
  이메일: <input class="form-control" type="text" name="memberEmail" id ="memberEmail"> <br>
  비밀번호: <input class="form-control" type="text" name="memberPassword" id = "memberPassword"> <br>
  <input type="submit" value="로그인">
</form>
<%@include file="component/footer.jsp"%>

</body>
<script>

</script>
</html>