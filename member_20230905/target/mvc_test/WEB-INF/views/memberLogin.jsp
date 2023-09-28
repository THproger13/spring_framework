<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <style>
        * {margin:0;padding:0;}
        body {
            overflow:hidden;
            background: url("https://images.unsplash.com/photo-1517328894681-0f5dfabd463c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=9a0a6ed9720a26bb382325be82d9baa9&auto=format&fit=crop&w=1900&q=80");
            background-size:cover;
            background-position:bottom;
            animation:lightning 10s linear infinite;
            transition: filter 5s;
        }

        .filtered {
            filter: grayscale(100%);
        }

        .container {
            width: 100vw;
            height: 100vh;
            background: url("https://images.unsplash.com/photo-1517328894681-0f5dfabd463c?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=9a0a6ed9720a26bb382325be82d9baa9&auto=format&fit=crop&w=1900&q=80");
            background-size: auto; /* 이미지 크기 조정 없음 */
            background-repeat: no-repeat; /* 이미지 반복 없음 */
            background-position: center; /* 이미지 중앙 위치 */
            animation: lightning 10s linear infinite;
            transition: filter 5s;
        }

        .login-container {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: rgba(255, 255, 255, 0.7); /* 흑백톤 배경 */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 400px; /* 변경: 컨테이너 너비 조정 */
            height: 400px; /* 변경: 컨테이너 높이 조정 */
        }

        .form-control {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: none;
            border-bottom: 1px solid #333; /* 입력 필드 밑줄 */
        }

        .form-control:focus {
            outline: none;
            border-bottom: 2px solid #007bff; /* 입력 필드에 포커스 시 밑줄 색상 변경 */
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff; /* 로그인 버튼 배경 색상 */
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease; /* 호버 시 배경 색상 전환 효과 */
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* 호버 시 배경 색상 변경 */
        }

        .login-title {
            text-align: center;
            font-size: 24px; /* 변경: 제목 폰트 크기 조정 */
            margin-bottom: 20px; /* 변경: 제목과 입력 폼 간격 조정 */
        }

        @keyframes lightning {
            /* 이 부분은 그대로 두세요. */
        }
    </style>
</head>
<body>
<%--<!--<%@include file="component/header.jsp"%>-->--%>
<%--<!--<%@include file="component/nav.jsp"%>-->--%>


<div class="login-container">
    <p class="login-title">Login</p> <!-- 변경: 제목 추가 -->
    <form class="dropdown-item-text" action="/memberLogin" method="post" onsubmit="return is_empty_login_info()">
        <input class="form-control" placeholder="Email" type="text" name="memberEmail" id="memberEmail"> <br>
        <input class="form-control" placeholder="Password" type="password" name="memberPassword" id="memberPassword"> <br>
        <input type="submit" value="로그인">
    </form>
</div>
<!--<%@include file="component/footer.jsp"%>-->
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    const is_empty_login_info = () => {
        const loginEmail = document.getElementById("memberEmail").value;
        const loginPass = document.getElementById("memberPassword").value;

        if (loginEmail === '' || loginPass === '') {
            alert("입력하지 않은 로그인 정보가 있습니다!");
            if (loginEmail === '') {
                $('#memberEmail').focus();
            } else if (loginPass === '') {
                $('#memberPassword').focus();
            }
            return false;
        }
        return true;
    }
    const canvas = document.createElement("canvas");
    const gl = canvas.getContext("webgl");

    if (gl) {
        console.log("WebGL is supported.");
    } else {
        console.log("WebGL is not supported.");
    }
    window.addEventListener('resize', adjustBackgroundSize);

    function adjustBackgroundSize() {
        const container = document.querySelector('.container');
        const windowWidth = window.innerWidth;
        const windowHeight = window.innerHeight;

        // 조절된 크기로 배경 이미지 설정
        container.style.backgroundSize = `${windowWidth}px ${windowHeight}px`;
    }

    // 페이지 로드시 초기 조절 실행
    window.onload = adjustBackgroundSize;

</script>
</html>
