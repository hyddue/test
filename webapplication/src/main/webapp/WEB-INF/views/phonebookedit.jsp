<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>전화번호 수정</title>
</head>
<body>
<h1>전화번호 수정</h1>
<form action="${pageContext.request.contextPath}/phonebook/update" method="post">
    <input type="hidden" name="id" value="${phonebook.id}">
    이름: <input type="text" name="name" value="${phonebook.name}"><br>
    전화번호: <input type="text" name="hp" value="${phonebook.hp}"><br>
    메모: <input type="text" name="memo" value="${phonebook.memo}"><br>
    <input type="submit" value="수정">
</form>
<a href="${pageContext.request.contextPath}/phonebooklist.jsp">목록으로 돌아가기</a>
</body>
</html>
