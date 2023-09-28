<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Update Contents Page</title>
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
    <form action="/board/update" method="post" name="boardUpdate" enctype="multipart/form-data">
      <input type="hidden" name="boardId" value="${board.boardId}">
      <div class="input-group mb-3">
        <span class="input-group-text">boardTitle</span>
        <input class="form-control" type="text" name="boardTitle" value="${board.boardTitle}">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text">boardWriter</span>
        <input class="form-control" type="text" name="boardWriter" value="${sessionScope.loginEmail}" readonly>
      </div>
      <div class="input-group mb-3">
        <textarea class="form-control" name="boardContents" placeholder="boardContents">${board.boardContents}</textarea>
      </div>
      <c:if test="${board.fileAttached == 1}">
        <div class="input-group mb-3">
          <span class="input-group-text">Choose delete File!</span>
          <c:forEach items="${boardFileList}" var="file">
            <input type="checkbox" name="deleteFile" value="${file.storedFileName}">${file.originalFileName}
          </c:forEach>
        </div>
      </c:if>
      <input type="hidden" name="fileAttached" value="${board.fileAttached}">
      <div class="input-group mb-3">
        <input class="form-control" type="file" name="boardFile" multiple accept="image/*">
      </div>
      <div class="input-group text-center">
        <button>Update</button>
        <button type="button" onclick="cancel_fn()">Cancel Update</button>
      </div>
    </form>
    <%@include file="../component/footer.jsp" %>
  </div>
</div>
</body>
<script>
  const cancel_fn = () => {
    location.href = "/board?boardId=" + ${board.boardId};
  }
</script>
</html>