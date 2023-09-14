
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">

<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<div class = "container_form">
    <form action="/member/save" method="post" enctype="multipart/form-data" id = "board-form">
        <h2 class="form__title">Sign Up</h2>
        <input type = "hidden" id="memberId" name="memberId">
        <input type = "text" onkeyup="check_email_dup()" placeholder="memberEmail" id="memberEmail" name="memberEmail" ><br>
        <p id = "email-dup-check-result" ></p><br>
        <input type = "password" onkeyup="check_memberPassword()" placeholder="memberPassword" id="memberPassword" name="memberPassword" ><br>
        <p id = "memberPassword-check-result" style="display : none;" ></p><br>
        <input type = "text" placeholder="memberName" name="memberName" ><br>
        <input type = "text" onkeyup="check_memberMobile()" placeholder="memberMobile" id="memberMobile" name="memberMobile" ><br>
        <p id = "memberMobile-check-result" style="display : none;"></p><br>
        <input type = "file" name = "memberProfile" multiple><br>
        <input type="submit" value="Sign Up" >
    </form>
</div>
</body>
<script>

    const check_email_dup = () => {
        const inputEmail = document.getElementById("memberEmail").value();
        const emailResult = document.getElementById("email-dup-check-result");
        $.ajax({
            type : "post",
            url : "/member/check-email-dup",
            data : {
                memberEmail : inputEmail
            },
            success : function () {
                emailResult.innerHTML = "appropriate Email!!";
                emailResult.style.color = "green";
            },
            error : function () {
                emailResult.innerHTML = "already used Email...please input other Email!!";
                emailResult.style.color = "green";
            }
        });
    }

    check_memberPassword = () => {
        let passRegExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
        const inputPass = document.getElementById("memberPassword").value;
        const passResult = document.getElementById("memberPassword-check-result");
        if(inputPass.match(passRegExp)) {
            passResult.style.display = "none";
        }else{
            passResult.innerHTML = "please Combine two or more of English, numbers, and special characters to create 10 characters";
            passResult.style.color = "red";
            passResult.style.display = "block";
        }
    }
    check_memberMobile = () => {
        let mobileRegExp = /^\d{3}-\d{3,4}-\d{4}$/;
        const inputMobile = document.getElementById("memberMobile").value;
        const mobileResult = document.getElementById("memberMobile-check-result");
        if(inputMobile.match(mobileRegExp)) {
            mobileResult.style.display = "none";
        }else{
            mobileResult.innerHTML = "please input valid MobileNumber!! ex) 032-541-8758 or 010-6548-8745";
            mobileResult.style.color = "red";
            mobileResult.style.display = "block";
        }
    }
</script>
</html>