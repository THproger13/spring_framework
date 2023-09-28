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
<button onclick="ajax02()">함수호출</button>
</body>
<script>
    const ajax02 = () => {
        $.ajax({
            type : "get",
            url : "/ajax02",
            success : function (res) {
                console.log("성공", res);
                location.href = "/"; //homeController의 메서드로가서 index를 리턴하는 방식으로 동작
            },
            error : function () {
                console.log("실패");
            }
        });
    }
</script>
</html>
