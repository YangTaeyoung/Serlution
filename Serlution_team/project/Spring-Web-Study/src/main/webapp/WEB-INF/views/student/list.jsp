<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 조회 결과</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>순번</th>
			<th>ID</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach var="student" items="${students}" >
			<tr>
				<td><a href="student_list?seq=${student.seq}">${student.seq}</a></td>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.age}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>