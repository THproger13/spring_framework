<%--
  Created by IntelliJ IDEA.
  User: thphy
  Date: 2023-09-16
  Time: 오후 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<h2>My Page</h2>
<div class = "container">
    <form id="updateForm" action = "/member/update" method="post">
        <input type="hidden" name="memberId" id = "memberId" value="${member.memberId}">
        <input type="text" name="memberEmail" id = "memberEmail" value="${member.memberEmail}">
        <input type="text" name="memberPassword" id="memberPassword">
        <input type="text" name="memberName" id="memberName" value="${member.memberName}" readonly>
        <input type="text" name="memberMobile" id="memberMobile" value="${member.memberMobile}">
        <img src="${pageContext.request.contextPath}/uploadProfile/${memberProfile.storedFileName}"
             alt="" width="100" height="100">
        <button type="button" onclick="submitForm()">Submit</button>

    <%--        <input type="file" id="newProfileImage" accept="image/*" style="display: none;">--%>
<%--        <button id="changeProfileButton">Change Profile Image</button>--%>
    </form>
</div>

</body>
<script>
    const check_emailPassword = () => {
        const inputPass = document.getElementById("memberPassword").value;
        if(inputPass !== '${member.memberPassword}') {
            alert("Incorrect Password!");
            document.getElementById("memberPassword").focus();
            return false; // 비밀번호가 틀리면 false 반환
        }
        return true; // 비밀번호가 맞으면 true 반환
    }

    // 폼 제출 함수
    const submitForm = () => {
        if(check_emailPassword()) {
            alert("your information updated!!");
            document.getElementById("updateForm").submit();// 비밀번호 체크가 true일 때만 폼 제출
        }
    }


    // // 이미지 변경 버튼 클릭 시, 파일 업로드 input을 트리거하는 함수
    // $("#changeProfileButton").click(function () {
    //     $("#newProfileImage").click();
    // });
    //
    // // 파일 업로드 input의 변경 이벤트 리스너
    // $("#newProfileImage").change(function () {
    //     const fileInput = document.getElementById("newProfileImage");
    //     const selectedFile = fileInput.files[0];
    //     const memberId = $("#memberId").val(); // memberId를 가져옴
    //
    //     if (selectedFile && memberId) {
    //         // 서버에 변경된 사진 업로드
    //         const formData = new FormData();
    //         formData.append("memberId", memberId); // memberId를 formData에 추가
    //         formData.append("newProfileImage", selectedFile);
    //
    //         $.ajax({
    //             type: "POST",
    //             url: "/member/updateProfileImage",
    //             data: formData,
    //             contentType: false,
    //             processData: false, // 필요한 경우에만 설정
    //             success: function (data) {
    //                 if (data.success) {
    //                     alert("프로필 사진이 변경되었습니다.");
    //                 } else {
    //                     alert("프로필 사진 변경에 실패했습니다.");
    //                 }
    //             },
    //             error: function (xhr, status, error) {
    //                 console.error("에러 발생:", error);
    //             }
    //         });
    //     }
    // });


</script>
</html>
