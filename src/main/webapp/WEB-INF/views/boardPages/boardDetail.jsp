
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<html>
<head>
    <title>게시글 상세 조회</title>
</head>
<body>
    <h2>boardDetail.jsp</h2>
    ${board.id}<br>
    ${board.boardWriter}<br>
    ${board.boardTitle}<br>
    ${board.boardContents}<br>
    ${board.boardHits}<br>
    <c:if test="${board.fileAttached ==1}">
        <tr>
            <th>image</th>
            <td>
                <img src="${pageContext.request.contextPath}/upload/${boardFile.storedFileName}"
                     alt="" width="100" height="100">
            </td>
        </tr>
    </c:if><br>

    <button type="button" class="btn btn-info" onclick="update_fn('${board.id}')">Update</button>
    <button type="button" class="btn btn-danger" onclick="delete_fn('${board.id}')">Delete</button>

<script>
    const update_fn = (id) => {
        location.href="/board/update?id=" +id;
    }

    const delete_fn = (id) => {
        location.href="/board/delete?id=" +id;
    }

</script>
</body>
</html>
