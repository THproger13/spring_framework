<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<html>
<head>
    <title>게시글 목록</title>
</head>
<body>
<div id = "section">
    <!--검색 창-->
    <div class="container" id="search-area">
        <form action = "/board/list" method="get">
            <select name="type">
                <option value="boardTitle">boardTitle</option>
                <option value="boardWriter">boardWriter</option>
            </select>
            <input type="text" name="q" placeholder="검색어를 입력하세요">
            <input type="submit" value="검색">
        </form>

    </div>
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

<%-- 페이지 번호 출력 부분 --%>
<div class="container">
    <ul class="pagination justify-content-center">
        <!--choose를 사용하면 하위에 when, otherwise가 있다 이는 그냥 if, else문이라 생각-->
        <!--페이지값을 줄이는 경우-->
        <c:choose>
            <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
            <c:when test="${paging.page<=1}">
                <li class="page-item disabled">
                    <a class="page-link">[이전]</a>
                </li>
            </c:when>
            <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.page-1}">[이전]</a>
                </li>
            </c:otherwise>
        </c:choose>

        <%--  for(int i=startPage; i<=endPage; i++)      --%>
        <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
            <c:choose>
                <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
                <c:when test="${i eq paging.page}">
                    <li class="page-item active">
                        <a class="page-link">${i}</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="/board/list?page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:choose>
            <c:when test="${paging.page>=paging.maxPage}">
                <li class="page-item disabled">
                    <a class="page-link">[다음]</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item">
                    <a class="page-link" href="/board/list?page=${paging.page+1}">[다음]</a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
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
        const url = "/board/detail?id=" + id & page=${paging.page}";
        window.location.href = url;
    }
</script>
</html>
