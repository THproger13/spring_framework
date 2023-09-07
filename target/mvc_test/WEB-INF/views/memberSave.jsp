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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>memberSave.jsp</h2>
<form action="/memberSave" method="post">
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
    const checkEmail = () => {
        $('#memberEmail').keyup = () => { // 이메일 입력 필드에서 키 입력 감지
            let email = $('#memberEmail').val();
            if (email !== '') {
                $.ajax({
                    type: 'post',
                    url: '/check-email', // 서버의 이메일 중복 체크 엔드포인트 URL로 변경
                    data: { memberEmail: email },
                    success: function (response) {
                        if (response != null) {
                            $('#emailStatus').text('이미 사용 중인 이메일입니다.');
                        } else {
                            $('#emailStatus').text('사용 가능한 이메일입니다.');
                        }
                    }
                });
            } else {
                $('#emailStatus').text('');
            }
        });
    });
</script>
</html>