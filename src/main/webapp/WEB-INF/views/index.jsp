<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>안녕하세요~ 반갑습니다!!</h1>
    <!--페이지 이동-->
    <!--demo1 주소를 요청하는 링크-->
    <a href = "/demo1">demo1.jsp로 이동</a>

    <!--form 태그로 파라미터 보내기-->
    <form action ="/demo2" method = "post">
        param1 : <input type="text" name = "param1"> <br>
        param2 : <input type="text" name = "param2"> <br>
        <input type="submit" value = "전송">
    </form>

     <form action ="/demo3" method = "post">
            param1 : <input type="text" name = "param1"> <br>
            param2 : <input type="text" name = "param2"> <br>
            <input type="submit" value = "전송">
        </form>

        <a href = "/result1">변수 화면에 출력</a>
        <a href = "/result2">DTO 객체 화면에 출력</a>
        <a href = "/result3">List 객체 화면에 출력</a>

</body>
</html>