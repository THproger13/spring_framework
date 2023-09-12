<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오후 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 수정</title>
</head>
<body>
<div class = "update_check_container_form">
    <form action="/board/update" method="post" id = "update-form">
        <h2 class="form__title">Update Board</h2>
        <input type = "hidden" name = "id" value="${board.id}"><br>
        <input type = "text" placeholder="boardWriter" name="boardWriter" value="${board.boardWriter}" readonly><br>
        <input type = "password" placeholder="Type Confirm boardPass here!" id = "boardPass" name="boardPass" ><br>
        <input type = "text" placeholder="boardTitle" value="${board.boardTitle}" name="boardTitle" ><br>
        <textarea placeholder="update your contents here!!" value="${board.boardContents}" name="boardContents" cols="30" rows="10"></textarea> <br>
        <input type="button" value="WriteContent" onclick="confirmUpdate('${board.boardPass}')">
    </form>
</div>
</body>
<script>
    const inputPass = document.getElementById("boardPass").value;
    const boardTitle = "${board.boardTitle}";

    const confirmUpdate = (boardPass) => {
        if(inputPass === boardPass) {
            confirm("Are you sure to update " + boardTitle + "?");
            document.getElementById("update-form").submit();
        }else{
            alert("Password does not match!");
        }
    }

</script>
</html>
