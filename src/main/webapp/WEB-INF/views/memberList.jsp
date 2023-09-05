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
</head>
<body>
<h2>회원 목록</h2>
<h3>memberList.jsp</h3>
<table>
    <tr>
        <td>id</td>
        <td>이메일</td>
        <td>비밀번호</td>
        <td>회원이름</td>
        <td>생년월일</td>
        <td>전화번호</td>
    </tr>
    <c:forEach items="${MemberDTOList}" var="member">
        <tr>
            <td>
                <a href="/memberDetail?id=${member.id}">${member.id}</a>
            </td>
            <td>${member.memberEmail}</td>
            <td>${member.studentName}</td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberBirth}</td>
            <td>${member.memberMobile}</td>
<%--            <td>--%>
<%--                <button onclick="update_fn('${student.id}')">수정</button>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <button onclick="delete_fn('${student.id}')">삭제</button>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
