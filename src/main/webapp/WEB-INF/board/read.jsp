<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-17
  Time: 오후 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Read</h1>

<form action="/board/list" method="get">
    <div>
        <div>
            <span>번호</span>
        </div>
        <input type="text" name="bno" value="${dto.bno}" readonly>
    </div>
    <div>
        <div>
            <span>제목</span>
        </div>
        <input type="text" name="title" value="${dto.title}" readonly>
    </div>
    <div>
        <div>
            <span>내용</span>
        </div>
        <input type="text" name="content" value="${dto.content}" readonly>
    </div>
    <div>
        <div>
            <span>작성자</span>
        </div>
        <input type="text" name="writer" value="${dto.writer}" readonly>
    </div>
    <div>
        <div>
            <span>작성일</span>
        </div>
        <input type="text" name="regdate" value="${dto.regdate}" readonly>
    </div>
    <button type="submit">목록</button>
</form>
</html>
