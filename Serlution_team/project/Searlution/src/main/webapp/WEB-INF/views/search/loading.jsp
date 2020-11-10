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
	<link rel="stylesheet" href="resources/css/cover.css">
	</head>
	
		<style>
			*{
				margin: 0;
				padding: 0;
			}
		</style>
		<script>

			window.onload = function() 
			{
				location.href="search.do?keyword=${keyword}";
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
			        <a class="nav-link active" href="/">Home</a>
			        <a class="nav-link" href="/user/logout">로그아웃</a>
			        <a class="nav-link" href="/user/myinfo">마이페이지</a>
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
			        <a class="nav-link active" href="/">Home</a>
			        <a class="nav-link" href="/user/login" >로그인</a>
			        <a class="nav-link" href="/user/join">회원가입</a>
      			</nav>
    		</div>
  		</header>

<%	
		}
%>
		
		<!-- 검색창, 로고 -->
		<main role="main" class="inner cover">
			<div class="mx-auto" style="width: 255px;">
			  	 <img class="img-fluid" src="resources/image/loading.gif" alt="현재 브라우저는 본 형식을 지원하지 않습니다.">
			  	 
			  	 
			</div>
		</main>
		<br/>
		<p style="text-align: center">분석 중 입니다.</p>
		<p style="text-align: center">게시글 량에 따라 많은 시간이 소요될 수 있습니다.</p>
		
		
		<!-- Copyright -->
		  <footer class="mastfoot mt-auto">
		    <div class="inner">
		      <p>Copyright &copy; 2020 Searlution Team All Rights Reserved.</p>
		    </div>
		  </footer>
		</div>
	</body>
</html>