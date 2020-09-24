<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>테스트 메인_비로그인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="../css/cover.css">
</head>
<body class="text-center"> <!-- 가운데 정렬 -->

<!-- 사이트 위 헤더 -->
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Searlution</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="#">Home</a>
        <a class="nav-link" href="./main_login_true.jsp">로그인</a>
        <a class="nav-link" href="./main_login_true.jsp">회원가입</a>
      </nav>
    </div>
  </header>

<!-- 검색창, 로고 -->
  <main role="main" class="inner cover">
    <img class="img-fluid" src="../png/main_logo_short.png" alt="Responsive image">
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
</body>
</html>