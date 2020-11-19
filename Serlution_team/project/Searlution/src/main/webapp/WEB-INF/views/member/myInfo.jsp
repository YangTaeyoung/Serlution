<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>마이 페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="/searlution/resources/css/cover_white.css">
</head>
<body class="text-center"> <!-- 가운데 정렬 -->

<!-- 사이트 위 헤더 -->
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Searlution</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="#">Home</a>
        <a class="nav-link">00님, 환영합니다.</a>
        <a class="nav-link active" href="#">마이페이지</a>
      </nav>
    </div>
  </header>

<!-- 메인페이지 내용 나중에 바꿀 것 -->
  <main role="main" class="inner cover">
    <h3 class="text-left text-dark">ID</h3>
  	<div class="input-group input-group-lg mb-3">
      <input type="text" class="form-control" placeholder="ID를 입력하세요." aria-label="ID를 입력하세요.">
    </div>
    <h3 class="text-left text-dark">비밀번호</h3>
  	<div class="input-group input-group-lg mb-3">
      <input type="text" class="form-control" placeholder="비밀번호를 입력하세요." aria-label="비밀번호를 입력하세요.">
    </div>
    <div class="form-check text-right">
	  <button class="form-check-btn btn btn-dark input-but">회원가입</button>
	  <button class="form-check-btn btn btn-dark input-but">로그인</button>
	</div>
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