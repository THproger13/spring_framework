<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-07
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>
<body>
<button onclick="ajax09()">함수호출</button>
</body>
<script>
    const ajax09 = () => {
        const email = "member1@member.com";
        const password = "1234";
        const name = "이름1";
        const member = {
            memberEmail : email,
            memberPassword : password,  //좌변의 키에는 dto의 필드 명과 같은 값을 넣어줘야 함
            memberName : name
        }
        $.ajax({
            type : "post",
            url : "/ajax09",
            //JSON 데이터 전송
            data : JSON.stringify(member),
            contentType : "application/json",
            success : function (res) {
                console.log("성공", res);
            },
            error : function () {
                console.log("실패");
            }
        });
    }
</script>
</html>
