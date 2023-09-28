<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<style>
    .navbar {
        background-color: rgba(255, 255, 255, 0.9); /* Use rgba for transparency */
        backdrop-filter: blur(5px); /* Apply a blur effect to the background */
        border-radius: 10px; /* Add some border radius for rounded corners */
        padding: 10px; /* Add padding for spacing */
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2); /* Add a subtle shadow */
    }

    .menu {
        list-style-type: none;
        padding: 0;
    }

    .menu-item {
        display: inline-block;
        margin-right: 10px;
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