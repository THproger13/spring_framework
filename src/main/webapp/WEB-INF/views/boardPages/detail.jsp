<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Content detail</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
          crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <style>
    @import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap");
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    body {
      background: #e8efff;
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100%;
      height: 100vh;
    }

    .like__btn {
      padding: 10px 15px;
      background: linear-gradient(to right, #800080, #00008B); /* 자주색에서 짙은 바다색으로 그라데이션 효과 */
      font-size: 14px;
      font-family: "Open Sans", sans-serif;
      border-radius: 5px;
      color: #e8efff;
      outline: none;
      border: none;
      cursor: pointer;
      width: 10%;
      float: right;
    }

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
    <div class="card p-3">
      <h5 class="card-title">${board.boardTitle}</h5>
      <hr>
      <h6 class="card-subtitle mb-4 text-body-secondary text-end">boardWriter: ${board.boardWriter}
        boardHits: ${board.boardHits}  </h6>

      <!--좋아요 버튼-->
      <button class="like__btn" data-board-id="${board.boardId}">
        <span name="icon" id="icon"><i class="far fa-thumbs-up"></i></span>
        <span name="likeCount" id="likeCount">0</span> Like
      </button>
      <!--좋아요 버튼-->

      <p class="card-text">${board.boardContents}</p>
      <c:if test="${board.fileAttached == 1}">
        <div class="row">
          <c:forEach items="${boardFileList}" var="boardFile">
            <div class="col-3 text-center">
              <img src="${pageContext.request.contextPath}/board_upload/${boardFile.storedFileName}" alt="" width="80%">
            </div>
          </c:forEach>
        </div>
      </c:if>
      <h6 class="card-subtitle mb-2 text-body-secondary text-end">Wrote On: ${board.createdAt}</h6>
      <div class="text-center">
        <c:if test="${sessionScope.loginEmail == board.boardWriter}">
          <button class="btn btn-primary px-3" onclick="update_fn('${board.boardId}')">Update</button>
        </c:if>
        <button class="btn btn-secondary px-3" onclick="list_fn()">Contents List</button>
        <c:if test="${sessionScope.loginEmail == board.boardWriter || sessionScope.loginEmail == 'admin'}">
          <button class="btn btn-danger px-3" onclick="delete_fn('${board.boardId}')">Delete</button>
        </c:if>
      </div>
    </div>

    <div id="comment-write-area">
      <input type ="text" name="commentWriter" id ="commentWriter" value="${sessionScope.loginEmail}" readonly>
      <input type ="text" name="commentContents" id="commentContents" placeholder="Write Comment Here">
      <button onclick="comment_write()">Comment write</button>
    </div>
<%--    comment-list-area의 경우 ajax으로 보내주는 테이블의 형식이랑 같아야 한다
그렇게 로직을 짜지 않으면 ajax으로 새로운 댓글을 보낼때 ajax으로 받아온 형식대로 테이블 형식이 바뀌어 버린다. --%>
    <div id="comment-list-area">
      <c:choose>
        <c:when test="${commentList == null}">
          <h3>No Comments Written</h3>
        </c:when>
        <c:otherwise>
          <table id = "comment-list">
            <tr>
              <th>CommentId</th>
              <th>Comment Writer</th>
              <th>Comment Contents</th>
              <th>Comment Written At</th>
              <th>Delete Comment</th>
            </tr>
              <c:forEach items="${commentList}" var="comment">
            <tr>
              <td class="commentId">${comment.commentId}</td>
              <td>${comment.commentWriter}</td>
              <td>${comment.commentContents}</td>
              <td>${comment.commentCreatedDate}</td>
              <button onclick="delete_comment_confirm(this)">Delete Comment</button>
            </tr>
            </c:forEach>
          </table>
        </c:otherwise>
      </c:choose>
    </div>

    <%@include file="../component/footer.jsp" %>
  </div>
</div>
</body>
<script>

//좋아요 버튼 동작 정의
  const likeBtn = document.querySelector(".like__btn");
  let likeIcon = document.querySelector("#icon");
  let likeCount = document.querySelector("#likeCount");
  const boardId = "${board.boardId}";

  // let isClicked = false;

likeBtn.addEventListener("click", () => {
  $.ajax({
    url: "/Like/like",
    type: "POST",
    data: {boardId: boardId},
    success: function (res) {
      if (res.success) {
        likeCount.textContent = res.likeCount;
        likeIcon.innerHTML = res.isClicked ? `<i class="fas fa-thumbs-up"></i>` : `<i class="far fa-thumbs-up"></i>`;
        // } else {
        //   alert(res.message);
        // }
      }
    },
    error: function (error) {
      console.log(error);
      alert("An error occurred");
    }
  });
});
//좋아요 버튼 동작 정의 끝


const page = '${page}';
  const type = '${type}';
  const q = '${q}';

  const update_fn = (boardId) => {
    location.href = "/board/update?boardId=" + boardId;
  }
  const list_fn = () => {
    location.href = "/board/list?page=" + page + "&searchType=" + type + "&q=" + q;
  }
  const delete_fn = (boardId) => {
    if(confirm("해당 게시글을 삭제하시겠습니까?")) {
      location.href = "/board/delete?boardId=" + boardId;
    }
  }
  const delete_comment_confirm = (buttonElement) => {
    if (confirm("are you sure to delete comment?")) {
      const commentIdElement = buttonElement.parentElement.parentElement.querySelector('.commentId');
      if (commentIdElement) {
        const commentId = commentIdElement.textContent;
        return delete_comment(commentId);
      } else {
        console.error("Comment ID element not found.");
      }
    } else {
      location.href = "/board/FindAll";
    }
  }

  const delete_comment = (commentId) => {
    location.href = "/comment/delete?commentId=" + commentId;
  }

  const comment_write = () => {
    const commentWriter = document.getElementById("commentWriter").value;
    const commentContents = document.getElementById("commentContents").value;
    // const commentCreatedDate = 'comment.commentCreatedDate';
    const boardId = '${board.boardId}';
    const result = document.getElementById("comment-list-area");

    $.ajax ({
      type:"post",
      url:"/comment/saveAjax",
      data:{
        commentWriter : commentWriter,
        commentContents : commentContents,
        boardId : boardId
      },
      success: function (res) {
        console.log("리턴값: ", res);
        let output = "<table id=\"comment-list\">\n" +
                "    <tr>\n" +
                "        <th>commentWriter</th>\n" +
                "        <th>commentContents</th>\n" +
                "    </tr>\n";
        for (let i in res) {
          output += "    <tr>\n";
          output += "        <td>" + res[i].commentWriter + "</td>\n";
          output += "        <td>" + res[i].commentContents + "</td>\n";
          output += "    </tr>\n";
        }
        output += "</table>";
        result.innerHTML = output;
        // document.getElementById("comment-writer").value = "";
        document.getElementById("comment-contents").value = "";
      },
      error: function () {
        console.log("댓글 작성 실패");
      }
    });
    }

</script>
</html>