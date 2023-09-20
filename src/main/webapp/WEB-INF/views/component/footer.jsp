<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .footer {
        position: fixed;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: rgba(255, 255, 255, 0.9); /* 배경 색상 지정 */
        padding: 10px; /* 패딩을 추가하여 내용과 테두리 간격을 설정합니다. */
        box-shadow: 0px -10px 10px rgba(0, 0, 0, 0.2); /* 하단 그림자를 추가합니다. */
        /* 다른 footer 스타일 속성은 그대로 유지합니다. */
    }
</style>

<div id="footer" class ="footer">

</div>


<script>
    const date = new Date();
    console.log(date);
    console.log(date.getFullYear());
    const footer = document.getElementById("footer");
    const footer1 = document.querySelector("#footer");
    footer.innerHTML = "<p>&copy;  " + date.getFullYear() + "&nbsp; THproger All rights reserved. </p>";
</script>