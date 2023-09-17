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
    <style>
        body {
            background-image: url('https://www.freecodecamp.org/news/content/images/size/w2000/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }

        .container, .input-group, .table {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 10px;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        .table th, .table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
    </style>
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
            <td class="button" onclick="confirm_delete('${member.memberId}')">Delete</td>
        </tr>
    </c:forEach>
    </table>
</div>

</body>
<script>
    const confirm_delete = (memberId) => {
        const confirmDelete = confirm("Do you want to delete " + memberId + "?");
        if (confirmDelete) {
            location.href = "/member/delete?memberId=" + memberId;
        }
    }
</script>
</html>

