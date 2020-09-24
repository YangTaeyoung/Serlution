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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/cover.css">
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
	
	<!-- 사이트 위 헤더 -->
	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
<%
		if(session.getAttribute("user_no") != null) // 로그인
		{
%>
		<header class="masthead mb-auto">
			<div class="inner">
		    	<h3 class="masthead-brand">Searlution</h3>
		    	<nav class="nav nav-masthead justify-content-center">
			        <a class="nav-link active" href="#">Home</a>
			        <a class="nav-link" href="./main_login_false.jsp">로그아웃</a>
			        <a class="nav-link" href="#">마이페이지</a>
		    	</nav>
			</div>
		</header>
<% 		
		}
		else // 비 로그인
		{
%>
		<header class="masthead mb-auto">
    		<div class="inner">
      			<h3 class="masthead-brand">Searlution</h3>
     			<nav class="nav nav-masthead justify-content-center">
			        <a class="nav-link active" href="#">Home</a>
			        <a class="nav-link" href="#">로그인</a>
			        <a class="nav-link" href="#">회원가입</a>
      			</nav>
    		</div>
  		</header>

<%	
		}
%>
		
		<!-- 검색창, 로고 -->
		  <main role="main" class="inner cover">
		    <img src="/image/main_logo.png" alt="씨바 왜 적용이 안되냐">
		  	<div class="input-group input-group-lg mb-3">
		      <input type="text" class="form-control" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요.">
		      <div class="input-group-append">
		        <button class="btn btn-outline-secondary" type="button" id="search">Search</button>
		      </div>
		    </div>
		    <div class="form-check">
			  <input class="form-check-input" type="checkbox" value="" id="advertisement">
			  <label class="form-check-label" for="advertisement">광고성 데이터 제거</label>
			</div>
		  </main>
		
		<!-- Copyright -->
		  <footer class="mastfoot mt-auto">
		    <div class="inner">
		      <p>Copyright &copy; 2020 Searlution Team All Rights Reserved.</p>
		    </div>
		  </footer>
		</div>
			
	
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