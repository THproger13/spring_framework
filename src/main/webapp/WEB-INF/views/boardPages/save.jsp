<%--
  Created by IntelliJ IDEA.
  User: thphy
  Date: 2023-09-16
  Time: 오후 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Write Contents</title>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>

<div class = "container_form">
  <form action="/board/save" method="post" name="boardSave" enctype="multipart/form-data">
<%--    <input type="hidden" name="boardWriterId" value="${sessionScope.loginId}"> <br>--%>
    <input type="text" name="boardWriter" placeholder="boardWriter" value="${sessionScope.loginEmail}" readonly> <br>
    <input type="text" id="boardTitle" name="boardTitle" placeholder="boardTitle"> <br>
    <textarea cols="50" rows="10" id="boardContents" name="boardContents" placeholder="boardContents"></textarea> <br>
    <input type="file" name="boardFile" multiple accept="image/*"> <br>
    <button onclick="is_submitted()">Write Contents</button>
  </form>
</div>

<%@include file="component/footer.jsp"%>

</body>
<script>
  const is_submitted = () => {
    const boardTitle = document.getElementById("boardTitle").value;
    const boardContents = document.getElementById("boardContents").value;

    if(boardTitle != null && boardContents != null) {
      alert("new Contents successfully saved!!");
    }else if (boardTitle != null) {
      alert("please Write boardTitle!!");
    }else if(boardContents != null) {
      alert("please Write boardContents!!");
    }else{
      alert("please Write boardTitle and boardContents!!");
    }
  }
</script>
</html>
