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
		<title>게시물 검색 결과</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
		<link rel="stylesheet" href="/searlution/resourses/css/dashboard.css">
		<script>
			function doSearch()
			{
				var keyword = document.getElementById("ser_key").value;
				location.href ="result/loading?keyword=" + keyword;
			}
			
			function isLogin(link)
			{
				var user_no = "${session.user_no}";
				
				console.log("들어옴?: " + session.user_no);
				if(session.user_no > 0)
				{
					alert("왔니");
					location.href = link + "?keyword=${keyword}";
				}
				else
				{
					alert("로그인을 하지 않으면 이용하실 수 없는 서비스입니다.");
					location.href = "search.do?keyword=${keyword}";
				}
			}
		</script>
	</head>
	<body>
		<!-- navbar -->
		<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="/searlution">Searlution</a>
		  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
<%
	request.setCharacterEncoding("UTF-8");
	if(session.getAttribute("user_no") == null)
	{
	
%>
		  <ul class="navbar-nav px-3" >
		      <li class="nav-item" >
		        <a class="nav-link" href="/searlution/user/login">로그인</a>
		      </li>
		  </ul>
<% 
	}
	else
	{
%>  

		  <ul class="navbar-nav px-3" >
		      <li class="nav-item" >
		        <a class="nav-link" href="/searlution/user/logout">로그아웃</a>
		      </li>
		  </ul>
<%
	}
%>	  
		  
		  
		  
		  <div class="form-check px-3">
			  <input class="form-check-input" type="checkbox" value="" id="advertisement">
			  <label class="form-check-label text-white" for="advertisement">No ad</label>
		  </div>
		  
		  <input id="ser_key" class="form-control form-control-dark w-60" type="text" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요." style="width: 65%">
		  <ul class="navbar-nav px-3">
		    <li class="nav-item text-nowrap">
		      <a class="nav-link font-weight-bold" href="#" onclick="doSearch()">Search</a>
		    </li>
		  </ul>
		</nav>
		
		<div class="container-fluid">
		  <div class="row">
		    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
		      <div class="sidebar-sticky pt-3">
		        <ul class="nav flex-column">
		          <li class="nav-item">
		            <a class="nav-link">
		              <span data-feather="hash"></span><span class="text-primary font-weight-bold">검색 결과 링크</span>
		              <span class="sr-only">(current)</span>
		            </a>
		          </li>
		        </ul>
		
		        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		          <span class="font-weight-bold">시각화 탭</span>
		          <a class="d-flex align-items-center text-muted" aria-label="Add a new report">
		            <span data-feather="log-in"></span>
		          </a>
		        </h6>
		        <ul class="nav flex-column mb-2">
		          <li class="nav-item">
		            <a class="nav-link" href="#" onclick="isLogin('chart/graph')">
		              <span data-feather="bar-chart-2"></span><span class="font-weight-bold">그래프</span>
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#" onclick="isLogin('chart/circle')">
		              <span data-feather="pie-chart"></span><span class="font-weight-bold">차트</span>
		            </a>
		          </li>
		          <li class="nav-item">
		            <a class="nav-link" href="#" onclick="isLogin('chart/wordcloud')">
		              <span data-feather="cloud"></span><span class="font-weight-bold">워드 클라우드</span>
		            </a>
		          </li>
		        </ul>
		      </div>
		    </nav>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
		      <h2><br>게시글 목록</h2>
		      <div class="table-responsive">
		        <table class="table table-striped table-sm">
		          <thead>
		            <tr>
		              <th>게시글 목록</th>
		            </tr>
		          </thead>
		          <tbody>
		          	<c:forEach var="search" items="${searches}" varStatus="status">
			            <tr>
			              <td>
			              	<a class="font-weight-bold" href="${search.ser_link}">${search.ser_title}</a>
				              	${search.ser_date}<br/>
				              	<p id = "content${status.index}">${search.ser_content}</p>
			              	<a class="text-secondary" href="${search.ser_link}">${search.ser_link}</a>
			              </td>     
			            </tr>
		            </c:forEach>
		          </tbody>
		        </table>
		      </div>
		    </main>
		  </div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
		<script src="/searlution/resources/js/dashboard.js"></script>
	</body>
</html>