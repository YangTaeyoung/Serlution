<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>${user.user_nickname}님의 검색 결과</title>
	</head>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
		</style>
		<script>
			
		</script>
	<body>
		<table border=1>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>링크</th>
				<th>작성 날짜</th>
			</tr>
			<c:forEach var="search" items="${searches}">
			<tr>
				<td >${search.ser_no}</td>
				<td>${search.ser_title}</td>
				<td>${search.ser_content}</td>
				<td><a href="${search.ser_link}">${search.ser_link}</a></td>
				<td>${search.ser_date}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>