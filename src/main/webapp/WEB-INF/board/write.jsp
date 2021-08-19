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

<h1>Write</h1>

<form action="/board/write" method="post">
    <div>
        <input type="text" name="title">
    </div>
    <div>
        <input type="text" name="content">
    </div>
    <div>
        <input type="text" name="writer">
    </div>
    <button type="submit">등록</button>
</form>

</body>
</html>
