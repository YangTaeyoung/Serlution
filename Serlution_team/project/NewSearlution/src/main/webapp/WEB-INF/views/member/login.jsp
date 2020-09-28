<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>테스트 메인_로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/cover_white.css">
</head>
<body class="text-center"> <!-- 가운데 정렬 -->

<!-- 사이트 위 헤더 -->
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Searlution</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link" href="#">Home</a>
        <a class="nav-link active" href="/searluton/user/login">로그인</a>
        <a class="nav-link" href="/searluton/user/join">회원가입</a>
      </nav>
    </div>
  </header>

<!-- 검색창, 로고 -->
  <main role="main" class="inner cover">
    <h3 class="text-left text-dark">이메일</h3>
    <form action="/user/login/chk" method="get">
	  	<div class="input-group input-group-lg mb-3">
	      <input type="text" class="form-control" placeholder="이메일을 입력하세요." aria-label="이메일을 입력하세요." name="id">
	    </div>
	    <h3 class="text-left text-dark">비밀번호</h3>
	  	<div class="input-group input-group-lg mb-3">
	      <input type="password" class="form-control" placeholder="비밀번호를 입력하세요." aria-label="비밀번호를 입력하세요." name="pw">
	    </div>
	    <div class="form-check text-right">
		  <button class="form-check-btn btn btn-dark input-but"  onclick="location.href='/searlution/user/join'">회원가입</button>
		  <input type="submit" class="form-check-btn btn btn-dark input-but" value="로그인">
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
