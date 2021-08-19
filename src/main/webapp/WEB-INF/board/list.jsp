<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h1>List</h1>

<form action="/board/write" method="get">

    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        </thead>
        <c:forEach items="${bno}" var="dto">
        <tbody>
        <tr>
            <td><a href="/board/read?bno=${dto.bno}">${dto.bno}</a></td>
            <td>${dto.title}</td>
            <td>${dto.writer}</td>
            <td>${dto.regdate}</td>
            <td>${dto.count}</td>
        </tr>
        </tbody>
        </c:forEach>

    </table>

    <button type="submit">글쓰기</button>

</form>

</body>
</html>
