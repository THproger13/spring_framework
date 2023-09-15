<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-15
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class = "container_form">
    <table>
        <tr>
            <th>memberId</th>
            <th>memberEmail</th>
            <th>memberPassword</th>
            <th>memberName</th>
            <th>memberMobile</th>
            <th>memberProfileAttached</th>
        </tr>
    <c:forEach items = "${memberDTOList}" var = "member">
        <tr>
            <td>${member.memberId}</td>
            <td>${member.memberEmail}</td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberMobile}</td>
            <td>${member.memberProfileAttached}</td>
            <td class="button" onclick="confirm_delete('${member.memberEmail}')">Delete</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
<script>
    const confirm_delete = (memberEmail) => {
        const confirmDelete = confirm("Do you want to delete " + memberEmail + "?");
        if (confirmDelete) {
            location.href = "/member/delete?memberEmail=" + memberEmail; // 컨트롤러로 이동하고 이메일을 파라미터로 전달
        }
    }
</script>
</html>
