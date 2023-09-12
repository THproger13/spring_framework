
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
    <title>게시글 상세 조회</title>
</head>
<body>
    <h2>boardDetail.jsp</h2>
    ${board.id}<br>
    ${board.boardWriter}<br>
    ${board.boardPass}<br>
    ${board.boardTitle}<br>
    ${board.boardContents}<br>
    ${board.createdAt}<br>
    ${board.boardHits}<br>
    ${board.fileAttached}<br>

    <button type="button" class="btn btn-info" onclick="update_fn('${board.id}')">Update</button>
    <button type="button" class="btn btn-danger" onclick="delete_fn('${board.id}')">Delete</button>

<script>
    const update_fn = (id) => {
        location.href="/board/update?id=" +id;
    }

    const delete_fn = (id) => {
        location.href="/board/delete?id=" +id;
    }

</script>
</body>
</html>
