<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>검색이 찾은 해답, Searlution</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
		  integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
		  crossorigin="anonymous">
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
	${pageContext.request.contextPath}
		<form action="search.do" method="get">
			<div> 
				<div>
					<img src="${pageContext.request.contextPath}/resources/main_logo.png" alt="본 브라우저에서 이미지 형식을 지원하지 않습니다."><!-- 시바 경로 설정 어떻게 하는겨... -->
				</div>
				<div class="input-group mb-3 mx-auto">
					<input type="text" class="form-control" placeholder="검색할 단어를 입력하세요." name="keyword">
					<div class="input-group-append">
						<input type="submit" class="btn btn-outline-secondary" type="button" id="button-addon2" value="검색"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>