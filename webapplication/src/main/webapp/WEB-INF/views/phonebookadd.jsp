<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>전화번호 추가</title>
</head>
<body>
<h1>전화번호 추가</h1>
<form action="${pageContext.request.contextPath}/phonebook/insert" method="post">
    이름: <input type="text" name="name"><br>
    전화번호: <input type="text" name="hp"><br>
    메모: <input type="text" name="memo"><br>
    <input type="submit" value="추가">
</form>
<a href="${pageContext.request.contextPath}/phonebooklist.jsp">목록으로 돌아가기</a>
</body>
</html>
