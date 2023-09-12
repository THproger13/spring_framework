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

<div class = "delete_check_container_form">
    <form method="post" action="/board/delete" id="delete-form">
        <h2 class="form__title">Delete Board</h2>
        <input type="hidden" name="id" value="${board.id}">
        <input type="hidden" name="boardTitle" value="${board.boardTitle}">
        <input type="password" placeholder="Type Confirm boardPass here!" id="boardPass" name="boardPass" required><br>
        <button type="button" class="btn btn-danger" onclick="confirmDelete()">Delete</button>
        <button type="button" class="btn btn-secondary" onclick="cancelDelete()">Cancel Delete</button>
    </form>
</div>

<script>
    const inputBoardPass = document.getElementById("boardPass");
    const boardTitle = "${board.boardTitle}";

    const confirmDelete = () => {
        const password = inputBoardPass.value;
        if (password === "${board.boardPass}") {
            if (confirm("Are you sure to delete " + boardTitle + "?")) {
                document.getElementById("delete-form").submit(); // 폼 제출
            }
        } else {
            alert("Password does not match!");
        }
    }
    const cancelDelete = () => {
        alert("cancel delete!!");
        window.location.href = "/board/boardList"; // 이동할 페이지 URL로 수정
    }
</script>

</body>
</html>
