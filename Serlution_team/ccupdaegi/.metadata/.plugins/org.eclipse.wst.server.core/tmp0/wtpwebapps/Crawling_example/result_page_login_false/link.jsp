<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>테스트 결과_비로그인_링크</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="../css/dashboard.css">

</head>
<body>
<!-- navbar -->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Searlution</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <ul class="navbar-nav px-3">
      <li class="nav-item">
        <a class="nav-link" href="#">로그인</a>
      </li>
  </ul>
  <div class="form-check px-3">
	  <input class="form-check-input" type="checkbox" value="" id="advertisement">
	  <label class="form-check-label text-white" for="advertisement">No ad</label>
  </div>
  <input class="form-control form-control-dark w-60" type="text" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요.">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link font-weight-bold" href="#">Search</a>
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
            <a class="nav-link" href="#">
              <span data-feather="lock"></span><span class="text-secondary">그래프</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="lock"></span><span class="text-secondary">차트</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="lock"></span><span class="text-secondary">워드 클라우드</span>
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
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/collectjin?Redirect=Log&logNo=222042646232">베트남 코로나 다낭 확진자 발생</a>
              	 2020.07.27.<br>
              	베트남 코로나 다낭 확진자 발생 최근 3달 넘게 베트남에서 코로나 확진자가 나오지 않고 있었는데요, 조금 더 있으면 환자들 다 치료하고 베트남 코로나 종식 선언도...<br>
              	<a class="text-secondary" href="https://blog.naver.com/collectjin?Redirect=Log&logNo=222042646232">https://blog.naver.com/collectjin?Redirect=Log&logNo=222042646232</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/imsanbu/51345582">코로나로 월급 타격 없으신가요?</a>
              	 2020.07.28.<br>
              	신랑이 파트장으로 승진하고 월급 올라서 통장보며 뿌듯해하던것도 딱 두달 코로나로 제대로 타격입고 3개월 무급휴가 월급삭감(100만원 이상) 그래 다들 힘들겠지 코로나로 위험해서 애들 학원도 쉬고...<br>
              	<a class="text-secondary" href="https://cafe.naver.com/imsanbu/51345582">https://cafe.naver.com/imsanbu/51345582</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/happy_snubh?Redirect=Log&logNo=222039262720">구강 염증이 폐에도 문제를 일으킨다? - 구강 위생과 코로나19</a>
              	 2020.07.27.<br>
              	바로 구강 위생과 코로나 감염의 관련성에 대한 논문으로(논문 제목 : Colud there be... 코로나19는 바이러스 감염이 원인이지만, 사실 환자가 중태에 빠지고, 사망하게...<br>
              	<a class="text-secondary" href="https://blog.naver.com/happy_snubh?Redirect=Log&logNo=222039262720">https://blog.naver.com/happy_snubh?Redirect=Log&logNo=222039262720</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/">코로나바이러스감염증-19(COVID-19)</a>
              	<br>코로나바이러스감염증-19 정식 홈페이지로 발생현황, 국내발생현황, 국외발생현황, 시도별발생현황, 대상별 유의사항, 생활 속 거리 두기, 공적마스크 공급현황, 피해지원정책, 홍보자료, FAQ, 관련기관(보건소, 선별진료소 찾기), 정부 브리핑 안내<br>
              	<a class="text-secondary" href="http://ncov.mohw.go.kr/">http://ncov.mohw.go.kr/</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://namu.wiki/w/코로나">코로나 - 나무위키</a>
              	<br>코로나 가열 문제 4. 화폐 단위 4.1. 실제 사례 5. 기호품 5.1. 멕시코의 맥주 5.2. 시가의 종류 중 하나 6. IT 6.1. Corona SDK 6.2. 코로나 렌더러 6.3. 대우전자의 컴퓨터 브랜드... 기타 독립 항목이 존재하는 코로나들 8.1. 서브컬처 9. 인물 9.1. 실존인물 9.2....<br>
              	<a class="text-secondary" href="https://namu.wiki/w/코로나">https://namu.wiki/w/코로나</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/makegoodstudy/334756">코로나 이후 학력저하..</a>
              	 2020.07.21<br>
              	코로나 땜에 2월 말부터 정말 상담 건이 없다가 7월 들어 몇 번 있었습니다. 근데 상담할 때마다 너무 코로나 이후 학력저하가 이런건가? 솔직히 너무 놀랍네요ㅡ.. 다른 선생님들은 어떠신지요? 매번...<br>
              	<a class="text-secondary" href="https://cafe.naver.com/makegoodstudy/334756">https://cafe.naver.com/makegoodstudy/334756</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/ok_hira?Redirect=Log&logNo=222045925503">코로나 블루, 실내 텃밭 채소 키우기로 극복해요</a>
              	 2020.07.31<br>
              	기약 없는 코로나19 사태, 당신의 마음은 안녕하신가요? 올해 초부터 시작된 코로나19 사태가 약 6개월이 지났는데도 끝날 기미가 보이지 않습니다. 많은 사람들이...<br>
              	<a class="text-secondary" href="https://blog.naver.com/ok_hira?Redirect=Log&logNo=222045925503">https://blog.naver.com/ok_hira?Redirect=Log&logNo=222045925503</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://www.seoul.go.kr/coronaV/coronaStatus.do">서울시 코로나19 - 서울특별시</a>
              	<br>안전·방역 발생동향 코로나19 선제검사 신청 생활 속 거리두기 기본지침 선별진료소 해외입국자 안내... 생활정보 코로나19 지원금 확인 공공이용시설 운영재개 현황 코로나19 주요뉴스 생활경제지원정책 지원금사용후기...<br>
              	<a class="text-secondary" href="https://www.seoul.go.kr/coronaV/coronaStatus.do">https://www.seoul.go.kr/coronaV/coronaStatus.do</a>
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13">코로나바이러스감염증-19 > 발생동향 > 시도별 발생동향</a>
              	<br>1,174 (+8)코로나-19 시도별 발생 현황표 - 시도명, 전일대비 확진환자 증감(합계, 해외유입, 국내발생), 확진환자수(명) (확진환자, 격리중, 격리해제, 사망자수, 발생률) 으로 구성 시도명 전일대비 확진환자...<br>
              	<a class="text-secondary" href="http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13">http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13</a>
              </td>
            </tr>
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
<script src="../js/dashboard.js"></script>

</body>
</html>