<%--
  Created by IntelliJ IDEA.
  User: thphy
  Date: 2023-09-14
  Time: 오후 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board Contents</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
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
<div class="row justify-content-center">
    <div class="col-10">
        <%@include file="../component/header.jsp" %>
        <%@include file="../component/nav.jsp" %>
        <h3 class="text-center mb-3">board List</h3>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-10">
        <div class="row justify-content-end">
            <div class="col-4">
                <form action="/board/list">
                    <div class="input-group mb-3">
                        <select class="form-select" name="searchType">
                            <option value="boardTitle" selected>boardTitle</option>
                            <option value="boardWriter">boardWriter(Email)</option>
                        </select>
                        <input name="q" class="form-control">&nbsp;
                        <button class="btn btn-primary">search</button>
                    </div>
                </form>
            </div>
        </div>
        <div id="list" class="m-3">
            <table class='table'>
                <tr class='table-table-boarder'>
                    <th>Id</th>
                    <th>글제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                <c:forEach items="${boardList}" var="board">
                    <tr>
                        <td>${board.boardId}</td>
                        <td><a href="/board?boardId=${board.boardId}&page=${paging.page}&searchType=${type}&q=${q}">${board.boardTitle}</a></td>
                        <td>${board.boardWriter}</td>
                        <td>${board.boardHits}</td>
                        <td>${board.createdAt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="container">
            <ul class="pagination justify-content-center">
                <c:choose>
                    <%-- 현재 페이지가 1페이지면 이전으로 이동을 제한 --%>
                    <c:when test="${paging.page<=1}">
                        <li class="page-item disabled">
                            <a class="page-link">[prev]</a>
                        </li>
                    </c:when>
                    <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="/board/list?page=${paging.page-1}&searchType=${type}&q=${q}">[prev]</a>
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
                                <a class="page-link" href="/board/list?page=${i}&searchType=${type}&q=${q}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${paging.page>=paging.maxPage}">
                        <li class="page-item disabled">
                            <a class="page-link">[next]</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="/board/list?page=${paging.page+1}&searchType=${type}&q=${q}">[next]</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <%@include file="../component/footer.jsp" %>
    </div>
</div>

</body>
</html>
