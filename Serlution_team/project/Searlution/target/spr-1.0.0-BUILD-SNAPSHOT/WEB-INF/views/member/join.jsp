<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
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

		
				<form:form method="POST" action="/searlution/join/user" commandName="user">
			<table>		
				<tr>
					<td>
						<form:label path="user_email">이메일</form:label>
					</td>
					<td>
						<form:input path="user_email"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="user_pw">비밀번호</form:label>
					</td>
					<td>
						<form:input path="user_pw"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="user_name">이름</form:label>
					</td>
					<td>
						<form:input path="user_name"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="user_nickname">닉네임</form:label>
					</td>
					<td>
						<form:input path="user_nickname"/>
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="user_phone">핸드폰</form:label>
					</td>
					<td>
						<form:input path="user_phone"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="회원가입">
					</td>
 				</tr>
			</table>
		</form:form>
	</body>
</html>