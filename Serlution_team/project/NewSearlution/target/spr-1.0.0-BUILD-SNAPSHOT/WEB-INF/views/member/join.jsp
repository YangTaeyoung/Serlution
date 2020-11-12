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
<title>테스트 메인_로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/cover_white.css">
</head>
<body class="text-center"> <!-- 가운데 정렬 -->

<!-- 사이트 위 헤더 -->
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Searlution</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="/">Home</a>
        <a class="nav-link" href="/user/login">로그인</a>
        <a class="nav-link active" href="/user/join">회원가입</a>
      </nav>
    </div>
  </header>

<!-- 검색창, 로고 -->
   <main role="main" class="inner cover">
    <form:form commandName="user" action="join/chk" method="POST">
	    <h4 class="text-left text-body">이메일</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <form:input type="email" class="form-control" placeholder="이메일을 입력하세요." aria-label="이메일을 입력하세요." path="user_email"/>
	    </div>
	    <h4 class="text-left text-body">비밀번호</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <form:input type="password" class="form-control" placeholder="비밀번호를 입력하세요." aria-label="비밀번호를 입력하세요." path="user_pw"/>
	    </div>
	    <h4 class="text-left text-body">비밀번호 확인</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <input type="password" class="form-control" placeholder="비밀번호를 입력하세요." aria-label="비밀번호를 입력하세요." name="user_pwChk"/>
	    </div>
	    <h4 class="text-left text-body">이름</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <form:input type="text" class="form-control" placeholder="이름을 입력하세요." aria-label="이름을 입력하세요." path="user_name"/>
	    </div>
	    <h4 class="text-left text-body">닉네임</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <input type="text" class="form-control" placeholder="닉네임을 입력하세요." aria-label="닉네임을 입력하세요." name="user_nickname"/>
	    </div>
	    <h4 class="text-left text-body">핸드폰</h4>
	  	<div class="input-group input-group-lg mb-4">
	      <form:input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" class="form-control" placeholder="핸드폰 번호를 입력하세요. 010-0000-0000" aria-label="핸드폰 번호를 입력하세요." path="user_phone"/>
	    </div>
	    <div class="form-check text-right">
		  <input type="submit" class="form-check-btn btn btn-dark input-but" value="회원가입"/>
		</div>
	</form:form>
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