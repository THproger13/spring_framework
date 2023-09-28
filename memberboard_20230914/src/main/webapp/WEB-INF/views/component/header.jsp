<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- header라는 id가 적용된 div --%>

<style>
    @import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;800&display=swap");

    :root {
        --bg: #000000;
        --clr-1: #00c2ff;
        --clr-2: #33ff8c;
        --clr-3: #ffc640;
        --clr-4: #e54cff;

        --blur: 1rem;
        --fs: clamp(3rem, 8vw, 7rem);
        --ls: clamp(-1.75px, -0.25vw, -3.5px);
    }

    body {
        min-height: 100vh;
        display: grid;
        place-items: center;
        background-color: var(--bg);
        color: #fff;
        font-family: "Inter", "DM Sans", Arial, sans-serif;
    }

    *,
    *::before,
    *::after {
        font-family: inherit;
        box-sizing: border-box;
    }

    .content {
        text-align: center;
    }

    .title::after {
        /* 기존 코드 그대로 유지합니다. */
        content: "Spring Framework Member Project";
        background: linear-gradient(45deg, var(--clr-1), var(--clr-2), var(--clr-3), var(--clr-4));
        -webkit-background-clip: text;
        background-clip: text;
        color: transparent;
        position: absolute;
        top: 0;
        left: 0;
        z-index: -1;
        animation: aurora-title 6s ease-in-out infinite, aurora-border 6s ease-in-out infinite;
        pointer-events: none;
    }

    .title {
        position: relative;
        font-size: var(--fs);
        font-weight: 800;
        letter-spacing: var(--ls);
        overflow: hidden;
        margin: 0;
        background-color: white; /* 배경을 흰색으로 설정합니다. */
    }

    /*.title {*/
    /*    font-size: var(--fs);*/
    /*    font-weight: 800;*/
    /*    letter-spacing: var(--ls);*/
    /*    position: relative;*/
    /*    overflow: hidden;*/
    /*    background: var(--bg);*/
    /*    margin: 0;*/
    /*}*/

    .subtitle {
    }

    .aurora {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 2;
        mix-blend-mode: darken;
        pointer-events: none;
    }

    .aurora__item {
        overflow: hidden;
        position: absolute;
        width: 60vw;
        height: 60vw;
        background-color: var(--clr-1);
        border-radius: 37% 29% 27% 27% / 28% 25% 41% 37%;
        filter: blur(var(--blur));
        mix-blend-mode: overlay;
    }

    .aurora__item:nth-of-type(1) {
        top: -50%;
        animation: aurora-border 6s ease-in-out infinite,
        aurora-1 12s ease-in-out infinite alternate;
    }

    .aurora__item:nth-of-type(2) {
        background-color: var(--clr-3);
        right: 0;
        top: 0;
        animation: aurora-border 6s ease-in-out infinite,
        aurora-2 12s ease-in-out infinite alternate;
    }

    .aurora__item:nth-of-type(3) {
        background-color: var(--clr-2);
        left: 0;
        bottom: 0;
        animation: aurora-border 6s ease-in-out infinite,
        aurora-3 8s ease-in-out infinite alternate;
    }

    .aurora__item:nth-of-type(4) {
        background-color: var(--clr-4);
        right: 0;
        bottom: -50%;
        animation: aurora-border 6s ease-in-out infinite,
        aurora-4 24s ease-in-out infinite alternate;
    }

    @keyframes aurora-1 {
        0% {
            top: 0;
            right: 0;
        }

        50% {
            top: 100%;
            right: 75%;
        }

        75% {
            top: 100%;
            right: 25%;
        }

        100% {
            top: 0;
            right: 0;
        }
    }

    @keyframes aurora-2 {
        0% {
            top: -50%;
            left: 0%;
        }

        60% {
            top: 100%;
            left: 75%;
        }

        85% {
            top: 100%;
            left: 25%;
        }

        100% {
            top: -50%;
            left: 0%;
        }
    }

    @keyframes aurora-3 {
        0% {
            bottom: 0;
            left: 0;
        }

        40% {
            bottom: 100%;
            left: 75%;
        }

        65% {
            bottom: 40%;
            left: 50%;
        }

        100% {
            bottom: 0;
            left: 0;
        }
    }

    @keyframes aurora-4 {
        0% {
            bottom: -50%;
            right: 0;
        }

        50% {
            bottom: 0%;
            right: 40%;
        }

        90% {
            bottom: 50%;
            right: 25%;
        }

        100% {
            bottom: -50%;
            right: 0;
        }
    }

    @keyframes aurora-border {
        0% {
            border-radius: 37% 29% 27% 27% / 28% 25% 41% 37%;
        }

        25% {
            border-radius: 47% 29% 39% 49% / 61% 19% 66% 26%;
        }

        50% {
            border-radius: 57% 23% 47% 72% / 63% 17% 66% 33%;
        }

        75% {
            border-radius: 28% 49% 29% 100% / 93% 20% 64% 25%;
        }

        100% {
            border-radius: 37% 29% 27% 27% / 28% 25% 41% 37%;
        }
    }

</style>



<div class="content">
    <h1 class="title">Spring Framework Member Project
        <div class="aurora">
            <div class="aurora__item"></div>
            <div class="aurora__item"></div>
            <div class="aurora__item"></div>
            <div class="aurora__item"></div>
        </div>
    </h1>
</div>
