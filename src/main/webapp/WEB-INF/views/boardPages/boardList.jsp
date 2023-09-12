<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>게시글 목록</title>
</head>
<body>
<div class="container">
    <div id="board-list">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>boardWriter</td>
                <td>boardPass</td>
                <td>boardTitle</td>
                <td>boardContents</td>
                <td>createdAt</td>
                <td>boardHits</td>
                <td>fileAttached</td>
            </tr>
            <c:forEach items="${boardDTOList}" var="board">
                <tr>
                    <td>
                        <a href="#" onclick="board_detail('${board.id}')">${board.id}</a>
                    </td> <br>
                    <td>${board.boardWriter}</td><br>
                    <td>${board.boardPass}</td><br>
                    <td>${board.boardTitle}</td><br>
                    <td>${board.boardContents}</td><br>
                    <td>${board.createdAt}</td><br>
                    <td>${board.boardHits}</td><br>
                    <td>${board.fileAttached}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
<!--"window.location.href"는 URL을 설정하는 것이 아니라 읽기 전용 속성이므로
        '=' 연산자를 사용하여 URL을 설정해야 한다. 그리고 또 하나의 문제는
    URL에 #을 붙여서 페이지를 변경하려는 시도 였다.
        #은 페이지 내부의 앵커로 사용되며, 외부 URL로 이동할 때는 /를 사용해야 한다.
        절대로 "window.location.href = /boardPages/boardDetail?id=" + "id"
    식으로 바로 url주소를 넣어주는 실수를 하지 말자-->
<script>
    const board_detail = (id) => {
        const url = "/board/detail?id=" + id;
        window.location.href = url;
    }
</script>
</html>
