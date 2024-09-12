<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>전화번호부 목록</title>
</head>
<body>
<h1>전화번호부 목록</h1>

<form action="${pageContext.request.contextPath}/phonebook/search" method="get">
    검색: <input type="text" name="keyword">
    <input type="submit" value="검색">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>메모</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="phonebook" items="${phonebooks}">
        <tr>
            <td>${phonebook.id}</td>
            <td>${phonebook.name}</td>
            <td>${phonebook.hp}</td>
            <td>${phonebook.memo}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${pageContext.request.contextPath}/phonebookadd.jsp">전화번호 추가하기</a>

</body>
</html>