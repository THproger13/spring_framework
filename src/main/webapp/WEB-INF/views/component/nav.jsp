<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<style>
    .navbar {
        background-color: rgba(255, 255, 255, 0.9);
        backdrop-filter: blur(5px);
        border-radius: 10px;
        padding: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        display: flex; /* 네비게이션 바를 가로로 나열합니다. */
        justify-content: center; /* 네비게이션 바를 수평 가운데로 정렬합니다. */
        width: 100vw; /* 네비게이션 바의 폭을 브라우저 창의 전체 너비와 같도록 설정합니다. */
    }

    .menu {
        list-style-type: none;
        padding: 0;
        display: flex; /* 메뉴 항목들을 가로로 나열합니다. */
        justify-content: center; /* 메뉴 항목들을 수평 가운데 정렬합니다. */
        width: 100%; /* 메뉴의 폭을 브라우저 창의 전체 폭과 일치하도록 설정합니다. */
    }

    .menu-item {
        display: inline-block;
        margin: 0 10px; /* 링크들 사이의 좌우 마진을 설정합니다. */
        text-align: center; /* 텍스트를 중앙 정렬합니다. */
        /*margin-right: 10px;*/
    }
</style>

<div id="nav" class="navbar">
    <ul class="menu">
        <li class="menu-item">
            <a href="/">Home</a>
        </li>
        <li class="menu-item">
            <a href="/member/save">Sign Up</a>
        </li>
        <!--        <li class="menu-item">-->
        <!--            <a href="/login">로그인</a>-->
        <!--        </li>-->
        <c:choose>
            <c:when test="${sessionScope.loginEmail == 'admin'}">
                <li class="menu-item">
                    <a href="/member/list">Member List</a>
                </li>
                <li class="menu-item">
                    <a href="/member/sample">Create Sampledata</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="menu-item">
                    <a href="/member/update">update My Profile</a>
                </li>
                <li class="menu-item">
                    <a href="/board/save">Board Write</a>
                </li>
                <li class="menu-item">
                    <a href="/board/list">Board List</a>
                </li>
            </c:otherwise>
        </c:choose>


        <!-- 로그인 여부에 따라 로그인했으면 oo님 환영합니다. 로그아웃링크 보이고
             로그인 하지 않았으면 로그인 이 보이도록
        -->
        <li class="menu-item" id="login-area">

        </li>
    </ul>
</div>
<script>
    const loginArea = document.getElementById("login-area");
    const loginEmail = '${sessionScope.loginEmail}';
    console.log(loginEmail.length);
    if (loginEmail.length != 0) {
        // 로그인 했음
        loginArea.innerHTML = "<a href='/mypage'>" + loginEmail + "님 환영해요!</a>" +
            "<a href='/member/logout'>Sign Out</a>";
    } else {
        // 로그인 안했음
        loginArea.innerHTML = "<a href='/member/login'>Sign In</a>";
    }
</script>