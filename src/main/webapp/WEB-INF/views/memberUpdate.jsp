<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-09-05
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/main.css">

    <style>
        #section {
            margin: auto;
        }
    </style>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<h2>회원 정보 수정.jsp</h2>
<div id="section">
<form action="/memberUpdate" method="post" name="updateForm">
    <!--폼 태그 안에서 버튼을 그냥 사용해 버리면 그냥 제출처리가 된다.
따라서 버튼 태그를 바로 만들지 말고 그냥 input 타입 안에서 type을 "button"으로 한다. -->
    <input type="hidden" name="id" value="${member.id}">
    이메일: <input class="form-control" type="text" name="memberEmail" value="${member.memberEmail}" readonly> <br>
    비밀번호: <input class="form-control" type="text" id="member-password" name="memberPassword"><br>
    이름: <input class="form-control" type="text" name="memberName" value="${member.memberName}" readonly> <br>
    생년월일: <input class="form-control" type="text" name="memberBirth" value="${member.memberBirth}"> <br>
    전화번호: <input class="form-control" type="text" name="memberMobile" value="${member.memberMobile}"> <br>
    <input type="button" value="수정" onclick="update_fn()">
</form>
<%@include file="component/footer.jsp"%>

</body>
<script>

    const update_fn = () => {
        const inputEmailPassword = document.getElementById("member-password").value;
        const passDB = '${member.memberPassword}';
        if(passDB === inputEmailPassword){
            alert('${member.memberName}' + "님 회원정보가 수정 되었습니다.");
            document.updateForm.submit();
        }else{
            alert("비밀번호가 일치하지 않습니다.")
        }
    }

</script>
</html>