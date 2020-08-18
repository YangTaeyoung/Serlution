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
        <a class="nav-link" href="#">로그아웃</a>
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
            <a class="nav-link" href="#">
              <span data-feather="hash"></span><span class="font-weight-bold">검색 결과 링크</span>
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
            <a class="nav-link">
              <span data-feather="bar-chart-2" href="#"></span><span class="font-weight-bold">그래프</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link">
              <span data-feather="pie-chart"></span><span class="text-primary font-weight-bold">차트</span>
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="cloud"></span><span class="font-weight-bold">워드 클라우드</span>
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <h2><br>신뢰도 순</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th>게시글 목록</th>
              <th class="text-center">신뢰도</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/collectjin?Redirect=Log&logNo=222042646232">베트남 코로나 다낭 확진자 발생</a>
              	 2020.07.27.
              </td>
              <td class="text-center">
                90%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/imsanbu/51345582">코로나로 월급 타격 없으신가요?</a>
              	 2020.07.28.
              </td>
              <td class="text-center">
                90%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/happy_snubh?Redirect=Log&logNo=222039262720">구강 염증이 폐에도 문제를 일으킨다? - 구강 위생과 코로나19</a>
              	 2020.07.27.
              </td>
              <td class="text-center">
                88%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/">코로나바이러스감염증-19(COVID-19)</a>
              </td>
              <td class="text-center">
                88%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://namu.wiki/w/코로나">코로나 - 나무위키</a>
              </td>
              <td class="text-center">
                86%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/makegoodstudy/334756">코로나 이후 학력저하..</a>
              	 2020.07.21.
              </td>
              <td class="text-center">
                83%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/ok_hira?Redirect=Log&logNo=222045925503">코로나 블루, 실내 텃밭 채소 키우기로 극복해요</a>
              	 2020.07.31.
              </td>
              <td class="text-center">
                82%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://www.seoul.go.kr/coronaV/coronaStatus.do">서울시 코로나19 - 서울특별시</a>
              </td>
              <td class="text-center">
                78%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13">코로나바이러스감염증-19 > 발생동향 > 시도별 발생동향</a>
              </td>
              <td class="text-center">
                77%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/mirae_saram?Redirect=Log&logNo=222050873195">[사람나래] 코로나19에도 공채시험을 무사히, 적극행정...</a>
              	 2020.08.05.
              </td>
              <td class="text-center">
                76%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/nhicblog?Redirect=Log&logNo=222026387525">코로나19 확산 막는 국내 여행 방법</a>
              	 2020.07.10.
              </td>
              <td class="text-center">
                76%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/allkillenglish/910921">워킹홀리데이가 문제가 아닌,, 지금 호주 코로나</a>
              	 2020.07.24.
              </td>
              <td class="text-center">
                75%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/supermomstory/1512930">코로나확진자발생 ㅜㅜ</a>
              	 2020.07.19.
              </td>
              <td class="text-center">
                73%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://cafe.naver.com/barman/652573">코로나를 너무사랑??화나 뒤질꺼 같아</a>
              	 2020.07.22.
              </td>
              <td class="text-center">
                73%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11">코로나바이러스감염증-19 > 발생동향 > 국내 발생 현황</a>
              </td>
              <td class="text-center">
                72%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13">코로나바이러스감염증-19 > 발생동향 > 시도별 발생동향</a>
              </td>
              <td class="text-center">
                72%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://www.gwangju.go.kr/c19/">코로나19 - 광주광역시청</a>
              </td>
              <td class="text-center">
                71%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/yuseonggu?Redirect=Log&logNo=222052234139">대전 유성구 소식, 코로나19 극복 희망일자리사업 2차 참여자...</a>
              	 2020.08.05.
              </td>
              <td class="text-center">
                70%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/eureka_plus?Redirect=Log&logNo=222052022888">[시사읽기] 코로나19, 사회적 불평등 심화시키다</a>
              	 2020.08.05.
              </td>
              <td class="text-center">
                68%
              </td>
            </tr>
            <tr>
              <td>
              	<a class="font-weight-bold" href="https://blog.naver.com/seogwipo-si?Redirect=Log&logNo=222047286818">코로나19 극복 희망일자리사업 참여자를 모집합니다.</a>
              	 2020.08.01.
              </td>
              <td class="text-center">
                67%
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