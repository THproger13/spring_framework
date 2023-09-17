<%--
  Created by IntelliJ IDEA.
  User: thphy
  Date: 2023-09-14
  Time: 오후 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<form action="/member/login" method="post" id = "board-form">
    <h2 class="form__title">Sign In</h2>
    <input type = "text" placeholder="input memberEmail" id="memberEmail" name="memberEmail" ><br>
    <input type = "text" placeholder="input memberPassword" id="memberPassword" name="memberPassword" ><br>
    <input type="submit" value="Sign In">
</form>
<%@include file="component/footer.jsp"%>

</body>
</html>
