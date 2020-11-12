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
	<link rel="stylesheet" href="/searlution/resources/css/cover.css">
	</head>
	
		<style>
			*{
				margin: 0;
				padding: 0;
			}
		</style>
		<script>
			function page_move(url)
			{
				var form = document.createElement("form");
				form.action = url;
			   	form.method = "post";

				document.body.appendChild(form);
				form.submit();
			}
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
			        <a class="nav-link active" href="/searlution">Home</a>
			        <a class="nav-link" href="/searlution/user/logout">로그아웃</a>
			        <a class="nav-link" href="/searlution/user/myinfo">마이페이지</a>
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
			        <a class="nav-link active" href="/searlution">Home</a>
			        <a class="nav-link" href="/searlution/user/login" >로그인</a>
			        <a class="nav-link" href="/searlution/user/join">회원가입</a>
      			</nav>
    		</div>
  		</header>

<%	
		}
%>
		
		<!-- 검색창, 로고 -->
		  <main role="main" class="inner cover">
		    <img class="img-fluid" src="/searlution/resources/image/main_logo.png" alt="씨바 왜 적용이 안되냐">
		    <form action="/searlution/loading.do" method="get">
			  	<div class="input-group input-group-lg mb-3">
				    <input type="text" class="form-control" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요." name="keyword">
				    <div class="input-group-append">
				    	<input type="submit" class="btn btn-outline-secondary" type="button" id="search"  value="Search">
					</div>
		    	</div>
		    	<div class="form-check">
					<input class="form-check-input" type="checkbox" value="" id="advertisement" name="adChk">
					<label class="form-check-label" for="advertisement">광고성 데이터 제거</label>
				</div>
			</form>
		</main>
		
		<!-- Copyright -->
		  <footer class="mastfoot mt-auto">
		    <div class="inner">
		      <p>Copyright &copy; 2020 Searlution Team All Rights Reserved.</p>
		    </div>
		  </footer>
		</div>
	</body>
</html>