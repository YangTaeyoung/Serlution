<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>학생 상세 정보 확인 화면</title>
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
		<table>
			<tr>
				<td>아이디</td>
				<td>${student.id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${student.name}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${student.age}</td>
			</tr>
		</table>
	</body>
</html>