<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>list.jsp</h2>
    <table>
        <tr>
            <td>id</td>
            <td>학번</td>
            <td>이름</td>
            <td>학과</td>
            <td>전화번호</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${studentDTOList}" var="student">
            <tr>
                <td>
                    <a href="<c:url value='/find?id=${student.id}' />">${student.id}</a>
                </td>
                <td>${student.studentNumber}</td>
                <td>${student.studentName}</td>
                <td>
                    <input type="text" id="major_${student.id}" value="${student.studentMajor}" />
                </td>
                <td>
                    <input type="text" id="mobile_${student.id}" value="${student.studentMobile}" />
                </td>
                <td>
                    <button onclick="update(${student.id})">수정</button>
                </td>
                <td>
                    <button onclick="deleteStudent(${student.id})">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    function update(id) {
        const newMajor = $(`#major_${id}`).val();
        const newMobile = $(`#mobile_${id}`).val();

        const encodedMajor = encodeURIComponent(newMajor);
        const encodedMobile = encodeURIComponent(newMobile);

        $.ajax({
            url: '/reqdb2',
            type: 'POST',
            data: {
                id: id,
                studentMajor: encodedMajor,
                studentMobile: encodedMobile
            },
            success: function() {
                location.reload(); // 화면 갱신
            }
        });
    }

    function deleteStudent(id) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            location.href = `/delete?id=${id}`;
        }
    }
</script>

<script>
   function update(id) {
       const newMajor = document.getElementById(`major_${id}`).value;
       const newMobile = document.getElementById(`mobile_${id}`).value;

       const encodedMajor = encodeURIComponent(newMajor);
       const encodedMobile = encodeURIComponent(newMobile);

       const xhr = new XMLHttpRequest();
       xhr.open("POST", "/reqdb2", true);
       xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
       xhr.onreadystatechange = function() {
           if (xhr.readyState === 4 && xhr.status === 200) {
               location.reload(); // 화면 갱신
           }
       };
       xhr.send(`id=${id}&studentMajor=${encodedMajor}&studentMobile=${encodedMobile}`);
   }

   function deleteStudent(id) {
       if (confirm("정말로 삭제하시겠습니까?")) {
           location.href = `/delete?id=${id}`;
       }
   }

</script>
