<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-11
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글작성</title>
</head>
<body>
<div class = "container_form">
    <form action="/board/save" method="post" enctype="multipart/form-data" id = "board-form">
        <h2 class="form__title">WriteContent</h2>
        <input type = "text" placeholder="boardWriter" name="boardWriter" ><br>
        <input type = "password" placeholder="boardPass" name="boardPass" ><br>
        <input type = "text" placeholder="boardTitle" name="boardTitle" ><br>
        <textarea placeholder="write your contents here!!" name="boardContents" cols="30" rows="10"></textarea> <br>
        <input type = "file" name = "boardFile" multiple><br>
        <input type="submit" value="WriteContent" >
    </form>
</div>
</body>
</html>
