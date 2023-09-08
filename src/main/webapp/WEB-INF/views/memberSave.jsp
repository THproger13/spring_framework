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
    <link rel="stylesheet" href="/resources/css/min.css">

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>memberSave.jsp</h2>
<form action="/memberSave" method="post">
    <!--onblur를 사용하면 해당 태그선택이 벗어나면 실행이 되는 방식이다. onkeyup의 경우
     키를 누를 때마다 서버에 요청을 하게 되므로 서버 부담을 줄일거면 onblur를 고려하기-->
    이메일: <input class="form-control" type="text" name="memberEmail" id="memberEmail"> <br>
    <span id="emailStatus"></span> <br>
    비밀번호: <input type="text" name="memberPassword"> <br>
    이름: <input type="text" name="memberName"> <br>
    생년월일: <input type="text" name="memberBirth"> <br>
    전화번호: <input type="text" name="memberMobile"> <br>
    <input type="submit" value="전송">
</form>
<%@include file="component/footer.jsp"%>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('#memberEmail').keyup(function () { // 이메일 입력 필드에서 키 입력 감지
            const email = $('#memberEmail').val();
            const emailStatus = $('#emailStatus');
            if (email !== '') {
                $.ajax({
                    type: 'post',
                    url: '/check-email',
                    data: { memberEmail: email },
                    success: function (response) {
                        console.log("서버 응답:", response); // 디버깅용 코드

                        if (response === "equals") {
                            emailStatus.text('이미 사용 중인 이메일입니다.');
                            emailStatus.css('color', 'red');
                        } else {
                            emailStatus.text('사용 가능한 이메일입니다.');
                            emailStatus.css('color', 'green');
                        }
                    },
                    error: function (xhr, status, error) {
                        console.log("에러:", error);
                    }
                });
            } else {
                emailStatus.text('');
            }
        });
    });
</script>

</html>