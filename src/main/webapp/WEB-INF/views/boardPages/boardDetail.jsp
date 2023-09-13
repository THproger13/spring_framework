
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
    <title>게시글 상세 조회</title>
</head>
<body>
    <h2>boardDetail</h2>
    ${board.id}<br>
    ${board.boardWriter}<br>
    ${board.boardTitle}<br>
    ${board.boardContents}<br>
    ${board.boardHits}<br>
    <c:if test="${board.fileAttached ==1}">
        <tr>
            <th>image</th>
            <td>
                <c:forEach items="${boardFileList}" var="boardFile">
                <img src="${pageContext.request.contextPath}/upload/${boardFile.storedFileName}"
                     alt="" width="100" height="100">
                </c:forEach>
            </td>
        </tr>
    </c:if><br>

    <button type="button" class="btn btn-info" onclick="update_fn('${board.id}')">Update</button><br>
    <button type="button" class="btn btn-danger" onclick="delete_fn('${board.id}')">Delete</button><br>

    <h2>write Comment</h2>
    <button type="button" class="btn btn-success" onclick="startCommentWrite()">Write Comment</button><br>

<!--폼으로 할 필요가 없다. 애초에 submit을 하면 동기 처리인데 ajax를 사용하면 비동기 처리여서 script부분에서
비동기 통신을 하기 때문에 input 태그만 사용하면 된다. -->

    <form id = "comment-write-form" action = "/comment/save" method="post" style="display: none;">
        <input type="hidden" name="boardId" id="boardId" value="${comment.boardId}"><br>
        <input type="hidden" name="cid" id="cid" value="${comment.cid}"><br>
        <input type = "text" name="commentWriter" id="commentWriter"><br>
        <textarea placeholder="write your comment here!!" name="boardContent" id="boardContent" cols="30" rows="10"></textarea> <br>
        <input type = "button" onclick="commentWrite()" id="commentWriteButton">
    </form>

    <div class="commentsContainer">
        <h3 id="comments-title">comments</h3>
        <div id="comments-list">
            <!-- AJAX로 가져온 내용이 이곳에 표시 -->
        </div>
    </div>

    <script>
    const update_fn = (id) => {
        location.href="/board/update?id=" +id;
    }

    const delete_fn = (id) => {
        location.href="/board/delete?id=" +id;
    }

    const startCommentWrite = () => {
        const commentForm = document.getElementById("comment-write-form");
        commentForm.style.display = "block";
    }

    const commentWrite = () => {
        const boardId = $("#boardId").val();
        const cid = $("#cid").val();
        const commentWriter = $("#commentWriter").val();
        const commentContents = $("#boardContent").val();

        $.ajax({
            type: 'post',
            url: '/comment/save',
            data: {
                boardId: boardId,
                commentWriter: commentWriter,
                commentContents: commentContents
            },
            success: function (comments) {
                console.log("서버 응답", comments);
                let commentsResultHTML = '';

                if (comments.length > 0) {
                    commentsResultHTML += '<table class="table table-bordered">';
                    for (const comment of comments) {
                        commentsResultHTML += '<tr>';
                        commentsResultHTML += '<td>boardId: ' + comment.boardId + '</td>';
                        commentsResultHTML += '<td>commentWriter: ' + comment.commentWriter + '</td>';
                        commentsResultHTML += '<td>commentContents: ' + comment.commentContents + '</td>';
                        commentsResultHTML += '</tr>';
                    }
                    commentsResultHTML += '</table>';
                } else {
                    commentsResultHTML += '<p>아직 작성된 댓글이 없습니다.</p>';
                }

                $("#comments-list").html(commentsResultHTML);
            },
            error: function (xhr, status, error) {
                console.log("에러:", error);
                alert("댓글 작성에 실패했습니다.");
            }
        });
    }

    </script>
</body>
</html>
