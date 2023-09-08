<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-05
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/min.css">
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
<div class="memberListContainer">
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
            <td>${member.id}</td>
            <!--data-email 속성은 HTML 요소에 사용자 정의 데이터를 저장하기 위한 속성이다.
            사용자 지정 데이터 속성이기 때문에 'data-' 부분은 고정으로 작성하고 뒷부분은 원하는 이름을
            주면 된다.
            다음 코드에서는 회원들 각각의 이메일을 행의 셀(<td>)에 저장하기 위해 사용.
             좀더 자세히 설명하자면 data-email="{member.memberEmail}" 부분은 각 셀에 해당 이메일을
             data-email 속성으로 저장하고 있다. 이렇게 하면 JavaScript에서
             클릭 이벤트가 발생할 때 해당 셀에서 data-email 속성 값을 가져올 수 있다.-->
            <td class="email-cell" data-email="${member.memberEmail}">${member.memberEmail}</td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberBirth}</td>
            <td>${member.memberMobile}</td>
        </tr>
    </c:forEach>
        </table>
        <div class="memberDetailContainer">
            <h3 id="member-detail-title">회원 상세 정보</h3>
            <div id="member-detail">
                <!-- AJAX로 가져온 내용이 이곳에 표시 -->
            </div>
        </div>
    </div>
</div>
</body>

<script>
    $(document).ready(function() {
        $(".email-cell").on("click", function() {
            const email = $(this).data("email");
            $.ajax({
                type: 'post',
                url: '/detail-member-by-email',
                data: { memberEmail: email },
                success: function (res) {
                    console.log("서버 응답", res);
                    if (res !== null) {
                        let memberDetailResultHTML = '<table class="table table-bordered">';
                        memberDetailResultHTML += '<tr>';
                        memberDetailResultHTML += '<td>이메일: ' + res.memberEmail + '</td>';
                        memberDetailResultHTML += '<td>비밀번호: ' + res.memberPassword + '</td>';
                        memberDetailResultHTML += '<td>이름: ' + res.memberName + '</td>';
                        memberDetailResultHTML += '<td>생일: ' + res.memberBirth + '</td>';
                        memberDetailResultHTML += '<td>전화번호: ' + res.memberMobile + '</td>';
                        memberDetailResultHTML += '</tr>';
                        memberDetailResultHTML += '</table>';

                        // 회원 정보를 표시할 div 엘리먼트에 HTML을 추가합니다.
                        $("#member-detail").html(memberDetailResultHTML);
                    }
                },
                error: function (xhr, status, error) {
                    console.log("에러:", error);
                    alert("회원 정보가 없습니다!");
                }
            });
        });
    });

</script>
</html>