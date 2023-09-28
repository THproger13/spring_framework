
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>

    <link rel="stylesheet" href="/resources/css/main.css">
<%--    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">--%>

    <style>:root {
        /* COLORS */
        --white: #e9e9e9;
        --gray: #333;
        --blue: #0367a6;
        --lightblue: #008997;

        /* RADII */
        --button-radius: 0.7rem;

        /* SIZES */
        --max-width: 900px;
        --max-height: 700px;

        font-size: 16px;
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
        Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
    }

    body {
        align-items: center;
        background-color: var(--white);
        background: url("https://cdn.pixabay.com/photo/2015/11/11/03/47/evening-1038148_1280.jpg");
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        display: grid;
        height: 100vh;
        place-items: center;
    }

    .form__title {
        font-weight: 300;
        margin: 0;
        margin-bottom: 1.25rem;
    }

    .link {
        color: var(--gray);
        font-size: 0.9rem;
        margin: 1.5rem 0;
        text-decoration: none;
    }

    .container {
        background-color: var(--white);
        border-radius: var(--button-radius);
        box-shadow: 0 0.9rem 1.7rem rgba(0, 0, 0, 0.25),
        0 0.7rem 0.7rem rgba(0, 0, 0, 0.22);
        height: var(--max-height);
        max-width: var(--max-width);
        overflow: hidden;
        position: relative;
        width: 100%;
    }

    .container__form {
        height: 100%;
        position: absolute;
        top: 0;
        transition: all 0.6s ease-in-out;
    }

    .container--signup {
        left: 0;
        opacity: 0;
        width: 50%;
        z-index: 1;
    }

    .container.right-panel-active .container--signup {
        animation: show 0.6s;
        opacity: 1;
        transform: translateX(100%);
        z-index: 5;
    }

    .container__overlay {
        height: 100%;
        left: 50%;
        overflow: hidden;
        position: absolute;
        top: 0;
        transition: transform 0.6s ease-in-out;
        width: 50%;
        z-index: 100;
    }

    .container.right-panel-active .container__overlay {
        transform: translateX(-100%);
    }

    .overlay {
        background-color: var(--lightblue);
        background: url("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99086B3C5B9B75C431");
        background-attachment: fixed;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;
        height: 100%;
        left: -100%;
        position: relative;
        transform: translateX(0);
        transition: transform 0.6s ease-in-out;
        width: 200%;
    }

    .container.right-panel-active .overlay {
        transform: translateX(50%);
    }

    .overlay__panel {
        align-items: center;
        display: flex;
        flex-direction: column;
        height: 100%;
        justify-content: center;
        position: absolute;
        text-align: center;
        top: 0;
        transform: translateX(0);
        transition: transform 0.6s ease-in-out;
        width: 50%;
    }

    .overlay--left {
        transform: translateX(-20%);
    }

    .container.right-panel-active .overlay--left {
        transform: translateX(0);
    }

    .overlay--right {
        right: 0;
        transform: translateX(0);
    }

    .container.right-panel-active .overlay--right {
        transform: translateX(20%);
    }

    .btn {
        background-color: var(--blue);
        background-image: linear-gradient(90deg, var(--blue) 0%, var(--lightblue) 74%);
        border-radius: 20px;
        border: 1px solid var(--blue);
        color: var(--white);
        cursor: pointer;
        font-size: 0.8rem;
        font-weight: bold;
        letter-spacing: 0.1rem;
        padding: 0.9rem 4rem;
        text-transform: uppercase;
        transition: transform 80ms ease-in;
    }

    .form > .btn {
        margin-top: 1.5rem;
    }

    .btn:active {
        transform: scale(0.95);
    }

    .btn:focus {
        outline: none;
    }

    .form {
        background-color: var(--white);
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
        padding: 0 3rem;
        height: 100%;
        text-align: center;
    }

    .input {
        background-color: #fff;
        border: none;
        padding: 0.9rem 0.9rem;
        margin: 0.5rem 0;
        width: 100%;
    }

    @keyframes show {
        0%,
        49.99% {
            opacity: 0;
            z-index: 1;
        }

        50%,
        100% {
            opacity: 1;
            z-index: 5;
        }
    }</style>
</head>
<body>
<%@include file="component/header.jsp"%>
<%@include file="component/nav.jsp"%>
<%--<h2>memberSave.jsp</h2>--%>
<div class="container right-panel-active">
    <!-- Sign Up -->
    <div class="container__form container--signup">
        <form action="/memberSave" method="post" class="form" id="form1">
            <h2 class="form__title">Sign Up</h2>
            <input class="input" type="text" placeholder="Email"
                   name="memberEmail" id="memberEmail"> <br>
            <span id="emailStatus"></span> <br>
            <input class="input" type="password" placeholder="Password" name="memberPassword"> <br>
            <input class="input" type="text" placeholder="Name" name="memberName"> <br>
            <input class="input" type="text" placeholder="Birthday(YY-MM-DD)" name="memberBirth"> <br>
            <input class="input" type="text" placeholder="Mobile" name="memberMobile"> <br>
            <button type="button" class="btn" id="signUp">Sign Up</button>
        </form>
    </div>
</div>
<%@include file="component/footer.jsp"%>

</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $('#memberEmail').keyup(function () { // 이메일 입력 필드에서 키 입력 감지
            const email = $('#memberEmail').val();
            const emailStatus = $('#emailStatus');
            if (email !== '') {
                $.ajax({
                    type: 'post',
                    url: '/check-email',
                    data: { memberEmail: email },
                    success: function (response) {
                        console.log("서버 응답:", response); // 디버깅용 코드

                        if (response === "equals") {
                            emailStatus.text('이미 사용 중인 이메일입니다.');
                            emailStatus.css('color', 'red');
                        } else {
                            emailStatus.text('사용 가능한 이메일입니다.');
                            emailStatus.css('color', 'green');
                        }
                    },
                    error: function (xhr, status, error) {
                        console.log("에러:", error);
                    }
                });
            } else {
                emailStatus.text('');
            }
        });

        $('#signUp').click(function () {
            const email = $('#memberEmail').val();
            const password = $('input[name="memberPassword"]').val();
            const name = $('input[name="memberName"]').val();
            const birth = $('input[name="memberBirth"]').val();
            const mobile = $('input[name="memberMobile"]').val();

            if (email === '' || password === '' || name === '' || birth === '' || mobile === '') {
                alert('입력하지 않은 정보가 있습니다!!');
                if (email === '') {
                    $('#memberEmail').focus();
                } else if (password === '') {
                    $('input[name="memberPassword"]').focus();
                } else if (name === '') {
                    $('input[name="memberName"]').focus();
                } else if (birth === '') {
                    $('input[name="memberBirth"]').focus();
                } else if (mobile === '') {
                    $('input[name="memberMobile"]').focus();
                }
            } else {
                // 모든 필드가 입력되었을 때 폼을 수동으로 제출
                $('#form1').submit();
            }
    });

    });
</script>
</html>